package com.jacekg.teamfinder.user.model.repository;

import com.jacekg.teamfinder.user.model.Role;
import com.jacekg.teamfinder.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
