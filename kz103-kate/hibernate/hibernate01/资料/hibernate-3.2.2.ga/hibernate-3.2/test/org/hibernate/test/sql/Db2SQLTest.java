//$Id$
package org.hibernate.test.sql;

import junit.framework.Test;

import org.hibernate.dialect.DB2Dialect;
import org.hibernate.dialect.Dialect;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;

/**
 * @author Max Rydahl Andersen
 */
public class Db2SQLTest extends HandSQLTest {
	
	public Db2SQLTest(String str) {
		super(str);
	}

	public String[] getMappings() {
		return new String[] { "sql/Db2Employment.hbm.xml" };
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( Db2SQLTest.class );
	}

	public boolean appliesTo(Dialect dialect) {
		return ( dialect instanceof DB2Dialect);
	}

}

