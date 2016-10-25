package main.security.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import main.security.role.model.Role;
import main.security.user.model.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by fun-redoc on 06.10.16.
 */
public class UserDetailsImpl implements UserDetails {

    private User user;

    public UserDetailsImpl(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        HashSet<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
        List<Role> roles = user.getRoles();
        roles.forEach(role -> grantedAuthorities.add( new SimpleGrantedAuthority(role.getStrType())));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getStrPassword();
    }

    @Override
    public String getUsername() {
        return user.getStrUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO
        return true;
    }
}