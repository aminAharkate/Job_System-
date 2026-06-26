package com.amineaharkate.job_api.job.DYOs;

import com.amineaharkate.job_api.job.Job;
import com.amineaharkate.job_api.job.external.company;

public class jobWithcompanyDTO {
    private Job job;
    private company company;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public company getCompany() {
        return company;
    }

    public void setCompany(company conpany) {
        this.company = conpany;
    }
}
