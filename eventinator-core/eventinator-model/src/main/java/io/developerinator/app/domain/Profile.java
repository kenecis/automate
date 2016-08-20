package io.developerinator.app.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Profile {

    @Column(name = "external_id")
    private String id;

    @Column
    private String email;

    @Column
    private Boolean verifiedEmail;

    @Column
    private String name;

    @Column
    private String givenName;

    @Column
    private String familyName;

    @Column
    private String link;

    @Column
    private String picture;

    @Column
    private String gender;

    @Column
    private String locale;

    @Column
    private String hd;
}
