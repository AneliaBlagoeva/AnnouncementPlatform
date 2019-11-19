package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.UserVolunteerAttributes;

@Repository
public interface UserVolunteerAttributesRepository extends JpaRepository<UserVolunteerAttributes, String> {

}
