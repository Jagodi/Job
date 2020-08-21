package edu.devember.Job.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private int salary;

    @Column(name = "business_website")
    private String businessWebsite;

    @Column(name = "job_website")
    private String jobWebsite;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    public Job() {
    }

    public Job(String name, int salary, String businessWebsite, String jobWebsite, LocalDate date) {
        this.name = name;
        this.salary = salary;
        this.businessWebsite = businessWebsite;
        this.jobWebsite = jobWebsite;
        this.date = date;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getBusinessWebsite() {
        return businessWebsite;
    }

    public void setBusinessWebsite(String businessWebsite) {
        this.businessWebsite = businessWebsite;
    }

    public String getJobWebsite() {
        return jobWebsite;
    }

    public void setJobWebsite(String jobWebsite) {
        this.jobWebsite = jobWebsite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", businessWebsite='" + businessWebsite + '\'' +
                ", jobWebsite='" + jobWebsite + '\'' +
                ", date=" + date +
                '}';
    }
}
