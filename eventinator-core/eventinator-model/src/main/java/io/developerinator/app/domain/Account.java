package io.developerinator.app.domain;

import io.developerinator.app.base.Persistable;
import io.developerinator.app.ref.AccountType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Getter
@Setter
@ToString
public class Account extends Persistable implements UserDetails {

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

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Event> events;

    @Embedded
    private Profile profile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(new SimpleGrantedAuthority("USER")).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
