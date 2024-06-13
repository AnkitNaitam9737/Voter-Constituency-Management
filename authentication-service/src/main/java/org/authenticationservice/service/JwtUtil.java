package org.authenticationservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtUtil {

//    @Value("${jwt.secret}")
//    private String secret;
//    @Value("${jwt.expiration}")
//    private String expiration;
//    private Key key;
//
//    public JwtUtil() {
//        this.key = Keys.hmacShaKeyFor(secret.getBytes());
//    }
//
//    public Claims getClaims(String token){
//        return Jwts.parser().setSigningKey(key).build().parseClaimsJwt(token).getBody();
//    }
//
//    public Date getExpirationDate(String token){
//        return getClaims(token).getExpiration();
//    }
//
//    private boolean isExpired(String token){
//        return getClaims(token).getExpiration().before(new Date());
//    }
//
//    public String generateToken(Integer id, String password, String tokenType){
//        Map<String, ? extends Serializable> claims = Map.of("id", id, "password", password, "tokenType", tokenType);
//        return null;
//    }
//


}
