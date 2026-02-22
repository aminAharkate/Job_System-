package com.amineaharkate.job_api.job.impl;

import com.amineaharkate.job_api.job.Job;
import com.amineaharkate.job_api.job.JobRebository;
import com.amineaharkate.job_api.job.jobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class jobServiceImpl implements jobService {

    private long nextID = 1L;

    private JobRebository jobRebository;

    public jobServiceImpl(JobRebository jobRebository) {
        this.jobRebository = jobRebository;
    }

    @Override
    public List<Job> findAll() {
        return jobRebository.findAll();
    }

    @Override
    public void creatJob(Job job) {
        jobRebository.save(job);
    }

    @Override
    public Job findJobbyId(Long jobId) {
       return  jobRebository.findById(jobId).orElse(null);
    }

    @Override
    public boolean deleteJobById(long jobId) {

        try {
            jobRebository.deleteById(jobId);
            return true;
        }catch (Exception e )
        {
            return false;
        }

    }

    @Override
    public boolean updateJobbyId(long jobId, Job updatedJob) {
        return jobRebository.findById(jobId)
                .map(existingJob -> {
                    updatedJob.setId(jobId);
                    jobRebository.save(updatedJob);
                    return true;
                })
                .orElse(false);
    }




}
