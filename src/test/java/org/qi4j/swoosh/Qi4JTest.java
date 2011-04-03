package org.qi4j.swoosh;

import org.junit.Test;
import org.ops4j.pax.exam.swoosh.BundleCheck;
import org.ops4j.pax.exam.swoosh.Player;

import static org.ops4j.pax.exam.CoreOptions.*;

/**
 *
 */
public class Qi4JTest {

    @Test
    public void testSetup()
        throws Exception
    {
        String qi4jversion = "1.3.RC5";

        Player player = new Player().with(
            composite(
                mavenBundle().groupId( "org.apache.servicemix.bundles" ).artifactId( "org.apache.servicemix.bundles.asm" ).version( "3.3_1" ),
                mavenBundle().groupId( "org.ops4j.pax.logging" ).artifactId( "pax-logging-api" ).version( "1.6.1" ),
                mavenBundle().groupId( "joda-time" ).artifactId( "joda-time" ).version( "1.6.2" ),
                mavenBundle().groupId( "com.hazelcast" ).artifactId( "hazelcast" ).version( "1.9.2.1" ),

                mavenBundle().groupId( "org.qi4j.core" ).artifactId( "org.qi4j.core.api" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.core" ).artifactId( "org.qi4j.core.spi" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.core" ).artifactId( "org.qi4j.core.bootstrap" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.core" ).artifactId( "org.qi4j.core.runtime" ).version( qi4jversion ),

                mavenBundle().groupId( "org.qi4j.library" ).artifactId( "org.qi4j.library.constraints" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.library" ).artifactId( "org.qi4j.library.jmx" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.library" ).artifactId( "org.qi4j.library.locking" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.library" ).artifactId( "org.qi4j.library.rdf" ).version( qi4jversion ),
                // Some extensions:
                mavenBundle().groupId( "org.qi4j.extension" ).artifactId( "org.qi4j.extension.indexing-rdf" ).version( qi4jversion ),
                mavenBundle().groupId( "org.qi4j.extension" ).artifactId( "org.qi4j.extension.entitystore-hazelcast" ).version( qi4jversion ),

                //
                mavenBundle().groupId( "org.apache.aries.blueprint" ).artifactId( "org.apache.aries.blueprint" ).version( "0.3.1" ).startLevel( 10 ),

                mavenBundle().groupId( "org.apache.aries.jmx" ).artifactId( "org.apache.aries.jmx" ).version( "0.3" ),
                mavenBundle().groupId( "org.apache.aries.jmx" ).artifactId( "org.apache.aries.jmx.blueprint" ).version( "0.3" ),

                mavenBundle().groupId( "org.apache.mina" ).artifactId( "mina-core" ).version( "2.0.0-RC1" ),
                mavenBundle().groupId( "org.apache.sshd" ).artifactId( "sshd-core" ).version( "0.4.0" ),
                mavenBundle().groupId( "org.apache.karaf.jaas" ).artifactId( "org.apache.karaf.jaas.config" ).version( "2.1.4" ),
                mavenBundle().groupId( "org.apache.karaf.jaas" ).artifactId( "org.apache.karaf.jaas.modules" ).version( "2.1.4" )
            )
        );

        player.play( new BundleCheck().allResolved() );
    }

}
