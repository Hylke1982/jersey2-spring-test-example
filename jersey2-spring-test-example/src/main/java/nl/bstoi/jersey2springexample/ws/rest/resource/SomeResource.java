package nl.bstoi.jersey2springexample.ws.rest.resource;

import nl.bstoi.jersey2springexample.service.SomeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
@Component // Required for using Spring and Jersey2
@Path("someaction")
public class SomeResource {

    private final static Log LOG = LogFactory.getLog(SomeResource.class);

    private SomeService someService; // Service we want to mock

    @GET
    public Response doSomething(){
        LOG.debug("SomeResource was called");
        getSomeService().doSomething();
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public SomeService getSomeService() {
        return someService;
    }

    public void setSomeService(SomeService someService) {
        this.someService = someService;
    }
}
