package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.UserJobAttributes;

@Repository
public interface UserJobAttributesRepository extends JpaRepository<UserJobAttributes, String>{
	
}
