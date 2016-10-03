package fr.xebia.clickcount;

import fr.xebia.clickcount.web.resource.ClickResource;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.glassfish.jersey.test.grizzly.GrizzlyWebTestContainerFactory;
import org.glassfish.jersey.test.spi.TestContainerException;
import org.glassfish.jersey.test.spi.TestContainerFactory;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.test.ServletDeploymentContext;
import org.glassfish.jersey.test.DeploymentContext;
import fr.xebia.clickcount.repository.ClickRepository;

public class ClickResourceTest extends JerseyTest {

    @Override
	protected DeploymentContext configureDeployment() {
		return ServletDeploymentContext.forServlet(new ServletContainer(
                               new ResourceConfig(ClickResource.class))).contextPath("rest").build();
	}

	@Override
	protected TestContainerFactory getTestContainerFactory() throws TestContainerException {
		return new GrizzlyWebTestContainerFactory();
	}
	
	@Test
	public void testHealthcheck() {
		Response output = target("healthcheck").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertEquals("Should return 'ok'", "ok", output.getEntity());
	}

}
