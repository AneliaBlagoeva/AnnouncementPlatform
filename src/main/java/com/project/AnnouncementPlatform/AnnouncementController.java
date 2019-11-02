package com.project.AnnouncementPlatform;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class AnnouncementController {
	
		@Autowired
		private AnnouncementService anncmntService;
		
		@GetMapping("/announcements")
		public ResponseEntity<List<Announcement>> getAnnouncements() {
	        return ResponseEntity.ok(anncmntService.findAll());
	    }
		
		@GetMapping("/announcements/{id}")
		public ResponseEntity<Announcement> getAnnouncementById(@PathVariable int id) {
			Optional<Announcement> ann=anncmntService.findById(id);
	        return ResponseEntity.ok(ann.get());
	    }
		
		@PostMapping("/announcements")
	    public ResponseEntity<Announcement> create(@Valid @RequestBody Announcement ann) {
	        return ResponseEntity.ok(anncmntService.save(ann));
	    }
		
		@DeleteMapping("/announcements/{id}")
		    public ResponseEntity<Announcement> delete(@PathVariable int id) {
		        if (!anncmntService.findById(id).isPresent()) {
		            ResponseEntity.badRequest().build();
		        }

		        anncmntService.deleteById(id);

		        return ResponseEntity.ok().build();
		    }
}

