package com.HindiProject.demo.job;

import java.util.List;

public interface jobService {
    List<Job> findAll();
    void creatJob(Job job );
    Job findJobbyId(Long jobId);
    boolean deleteJobById(long jobId);
    boolean updateJobbyId(long jobId, Job updatedJob);
}
