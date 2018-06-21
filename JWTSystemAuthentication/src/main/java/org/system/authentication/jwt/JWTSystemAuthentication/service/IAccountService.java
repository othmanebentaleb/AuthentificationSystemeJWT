package org.system.authentication.jwt.JWTSystemAuthentication.service;

import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppRole;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;

public interface IAccountService {

    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);

    public AppUser getUserByUsername(String username);
    public AppRole getRoleByRolename(String rolename);

    public void addRoleToUser(String username,String rolename);
}
