//$Id$
package org.hibernate.test.sql;

import junit.framework.Test;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.SybaseDialect;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;

/**
 * @author Gavin King
 */
public class MSSQLTest extends HandSQLTest {

	public MSSQLTest(String str) {
		super( str );
	}

	public String[] getMappings() {
		return new String[] {"sql/MSSQLEmployment.hbm.xml"};
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( MSSQLTest.class );
	}

	public boolean appliesTo(Dialect dialect) {
		return ( dialect instanceof SybaseDialect );
	}
}

