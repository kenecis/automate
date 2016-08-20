package io.developerinator.service;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.developerinator.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Before
    public void init(){}

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSave_accountNotExists(){

        expectedException.expect(NullPointerException.class);
        accountService.save(null);
    }
}
