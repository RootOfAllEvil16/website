package com.project.eva.service.interfaces;

import com.project.eva.model.User;
import com.project.eva.model.UserRole;

import java.util.Collection;

public interface UserService extends MainService<User> {


    User getByUsername(String username);

    User getMainAdministrator();

    Collection<User> getAdministrators();

    Collection<User> getPersonnel();

    User getAuthenticatedUser();

    void removeByUsername(String username);

    void removeByRole(UserRole role);

    void removePersonnel();
}
