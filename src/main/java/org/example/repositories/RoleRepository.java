package org.example.repositories;

import org.example.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserRole, Long> {

}
