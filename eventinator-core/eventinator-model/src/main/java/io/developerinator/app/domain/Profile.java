package io.developerinator.app.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Profile {

    @Column(name = "account_id")
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
