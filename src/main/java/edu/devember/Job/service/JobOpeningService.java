package edu.devember.Job.service;

import edu.devember.Job.model.JobOpening;

import java.util.List;
import java.util.Optional;

public interface JobOpeningService {

    List<JobOpening> findAll();

    Optional<JobOpening> findById(Long theId);

    void save(JobOpening theJobOpening);

    void deleteById(Long theId);
}
