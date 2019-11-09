package com.project.AnnouncementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.Scholarship;
import com.project.AnnouncementPlatform.repository.ScholarshipRepository;

@Service
public class ScholarshipService {
	@Autowired
    private ScholarshipRepository scholarshipRepository;
	
	public List<Scholarship> findAll() {
        return scholarshipRepository.findAll();
    }
    
    public Optional<Scholarship> findById(int id) {
        return scholarshipRepository.findById(id);
    }
    
    public void deleteById(int id) {
    	scholarshipRepository.deleteById(id);
    }
    
    public Scholarship save(Scholarship scholarship) {
        return scholarshipRepository.save(scholarship);
    }
    
    public Scholarship update(Scholarship scholarship) {
    	if (!scholarshipRepository.findById(scholarship.getAnncmntID()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return scholarshipRepository.save(scholarship);
    }
}
