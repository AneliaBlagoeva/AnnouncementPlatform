package com.project.AnnouncementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.UserJobAttributes;
import com.project.AnnouncementPlatform.repository.UserJobAttributesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserJobAttributesService {
    @Autowired
    private UserJobAttributesRepository userJobAttributesRepository;

    public List<UserJobAttributes> findAll() {
        return userJobAttributesRepository.findAll();
    }
    
    public Optional<UserJobAttributes> findById(String email) {
        return userJobAttributesRepository.findById(email);
    }
    
    public void deleteById(String email) {
    	userJobAttributesRepository.deleteById(email);
    }
    
    public UserJobAttributes save(UserJobAttributes attrs) {
        return userJobAttributesRepository.save(attrs);
    }
    
    public UserJobAttributes update(UserJobAttributes attrs) {
    	if (!userJobAttributesRepository.findById(attrs.getEmail()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return userJobAttributesRepository.save(attrs);
    }
    
}
