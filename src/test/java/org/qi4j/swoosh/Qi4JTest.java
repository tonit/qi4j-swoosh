package org.qi4j.swoosh;

import org.junit.Test;
import org.osgi.framework.Bundle;
import org.ops4j.pax.exam.player.Player;
import org.ops4j.pax.exam.testforge.BundlesInState;

/**
 * Test example that uses the Pax Exam Player to run the setup (see {@link Setup#setup(String)}} to run pre-build simple tests.
 */
public class Qi4JTest {

    @Test
    public void testSetup()
        throws Exception
    {
        String qi4jversion = "1.3.RC5";

        System.setProperty( "org.ops4j.pax.url.mvn.repositories", "+https://repository.jboss.org/nexus/content/repositories/thirdparty-releases@id=jboss" );

        Player player = new Player().with( Setup.setup( qi4jversion ) );

        player.test( BundlesInState.class, Bundle.RESOLVED, Bundle.ACTIVE ).play();
    }
}
