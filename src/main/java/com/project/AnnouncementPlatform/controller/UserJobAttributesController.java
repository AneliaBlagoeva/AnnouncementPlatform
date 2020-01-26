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

import com.project.AnnouncementPlatform.domain.UserJobAttributes;
import com.project.AnnouncementPlatform.service.UserJobAttributesService;

@RestController
@RequestMapping("/api")
public class UserJobAttributesController {

	@Autowired
	private UserJobAttributesService userJobAttributesService;

	@GetMapping("/userJobAttributes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<UserJobAttributes>> getUserJobAttributes() {
		return ResponseEntity.ok(userJobAttributesService.findAll());
	}

	@GetMapping("/userJobAttributes/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserJobAttributes> getUserJobAttributesById(@PathVariable String email) {
		Optional<UserJobAttributes> userJobAttributes = userJobAttributesService.findById(email);
		if (userJobAttributes.isPresent()) {
			return ResponseEntity.ok(userJobAttributes.get());
		} else {
			return ResponseEntity.ok(new UserJobAttributes());
		}
	}

	@PostMapping("/userJobAttributes")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserJobAttributes> create(@Valid @RequestBody UserJobAttributes userJobAttributes) {
		return ResponseEntity.ok(userJobAttributesService.save(userJobAttributes));
	}

	@DeleteMapping("/userJobAttributes/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserJobAttributes> delete(@PathVariable String email) {
		if (!userJobAttributesService.findById(email).isPresent()) {
			ResponseEntity.badRequest().build();
		}

		userJobAttributesService.deleteById(email);

		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "/userJobAttributes", produces = "application/json", method = RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserJobAttributes> update(@PathVariable String email,
			@Valid @RequestBody UserJobAttributes product) {
		return ResponseEntity.ok(userJobAttributesService.update(product));
	}
}
