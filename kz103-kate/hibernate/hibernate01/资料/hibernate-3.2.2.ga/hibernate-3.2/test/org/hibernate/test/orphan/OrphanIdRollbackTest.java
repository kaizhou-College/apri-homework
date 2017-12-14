//$Id: OrphanIdRollbackTest.java 10976 2006-12-12 23:22:26Z steve.ebersole@jboss.com $
package org.hibernate.test.orphan;

import junit.framework.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.junit.functional.FunctionalTestCase;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;

/**
 * @author Emmanuel Bernard
 */
public class OrphanIdRollbackTest extends FunctionalTestCase {
	
	public OrphanIdRollbackTest(String str) {
		super(str);
	}

	public String[] getMappings() {
		return new String[] { "orphan/ProductAndIdRollback.hbm.xml" };
	}

	public void configure(Configuration cfg) {
		cfg.setProperty( Environment.USE_IDENTIFIER_ROLLBACK, "true");
		super.configure( cfg );
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( OrphanIdRollbackTest.class );
	}

	public void testOrphanDeleteOnDelete() {
		Session session = openSession();
		Transaction t = session.beginTransaction();
		Product prod = new Product();
		session.persist(prod);
		session.flush();
		t.commit();
		session.close();
		session = openSession();
		t = session.beginTransaction();
		prod = (Product) session.get( Product.class, prod.getName() );
		session.delete(prod);
		t.commit();
		session.close();
	}

}

