package nl.qitter.api;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

import org.springframework.stereotype.Component;

import nl.qitter.domain.Reactie;
import nl.qitter.services.ReactieService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("reactie")
public class ReactieApi {
	@Autowired
	ReactieService reactieService;
	
	@POST
	public Response apiCreate(Reactie reactie) {
		System.out.println("check in @Post van ReactieApi");
		if (reactie.getId() != 0) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok(reactieService.save(reactie)).build();
	}
	
	@GET // Retrieve/Read
	public Response apiGetAll() {
		System.out.println("Check in @GET/all van ReactieApi");
		return Response.ok(reactieService.findAll()).build();
	}

	@GET // Retrieve/Read
	@Path("{id}")
	public Response apiGetById(@PathParam("id") long id) {
		System.out.println("Check in @GET/id van ReactieApi");
		Optional<Reactie> reactie = reactieService.findById(id);
		if (reactie.isPresent() == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return Response.ok(reactie.get()).build();
		}
	}

	@PUT // Update
	@Path("{id}")
	public Response apiUpdate(@PathParam("id") long id, Reactie reactie) {
		if (reactie == null || reactie.getId() != id)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Optional<Reactie> oldReactie = reactieService.findById(id);
		if (!oldReactie.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Reactie target = oldReactie.get();
		target.setGebruiker(reactie.getGebruiker());
		target.setGebruikersToegang(reactie.getGebruikersToegang());
		target.setAanmaakDatum(reactie.getAanmaakDatum());
		target.setTekst(reactie.getTekst());
		
		System.out.println("Check in @PUT/id van ReactieApi");
		return Response.ok(reactieService.save(target)).build();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response apiDeleteById(@PathParam("id") long id) {
		System.out.println("Check in @Delete/id van ReactieApi");
		if (reactieService.findById(id).isPresent() == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			reactieService.deleteById(id);
			return Response.status(Response.Status.OK).build();
		}
	}
}
