package io.developerinator.app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.developerinator.app.dto.ErrorResponseDto;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private ObjectMapper objectMapper;

    public CustomAccessDeniedHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");

        ErrorResponseDto errorDto = new ErrorResponseDto("You do not have permission to access this resource");
        objectMapper.writeValue(response.getWriter(), errorDto);
    }
}
