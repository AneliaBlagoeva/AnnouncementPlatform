package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer>{
	
}
