package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.AnnouncementPlatform.domain.Degree;

@Repository
public interface DegreeRepository extends JpaRepository<Degree, Integer> {

}
