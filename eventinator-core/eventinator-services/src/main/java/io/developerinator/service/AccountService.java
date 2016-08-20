package io.developerinator.service;


import io.developerinator.app.dto.AccountDto;
import io.developerinator.app.dto.ProfileDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface AccountService  extends UserDetailsService {

    AccountDto save(ProfileDto profileDto);

    void delete(AccountDto account);

    AccountDto find(Long id);

    List<AccountDto> findAll();
}
