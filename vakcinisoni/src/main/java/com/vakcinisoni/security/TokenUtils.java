package com.vakcinisoni.security;

import com.vakcinisoni.models.Citizen;
import com.vakcinisoni.repository.impl.CitizenRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.xmldb.api.base.XMLDBException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class TokenUtils {

	@Value("spring-security-example")
	private String APP_NAME;
	
	//Secret is used to generate and validate JWT
	@Value("somesecret")
	public String SECRET;

	// Valid for - 30 minutes
	@Value("1800000")
	private int EXPIRES_IN;
	
	//Request header
	@Value("Authorization")
	private String AUTH_HEADER;
	
	private static final String AUDIENCE_WEB = "web";
	
	@Autowired
	private CitizenRepository userService;

	// Algoritam za potpisivanje JWT
	private SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
	
	public String generateToken(String id) {
		return Jwts.builder()
				.setIssuer(APP_NAME)
				.setSubject(id.toString())
				.setAudience(generateAudience())
				.setIssuedAt(new Date())
				.setExpiration(generateExpirationDate())
				.signWith(SIGNATURE_ALGORITHM, SECRET).compact();
	}
		
	private String generateAudience() {
		//	https://spring.io/projects/spring-mobile
		//	String audience = AUDIENCE_UNKNOWN;
		//		if (device.isNormal()) {
		//			audience = AUDIENCE_WEB;
		//		} else if (device.isTablet()) {
		//			audience = AUDIENCE_TABLET;
		//		} else if (device.isMobile()) {
		//			audience = AUDIENCE_MOBILE;
		//		}
		
		return AUDIENCE_WEB;
	}
	
	private Date generateExpirationDate() {
		return new Date(new Date().getTime() + EXPIRES_IN);
	}
	
	public String getToken(HttpServletRequest request) {
		String authHeader = getAuthHeaderFromHeader(request);

		// JWT is received through header 'Authorization' in format:
		// Bearer header.payload.signature
		
		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}

		return null;
	}
	
	public String getUsernameFromToken(String token) {
		String userId;
		
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			userId =claims.getSubject();
		} catch (ExpiredJwtException ex) {
			userId = null;
		} catch (Exception e) {
			userId = null;
		}
		
		return userId;
	}
	
	public Date getIssuedAtDateFromToken(String token) {
		Date issueAt;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			issueAt = claims.getIssuedAt();
		} catch (ExpiredJwtException ex) {
			System.out.println("Token expired");
			issueAt = null;
		} catch (Exception e) {
			issueAt = null;
		}
		return issueAt;
	}
	
	public String getAudienceFromToken(String token) {
		String audience;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			audience = claims.getAudience();
		} catch (ExpiredJwtException ex) {
			System.out.println("Token expired");
			audience = null;
		} catch (Exception e) {
			audience = null;
		}
		return audience;
	}
	
	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = this.getAllClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (ExpiredJwtException ex) {
			System.out.println("Token expired");
			expiration = null;
		} catch (Exception e) {
			expiration = null;
		}
		
		return expiration;
	}
	
	private Claims getAllClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token)
					.getBody();
		} catch (ExpiredJwtException ex) {
			System.out.println("Token expired");
			claims = null;
		} catch (Exception e) {
			claims = null;
		}
		
		return claims;
	}
	
	public Boolean validateToken(String token, Citizen userDetails) {
		Citizen user = userDetails;
		final String userId = getUsernameFromToken(token);

		return (userId != null
			&& userId == user.getJmbg());
	}
	
	public int getExpiredIn() {
		return EXPIRES_IN;
	}
	
	public String getAuthHeaderFromHeader(HttpServletRequest request) {
		return request.getHeader(AUTH_HEADER);
	}

	public boolean validate(String token) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		String userId = getUsernameFromToken(token);
		return (userId != null && userService.findOne(userId) != null);
	}
	
}
