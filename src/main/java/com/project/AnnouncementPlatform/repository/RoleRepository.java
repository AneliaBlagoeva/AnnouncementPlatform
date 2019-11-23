package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>{
	Role findByDescription(String email);
}
