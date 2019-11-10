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
			
	@GetMapping("/userJobAttributes/{id}")
	public ResponseEntity<UserJobAttributes> getUserJobAttributesById(@PathVariable String id) {
		Optional<UserJobAttributes> userJobAttributes=userJobAttributesService.findById(id);
        return ResponseEntity.ok(userJobAttributes.get());
    }
	
	@PostMapping("/userJobAttributes")
    public ResponseEntity<UserJobAttributes> create(@Valid @RequestBody UserJobAttributes userJobAttributes) {
        return ResponseEntity.ok(userJobAttributesService.save(userJobAttributes));
    }
	
	@DeleteMapping("/userJobAttributes/{id}")
	    public ResponseEntity<UserJobAttributes> delete(@PathVariable String id) {
	        if (!userJobAttributesService.findById(id).isPresent()) {
	            ResponseEntity.badRequest().build();
	        }

	        userJobAttributesService.deleteById(id);

	        return ResponseEntity.ok().build();
	    }
	
	@PutMapping("/userJobAttributes/{id}")
    public ResponseEntity<UserJobAttributes> update(@PathVariable String id, @Valid @RequestBody UserJobAttributes product) {
            return ResponseEntity.ok(userJobAttributesService.update(product));
    }
}
