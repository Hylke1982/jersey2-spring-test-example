package nl.bstoi.jersey2springexample.test;

import org.glassfish.jersey.test.spi.TestContainer;
import org.springframework.context.ApplicationContext;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
public interface SpringTestContainer extends TestContainer{
    public ApplicationContext getApplicationContext();
}
