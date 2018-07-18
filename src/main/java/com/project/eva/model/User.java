package com.project.eva.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public final class User extends Model implements UserDetails {

    private static final long serialVersionUID = 1L;



    @Column(name = "username")
    private String username = "";


    @Column(name = "password")
    private String password = "";


    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ADMIN;

    protected User() {
    }
    @Override
    public String toString() {
        return "Username: " + this.username
                + "\nRole: " + this.role.name();
    }


    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result) {
            final User user = (User) object;
            result = this.username.equals(user.username) &&
                    this.role.equals(user.role);
        }
        return result;
    }


    @Override
    public int hashCode() {
        int result = this.username.hashCode();
        result = 31 * result + this.role.hashCode();
        return result;
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final List<GrantedAuthority> roles = new ArrayList<>();
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + this.role.name());
        roles.add(authority);
        return roles;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }


    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }


    public UserRole getRole() {
        return this.role;
    }


    public void setRole(final UserRole role) {
        this.role = role;
    }


    public static UserBuilder getBuilder() {
        return new UserBuilder();
    }
}
