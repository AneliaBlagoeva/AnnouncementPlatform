package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	User findByEmail(String email);
}
