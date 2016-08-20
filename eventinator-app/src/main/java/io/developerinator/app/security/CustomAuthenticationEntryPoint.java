package io.developerinator.app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.developerinator.app.dto.ErrorResponseDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jvillanueva on 8/20/16.
 */
public class CustomAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private ObjectMapper objectMapper;

    public CustomAuthenticationEntryPoint(String loginFormUrl, ObjectMapper objectMapper) {
        super(loginFormUrl);
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");

        String errorMessage = "Access is denied";
        if (StringUtils.isNotBlank(e.getMessage())) {
            errorMessage = e.getMessage();
        }
        ErrorResponseDto errorDto = new ErrorResponseDto(errorMessage);
        objectMapper.writeValue(response.getWriter(), errorDto);
    }

}
