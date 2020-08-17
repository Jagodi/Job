package edu.devember.Job.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "job_opening")
public class JobOpening {

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

    @Column(name = "opening_website")
    private String openingWebsite;

    @Column(name = "date")
    private LocalDate date;

    public JobOpening() {
    }

    public JobOpening(String name, int salary, String businessWebsite, String openingWebsite, LocalDate date) {
        this.name = name;
        this.salary = salary;
        this.businessWebsite = businessWebsite;
        this.openingWebsite = openingWebsite;
        this.date = date;
    }

    public Long getId() {

        return id;
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

    public String getOpeningWebsite() {
        return openingWebsite;
    }

    public void setOpeningWebsite(String openingWebsite) {
        this.openingWebsite = openingWebsite;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JobOpening{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", businessWebsite='" + businessWebsite + '\'' +
                ", openingWebsite='" + openingWebsite + '\'' +
                ", date=" + date +
                '}';
    }
}
