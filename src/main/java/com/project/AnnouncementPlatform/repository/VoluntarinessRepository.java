package com.project.AnnouncementPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.project.AnnouncementPlatform.domain.Voluntariness;

@Repository
public interface VoluntarinessRepository extends JpaRepository<Voluntariness, Integer> {
    Optional<Voluntariness> findById(Integer id);
}
