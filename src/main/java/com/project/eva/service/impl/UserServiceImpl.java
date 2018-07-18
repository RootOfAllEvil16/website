package com.project.eva.service.impl;

import com.project.eva.model.User;
import com.project.eva.model.UserRole;
import com.project.eva.repository.UserRepository;
import com.project.eva.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.project.eva.util.validator.ObjectValidator.*;

@Service
@ComponentScan(basePackages = "com.project.eva.repository")
public final class UserServiceImpl extends MainServiceImpl<User> implements UserService, UserDetailsService {

    private final static Long ADMIN_ROLE_ID = 1L;

    private final UserRepository repository;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    public UserServiceImpl(final UserRepository repository) {
        super(repository);
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public User getByUsername(final String username)
            throws IllegalArgumentException, NullPointerException {
        if (isEmpty(username)) {
            throw new IllegalArgumentException("No username!");
        }
        final User user = this.repository.findByUsername(username);
        if (isNull(user)) {
            throw new NullPointerException("Can't find user by username " + username + "!");
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public User getMainAdministrator() throws NullPointerException {
        final User user = new ArrayList<>(getAdministrators()).get(0);
        if (isNull(user)) {
            throw new NullPointerException("Can't find administrator!");
        }
        return user;
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<User> getAdministrators() {
        return this.repository.findAllByRole(UserRole.ADMIN);
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<User> getPersonnel() {
        final List<User> users = new ArrayList<>();
        users.addAll(getAdministrators());
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public User getAuthenticatedUser() {
        User user;
        try {
            final SecurityContext context = SecurityContextHolder.getContext();
            final Authentication authentication = context.getAuthentication();
            user = (User) authentication.getPrincipal();
        } catch (Exception ex) {
            ex.printStackTrace();
            user = null;
        }
        return user;
    }


    @Override
    @Transactional
    public void removeByUsername(final String username) {
        if (isNotEmpty(username)) {
            this.repository.deleteByUsername(username);
        }
    }

    @Override
    @Transactional
    public void removeByRole(final UserRole role) {
        if (isNotNull(role)) {
            this.repository.deleteAllByRole(role);
        }
    }

    /**
     * Удаляет список персонала сайта.
     */
    @Override
    @Transactional
    public void removePersonnel() {
        final Collection<User> personnel = getPersonnel();
        if (isNotEmpty(personnel)) {
            final User mainAdmin = getMainAdministrator();
            personnel.remove(mainAdmin);
            this.repository.delete(personnel);
        }
    }


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        try {
            return getByUsername(username);
        } catch (IllegalArgumentException | NullPointerException ex) {
            throw new UsernameNotFoundException(ex.getMessage(), ex);
        }
    }
}

