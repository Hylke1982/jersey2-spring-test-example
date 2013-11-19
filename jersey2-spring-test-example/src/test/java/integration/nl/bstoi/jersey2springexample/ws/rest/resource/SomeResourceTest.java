package integration.nl.bstoi.jersey2springexample.ws.rest.resource;

import nl.bstoi.jersey2springexample.service.SomeService;
import nl.bstoi.jersey2springexample.test.SpringContextJerseyTest;
import nl.bstoi.jersey2springexample.ws.rest.SomeApplication;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.TestProperties;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
public class SomeResourceTest extends SpringContextJerseyTest {

    public static final String MOCK_SPRING_APPLICATIONCONTEXT = "classpath:mockApplicationContext.xml";


    private SomeService mockSomeService;

    @Override
    protected Application configure() {
        ResourceConfig resourceConfig = new SomeApplication();
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        resourceConfig.property("contextConfigLocation", MOCK_SPRING_APPLICATIONCONTEXT); // Set which application context to use
        return resourceConfig;
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        mockSomeService = (SomeService) getSpringApplicationContext().getBean("someService");
        Assert.assertNotNull(mockSomeService);
    }

    @After
    public void after() throws Exception {
        super.tearDown();
    }

    @Test
    public void testDoSomething() {
        Response response = target("someaction").request().get(Response.class);
        Mockito.verify(mockSomeService, Mockito.times(1)).doSomething();  // Validate if doSomething() is called
        Assert.assertEquals(204, response.getStatus());
    }

    @Test
    public void testDoSomethingWithException() {
        Mockito.doThrow(new RuntimeException()).when(mockSomeService).doSomething();
        Response response = target("someaction").request().get(Response.class);
        Mockito.verify(mockSomeService, Mockito.times(1)).doSomething();  // Validate if doSomething() is called
        Assert.assertEquals(500, response.getStatus()); // Expect 500 when exception is thrown
    }


}
