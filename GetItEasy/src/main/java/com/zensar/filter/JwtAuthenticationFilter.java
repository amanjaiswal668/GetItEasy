package com.zensar.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.zensar.helper.JwtUtil;
import com.zensar.service.CustomUserDetailService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		/*Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			System.out.println(headerNames.nextElement());
		}
		*/
		String requestHeaderToken = request.getHeader("Authorization");
		System.out.println(requestHeaderToken);
		String username = null;
		String jwtToken = null;
		if (requestHeaderToken != null && requestHeaderToken.startsWith("Bearer ")) {
			jwtToken = requestHeaderToken.substring(7);
			try {
				username = jwtUtil.extractUsername(jwtToken);
				System.out.println(username);

			} catch (Exception e) {
				e.printStackTrace();
			}

			UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);
		

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

			} else {
				System.out.println("Username or token not correct");
			}

		} else {
			System.out.println("Token Not present : Authorization");
		}

		filterChain.doFilter(request, response);
	}

}
