package com.cg.onlinetraining.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Tejaswini
 * Created On: 05/11/2019
 * Description: Checks for Unauthorized access
 *
 */
@Component
public class JwtAuthEntryPoint implements AuthenticationEntryPoint {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {

		logger.error("Unauthorized error. Message - {}", e.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Error -> Unauthorized");

	}
}
