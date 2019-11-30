package com.project.AnnouncementPlatform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.AnnouncementPlatform.domain.Announcement;
import com.project.AnnouncementPlatform.service.AnnouncementService;

@RestController
@RequestMapping("/api")
public class AnnouncementController {

	@Autowired
	private AnnouncementService announcementService;

	@GetMapping("/announcements")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Announcement>> getAnnouncements() {
		return ResponseEntity.ok(announcementService.findAll());
	}

	@GetMapping("/announcement/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Announcement> getAnnouncementById(@PathVariable int id) {
		Optional<Announcement> announcement = announcementService.findById(id);
		return ResponseEntity.ok(announcement.get());
	}

	@PostMapping("/announcement")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Announcement> create(@Valid @RequestBody Announcement announcement) {
		return ResponseEntity.ok(announcementService.save(announcement));
	}

	@DeleteMapping("/announcement/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Announcement> delete(@PathVariable int id) {
		if (!announcementService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		announcementService.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/announcement", produces = "application/json", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Announcement> update(@Valid @RequestBody Announcement product) {
		return ResponseEntity.ok(announcementService.update(product));
	}

}
