package com.stackroute.universityapp.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
//
//public class UniversityFilter extends GenericFilter{
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		
//	HttpServletRequest 	httprequest=(HttpServletRequest) request;
//	HttpServletResponse httpresponse=(HttpServletResponse) response;
//	
//	httpresponse.setHeader("Access-Control-Allow-Origin", httprequest.getHeader("origin"));
//	httpresponse.setHeader("Access-Control-Allow-Method", "POST,GET,DELETE,PUT,OPTIONS");
//	httpresponse.setHeader("Access-Control-Allow-Credential", "true");
//	
//	String authheader=httprequest.getHeader("Authorization");
//	
//	System.out.println(authheader);
//	
//	
//	if((authheader==null) || (!authheader.startsWith("Bearer")))
//	throw new ServletException("JWT Token is missing");
//	
//	String mytoken=authheader.substring(7);
//	
//	try
//	{
//		JwtParser jparser=Jwts.parser().setSigningKey("ibmkey");
//	Jwt jwtobj=jparser.parse(mytoken);
//	Claims claim=(Claims)jwtobj.getBody();
//	System.out.println("User logged in is " + claim.getSubject());
//	
//	
//	}
//	catch(SignatureException e)
//	{
//		throw new ServletException("signature mismatch");
//	//	System.out.println("Signature error " + e);
//	}
//		
//	catch(MalformedJwtException e)
//	{
//		throw new ServletException("malformed mismatch");
//		
//		//System.out.println("invalid tokdn error " + e);
//	}
//	
//	chain.doFilter(httprequest, httpresponse);
//	}
//	
//	
//	
//	
//
//}
