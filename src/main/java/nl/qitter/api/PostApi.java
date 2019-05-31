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

import nl.qitter.domain.Post;
import nl.qitter.services.PostService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("post")
public class PostApi {
	@Autowired
	private PostService postService;

	@POST // Create
	public Response apiCreate(Post post) {
		if (post.getId() != 0) {
			return Response.status(Response.Status.CONFLICT).build();
		}
		return Response.ok(postService.save(post)).build();
	}

	@GET // Retrieve/Read
	@Path("{id}")
	public Response apiGetById(@PathParam("id") long id) {
		Optional<Post> post = postService.findById(id);
		if (post.isPresent() == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			return Response.ok(post.get()).build();
		}
	}

	@GET // Retrieve/Read
	public Response apiGetAll() {
		System.out.println("Check in @GET van PostApi");
		return Response.ok(postService.findAll()).build();
	}

	@PUT // Update
	@Path("{id}")
	public Response apiUpdate(@PathParam("id") long id, Post post) {
		if (post == null || post.getId() != id)
			return Response.status(Response.Status.BAD_REQUEST).build();

		Optional<Post> oldPost = postService.findById(id);
		if (!oldPost.isPresent()) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
		Post target = oldPost.get();
		target.setGebruikersToegang(post.getGebruikersToegang());
		target.setPosts(post.getPosts());
		target.setPostSoort(post.getPostSoort());
		target.setAanmaakDatum(post.getAanmaakDatum());
		target.setTekst(post.getTekst());
		System.out.println("Check in @PUT/id van PostApi");
		return Response.ok(postService.save(target)).build();
	}

	@DELETE // Delete
	@Path("{id}")
	public Response apiDeleteById(@PathParam("id") long id) {
		if (postService.findById(id).isPresent() == false) {
			return Response.status(Response.Status.NOT_FOUND).build();
		} else {
			postService.deleteById(id);
			return Response.status(Response.Status.OK).build();
		}
	}

}