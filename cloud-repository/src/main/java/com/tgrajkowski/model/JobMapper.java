package com.tgrajkowski.model;

import com.tgrajkowski.model.job.Job;
import com.tgrajkowski.model.job.JobDto;
import org.springframework.stereotype.Service;

@Service
public class JobMapper {
    public Job mapToJob(JobDto jobDto) {
        Job job = new Job();
        job.setDate(jobDto.getDate());
        job.setTitle(jobDto.getTitle());
        return job;
    }

    public JobDto mapToJobDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setDate(job.getDate());
        jobDto.setTitle(job.getTitle());
        jobDto.setUser(job.getUsers().getLogin());
        return jobDto;
    }
}
