package nl.qitter.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.impl.DefaultClaims;
import nl.qitter.domain.Rol;

public class OnzeClaims extends DefaultClaims{
	private static String rol = "rol";
	
    public String getRol() {
        return String.valueOf(rol);
    }

    public Claims setRol(Rol rol) {
        setValue(this.getRol(), rol);
        return this;
    }
    
    public static OnzeClaims copyFields(Claims claims) {
    	OnzeClaims oc = new OnzeClaims();
    	oc.setId(claims.getId());
    	oc.setIssuer(claims.getIssuer());
    	oc.setSubject(claims.getSubject());
    	oc.setIssuedAt(claims.getIssuedAt());
    	return oc;
    }
}
