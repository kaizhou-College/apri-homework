//$Id: ComponentTest.java 11070 2007-01-20 19:16:38Z steve.ebersole@jboss.com $
package org.hibernate.test.component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Mappings;
import org.hibernate.criterion.Property;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.junit.functional.FunctionalTestCase;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.Formula;
import org.hibernate.mapping.PersistentClass;

/**
 * @author Gavin King
 */
public class ComponentTest extends FunctionalTestCase {
	
	public ComponentTest(String str) {
		super(str);
	}

	public String[] getMappings() {
		return new String[] { "component/User.hbm.xml" };
	}

	public void configure(Configuration cfg) {
		cfg.setProperty( Environment.GENERATE_STATISTICS, "true" );
	}

	public void afterConfigurationBuilt(Mappings mappings, Dialect dialect) {
		super.afterConfigurationBuilt( mappings, dialect );
		// Oracle and Postgres do not have year() functions, so we need to
		// redefine the 'User.person.yob' formula
		//
		// consider temporary until we add the capability to define
		// mapping foprmulas which can use dialect-registered functions...
		PersistentClass user = mappings.getClass( User.class.getName() );
		org.hibernate.mapping.Property personProperty = user.getProperty( "person" );
		Component component = ( Component ) personProperty.getValue();
		Formula f = ( Formula ) component.getProperty( "yob" ).getValue().getColumnIterator().next();

		SQLFunction yearFunction = ( SQLFunction ) dialect.getFunctions().get( "year" );
		if ( yearFunction == null ) {
			// the dialect not know to support a year() function, so rely on the
			// ANSI SQL extract function
			f.setFormula( "extract( year from dob )");
		}
		else {
			List args = new ArrayList();
			args.add( "dob" );
			f.setFormula( yearFunction.render( args, null ) );
		}
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite(ComponentTest.class);
	}
	
	public void testUpdateFalse() {
		getSessions().getStatistics().clear();
		
		Session s = openSession();
		Transaction t = s.beginTransaction();
		User u = new User( "gavin", "secret", new Person("Gavin King", new Date(), "Karbarook Ave") );
		s.persist(u);
		s.flush();
		u.getPerson().setName("XXXXYYYYY");
		t.commit();
		s.close();
		
		assertEquals( 1, getSessions().getStatistics().getEntityInsertCount() );
		assertEquals( 0, getSessions().getStatistics().getEntityUpdateCount() );

		s = openSession();
		t = s.beginTransaction();
		u = (User) s.get(User.class, "gavin");
		assertEquals( u.getPerson().getName(), "Gavin King" );
		s.delete(u);
		t.commit();
		s.close();
		
		assertEquals( 1, getSessions().getStatistics().getEntityDeleteCount() );
	}
	
	public void testComponent() {
		Session s = openSession();
		Transaction t = s.beginTransaction();
		User u = new User( "gavin", "secret", new Person("Gavin King", new Date(), "Karbarook Ave") );
		s.persist(u);
		s.flush();
		u.getPerson().changeAddress("Phipps Place");
		t.commit();
		s.close();
		
		s = openSession();
		t = s.beginTransaction();
		u = (User) s.get(User.class, "gavin");
		assertEquals( u.getPerson().getAddress(), "Phipps Place" );
		assertEquals( u.getPerson().getPreviousAddress(), "Karbarook Ave" );
		assertEquals( u.getPerson().getYob(), u.getPerson().getDob().getYear()+1900 );
		u.setPassword("$ecret");
		t.commit();
		s.close();

		s = openSession();
		t = s.beginTransaction();
		u = (User) s.get(User.class, "gavin");
		assertEquals( u.getPerson().getAddress(), "Phipps Place" );
		assertEquals( u.getPerson().getPreviousAddress(), "Karbarook Ave" );
		assertEquals( u.getPassword(), "$ecret" );
		s.delete(u);
		t.commit();
		s.close();
	}

	public void testComponentStateChangeAndDirtiness() {
		// test for HHH-2366
		Session s = openSession();
		s.beginTransaction();
		User u = new User( "steve", "hibernater", new Person( "Steve Ebersole", new Date(), "Main St") );
		s.persist( u );
		s.flush();
		long intialUpdateCount = sfi().getStatistics().getEntityUpdateCount();
		u.getPerson().setAddress( "Austin" );
		s.flush();
		assertEquals( intialUpdateCount + 1, sfi().getStatistics().getEntityUpdateCount() );
		intialUpdateCount = sfi().getStatistics().getEntityUpdateCount();
		u.getPerson().setAddress( "Cedar Park" );
		s.flush();
		assertEquals( intialUpdateCount + 1, sfi().getStatistics().getEntityUpdateCount() );
		s.delete( u );
		s.getTransaction().commit();
		s.close();
	}

	public void testComponentQueries() {
		Session s = openSession();
		Transaction t = s.beginTransaction();
		Employee emp = new Employee();
		emp.setHireDate( new Date() );
		emp.setPerson( new Person() );
		emp.getPerson().setName( "steve" );
		emp.getPerson().setDob( new Date() );
		s.save( emp );

		s.createQuery( "from Employee e where e.person = :p and 1 = 1 and 2=2" ).setParameter( "p", emp.getPerson() ).list();
		s.createQuery( "from Employee e where :p = e.person" ).setParameter( "p", emp.getPerson() ).list();
		s.createQuery( "from Employee e where e.person = ('steve', current_timestamp)" ).list();

		s.delete( emp );
		t.commit();
		s.close();
	}
	
	public void testComponentFormulaQuery() {
		Session s = openSession();
		Transaction t = s.beginTransaction();
		s.createQuery("from User u where u.person.yob = 1999").list();
		s.createCriteria(User.class)
			.add( Property.forName("person.yob").between( new Integer(1999), new Integer(2002) ) )
			.list();
		if ( getDialect().supportsRowValueConstructorSyntax() ) {
			s.createQuery("from User u where u.person = ('gavin', :dob, 'Peachtree Rd', 'Karbarook Ave', 1974, 'Peachtree Rd')")
				.setDate("dob", new Date("March 25, 1974")).list();
			s.createQuery("from User where person = ('gavin', :dob, 'Peachtree Rd', 'Karbarook Ave', 1974, 'Peachtree Rd')")
				.setDate("dob", new Date("March 25, 1974")).list();
		}
		t.commit();
		s.close();
	}

	public void testNamedQuery() {
		Session s = openSession();
		Transaction t = s.beginTransaction();
		s.getNamedQuery("userNameIn")
			.setParameterList( "nameList", new Object[] {"1ovthafew", "turin", "xam"} )
			.list();
		t.commit();
		s.close();
	}

}

