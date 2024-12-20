package com.hasansahin.gallerist.jwt;

import com.hasansahin.gallerist.exception.BaseException;
import com.hasansahin.gallerist.exception.ErrorMessage;
import com.hasansahin.gallerist.exception.MessageType;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = extractToken(request);
        if (token == null) {
            filterChain.doFilter(request, response);
            return;
        }
        try {
            authenticateToken(token);
        } catch (ExpiredJwtException e) {
            handleException(MessageType.TOKEN_IS_EXPIRED, e);
        } catch (Exception e) {
            handleException(MessageType.GENERAL_EXCEPTION, e);
        }
        filterChain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }


    private void handleException(MessageType messageType, Exception e) {
        throw new BaseException(new ErrorMessage(messageType, e.getMessage()));
    }

    private void setAuthentication(String username, UserDetails userDetails) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                username, null, userDetails.getAuthorities());
        authentication.setDetails(userDetails);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private void authenticateToken(String token) {
        String username = jwtService.getUsernameByToken(token);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtService.isTokenValid(token)) {
                setAuthentication(username, userDetails);
            }
        }
    }

}
