package io.developerinator.service;

import java.util.List;

import io.developerinator.app.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.developerinator.repository.AccountRepository;


@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account save(Account account) {
        log.info("Saving Account.");
        Validate.notNull(account);
        return accountRepository.save(account);
    }

    @Override
    public void delete(Account account) {

        Validate.notNull(account);
        accountRepository.delete(account);
    }

    @Override
    public Account find(String id) {

        Validate.notEmpty(id);
        return accountRepository.findOne(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
