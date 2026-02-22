package com.HindiProject.demo.job.impl;

import aj.org.objectweb.asm.commons.TryCatchBlockSorter;
import com.HindiProject.demo.job.JobRebository;
import com.HindiProject.demo.job.Job;
import com.HindiProject.demo.job.jobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class jobServiceImpl implements jobService {
    private long nextID = 1L;
    //private List<job> jobs = new ArrayList<>();
    private JobRebository jobRebository;

    public jobServiceImpl(JobRebository jobRebository) {
        this.jobRebository = jobRebository;
    }

    @Override
    public List<Job> findAll() {
        //return jobs;
        return jobRebository.findAll();
    }

    @Override
    public void creatJob(Job job) {
//        job.setId(nextID++);
//        jobs.add(job);
        jobRebository.save(job);
    }

    @Override
    public Job findJobbyId(Long jobId) {
        /*for (job job : jobs) {
            if (job.getId() == jobId)
                return job;
        }
        return null;*/
       return  jobRebository.findById(jobId).orElse(null);
    }

    @Override
    public boolean deleteJobById(long jobId) {

        /*Iterator<job> iterator = jobs.iterator();
        while (iterator.hasNext()) {
            job job = iterator.next();
            //if (job.getId().equals(jobId))
            if (job.getId() == (jobId))
            {
                iterator.remove();
                 return true;
                 }
        }
        return false;*/
        try {
            jobRebository.deleteById(jobId);
            return true;
        }catch (Exception e )
        {
            return false;
        }

    }

    /*@Override
    public boolean updateJobbyId(long jobId, job updatedJob) {
        for (int i = 0; i < jobs.size(); i++) {
            job existingJob = jobs.get(i);
            if (existingJob.getId() == jobId) {
                updatedJob.setId(jobId);

                jobs.set(i, updatedJob);
                return true;
            }
        }
        return false;
    }*/
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
