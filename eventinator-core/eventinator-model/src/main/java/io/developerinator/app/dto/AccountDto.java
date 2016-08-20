package io.developerinator.app.dto;


import io.developerinator.app.ref.AccountType;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class AccountDto implements Serializable{

    private static final long serialVersionUID = -6268340832052128049L;

    private Long id;

    private String username;

    private String password;

    private AccountType accountType;

    private Set<InterestDto> interests;
}
