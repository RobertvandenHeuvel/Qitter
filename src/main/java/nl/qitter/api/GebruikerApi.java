package nl.qitter.api;

import java.util.Optional;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.qitter.domain.Gebruiker;
import nl.qitter.domain.Groep;
import nl.qitter.services.GebruikerService;

@Component
@Path("gebruiker")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GebruikerApi {
	@Autowired
	GebruikerService gebruikerService;

	@POST
	public Response postGebruiker(Gebruiker gebruiker) {
		Gebruiker gebruikerPost = gebruikerService.saveGebruiker(gebruiker);
		return Response.ok(gebruikerPost).build();
	}

	@GET
	public Response getAlleGebruikers() {
		Iterable<Gebruiker> deGebruikers = gebruikerService.findAlleGebruikers();
		return Response.ok(deGebruikers).build();
	}

	@GET
	@Path("{id}")
	public Response getGebruikerById(@PathParam("id") long id) {
		Optional<Gebruiker> gebruiker = gebruikerService.findGebruikerById(id);
		return Response.ok(gebruiker.get()).build();
	}
	

	@PUT
	@Path("{id}")
	public Response updateGebruiker(@PathParam("id") long id, Gebruiker gebruiker) {
		
		Optional<Gebruiker> oudeGebruiker = gebruikerService.findGebruikerById(id);
		Gebruiker nieuw = oudeGebruiker.get();
		nieuw.setUsername(gebruiker.getUsername());
		nieuw.setWachtwoord(gebruiker.getWachtwoord());
		nieuw.setBio(gebruiker.getBio());
		nieuw.setVoornaam(gebruiker.getVoornaam());
		nieuw.setAchternaam(gebruiker.getAchternaam());
		nieuw.setEmail(gebruiker.getEmail());
		nieuw.setRol(gebruiker.getRol());
		return Response.ok(gebruikerService.saveGebruiker(nieuw)).build();
	}


	@DELETE
	@Path("{id}")
	public Response deleteGebruiker(@PathParam("id") long id) {
		gebruikerService.deleteGebruikerById(id);
		return Response.status(Response.Status.OK).build();
	}
}