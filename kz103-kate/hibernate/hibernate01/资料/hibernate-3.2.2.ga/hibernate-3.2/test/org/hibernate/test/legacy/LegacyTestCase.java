package org.hibernate.test.legacy;

import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.hql.classic.ClassicQueryTranslatorFactory;
import org.hibernate.util.StringHelper;
import org.hibernate.junit.functional.FunctionalTestCase;

/**
 * @author Steve Ebersole
 */
public abstract class LegacyTestCase extends FunctionalTestCase {

	public static final String USE_ANTLR_PARSER_PROP = "legacy.use_antlr_hql_parser";
	private final boolean useAntlrParser;

	public LegacyTestCase(String x) {
		super( x );
		useAntlrParser = Boolean.valueOf( extractFromSystem( USE_ANTLR_PARSER_PROP ) ).booleanValue();
	}

	protected static String extractFromSystem(String systemPropertyName) {
		try {
			return System.getProperty( systemPropertyName );
		}
		catch( Throwable t ) {
			return null;
		}
	}

	public void configure(Configuration cfg) {
		super.configure( cfg );
		if ( !useAntlrParser ) {
			cfg.setProperty( Environment.QUERY_TRANSLATOR, ClassicQueryTranslatorFactory.class.getName() );
			String subs = cfg.getProperties().getProperty( Environment.QUERY_SUBSTITUTIONS );
			if ( StringHelper.isEmpty( subs ) ) {
				subs = "true=1, false=0";
			}
			else {
				subs += ", true=1, false=0";
			}
			cfg.getProperties().setProperty( Environment.QUERY_SUBSTITUTIONS, subs );
		}
	}
}
