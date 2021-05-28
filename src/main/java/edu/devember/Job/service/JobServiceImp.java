package edu.devember.Job.service;

import edu.devember.Job.model.Job;
import edu.devember.Job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImp implements JobService {

    private final JobRepository repository;

    @Autowired
    public JobServiceImp(JobRepository repository) {

        this.repository = repository;
    }

    @Override
    public List<Job> findAll() {

        return repository.findAll();
    }

    @Override
    public Optional<Job> findById(Long theId) {

        return repository.findById(theId);
    }

    @Override
    public void save(Job theJob) {

        repository.save(theJob);
    }

    @Override
    public void deleteById(Long theId) {

        repository.deleteById(theId);
    }
}
