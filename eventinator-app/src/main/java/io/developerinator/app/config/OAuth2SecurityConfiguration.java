package io.developerinator.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by jvillanueva on 8/20/16.
 */
public class OAuth2SecurityConfiguration {

    @Autowired
    private Environment env;

    @Resource
    @Qualifier("accessTokenRequest")
    private AccessTokenRequest accessTokenRequest;

    @Bean
    public OAuth2ProtectedResourceDetails googleResource() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setId("google-oauth-client");
        details.setClientId(env.getProperty("google.client.id"));
        details.setClientSecret(env.getProperty("google.client.secret"));
        details.setAccessTokenUri(env.getProperty("google.accessTokenUri"));
        details.setUserAuthorizationUri(env.getProperty("google.userAuthorizationUri"));
        details.setTokenName(env.getProperty("google.authorization.code"));
        String commaSeparatedScopes = env.getProperty("google.auth.scope");
        details.setScope(parseScopes(commaSeparatedScopes));
        details.setPreEstablishedRedirectUri(env.getProperty("google.preestablished.redirect.url"));
        details.setUseCurrentUri(false);
        details.setAuthenticationScheme(AuthenticationScheme.query);
        details.setClientAuthenticationScheme(AuthenticationScheme.form);
        return details;
    }

    private List<String> parseScopes(String commaSeparatedScopes) {
        List<String> scopes = newArrayList();
        Collections.addAll(scopes, commaSeparatedScopes.split(","));
        return scopes;
    }

    @Bean
    public OAuth2RestTemplate googleRestTemplate() {
        return new OAuth2RestTemplate(googleResource(), new DefaultOAuth2ClientContext(accessTokenRequest));
    }

}
