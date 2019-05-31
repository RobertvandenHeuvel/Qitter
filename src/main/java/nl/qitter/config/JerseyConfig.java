package nl.qitter.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import nl.qitter.api.GroepApi;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {

		register(GroepApi.class); //--> commando voor aanroepen Api
		
	}
}
