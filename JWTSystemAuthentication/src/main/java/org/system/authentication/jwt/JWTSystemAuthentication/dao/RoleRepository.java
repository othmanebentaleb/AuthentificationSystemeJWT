package org.system.authentication.jwt.JWTSystemAuthentication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.system.authentication.jwt.JWTSystemAuthentication.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole,Long> {

    public AppRole findByRolename(String rolename);
}
