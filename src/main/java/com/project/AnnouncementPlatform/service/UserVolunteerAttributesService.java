package com.project.AnnouncementPlatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.UserVolunteerAttributes;
import com.project.AnnouncementPlatform.repository.UserVolunteerAttributesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserVolunteerAttributesService {
    @Autowired
    private UserVolunteerAttributesRepository userVolunteerAttributesRepository;

    public List<UserVolunteerAttributes> findAll() {
        return userVolunteerAttributesRepository.findAll();
    }

    public Optional<UserVolunteerAttributes> findById(String email) {
        return userVolunteerAttributesRepository.findById(email);
    }

    public void deleteById(String email) {
        userVolunteerAttributesRepository.deleteById(email);
    }

    public UserVolunteerAttributes save(UserVolunteerAttributes attrs) {
        return userVolunteerAttributesRepository.save(attrs);
    }

    public UserVolunteerAttributes update(UserVolunteerAttributes attrs) {
        if (!userVolunteerAttributesRepository.findById(attrs.getEmail()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return userVolunteerAttributesRepository.save(attrs);
    }

}
