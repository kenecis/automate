package io.developerinator.app.domain;

import io.developerinator.app.base.Persistable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
public class Interest extends Persistable {


    @JoinTable(
            name = "ACCOUNT_INTERESTS",
            joinColumns = @JoinColumn(name = "INTEREST_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID")
    )
    @ManyToMany
    private List<Account> account;

    @Column
    private String name;
}
