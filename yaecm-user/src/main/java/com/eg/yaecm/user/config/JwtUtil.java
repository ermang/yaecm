package com.eg.yaecm.user.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {
    private String secretKey = "your256bitlongsecretkey123456789012";; // Secret key used to sign the JWT

    public JwtUtil() {
    }

    // Generate token
    public String generateToken(String username) {

        //return JwtBuilder.
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    // Extract username from token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // Validate token
    public boolean validateToken(String token, String username) {
        return (username.equals(extractUsername(token)) && !isTokenExpired(token));
    }

    // Check if token is expired
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // Extract claims (subject, expiration, etc.)
    private Claims extractClaims(String token) {
        JwtParser parser = Jwts.parser() // Updated for new version
                .setSigningKey(secretKey) // Set the secret key for signing
                .build(); // Build the parser
        return parser.parseClaimsJws(token).getBody(); // Parse the claims
    }
}