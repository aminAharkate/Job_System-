package com.amineaharkate.job_api.job;

import com.amineaharkate.job_api.job.DYOs.jobWithcompanyDTO;

import java.util.List;

public interface jobService {
    List<jobWithcompanyDTO> findAll();
    void creatJob(Job job );
    Job findJobbyId(Long jobId);
    boolean deleteJobById(long jobId);
    boolean updateJobbyId(long jobId, Job updatedJob);
}
