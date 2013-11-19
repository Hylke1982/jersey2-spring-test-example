package nl.bstoi.jersey2springexample.ws.rest;

import nl.bstoi.jersey2springexample.ws.rest.resource.SomeResource;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
public class SomeApplication extends ResourceConfig {
    public SomeApplication() {
        packages(SomeResource.class.getPackage().toString());
    }
}
