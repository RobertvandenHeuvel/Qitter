package nl.qitter.config;

import io.jsonwebtoken.JwtBuilder;
import nl.qitter.domain.Rol;
import io.jsonwebtoken.impl.*;

public class OnzeJwtBuilder extends DefaultJwtBuilder {
	public Rol rol;
	private OnzeClaims oc = new OnzeClaims();
	
	JwtBuilder setSubjectRol(Rol rol) {
		oc.setRol(rol);
		return this;
	}
}
