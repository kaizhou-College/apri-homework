package org.hibernate.test.sql;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.hibernate.test.sql.check.OracleCheckStyleTest;

/**
 * todo: describe NativeSqlSupportSuite
 *
 * @author Steve Ebersole
 */
public class NativeSqlSupportSuite {
	public static Test suite() {
		TestSuite suite = new TestSuite( "Native SQL support tests" );
		suite.addTest( Db2SQLTest.suite() );
		suite.addTest( DataDirectOracleSQLTest.suite() );
		suite.addTest( OracleSQLTest.suite() );
		suite.addTest( MSSQLTest.suite() );
		suite.addTest( MySQLTest.suite() );
		suite.addTest( GeneralTest.suite() );
		suite.addTest( OracleCheckStyleTest.suite() );
		return suite;
	}
}
