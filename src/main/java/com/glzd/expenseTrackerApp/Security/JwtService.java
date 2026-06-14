package com.glzd.expenseTrackerApp.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Generate Signing Key
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    // Generate JWT Token
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + jwtExpiration
                        )
                )
                .signWith(
                        getSigningKey(),
                        SignatureAlgorithm.HS256
                )
                .compact();
    }

    // Extract Email from Token
    public String extractUsername(String token) {
        return extractClaim(
                token,
                Claims::getSubject
        );
    }

    // Generic Claim Extractor
    public <T> T extractClaim(
            String token,
            Function<Claims, T> claimsResolver) {

        final Claims claims = extractAllClaims(token);

        return claimsResolver.apply(claims);
    }

    // Extract Claims
    private Claims extractAllClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validate Token
    public boolean isTokenValid(
            String token,
            String email) {

        final String extractedEmail =
                extractUsername(token);

        return extractedEmail.equals(email)
                && !isTokenExpired(token);
    }

    // Check Expiration
    private boolean isTokenExpired(
            String token) {

        return extractExpiration(token)
                .before(new Date());
    }

    private Date extractExpiration(
            String token) {

        return extractClaim(
                token,
                Claims::getExpiration
        );
    }
}