package com.project.AnnouncementPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
	@Autowired
    private AnnouncementRepository annRespository;

    public List<Announcement> findAll() {
        return annRespository.findAll();
    }
    
    public Optional<Announcement> findById(int id) {
        return annRespository.findById(id);
    }
    
    public void deleteById(int id) {
    	annRespository.deleteById(id);
    }
    
    public Announcement save(Announcement ann) {
        return annRespository.save(ann);
    }
}
