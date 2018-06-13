package org.system.authentication.jwt.JWTSystemAuthentication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AppRole {

    @Id @GeneratedValue
    private Long id;
    private String rolename;

    public AppRole() {
    }

    public AppRole(String rolename) {
        this.rolename = rolename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
