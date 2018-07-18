package com.project.eva.repository;

import com.project.eva.model.User;
import com.project.eva.model.UserRole;

import java.util.Collection;

public interface UserRepository extends MainRepository<User> {

    User findByUsername(String username);

    User findByRole(UserRole role);

    Collection<User> findAllByRole(UserRole role);

    void deleteAllByRole(UserRole role);

    void deleteByUsername(String username);
}

