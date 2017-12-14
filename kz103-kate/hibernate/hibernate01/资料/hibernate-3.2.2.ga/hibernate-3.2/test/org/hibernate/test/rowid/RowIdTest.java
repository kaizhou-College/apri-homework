//$Id: RowIdTest.java 10976 2006-12-12 23:22:26Z steve.ebersole@jboss.com $
package org.hibernate.test.rowid;

import java.math.BigDecimal;
import java.sql.Statement;
import java.sql.SQLException;

import junit.framework.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.dialect.Oracle9Dialect;
import org.hibernate.dialect.Dialect;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;
import org.hibernate.junit.functional.DatabaseSpecificFunctionalTestCase;

/**
 * @author Gavin King
 */
public class RowIdTest extends DatabaseSpecificFunctionalTestCase {
	
	public RowIdTest(String str) {
		super(str);
	}

	public String[] getMappings() {
		return new String[] { "rowid/Point.hbm.xml" };
	}

	public String getCacheConcurrencyStrategy() {
		return null;
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( RowIdTest.class );
	}

	public boolean appliesTo(Dialect dialect) {
		return dialect instanceof Oracle9Dialect;
	}

	public boolean createSchema() {
		return false;
	}

	public void afterSessionFactoryBuilt() {
		super.afterSessionFactoryBuilt();
		try {
			Session s = openSession();
			Statement st = s.connection().createStatement();
			try {
				st.execute( "drop table Point");
			}
			catch( Throwable t ) {
				// ignore
			}
			st.execute("create table Point (\"x\" number(19,2) not null, \"y\" number(19,2) not null, description varchar2(255) )");
			s.close();
		}
		catch ( SQLException e ) {
			throw new RuntimeException( "Unable to build actual schema : " + e.getMessage() );
		}
	}

	public void testRowId() {
		Session s = openSession();
		Transaction t = s.beginTransaction();
		Point p = new Point( new BigDecimal(1.0), new BigDecimal(1.0) );
		s.persist(p);
		t.commit();
		s.clear();
		
		t = s.beginTransaction();
		p = (Point) s.createCriteria(Point.class).uniqueResult();
		p.setDescription("new desc");
		t.commit();
		s.clear();
		
		t = s.beginTransaction();
		p = (Point) s.createQuery("from Point").uniqueResult();
		p.setDescription("new new desc");
		t.commit();
		s.clear();
		
		t = s.beginTransaction();
		p = (Point) s.get(Point.class, p);
		p.setDescription("new new new desc");
		t.commit();
		s.close();
		
	}

}

