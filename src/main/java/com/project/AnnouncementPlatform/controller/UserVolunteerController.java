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

import com.project.AnnouncementPlatform.domain.UserVolunteerAttributes;
import com.project.AnnouncementPlatform.service.UserVolunteerAttributesService;

@RestController
@RequestMapping("/api")
public class UserVolunteerController {

    @Autowired
    private UserVolunteerAttributesService userVolunteerAttributesService;

    @GetMapping("/userVolunteerAttributes")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<UserVolunteerAttributes>> getUserVolunteerAttributes() {
        return ResponseEntity.ok(userVolunteerAttributesService.findAll());
    }

    @GetMapping("/userVolunteerAttributes/{email}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserVolunteerAttributes> getUserVolunteerAttributesByEmail(@PathVariable String email) {
        Optional<UserVolunteerAttributes> userVolunteerAttributes = userVolunteerAttributesService.findById(email);
        return ResponseEntity.ok(userVolunteerAttributes.get());
    }

    @PostMapping("/userVolunteerAttributes")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserVolunteerAttributes> create(
            @Valid @RequestBody UserVolunteerAttributes userVolunteerAttributes) {
        return ResponseEntity.ok(userVolunteerAttributesService.save(userVolunteerAttributes));
    }

    @DeleteMapping("/userVolunteerAttributes/{email}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserVolunteerAttributes> delete(@PathVariable String email) {
        if (!userVolunteerAttributesService.findById(email).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        userVolunteerAttributesService.deleteById(email);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/userVolunteerAttributes/{email}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserVolunteerAttributes> update(@PathVariable String email,
            @Valid @RequestBody UserVolunteerAttributes product) {
        return ResponseEntity.ok(userVolunteerAttributesService.update(product));
    }
}
