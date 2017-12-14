//$Id$
package org.hibernate.test.sql;

import junit.framework.Test;

import org.hibernate.dialect.DataDirectOracle9Dialect;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.Oracle9Dialect;
import org.hibernate.junit.functional.FunctionalTestClassTestSuite;

/**
 * @author Gavin King
 */
public class OracleSQLTest extends HandSQLTest {

	public OracleSQLTest(String str) {
		super(str);
	}

	public String[] getMappings() {
		return new String[] { "sql/OracleEmployment.hbm.xml", "sql/OracleDriverStoredProcedures.hbm.xml" };
	}

	public static Test suite() {
		return new FunctionalTestClassTestSuite( OracleSQLTest.class );
	}

	public boolean appliesTo(Dialect dialect) {
		return ( dialect instanceof Oracle9Dialect ) && !( dialect instanceof DataDirectOracle9Dialect );
	}

}

