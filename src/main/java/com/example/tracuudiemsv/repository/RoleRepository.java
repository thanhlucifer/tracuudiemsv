package com.example.tracuudiemsv.repository;

import com.example.tracuudiemsv.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
