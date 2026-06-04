package com.amineaharkate.job_api.job.external;

public class company {
    private Long id;
    private String name;
    private String description;
    // Default constructor required by JPA
    public company() {
    }
    public company(String description, String name) {
        //Id = id;
        this.name = name;
        this.description = description;
    }
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}




