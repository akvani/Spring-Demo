package com.stackroute.ecommerce.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.GenericFilter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class EcommFilter extends GenericFilter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	HttpServletRequest 	httprequest=(HttpServletRequest) request;
	HttpServletResponse httpresponse=(HttpServletResponse) response;
	
	httpresponse.setHeader("Access-Control-Allow-Origin", httprequest.getHeader("origin"));
	httpresponse.setHeader("Access-Control-Allow-Method", "POST,GET,DELETE,PUT,OPTIONS");
	httpresponse.setHeader("Access-Control-Allow-Credential", "true");
	
	String authheader=httprequest.getHeader("Authorization");
	
	System.out.println(authheader);
	
	if(httprequest.getMethod().equalsIgnoreCase(HttpMethod.OPTIONS.name()))
	{
chain.doFilter(httprequest, httpresponse);
	}

else
{

String authheader1=httprequest.getHeader("Authorization");
System.out.println(authheader);

if((authheader1==null) || (!authheader1.startsWith("Bearer")))
		{
	throw new ServletException("JWT Token is missing");
		}

String mytoken=authheader1.substring(7);

try
{
JwtParser jparser=Jwts.parser().setSigningKey("ibmfsd");	

Jwt jwtobj=jparser.parse(mytoken);

Claims claim= (Claims)jwtobj.getBody();
System.out.println(claim.getSubject());

}
catch(SignatureException sig)
{
	
	throw new ServletException("signature mismatch / token expried");
}
catch(MalformedJwtException excep)
{
	throw new ServletException("token is modified which is unauthorized");
}
}


chain.doFilter(httprequest, httpresponse);

}


}
