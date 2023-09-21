package com.example.dvaraproject.ecom.jwt;

import com.example.dvaraproject.ecom.security.ProductUserDetailsService;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final ProductUserDetailsService productUserDetailsService;
    

    public JWTAuthenticationFilter(JWTService jwtService, ProductUserDetailsService productUserDetailsService) {
		super();
		this.jwtService = jwtService;
		this.productUserDetailsService = productUserDetailsService;
	}


	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userName = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7);
            userName = jwtService.extractUsernameFromToken(token);
        }
        if (userName != null & SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = productUserDetailsService.loadUserByUsername(userName);
            if(jwtService.validateToken(token, userDetails)) {
                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}