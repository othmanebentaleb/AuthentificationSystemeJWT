package org.system.authentication.jwt.JWTSystemAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IAccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser user = accountService.getUserByUsername(username);
        if(user == null ) throw new UsernameNotFoundException(username);
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRolename()));
        });
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
