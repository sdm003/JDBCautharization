package com.example.Artifact.repository;

import com.example.Artifact.entity.UserRoles;
import com.example.Artifact.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
