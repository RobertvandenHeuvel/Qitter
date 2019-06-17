package nl.qitter.api;

import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.qitter.domain.Gebruiker;
import nl.qitter.domain.Post;
//import nl.qitter.domain.Groep;
import nl.qitter.services.GebruikerService;
import nl.qitter.services.PostService;

@Component
@Path("gebruiker")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GebruikerApi {
	@Autowired
	GebruikerService gebruikerService;
	@Autowired
	PostService postService;

	@POST
	public Response postGebruiker(Gebruiker gebruiker) {
		System.out.println("Check in @Post van gebruikerApi");
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
		System.out.println("Check in @GET van gebruikerApi: gebruikerID =" + id);
		Optional<Gebruiker> gebruiker = gebruikerService.findGebruikerById(id);
		return Response.ok(gebruiker.get()).build();
	}
	

	@PUT
	@Path("{id}")
	public Response updateGebruiker(@PathParam("id") long id, Gebruiker gebruiker) {
		System.out.println("Check in PUT/id van GebruikerApi");
		Optional<Gebruiker> oudeGebruiker = gebruikerService.findGebruikerById(id);
		Gebruiker nieuw = oudeGebruiker.get();
		if (gebruiker.getUsername() != null)
		nieuw.setUsername(gebruiker.getUsername());
		if (gebruiker.getWachtwoord() != null)
		nieuw.setWachtwoord(gebruiker.getWachtwoord());
		if (gebruiker.getBio() != null)
		nieuw.setBio(gebruiker.getBio());
		if (gebruiker.getVoornaam() != null)
		nieuw.setVoornaam(gebruiker.getVoornaam());
		if (gebruiker.getAchternaam() != null)
		nieuw.setAchternaam(gebruiker.getAchternaam());
		if (gebruiker.getEmail() != null)
		nieuw.setEmail(gebruiker.getEmail());
		if (gebruiker.getRol() != null)
		nieuw.setRol(gebruiker.getRol());
		
		
//		if (gebruiker.getGroep() != null)
//			nieuw.setGroep(gebruiker.getGroep());
		
//		if (gebruiker.getPosts() != null)
//		nieuw.setPosts(gebruiker.getPosts());
		System.out.print("gebruiker voornaam: ");
		System.out.println(gebruiker.getVoornaam());
		System.out.print("nieuw voornaam: ");
		System.out.println(nieuw.getVoornaam());
		System.out.print("gebruiker api getPosts ");

		System.out.println(gebruiker.getPosts());
			for(Post post: gebruiker.getPosts()) {
				System.out.println(post.getTekst());
	     		post.setGebruiker(nieuw);
	     		System.out.println(post.getGebruiker().getUsername());
	     		postService.save(post);
	     		nieuw.addPost(post);
	     	}
		nieuw.setPosts(gebruiker.getPosts());
		
		
		System.out.println("Get posts van nieuwe gebruiker" + nieuw.getPosts());
		return Response.ok(gebruikerService.saveGebruiker(nieuw)).build();
	}

//	@PUT
//	@Path("{id}/groep/{id}")
//	public Response updateGebruikerGroep(@PathParam("id") long id, Gebruiker gebruiker) {
//		System.out.println("Check in PUT/id/groep van GebruikerApi");
//		Optional<Gebruiker> oudeGebruiker = gebruikerService.findGebruikerById(id);
//		Gebruiker nieuw = oudeGebruiker.get();
//		return Response.ok(gebruikerService.saveGebruiker(nieuw)).build();
//	}
	

	@DELETE
	@Path("{id}")
	public Response deleteGebruiker(@PathParam("id") long id) {
		gebruikerService.deleteGebruikerById(id);
		System.out.println("Check in Delete/id van GebruikerApi");
		return Response.status(Response.Status.OK).build();
	}
}