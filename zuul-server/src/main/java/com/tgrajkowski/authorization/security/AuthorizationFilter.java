package com.tgrajkowski.authorization.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class AuthorizationFilter extends BasicAuthenticationFilter {
    public AuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public AuthorizationFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader("Authorization");
        String secret = "Secret";
        if (token == null) {
            chain.doFilter(request, response);
            } else {
            String user = Jwts.parser()
                    .setSigningKey(secret.getBytes())
                    .parseClaimsJws(token)
                    .getBody().getSubject();
            if (user != null) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
            chain.doFilter(request, response);
        }
    }
}
