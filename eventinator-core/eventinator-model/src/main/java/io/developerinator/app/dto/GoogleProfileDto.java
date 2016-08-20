package io.developerinator.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by jvillanueva on 8/20/16.
 */
@Getter
@Setter
@ToString
public class GoogleProfileDto {

    private String id;

    private String email;

    @JsonProperty("verified_email")
    private Boolean verifiedEmail;

    private String name;

    @JsonProperty("given_name")
    private String givenName;

    @JsonProperty("family_name")
    private String familyName;

    private String link;

    private String picture;

    private String gender;

    private String locale;

    private String hd;

}
