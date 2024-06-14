package org.apigateway.utils;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtUtils {

    public static final String SECRET = "secrfjadjkfskdatirNJ8979ujhnjnIN9899jnigHJB99NJNJDDDDDDDDDDDDDDDNDSYED93887383EDHJXNJFNDIEU38jdue8dje8jsi9et";

    public void validateToken(final String token) {
        Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(token);
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
