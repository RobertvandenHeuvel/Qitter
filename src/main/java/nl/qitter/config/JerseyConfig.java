package nl.qitter.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import nl.qitter.api.GebruikerApi;
import nl.qitter.api.GroepApi;
import nl.qitter.api.PostApi;
import nl.qitter.api.ReactieApi;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {

		register(GroepApi.class); //--> commando voor aanroepen Api
		register(PostApi.class); //--> commando voor aanroepen Api
		register(GebruikerApi.class); //--> commando voor aanroepen Api
		register(ReactieApi.class);
	}
}
