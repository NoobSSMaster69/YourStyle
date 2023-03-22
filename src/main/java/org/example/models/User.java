package org.example.models;


import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.validation.constraints.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class User implements UserDetails {
    @Id
    private long userId;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String userLogin;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 1, max = 30, message = "Name should be between 1 and 30 characters")
    private String userName;

    @Size(min = 1, max = 30, message = "Last name should be between 1 and 30 characters")
    private String userLastname;

    @Size(min = 1, max = 30, message = "Patronymic should be between 1 and 30 characters")
    private String userPatronymic;


    @Max(value = 12, message = "Age should be greater than 0")
    private String userPhone;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String userEmail;

    @NotEmpty(message = "Password should not be empty")
    private String userPass;

    @NotEmpty(message = "Password should not be empty")
    private String userPassConfirm;

    private Set<UserRole> roles;


    public User() {

    }

    public User(long userId, String userLogin, String userName, String userLastname, String userPatronymic, String userPhone, String userEmail, String userPass, String userPassConfirm, Set<UserRole> roles) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userName = userName;
        this.userLastname = userLastname;
        this.userPatronymic = userPatronymic;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userPass = userPass;
        this.userPassConfirm = userPassConfirm;
        this.roles = roles;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserPatronymic() {
        return userPatronymic;
    }

    public void setUserPatronymic(String userPatronymic) {
        this.userPatronymic = userPatronymic;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPassConfirm() {
        return userPassConfirm;
    }

    public void setUserPassConfirm(String userPassConfirm) {
        this.userPassConfirm = userPassConfirm;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
