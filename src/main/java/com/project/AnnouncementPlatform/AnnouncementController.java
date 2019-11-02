package com.project.AnnouncementPlatform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
@RequestMapping("/")
public class AnnouncementController {
	
		@Autowired
		private AnnouncementService anncmntService;
		
		@GetMapping("/announcements")
		public ResponseEntity<List<Announcement>> getAnnouncements() {
	        return ResponseEntity.ok(anncmntService.findAll());
	    }
}

