package io.developerinator.service;


import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {

    UserDetails getCurrentlyLoggedInUser();
}
