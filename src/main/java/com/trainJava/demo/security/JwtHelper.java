// package com.trainJava.demo.security;

// import java.util.Date;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Component;

// import com.trainJava.demo.dtos.UserAccountDto;

// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// @Component
// public class JwtHelper {

//     @Value("${jwt.secret}")
//     private String secretKey;

//     public String getSecretKey() {
//         return secretKey;
//     }

//     public String generatToken(Map<String, Object> claims, UserAccountDto userDetails) {
//         var jwt = Jwts.builder().setClaims(claims)
//                 .setSubject(userDetails.getEmployeeId().toString()).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
//                 .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256))
//                 .compact();
//         return jwt;
//     }

//     public  String extractUsername(String token) {
//         return Jwts.parserBuilder().setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS256)).build()
//                 .parseClaimsJws(token).getBody().getSubject();
//     }

//      public  boolean validateToken(String token, String username) {
//         String extractedUser = extractUsername(token);
//         return (extractedUser.equals(username) && !isTokenExpired(token));
//     }

//     private  boolean isTokenExpired(String token) {
//         Date expiration = Jwts.parserBuilder()
//                 .setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.HS256))
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getExpiration();
//         return expiration.before(new Date());
//     }

// }
