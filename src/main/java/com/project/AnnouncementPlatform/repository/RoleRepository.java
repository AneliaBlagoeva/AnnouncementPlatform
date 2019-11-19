package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.project.AnnouncementPlatform.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
	Optional<Role> findById (String roleDescription);
}
