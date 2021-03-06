package io.developerinator.app.controller;

import io.developerinator.app.dto.AccountDto;
import io.developerinator.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jvillanueva on 8/21/16.
 */
@RestController
@RequestMapping("/api/user")
public class PrincipalController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private SecurityContext securityContext;

    @RequestMapping
    public ResponseEntity<AccountDto> getPrincipal(){
        OAuth2Authentication principal = (OAuth2Authentication) securityContext.getAuthentication();
        AccountDto account = accountService.findByExternalId(principal.getPrincipal().toString());
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
