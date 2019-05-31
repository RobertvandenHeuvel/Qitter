package nl.qitter.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import nl.qitter.domain.Groep;
import nl.qitter.services.GroepService;

@Component
@Path("groep")
public class GroepApi {
	@Autowired
	GroepService groepService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response proberen() {
		Iterable<Groep> deGroepen = groepService.getAlleGroepen();
		return Response.ok(deGroepen).build();
	}
}
