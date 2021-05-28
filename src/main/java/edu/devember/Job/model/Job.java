package edu.devember.Job.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@NoArgsConstructor @Setter @Getter
@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    private Integer salary;

    @Column(name = "business_website")
    private String businessWebsite;

    @Column(name = "job_website")
    private String jobWebsite;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    public Job(String name, Integer salary, String businessWebsite, String jobWebsite, LocalDate date) {
        this.name = name;
        this.salary = salary;
        this.businessWebsite = businessWebsite;
        this.jobWebsite = jobWebsite;
        this.date = date;
    }

}
