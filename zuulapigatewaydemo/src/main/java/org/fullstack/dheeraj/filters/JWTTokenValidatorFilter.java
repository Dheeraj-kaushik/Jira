//package org.fullstack.dheeraj.filters;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//
//import javax.crypto.SecretKey;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.fullstack.dheeraj.constants.SecurityConstants;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//
//public class JWTTokenValidatorFilter extends OncePerRequestFilter{
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//
//		String jwt = request.getHeader(SecurityConstants.JWT_HEADER);
//		if(jwt != null) {
//			try {
//				SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
//				Claims claims = Jwts.parserBuilder()
//						.setSigningKey(key)
//						.build()
//						.parseClaimsJws(jwt)
//						.getBody();
//				
//				String username = String.valueOf(claims.get("Username"));
//				String authorities = (String) claims.get("Authorities");
//				Authentication auth = new UsernamePasswordAuthenticationToken(username , null ,
//									AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
//				SecurityContextHolder.getContext().setAuthentication(auth);
//			}catch(Exception e){
//				throw new BadCredentialsException("invalid token received");
//			}
//		}
//		filterChain.doFilter(request , response);
//	}
//	
//	@Override
//	protected boolean shouldNotFilter(HttpServletRequest request) {
//		return request.getServletPath().equals("/user");
//	}
//
//	
//	
//}
