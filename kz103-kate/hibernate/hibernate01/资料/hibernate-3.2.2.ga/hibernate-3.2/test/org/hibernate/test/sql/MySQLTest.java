//$Id: MySQLTest.java 10976 2006-12-12 23:22:26Z steve.ebersole@jboss.com $
package org.hibernate.test.sql;

import junit.framework.Test;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;

/**
 * @author Gavin King
 */
public class MySQLTest extends HandSQLTest {

	public MySQLTest(String str) {
		super(str);
	}

	public String[] getMappings() {
		return new String[] { "sql/MySQLEmployment.hbm.xml" };
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( MySQLTest.class );
	}

	public boolean appliesTo(Dialect dialect) {
		return ( dialect instanceof MySQLDialect );
	}
}

