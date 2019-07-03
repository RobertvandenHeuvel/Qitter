package nl.qitter.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import nl.qitter.config.JsonWebToken;
import nl.qitter.domain.Gebruiker;

@Component
@Path("checkCredentials")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CheckCredentialsApi {
	@POST
	public Response checkCredentials(Gebruiker user){
		Claims claims = JsonWebToken.decodeJWT(user.getToken(), user.getRol());
		if (claims != null)
			System.out.println(claims);
		else
			System.out.println("Er is geen token");
		return Response.ok(user).build();
	}
}
