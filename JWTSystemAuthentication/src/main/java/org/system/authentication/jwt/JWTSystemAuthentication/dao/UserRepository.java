package org.system.authentication.jwt.JWTSystemAuthentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long> {

    public AppUser findByUsername(String username);

}
