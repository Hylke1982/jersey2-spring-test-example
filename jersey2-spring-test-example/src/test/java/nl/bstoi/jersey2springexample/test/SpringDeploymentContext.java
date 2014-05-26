package nl.bstoi.jersey2springexample.test;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.DeploymentContext;

import javax.ws.rs.core.Application;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
public class SpringDeploymentContext extends DeploymentContext{

    private ResourceConfig resourceConfig;

    protected SpringDeploymentContext(Builder b) {
        super(b);
    }


    public ResourceConfig getResourceConfig() {
        return resourceConfig;
    }

    public void setResourceConfig(ResourceConfig resourceConfig) {
        this.resourceConfig = resourceConfig;
    }
}
