package com.nuwaish.jobms.job;

import com.nuwaish.jobms.job.dto.JobDTO;

import java.util.List;

public interface JobService {
    List<JobDTO> getAllJobs();

    void createJob(Job job);

    JobDTO getJobById(Long id);

    boolean deleteJobById(Long id);

    boolean updateJobById(Long id, Job updatedJobData);
}
