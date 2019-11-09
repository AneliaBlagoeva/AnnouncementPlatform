package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.UserSchoralshipAttributes;

@Repository
public interface UserSchoralshipAttributesRepository extends JpaRepository<UserSchoralshipAttributes, String>{
	
}
