package edu.devember.Job.service;

import edu.devember.Job.model.JobOpening;
import edu.devember.Job.repository.JobOpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobOpeningServiceImp implements JobOpeningService {

    private final JobOpeningRepository repository;

    @Autowired
    public JobOpeningServiceImp(JobOpeningRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<JobOpening> findAll() {

        return repository.findAll();
    }

    @Override
    public Optional<JobOpening> findById(Long theId) {

        return repository.findById(theId);
    }

    @Override
    public void save(JobOpening theJobOpening) {
        repository.save(theJobOpening);
    }

    @Override
    public void deleteById(Long theId) {
        repository.deleteById(theId);
    }
}
