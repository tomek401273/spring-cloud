package com.tgrajkowski.controller;

import com.tgrajkowski.model.job.JobDto;
import com.tgrajkowski.model.job.daily.JobDaily;
import com.tgrajkowski.model.job.active.title.ActiveTitle;
import com.tgrajkowski.model.job.active.user.ActiveUser;
import com.tgrajkowski.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "job/")
public class JobController {
    @Autowired
    private JobService jobService;

    @RequestMapping(value = "for/each/day", method = RequestMethod.GET)
    public List<JobDaily> findJobsForEachDay() {
        return jobService.getJobsForEachDay();
    }

    @RequestMapping(value = "data/monthly/chart", method = RequestMethod.GET)
    public List<JobDaily> findDataForMonthlyChart() {
        return jobService.findDataForMonthlyChart();
    }

    @RequestMapping(value = "the/most/active/users", method = RequestMethod.GET)
    public List<ActiveUser> findTheMostActiveUsers() {
        return jobService.findTheMostActiveUsers();
    }

    @RequestMapping(value = "the/most/active/title", method = RequestMethod.GET)
    public List<ActiveTitle> findTheMostActiveTitle() {
        return jobService.findTheMostActiveTitle();
    }

    @RequestMapping(value = "new/job", method = RequestMethod.POST)
    public JobDto addNewJob(@RequestBody JobDto jobDto) {
        return jobService.addNewJob(jobDto);
    }
}
