package nl.bstoi.jersey2springexample.service.impl;

import nl.bstoi.jersey2springexample.service.SomeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
public class SomeServiceImpl implements SomeService{

    private static final Log LOG = LogFactory.getLog(SomeServiceImpl.class);

    @Override
    public void doSomething() {
        LOG.debug("Something has been done");
    }
}
