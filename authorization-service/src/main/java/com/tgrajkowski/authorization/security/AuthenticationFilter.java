package com.tgrajkowski.authorization.security;




import com.tgrajkowski.authorization.model.user.UserDto;
import com.tgrajkowski.authorization.model.user.UserMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final long EXPIRATION_TIME = 30 * 60 * 1000;
    static final String SECRET = "Secret";
    static final String HEADER_STRING = "Authorization";
    AuthenticationManager authenticationManager;
    UserMapper userMapper = new UserMapper();

    public AuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UserDto userDto = userMapper.mapToUserDto(request.getInputStream());
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword());
            return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();

        response.addHeader("Credentials", auth.getAuthorities().stream()
                .map(x -> x.getAuthority())
                .collect(Collectors.joining(", ")));
        response.addHeader(HEADER_STRING, token);

    }
}
