package com.HindiProject.demo.job;

import com.HindiProject.demo.company.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "job_TableName")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String localisation;
    /*
    @OneToMany
    private Company company;
    */
    @ManyToOne
    @JoinColumn(name = "company_id") // foreign key column in job table
    private Company company;

    public Job() {
    }

    public Job(String title, String description, String minSalary, String maxSalary, String localisation) {
        //this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.localisation = localisation;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
}
