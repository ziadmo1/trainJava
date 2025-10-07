// package com.trainJava.demo.security;

// import java.io.IOException;
// import java.util.ArrayList;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Component;
// import org.springframework.web.filter.OncePerRequestFilter;

// import jakarta.servlet.FilterChain;
// import jakarta.servlet.ServletException;
// import jakarta.servlet.http.HttpServletRequest;
// import jakarta.servlet.http.HttpServletResponse;

// @Component
// public class JwtAuthFilter extends OncePerRequestFilter {

//     @Autowired
//     private JwtHelper jwtUtil;

//     @Override
//     protected void doFilterInternal(HttpServletRequest request,
//             HttpServletResponse response,
//             FilterChain filterChain)
//             throws ServletException, IOException {

//         String authHeader = request.getHeader("Authorization");

//         if (authHeader == null || !authHeader.startsWith("Bearer ")) {
//             filterChain.doFilter(request, response);
//             return;
//         }

//         String jwt = authHeader.substring(7);
//         String username = jwtUtil.extractUsername(jwt);

//         if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//             boolean isValid = jwtUtil.validateToken(jwt, username);

//             if (isValid) {
//                 UsernamePasswordAuthenticationToken authToken
//                         = new UsernamePasswordAuthenticationToken(username, null, new ArrayList<>());
//                 SecurityContextHolder.getContext().setAuthentication(authToken);
//             }
//         }

//         filterChain.doFilter(request, response);
//     }
// }
