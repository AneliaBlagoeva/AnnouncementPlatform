package com.project.AnnouncementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.UserSchoralshipAttributes;
import com.project.AnnouncementPlatform.repository.UserSchoralshipAttributesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserSchoralshipAttributesService {
    @Autowired
    private UserSchoralshipAttributesRepository userSchoralshipAttributesRepository;

    public List<UserSchoralshipAttributes> findAll() {
        return userSchoralshipAttributesRepository.findAll();
    }
    
    public Optional<UserSchoralshipAttributes> findById(String email) {
        return userSchoralshipAttributesRepository.findById(email);
    }
    
    public void deleteById(String email) {
    	userSchoralshipAttributesRepository.deleteById(email);
    }
    
    public UserSchoralshipAttributes save(UserSchoralshipAttributes attrs) {
        return userSchoralshipAttributesRepository.save(attrs);
    }
    
    public UserSchoralshipAttributes update(UserSchoralshipAttributes attrs) {
    	if (!userSchoralshipAttributesRepository.findById(attrs.getEmail()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return userSchoralshipAttributesRepository.save(attrs);
    }
    
}
