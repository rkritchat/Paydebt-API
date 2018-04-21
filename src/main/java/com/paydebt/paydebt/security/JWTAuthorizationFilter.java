package com.paydebt.paydebt.security;

import com.paydebt.paydebt.model.UserId;
import com.paydebt.paydebt.service.CustomerDetailService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.paydebt.paydebt.constants.SecurityConstant.HEADER_STRING;
import static com.paydebt.paydebt.constants.SecurityConstant.SECRET;
import static com.paydebt.paydebt.constants.SecurityConstant.TOKEN_PREFIX;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    private CustomerDetailService customerDetailService;

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager, CustomerDetailService customerDetailService) {
        super(authenticationManager);
        this.customerDetailService = customerDetailService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Authorization");
        String header = request.getHeader(HEADER_STRING);
        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            System.out.println("header null");
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken token = getToken(header);
        SecurityContextHolder.getContext().setAuthentication(token);
        chain.doFilter(request, response);
    }

    public UsernamePasswordAuthenticationToken getToken(String header) {
        String username = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(header.replace(TOKEN_PREFIX, "")).getBody()
                .getSubject();
        UserId userIdByUsername = customerDetailService.getUserIdByUsername(username);
        UserDetails userDetails = customerDetailService.loadUserByUsername(username);
        return username != null ? new UsernamePasswordAuthenticationToken(userIdByUsername, null, userDetails.getAuthorities()) : null;
    }


}
