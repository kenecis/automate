package io.developerinator.service;

import io.developerinator.app.domain.Account;
import io.developerinator.app.domain.Profile;
import io.developerinator.app.dto.AccountDto;
import io.developerinator.app.dto.ProfileDto;
import io.developerinator.app.ref.AccountType;
import io.developerinator.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private Mapper mapper;

    @Override
    public Account loadUserByUsername(String s) throws UsernameNotFoundException {
        return accountRepository.findByUsername(s);
    }

    @Override
    public AccountDto save(ProfileDto profileDto) {
        log.info("Saving Account.");
        Validate.notNull(profileDto);

        Account account = new Account();
        account.setProfile(mapper.map(profileDto, Profile.class));
        account.setUsername(profileDto.getEmail());
        account.setPassword("N/A");
        account.setAccountType(AccountType.PERSONAL);
        return mapper.map(accountRepository.save(account), AccountDto.class);
    }

    @Override
    public void delete(AccountDto account) {

        Validate.notNull(account);
        accountRepository.delete(account.getId());
    }

    @Override
    public AccountDto find(Long id) {

        Validate.notNull(id);
        return mapper.map(accountRepository.findOne(id), AccountDto.class);
    }

    @Override
    public List<AccountDto> findAll() {
        return accountRepository.findAll().stream().map(a -> mapper.map(a, AccountDto.class)).collect(Collectors.toList());
    }
}
