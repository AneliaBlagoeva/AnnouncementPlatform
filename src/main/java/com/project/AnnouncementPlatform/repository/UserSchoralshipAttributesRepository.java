package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.project.AnnouncementPlatform.domain.UserSchoralshipAttributes;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface UserSchoralshipAttributesRepository extends JpaRepository<UserSchoralshipAttributes, String> {

}
