package nl.qitter.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.qitter.domain.Gebruiker;
import nl.qitter.services.GebruikerService;

@Component
@Path("gebruiker")
public class GebruikerApi {
	@Autowired
	GebruikerService gebruikerService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAlleGebruikers() {
		Iterable<Gebruiker> deGebruikers = gebruikerService.findAlleGebruikers();
		return Response.ok(deGebruikers).build();
	}
}
