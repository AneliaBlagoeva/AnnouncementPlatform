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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.AnnouncementPlatform.domain.Voluntariness;
import com.project.AnnouncementPlatform.service.VoluntarinessService;

@RestController
@RequestMapping("/api")
public class VoluntarinessController {

	@Autowired
	private VoluntarinessService voluntarinessService;

	@GetMapping("/voluntarinesses")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<Voluntariness>> getVoluntarinesses() {
		return ResponseEntity.ok(voluntarinessService.findAll());
	}

	@GetMapping("/voluntariness/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Voluntariness> getVoluntarinessById(@PathVariable("id") int id) {
		Optional<Voluntariness> voluntariness = voluntarinessService.findById(id);
		if (voluntariness != null) {
			return ResponseEntity.ok(voluntariness.get());
		} else {
			return null;
		}
	}

	@PostMapping("/voluntariness")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Voluntariness> create(@Valid @RequestBody Voluntariness voluntariness) {
		return ResponseEntity.ok(voluntarinessService.save(voluntariness));
	}

	@DeleteMapping("/voluntariness/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Voluntariness> delete(@PathVariable int id) {
		if (!voluntarinessService.findById(id).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		voluntarinessService.deleteById(id);

		return ResponseEntity.ok().build();
	}

	@PutMapping("/voluntariness")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Voluntariness> update(@Valid @RequestBody Voluntariness product) {
		return ResponseEntity.ok(voluntarinessService.update(product));
	}

}
