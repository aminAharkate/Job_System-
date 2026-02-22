package com.amineaharkate.job_api.job;


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
    private long CompanyId;

    public Job() {
    }

    public long getCompanyId() {
        return CompanyId;
    }

    public void setCompanyId(long companyId) {
        CompanyId = companyId;
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
