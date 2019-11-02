package com.project.AnnouncementPlatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementService {
	@Autowired
    private AnnouncementRepository annRespository;

    public List<Announcement> findAll() {
        return annRespository.findAll();
    }
}
