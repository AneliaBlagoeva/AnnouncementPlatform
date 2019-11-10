package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.AnnouncementPlatform.domain.UserJobAttributes;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserJobAttributesRepository extends JpaRepository<UserJobAttributes, String>{
	
}
