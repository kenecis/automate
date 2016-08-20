package io.developerinator.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.developerinator.app.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by jvillanueva on 8/20/16.
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] PERMIT_ALL = {
            "/", "/googleLogin", "/api/logout", "/js/**", "/css/**", "/images/**",
            "/static/**", "/public/**", "/favicon.ico"
    };
    private static final String LOGIN_FORM_URL = "/googleLogin";
    private static final String DEFAULT_FILTER_PROCESSOR_URL = LOGIN_FORM_URL;
    private static final String CHECK_TOKEN_ENDPOINT_URL = "https://www.googleapis.com/oauth2/v1/tokeninfo";


    @Autowired
    @Qualifier("googleRestTemplate")
    private OAuth2RestTemplate googleRestTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OAuth2ClientContextFilter oAuth2ClientContextFilter;

    @Value("${google.client.id}")
    private String clientId;
    @Value("${google.client.secret}")
    private String clientSecret;

    @Bean
    public CustomAccessDeniedHandler accessDeniedHandler(){
        return new CustomAccessDeniedHandler(objectMapper);
    }

    @Bean
    public CustomAuthenticationEntryPoint authenticationEntryPoint(){
        return new CustomAuthenticationEntryPoint(LOGIN_FORM_URL, objectMapper);
    }

    @Bean
    public DefaultUserAuthenticationConverter userAuthenticationConverter(){
        return new DefaultUserAuthenticationConverter();
    }

    @Bean
    public GoogleAccessTokenConverter accessTokenConverter(){
        GoogleAccessTokenConverter accessTokenConverter = new GoogleAccessTokenConverter();
        accessTokenConverter.setUserTokenConverter(userAuthenticationConverter());
        return accessTokenConverter;
    }

    @Bean
    @Primary
    public GoogleTokenServices tokenServices(){
        GoogleTokenServices tokenServices = new GoogleTokenServices();
        tokenServices.setCheckTokenEndpointUrl(CHECK_TOKEN_ENDPOINT_URL);
        tokenServices.setClientId(clientId);
        tokenServices.setClientSecret(clientSecret);
        tokenServices.setAccessTokenConverter(accessTokenConverter());
        return tokenServices;
    }

    @Bean
    public CustomLogoutSuccessHandler logoutSuccessHandler(){
        return new CustomLogoutSuccessHandler(objectMapper);
    }

    @Bean
    public CustomOAuth2ClientAuthenticationProcessingFilter authenticationProcessingFilter(){
        CustomOAuth2ClientAuthenticationProcessingFilter filter = new CustomOAuth2ClientAuthenticationProcessingFilter(DEFAULT_FILTER_PROCESSOR_URL);
        filter.setRestTemplate(googleRestTemplate);
        filter.setTokenServices(tokenServices());
        return filter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(PERMIT_ALL).permitAll()
                .anyRequest().fullyAuthenticated()
                .and()
                .csrf().disable()
                .headers().frameOptions().sameOrigin()
                .and()
                .formLogin().disable()
                .logout().logoutUrl("/api/logout").logoutSuccessHandler(logoutSuccessHandler()).permitAll()
                .and()
                .anonymous().disable()
                .addFilterAfter(oAuth2ClientContextFilter, ExceptionTranslationFilter.class)
                .addFilterBefore(authenticationProcessingFilter(), FilterSecurityInterceptor.class)
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler()).authenticationEntryPoint(authenticationEntryPoint());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("user");
    }
}
