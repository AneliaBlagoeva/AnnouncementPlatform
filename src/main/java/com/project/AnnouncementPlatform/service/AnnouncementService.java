package com.project.AnnouncementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.Announcement;
import com.project.AnnouncementPlatform.repository.AnnouncementRepository;

@Service
public class AnnouncementService {
	@Autowired
    private AnnouncementRepository announcementRepository;
	
	public List<Announcement> findAll() {
        return announcementRepository.findAll();
    }
    
    public Optional<Announcement> findById(int id) {
        return announcementRepository.findById(id);
    }
    
    public void deleteById(int id) {
    	announcementRepository.deleteById(id);
    }
    
    public Announcement save(Announcement announcement) {
        return announcementRepository.save(announcement);
    }
    
    public Announcement update(Announcement announcement) {
    	if (!announcementRepository.findById(announcement.getAnncmntId()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return announcementRepository.save(announcement);
    }
}
