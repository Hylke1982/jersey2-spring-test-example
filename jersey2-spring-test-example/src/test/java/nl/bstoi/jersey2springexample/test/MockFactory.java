package nl.bstoi.jersey2springexample.test;

import nl.bstoi.jersey2springexample.service.SomeService;
import nl.bstoi.jersey2springexample.service.impl.SomeServiceImpl;
import org.mockito.Mockito;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 * <p/>
 * MockFactory is used to create mocked items with Mockito
 */
public class MockFactory {
    public SomeService createSomeService() {
        return Mockito.mock(SomeServiceImpl.class);
    }
}
