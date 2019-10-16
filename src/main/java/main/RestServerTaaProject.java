package main;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.logging.Logger;

public class RestServerTaaProject {
	/**
	 * RESTfull microservice, based on JAX-RS and JBoss Undertow
	 *
	 */

	    private static final Logger logger = Logger.getLogger(RestServerTaaProject.class.getName());

	    public static void main( String[] args ) {

	        UndertowJaxrsServer ut = new UndertowJaxrsServer();

	        TestApplication ta = new TestApplication();

	        ut.deploy(ta);

	        ut.start(
	                Undertow.builder()
	                        .addHttpListener(8080, "localhost")

	        );

	        logger.info("JAX-RS ruuuuuunning!");
	    }
	}

