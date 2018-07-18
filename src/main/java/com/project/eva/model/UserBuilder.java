package com.project.eva.model;



import static com.project.eva.util.validator.ObjectValidator.isNotEmpty;
import static com.project.eva.util.validator.ObjectValidator.isNotNull;

public final class UserBuilder extends ModelBuilder<User, UserBuilder> {

    private String username;

    private String password;

    private UserRole role;


    UserBuilder() {
    }

    @Override
    public User build() {
        final User user = new User();

        user.setUsername(getUsername());
        user.setPassword(getPassword());
        user.setRole(getRole());
        return super.build(user);
    }



    public UserBuilder addUsername(final String username) {
        this.username = username;
        return this;
    }

    public UserBuilder addPassword(final String password) {
        this.password = password;
        return this;
    }


    public UserBuilder addRole(final UserRole role) {
        this.role = role;
        return this;
    }




    private String getUsername() {
        return isNotEmpty(this.username) ? this.username : "";
    }

    private String getPassword() {
        return isNotEmpty(this.password) ? this.password : "";
    }

    private UserRole getRole() {
        return isNotNull(this.role) ? this.role : UserRole.ADMIN;
    }

}

