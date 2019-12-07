package com.project.AnnouncementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.Voluntariness;
import com.project.AnnouncementPlatform.repository.VoluntarinessRepository;

@Service
public class VoluntarinessService {
    @Autowired
    private VoluntarinessRepository voluntarinessRepository;

    public List<Voluntariness> findAll() {
        return voluntarinessRepository.findAll();
    }

    public Optional<Voluntariness> findById(int id) {
        Optional<Voluntariness> result = voluntarinessRepository.findById(id);
        if (result.isPresent()) {
            return result;
        } else {
            return null;
        }
    }

    public void deleteById(int id) {
        voluntarinessRepository.deleteById(id);
    }

    public Voluntariness save(Voluntariness voluntariness) {
        return voluntarinessRepository.save(voluntariness);
    }

    public Voluntariness update(Voluntariness voluntariness) {
        if (!voluntarinessRepository.findById(voluntariness.getAnncmntID()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return voluntarinessRepository.save(voluntariness);
    }
}
