package com.project.AnnouncementPlatform.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.AnnouncementPlatform.config.JwtTokenProvider;
import com.project.AnnouncementPlatform.domain.Role;
import com.project.AnnouncementPlatform.domain.User;
import com.project.AnnouncementPlatform.repository.UserRepository;
import com.project.AnnouncementPlatform.service.CustomUserDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserRepository users;

    @Autowired
    private CustomUserDetailsService userService;

    @RequestMapping(value = "/login", produces = "application/json", method = { RequestMethod.POST, RequestMethod.GET })
    public ResponseEntity<Map<Object, Object>> login(@RequestBody AuthBody data) {
        try {
            String username = data.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            Set<Role> roles = new HashSet<Role>();
            roles.add(this.users.findByEmail(username).getRole());
            String token = jwtTokenProvider.createToken(username, roles);
            Map<Object, Object> model = new HashMap<>();
            model.put("role", this.users.findByEmail(username).getRole());
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email/password supplied");
        }
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/register", produces = "application/json", method = RequestMethod.POST)
    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    public ResponseEntity register(@RequestBody User user) {
        User userExists = userService.findUserByEmail(user.getEmail());
        if (userExists != null) {
            throw new BadCredentialsException("User with username: " + user.getEmail() + " already exists");
        }
        userService.saveUser(user);
        Map<Object, Object> model = new HashMap<>();
        model.put("message", "User registered successfully");
        return ok(model);
    }
}
