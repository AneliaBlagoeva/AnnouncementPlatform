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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.AnnouncementPlatform.domain.User;
import com.project.AnnouncementPlatform.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(userService.findAll());
    }
			
	@GetMapping("/user/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
		Optional<User> user=userService.findById(email);
        return ResponseEntity.ok(user.get());
    }
	
	@PostMapping("/user")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> create(@Valid @RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }
	
	@DeleteMapping("/user/{email}")
	@CrossOrigin(origins = "http://localhost:4200")
	    public ResponseEntity<User> delete(@PathVariable("email") String email) {
	        if (!userService.findById(email).isPresent()) {
	            ResponseEntity.badRequest().build();
	        }

	        userService.deleteById(email);

	        return ResponseEntity.ok().build();
	    }
	
	@RequestMapping(value = "/user", 
			  produces = "application/json", 
			  method=RequestMethod.PUT)
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> update( @Valid @RequestBody User product) {
		boolean a=(product==null);
		System.out.print(a);
            return ResponseEntity.ok(userService.update(product));
    }
	

}
