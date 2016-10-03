package fr.xebia.clickcount

import fr.xebia.clickcount.web.resource.ClickResource;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import javax.ws.rs.core.Response;

public class ClickResourceTest extends JerseyTest {

	@Override
	public Application configure() {
		enable(TestProperties.LOG_TRAFFIC);
		enable(TestProperties.DUMP_ENTITY);
		return new ResourceConfig(ClickResource.class)
	}
	
	@Test
	public void testHealthcheck() {
		Response output = target("/healthcheck").request().get();
		assertEquals("Should return status 200", 200, output.getStatus());
		assertEquals("Should return 'ok'", "ok", output.getEntity());
	}

}
