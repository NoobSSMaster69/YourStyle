//package org.example.tokens;
//
//import io.jsonwebtoken.*;
//import io.jsonwebtoken.security.SignatureException;
//import org.example.models.User;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Component;
//
//import java.nio.file.attribute.UserPrincipal;
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProvider.class);
//
//    @Value(value = "${app.jwtSecret}")
//    private String jwtSecret;
//
//    @Value(value = "${app.jwtExpirationInMs}")
//    private int jwtExpirationInMs;
//
//    public String generateToken(Authentication authentication) {
//        User user = (User) authentication.getPrincipal();
//
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);
//
//        return Jwts.builder().setSubject(Long.toString(user.getUserId())).setIssuedAt(new Date())
//                .setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
//    }
//
//    public Long getUserIdFromJWT(String token) {
//        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//
//        return Long.valueOf(claims.getSubject());
//    }
//
//    public boolean validateToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException ex) {
//            LOGGER.error("Invalid JWT signature");
//        } catch (MalformedJwtException ex) {
//            LOGGER.error("Invalid JWT token");
//        } catch (ExpiredJwtException ex) {
//            LOGGER.error("Expired JWT token");
//        } catch (UnsupportedJwtException ex) {
//            LOGGER.error("Unsupported JWT token");
//        } catch (IllegalArgumentException ex) {
//            LOGGER.error("JWT claims string is empty");
//        }
//        return false;
//    }
//}