package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.AnnouncementStatus;

@Repository
public interface AnnouncementStatusRepository extends JpaRepository<AnnouncementStatus, Integer>{
	
}
