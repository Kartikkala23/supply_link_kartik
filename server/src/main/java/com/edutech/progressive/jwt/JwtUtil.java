// package com.edutech.progressive.jwt;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.stereotype.Component;

// import com.edutech.progressive.entity.Supplier;
// import com.edutech.progressive.repository.SupplierRepository;

// import java.util.Date;
// import java.util.HashMap;
// import java.util.Map;

// // @Component
// // public class JwtUtil {

// //     private SupplierRepository supplierRepository;

// //     @Autowired
// //     public JwtUtil(SupplierRepository supplierRepository) {
// //         this.supplierRepository = supplierRepository;
// //     }

// //     private final String secret = "secretKey";

// //     private final int expiration = 86400;

// //     public String generateToken(String username) {
// //         Date now = new Date();
// //         Date expiryDate = new Date(now.getTime() + expiration * 1000);
// //         Supplier user = supplierRepository.findByUsername(username);

// //         Map<String, Object> claims = new HashMap<>();
// //         claims.put("sub", username);

// //         // Assign role based on user type
// //         claims.put("role", user.getRole());

// //         return Jwts.builder()
// //                 .setClaims(claims)
// //                 .setIssuedAt(now)
// //                 .setExpiration(expiryDate)
// //                 .signWith(SignatureAlgorithm.HS512, secret)
// //                 .compact();
// //     }

// //     public Claims extractAllClaims(String token) {
// //         Claims claims;
// //         try {
// //             claims = Jwts.parser()
// //                     .setSigningKey(secret)
// //                     .parseClaimsJws(token)
// //                     .getBody();
// //         } catch (Exception e) {
// //             claims = null;
// //         }
// //         return claims;
// //     }

// //     public String extractUsername(String token) {
// //         Claims claims = Jwts.parser()
// //                 .setSigningKey(secret)
// //                 .parseClaimsJws(token)
// //                 .getBody();
// //         return claims.getSubject();
// //     }

// //     public boolean isTokenExpired(String token) {
// //         Date expirationDate = Jwts.parser()
// //                 .setSigningKey(secret)
// //                 .parseClaimsJws(token)
// //                 .getBody()
// //                 .getExpiration();
// //         return expirationDate.before(new Date());
// //     }

// //     public boolean validateToken(String token, UserDetails userDetails) {
// //         final String username = extractUsername(token);
// //         return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
// //     }
// // }



// @Component
// public class JwtUtil {

//     private SupplierRepository supplierRepository;

//     @Autowired
//     public JwtUtil(SupplierRepository supplierRepository) {
//         this.supplierRepository = supplierRepository;
//     }

//     private final String secret = "secretKey";

//     private final int expiration = 86400;

//     public String generateToken(String username) {
//         Date now = new Date();
//         Date expiryDate = new Date(now.getTime() + expiration * 1000);
//         Supplier user = supplierRepository.findByUsername(username);

//         Map<String, Object> claims = new HashMap<>();
//         claims.put("sub", username);

//         // Assign role based on user type
//         claims.put("role", user.getRole());

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setIssuedAt(now)
//                 .setExpiration(expiryDate)
//                 .signWith(SignatureAlgorithm.HS512, secret)
//                 .compact();
//     }

//     public Claims extractAllClaims(String token) {
//         Claims claims;
//         try {
//             claims = Jwts.parser()
//                     .setSigningKey(secret)
//                     .parseClaimsJws(token)
//                     .getBody();
//         } catch (Exception e) {
//             claims = null;
//         }
//         return claims;
//     }

//     public String extractUsername(String token) {
//         Claims claims = Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody();
//         return claims.getSubject();
//     }

//     public boolean isTokenExpired(String token) {
//         Date expirationDate = Jwts.parser()
//                 .setSigningKey(secret)
//                 .parseClaimsJws(token)
//                 .getBody()
//                 .getExpiration();
//         return expirationDate.before(new Date());
//     }

//     public boolean validateToken(String token, UserDetails userDetails) {
//         final String username = extractUsername(token);
//         return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//     }
// }



package com.edutech.progressive.jwt;

import com.edutech.progressive.entity.Supplier;
import com.edutech.progressive.repository.SupplierRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private final SupplierRepository supplierRepository;

    // ✅ Secure 512‑bit key generated by JJWT (HS512 compliant)
    private static final SecretKey SIGNING_KEY =
            Keys.secretKeyFor(SignatureAlgorithm.HS512);

    // ✅ Token validity: 24 hours
    private static final long EXPIRATION_TIME = 86400 * 1000L;

    @Autowired
    public JwtUtil(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    // ✅ Generate JWT
    public String generateToken(String username) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        Supplier user = supplierRepository.findByUsername(username);

        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SIGNING_KEY, SignatureAlgorithm.HS512)
                .compact();
    }

    // ✅ Extract all claims
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // ✅ Extract username
    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    // ✅ Check expiration
    public boolean isTokenExpired(String token) {
        return extractAllClaims(token)
                .getExpiration()
                .before(new Date());
    }

    // ✅ Validate token
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }
}