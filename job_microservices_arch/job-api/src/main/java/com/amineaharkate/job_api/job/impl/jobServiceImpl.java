package com.amineaharkate.job_api.job.impl;

import com.amineaharkate.job_api.job.DYOs.jobWithcompanyDTO;
import com.amineaharkate.job_api.job.Job;
import com.amineaharkate.job_api.job.JobRebository;
import com.amineaharkate.job_api.job.external.company;
import com.amineaharkate.job_api.job.jobService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service


public class jobServiceImpl implements jobService {

    private long nextID = 1L;

    private JobRebository jobRebository;

    public jobServiceImpl(JobRebository jobRebository) {
        this.jobRebository = jobRebository;
    }

    @Override
    public List<jobWithcompanyDTO> findAll() {
        List<Job> jobs = jobRebository.findAll();
        List<jobWithcompanyDTO> jobWithcompanyDTOList = new ArrayList<>();
        for (Job job : jobs)
        {
            jobWithcompanyDTO obj = new jobWithcompanyDTO();
            obj.setJob(job);
            RestTemplate restTemplate = new RestTemplate();
            company company = restTemplate.getForObject("http://localhost:5082/Companies/"+job.getCompanyId(), company.class);
            obj.setConpany(company);
            jobWithcompanyDTOList.add(obj);


        }


        return jobWithcompanyDTOList;
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
