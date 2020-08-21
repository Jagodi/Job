package edu.devember.Job.service;

import edu.devember.Job.model.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<Job> findAll();

    Optional<Job> findById(Long theId);

    void save(Job theJob);

    void deleteById(Long theId);
}
