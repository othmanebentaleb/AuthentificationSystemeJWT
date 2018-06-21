package org.system.authentication.jwt.JWTSystemAuthentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.system.authentication.jwt.JWTSystemAuthentication.dao.RoleRepository;
import org.system.authentication.jwt.JWTSystemAuthentication.dao.UserRepository;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppRole;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        if (user == null) {
            throw new RuntimeException("User not valid");
        }
        AppUser tmpUser = this.userRepository.findByUsername(user.getUsername());
        if(tmpUser!=null) throw new RuntimeException("User alerady exists");
        user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }
    @Override
    public AppRole saveRole(AppRole role) {
        if(role==null || role.equals("") ) throw new RuntimeException("invalid rolename");
        return this.roleRepository.save(role);
    }

    @Override
    public AppUser getUserByUsername(String username) {
        if(username == null || username.equals("")) throw new RuntimeException("Please make sure the username is valid");
        AppUser user = this.userRepository.findByUsername(username);
        if(user == null) throw  new RuntimeException("User not found");
        return user;
    }

    @Override
    public AppRole getRoleByRolename(String rolename) {
        if(rolename == null || rolename.equals("")) throw new RuntimeException("Please make sure the rolename is valid");
        return this.roleRepository.findByRolename(rolename);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {

    }
}
