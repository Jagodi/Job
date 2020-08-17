package edu.devember.Job.repository;

import edu.devember.Job.model.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobOpeningRepository extends JpaRepository<JobOpening, Long> {
}
