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

import com.project.AnnouncementPlatform.domain.Job;
import com.project.AnnouncementPlatform.service.JobService;

@RestController
@RequestMapping("/")
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@GetMapping("/jobs")
	public ResponseEntity<List<Job>> getJobs() {
        return ResponseEntity.ok(jobService.findAll());
    }
			
	@GetMapping("/job/{id}")
	public ResponseEntity<Job> getJobById(@PathVariable int id) {
		Optional<Job> job=jobService.findById(id);
        return ResponseEntity.ok(job.get());
    }
	
	@PostMapping("/job")
    public ResponseEntity<Job> create(@Valid @RequestBody Job job) {
        return ResponseEntity.ok(jobService.save(job));
    }
	
	@DeleteMapping("/job/{id}")
	    public ResponseEntity<Job> delete(@PathVariable int id) {
	        if (!jobService.findById(id).isPresent()) {
	            ResponseEntity.badRequest().build();
	        }

	        jobService.deleteById(id);

	        return ResponseEntity.ok().build();
	    }
	
	@PutMapping("/job/{id}")
    public ResponseEntity<Job> update(@PathVariable int id, @Valid @RequestBody Job product) {
            return ResponseEntity.ok(jobService.update(product));
    }
	

}
