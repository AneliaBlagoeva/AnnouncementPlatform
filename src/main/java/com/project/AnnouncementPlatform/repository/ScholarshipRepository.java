package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.project.AnnouncementPlatform.domain.Scholarship;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Integer> {
    Optional<Scholarship> findById(Integer id);
}
