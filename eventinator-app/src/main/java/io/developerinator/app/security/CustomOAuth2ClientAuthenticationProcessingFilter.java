package io.developerinator.app.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.developerinator.app.dto.ErrorResponseDto;
import io.developerinator.app.dto.ProfileDto;
import io.developerinator.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by jvillanueva on 8/20/16.
 */
public class CustomOAuth2ClientAuthenticationProcessingFilter extends OAuth2ClientAuthenticationProcessingFilter {

    private static final String PROFILE_LINK = "https://www.googleapis.com/oauth2/v1/userinfo?alt=json&access_token=";

    private ObjectMapper objectMapper;

    private AccountService accountService;

    private SecurityContext securityContext;

    public CustomOAuth2ClientAuthenticationProcessingFilter(String defaultFilterProcessesUrl, ObjectMapper objectMapper, AccountService accountService, SecurityContext securityContext) {
        super(defaultFilterProcessesUrl);
        this.objectMapper = objectMapper;
        this.accountService = accountService;
        this.securityContext =  securityContext;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);
        ResponseEntity<ProfileDto> profileEntity = restTemplate.getForEntity(
                PROFILE_LINK + restTemplate.getAccessToken(),
                ProfileDto.class
        );
        if(accountService.loadUserByUsername(profileEntity.getBody().getEmail()) == null){
            accountService.save(profileEntity.getBody());
        }
        securityContext.setAuthentication(authResult);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");
        response.setHeader("Cache-Control", "no-cache");

        ErrorResponseDto errorDto = new ErrorResponseDto("You do not have permission to access this resource");
        objectMapper.writeValue(response.getWriter(), errorDto);
    }
}
