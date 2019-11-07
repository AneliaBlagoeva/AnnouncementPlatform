package com.project.AnnouncementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.Announcement;
import com.project.AnnouncementPlatform.repository.AnnouncementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
	@Autowired
    private AnnouncementRepository annRepository;

    public List<Announcement> findAll() {
        return annRepository.findAll();
    }
    
    public Optional<Announcement> findById(int id) {
        return annRepository.findById(id);
    }
    
    public void deleteById(int id) {
    	annRepository.deleteById(id);
    }
    
    public Announcement save(Announcement ann) {
        return annRepository.save(ann);
    }
    
    public Announcement update(Announcement ann) {
    	if (!annRepository.findById(ann.getAnncmntId()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return annRepository.save(ann);
    }
    
}
