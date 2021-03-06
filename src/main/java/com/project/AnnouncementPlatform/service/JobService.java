package com.project.AnnouncementPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.AnnouncementPlatform.domain.Job;
import com.project.AnnouncementPlatform.repository.JobRepository;

@Service
public class JobService {
    @Autowired
    private JobRepository jobRepository;

    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    public Optional<Job> findById(int id) {
        Optional<Job> result = jobRepository.findById(id);
        if (result.isPresent()) {
            return result;
        } else {
            return null;
        }
    }

    public void deleteById(int id) {
        jobRepository.deleteById(id);
    }

    public Job save(Job job) {
        return jobRepository.save(job);
    }

    public Job update(Job job) {
        if (!jobRepository.findById(job.getAnncmntID()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
        return jobRepository.save(job);
    }
}
