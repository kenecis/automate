package io.developerinator.app.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
public class Account extends Persistable {

    @Column
    private String username;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToMany
    @JoinTable(
            name = "ACCOUNT_INTERESTS",
            joinColumns = @JoinColumn(name = "ACCOUNT_ID"),
            inverseJoinColumns = @JoinColumn(name = "INTEREST_ID")
    )
    private Set<Interest> interests;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Event> events;

    @Embedded
    private Profile profile;

}
