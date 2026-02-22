package com.amineaharkate.job_api.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Jobs")
public class JobController {

    private jobService  jobService;

    public JobController(jobService jobService) {
        this.jobService = jobService;
    }

    //@GetMapping("/Jobs")
    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }
   //@PostMapping("/Jobs")
    @PostMapping
    public String addJob(@RequestBody Job job)
    {
        jobService.creatJob(job);
        return "the new job added succesfully";
    }


    //@GetMapping("/Jobs/{jobId}")
    @GetMapping("/{jobId}")
    public ResponseEntity<Job>  findJobbyId(@PathVariable Long jobId)
    {
        Job job = jobService.findJobbyId(jobId);
        if (job == null)
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(jobService.findJobbyId(jobId), HttpStatus.OK) ;
       /* job job = jobService.findJobbyId(jobId;
        if (job == null)
            return new ResponseEntity<>(), HttpStatus.ok) ;

        return new ResponseEntity<>(), HttpStatus.ok) ;*/
    }

    //@DeleteMapping("/Jobs/{jobId}")
    @DeleteMapping("/{jobId}")
    public  ResponseEntity<String> deleteJobById(@PathVariable long jobId){
        boolean deleted = jobService.deleteJobById(jobId);

        if (deleted)
           return new ResponseEntity<>("Job Deleted succesfully",HttpStatus.OK);
            //return new ResponseEntity<>("Job Deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //@PutMapping("/Jobs/{jobId}")
    @PutMapping("/{jobId}")
    public ResponseEntity<String> updateJob(@PathVariable long jobId, @RequestBody Job updatedJob)
    {
        boolean updaded = jobService.updateJobbyId(jobId, updatedJob);
        if (updaded)
        {
            return  new ResponseEntity<>("updated successfully",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
