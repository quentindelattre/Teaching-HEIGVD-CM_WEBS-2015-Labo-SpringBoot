package ch.heigvd.ptl.sc;

import ch.heigvd.ptl.sc.rest.UserResource;
import ch.heigvd.ptl.sc.rest.IssueTypeResource;
import ch.heigvd.ptl.sc.rest.DataResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		register(ObjectMapperProvider.class);
		register(CityEngagementExceptionMapper.class);
		register(DataResource.class);
		register(UserResource.class);
		register(IssueTypeResource.class);
	}
}
