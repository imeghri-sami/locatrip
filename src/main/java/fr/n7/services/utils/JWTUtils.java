package fr.n7.services.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.Date;

public class JWTUtils {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String SECRET_KEY = "secret-key";
    private static final long EXPIRATION_DATE = 18_000_000; /*5 Hours*/
    private static final String REQUEST_HEADER = "Authorization";

    private static Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY)
                .parseClaimsJws(token).getBody();
    }

    public static String extractSubject(String token) {
        return getClaims(token).getSubject();
    }

    public static Date extractExDate(String token) {
        return getClaims(token).getExpiration();
    }

    public static String extractPlatform(String token) {
        return getClaims(token).get("platform", String.class);
    }

    private static boolean isExpired(String token) {
        return extractExDate(token).before(new Date());
    }

    public static String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_DATE))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static boolean validateToken(String token, String username) {
        String subject = extractSubject(token);
        return (subject.equals(username) && !isExpired(token));
    }

}