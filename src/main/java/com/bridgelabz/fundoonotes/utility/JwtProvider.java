package com.bridgelabz.fundoonotes.utility;
import org.springframework.context.annotation.Configuration;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
@Configuration
public class JwtProvider {
	public String generateToken(String emailId) {
		
		return JWT.create().withClaim("email", emailId).sign(Algorithm.HMAC512(emailId));
		
	}

	public String parseToken(String token) {
		//return JWT.create(Algorithm.HMAC512(token)).build().verify(token)
		return JWT.require(Algorithm.HMAC512(token)).build().verify(token).getClaim("email").asString();
	}

}

