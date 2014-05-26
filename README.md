Jersey 2.8, Spring framework, Mockito test example
==================================================

The problem I ran into while using Jersey 2.8 in combination with Spring Framework was,
that I was unable to wire in Mockito mocks into Jersey 2 resources while doing integration test. I created this sample
application to show you how to solve this problem. After version 2.7 it was not longer possible to use ApplicationHandler
to get the Spring Application Context, the Spring context was loaded 2 times when using the old method.

Problem
-------

I want to be able to test a Jersey 2 resource (get status codes, etc...) without creating a complete Spring Application
Context.

Goals
-----

The example application has the following goals:

- Show how to wire a mocked context into resources
- How gain control over mocked item with Mockito
- Show you if you're Jersey 2 behaviour is correct

Solution
--------

I've created the following solution.

The SpringContextJerseyTest is a copy of the JerseyTest, the Jersey test didn't allow you to have access to the Spring
ApplicationContext. The can be done with SpringContextJerseyTest.getSpringApplicationContext().

I'm able to create mocked objects with Mockito using a factory pattern in the MockFactory. The MockFactory is able to
create a mocked version of SomeService.

Testing
-------

You're able to run the test by running this command, or run the test in you're IDE.

    mvn test

The real implementation can also be tested, you're able to run the application with the following command.

    mvn jetty:run

And when the application is started, you can test the resource with following command (OSX tested only)

    curl -i http://localhost:8080/resources/someaction

You should expect a response like this

     HTTP/1.1 204 No Content
     Server: Jetty(8.1.14.v20131031)







