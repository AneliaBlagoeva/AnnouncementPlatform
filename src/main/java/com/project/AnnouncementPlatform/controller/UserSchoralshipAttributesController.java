package com.project.AnnouncementPlatform.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.AnnouncementPlatform.domain.UserSchoralshipAttributes;
import com.project.AnnouncementPlatform.service.UserSchoralshipAttributesService;

@RestController
@RequestMapping("/api")
public class UserSchoralshipAttributesController {
	
	@Autowired
	private UserSchoralshipAttributesService userSchoralshipAttributesService;
	
	@GetMapping("/userSchoralshipAttributes")
	public ResponseEntity<List<UserSchoralshipAttributes>> getUserSchoralshipAttributes() {
        return ResponseEntity.ok(userSchoralshipAttributesService.findAll());
    }
			
	@GetMapping("/userSchoralshipAttributes/{id}")
	public ResponseEntity<UserSchoralshipAttributes> getUserSchoralshipAttributesById(@PathVariable String id) {
		Optional<UserSchoralshipAttributes> userSchoralshipAttributes=userSchoralshipAttributesService.findById(id);
        return ResponseEntity.ok(userSchoralshipAttributes.get());
    }
	
	@PostMapping("/userSchoralshipAttributes")
    public ResponseEntity<UserSchoralshipAttributes> create(@Valid @RequestBody UserSchoralshipAttributes userSchoralshipAttributes) {
        return ResponseEntity.ok(userSchoralshipAttributesService.save(userSchoralshipAttributes));
    }
	
	@DeleteMapping("/userSchoralshipAttributes/{id}")
	    public ResponseEntity<UserSchoralshipAttributes> delete(@PathVariable String id) {
	        if (!userSchoralshipAttributesService.findById(id).isPresent()) {
	            ResponseEntity.badRequest().build();
	        }

	        userSchoralshipAttributesService.deleteById(id);

	        return ResponseEntity.ok().build();
	    }
	
	@PutMapping("/userSchoralshipAttributes/{id}")
    public ResponseEntity<UserSchoralshipAttributes> update(@PathVariable String id, @Valid @RequestBody UserSchoralshipAttributes product) {
            return ResponseEntity.ok(userSchoralshipAttributesService.update(product));
    }
}
