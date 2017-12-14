package org.hibernate.test.keymanytoone.bidir.component;

import junit.framework.Test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;
import org.hibernate.test.TestCase;

/**
 * @author Steve Ebersole
 */
public class EagerKeyManyToOneTest extends TestCase {
	public EagerKeyManyToOneTest(String name) {
		super( name );
	}

	protected String[] getMappings() {
		return new String[] { "keymanytoone/bidir/component/EagerMapping.hbm.xml" };
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( EagerKeyManyToOneTest.class );
	}

	protected void configure(Configuration cfg) {
		super.configure( cfg );
		cfg.setProperty( Environment.GENERATE_STATISTICS, "true" );
	}

	public void testSaveCascadedToKeyManyToOne() {
		// test cascading a save to an association with a key-many-to-one which refers to a
		// just saved entity
		Session s = openSession();
		s.beginTransaction();
		Customer cust = new Customer( "Acme, Inc." );
		Order order = new Order( new Order.Id( cust, 1 ) );
		cust.getOrders().add( order );
		s.save( cust );
		s.flush();
		assertEquals( 2, sfi().getStatistics().getEntityInsertCount() );
		s.delete( cust );
		s.getTransaction().commit();
		s.close();
	}

	public void testLoadingStrategies() {
		Session s = openSession();
		s.beginTransaction();
		Customer cust = new Customer( "Acme, Inc." );
		Order order = new Order( new Order.Id( cust, 1 ) );
		cust.getOrders().add( order );
		s.save( cust );
		s.getTransaction().commit();
		s.close();

		s = openSession();
		s.beginTransaction();

// Here is an example of HHH-2277
// essentially we have a bidirectional association where one side of the
// association is actually part of a composite PK
//
// The way these are mapped causes the problem because both sides
// are defined as eager which leads to the infinite loop; if only
// one side is marked as eager, then all is ok...
//		cust = ( Customer ) s.get( Customer.class, cust.getId() );
//		assertEquals( 1, cust.getOrders().size() );
//		s.clear();

		cust = ( Customer ) s.createQuery( "from Customer" ).uniqueResult();
		assertEquals( 1, cust.getOrders().size() );
		s.clear();

		cust = ( Customer ) s.createQuery( "from Customer c join fetch c.orders" ).uniqueResult();
		assertEquals( 1, cust.getOrders().size() );
		s.clear();

		cust = ( Customer ) s.createQuery( "from Customer c join fetch c.orders as o join fetch o.id.customer" ).uniqueResult();
		assertEquals( 1, cust.getOrders().size() );
		s.clear();

		cust = ( Customer ) s.createCriteria( Customer.class ).uniqueResult();
		assertEquals( 1, cust.getOrders().size() );
		s.clear();

		s.delete( cust );
		s.getTransaction().commit();
		s.close();
	}
}
