package nl.qitter.api;

import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import nl.qitter.domain.Groep;
import nl.qitter.services.GroepService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("groep")
public class GroepApi {
	@Autowired
	private GroepService groepService;

	@POST // Create
	public Response apiCreate(Groep groep) {
		if (groep.getId() != 0) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok(groepService.save(groep)).build();
	}

	@GET // Retrieve/Read
	@Path("{id}")
	public Response apiGetById(@PathParam("id") long id) {
		Optional<Groep> groep = groepService.findById(id);
		if (groep.isPresent() == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return Response.ok(groep.get()).build();
		}
	}

	@GET // Retrieve/Read
	public Response apiGetAll() {
		System.out.println("Check in @GET van GroepApi");
		return Response.ok(groepService.findAll()).build();
	}

	@PUT // Update
	@Path("{id}")
	public Response apiUpdate(@PathParam("id") long id, Groep groep) {
		if (groep == null || groep.getId() != id)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Optional<Groep> oldGroep = groepService.findById(id);
		if (!oldGroep.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Groep target = oldGroep.get();
		target.setGebruikers(groep.getGebruikers());
		target.setGroepsNaam(groep.getGroepsNaam());
		System.out.println("Check in @PUT/id van GroepApi");
		return Response.ok(groepService.save(target)).build();
	}

	@DELETE // Delete
	@Path("{id}")
	public Response apiDeleteById(@PathParam("id") long id) {
		if (groepService.findById(id).isPresent() == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			groepService.deleteById(id);
			return Response.status(Response.Status.OK).build();
		}
	}

}