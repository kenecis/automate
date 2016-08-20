package io.developerinator.service;


import java.util.List;

import io.developerinator.app.domain.Account;

public interface AccountService {

    Account save(Account account);

    void delete(Account account);

    Account find(String id);

    List<Account> findAll();
}
