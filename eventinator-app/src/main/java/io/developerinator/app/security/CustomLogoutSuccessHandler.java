package io.developerinator.app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.developerinator.app.dto.MessageResponseDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jvillanueva on 8/20/16.
 */
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    private ObjectMapper objectMapper;

    public CustomLogoutSuccessHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {

        String message = "Logged out";

        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");

        MessageResponseDto messageDto = new MessageResponseDto(message);
        objectMapper.writeValue(response.getWriter(), messageDto);
    }
}
