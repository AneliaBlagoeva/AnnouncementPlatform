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

import com.project.AnnouncementPlatform.domain.Job;
import com.project.AnnouncementPlatform.domain.Scholarship;
import com.project.AnnouncementPlatform.service.ScholarshipService;

@RestController
@RequestMapping("/api")
public class ScholarshipController {

	@Autowired
	private ScholarshipService scholarshipService;

	@GetMapping("/scholarships")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Scholarship>> getScholarships() {
		return ResponseEntity.ok(scholarshipService.findAll());
	}

	@GetMapping("/scholarship/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Scholarship> getScholarshipById(@PathVariable("id") int id) {
		Optional<Scholarship> scholarship = scholarshipService.findById(id);
		if (scholarship != null) {
			return ResponseEntity.ok(scholarship.get());
		} else {
			return null;
		}
	}

	@PostMapping("/scholarship")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Scholarship> create(@Valid @RequestBody Scholarship scholarship) {
		return ResponseEntity.ok(scholarshipService.save(scholarship));
	}

	@DeleteMapping("/scholarship/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Scholarship> delete(@PathVariable int id) {
		if (!scholarshipService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		scholarshipService.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/scholarship", produces = "application/json", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Scholarship> update(@Valid @RequestBody Scholarship product) {
		return ResponseEntity.ok(scholarshipService.update(product));
	}

}
