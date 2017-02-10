/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crm;

import java.io.Serializable;

/**
 *
 * @author xulix
 */
public class Users implements Serializable {
    private int idusers;
    private String UserName;
    private String Password;
    private boolean BasicUser;
    private boolean UserManager;
    private boolean Admin;

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public boolean isBasicUser() {
        return BasicUser;
    }

    public void setBasicUser(boolean BasicUser) {
        this.BasicUser = BasicUser;
    }

    public boolean isUserManager() {
        return UserManager;
    }

    public void setUserManager(boolean UserManager) {
        this.UserManager = UserManager;
    }

    public boolean isAdmin() {
        return Admin;
    }

    public void setAdmin(boolean Admin) {
        this.Admin = Admin;
    }
}
