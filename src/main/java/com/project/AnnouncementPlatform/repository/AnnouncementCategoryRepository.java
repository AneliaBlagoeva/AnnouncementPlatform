package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.AnnouncementCategory;

@Repository
public interface AnnouncementCategoryRepository extends JpaRepository<AnnouncementCategory, Integer>{
	
}
