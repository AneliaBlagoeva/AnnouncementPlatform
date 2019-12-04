package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.project.AnnouncementPlatform.domain.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    Optional<Job> findById(Integer id);
}
