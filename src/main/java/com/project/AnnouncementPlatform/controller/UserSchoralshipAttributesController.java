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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.AnnouncementPlatform.domain.UserSchoralshipAttributes;
import com.project.AnnouncementPlatform.service.UserSchoralshipAttributesService;

@RestController
@RequestMapping("/api")
public class UserSchoralshipAttributesController {

	@Autowired
	private UserSchoralshipAttributesService userSchoralshipAttributesService;

	@GetMapping("/userSchoralshipAttributes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<UserSchoralshipAttributes>> getUserSchoralshipAttributes() {
		return ResponseEntity.ok(userSchoralshipAttributesService.findAll());
	}

	@GetMapping("/userSchoralshipAttributes/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserSchoralshipAttributes> getUserSchoralshipAttributesById(@PathVariable String email) {
		Optional<UserSchoralshipAttributes> userSchoralshipAttributes = userSchoralshipAttributesService
				.findById(email);
		if (userSchoralshipAttributes.isPresent()) {
			return ResponseEntity.ok(userSchoralshipAttributes.get());
		} else {
			return ResponseEntity.ok(new UserSchoralshipAttributes());
		}
	}

	@PostMapping("/userSchoralshipAttributes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserSchoralshipAttributes> create(
			@Valid @RequestBody UserSchoralshipAttributes userSchoralshipAttributes) {
		return ResponseEntity.ok(userSchoralshipAttributesService.save(userSchoralshipAttributes));
	}

	@DeleteMapping("/userSchoralshipAttributes/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserSchoralshipAttributes> delete(@PathVariable String email) {
		if (!userSchoralshipAttributesService.findById(email).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		userSchoralshipAttributesService.deleteById(email);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/userScholarshipAttributes", produces = "application/json", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserSchoralshipAttributes> update(@PathVariable String email,
			@Valid @RequestBody UserSchoralshipAttributes product) {
		return ResponseEntity.ok(userSchoralshipAttributesService.update(product));
	}
}
