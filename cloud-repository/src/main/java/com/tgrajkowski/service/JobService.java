package com.tgrajkowski.service;

import com.tgrajkowski.model.JobMapper;
import com.tgrajkowski.model.job.Job;
import com.tgrajkowski.model.job.JobDaoIml;
import com.tgrajkowski.model.job.JobDto;
import com.tgrajkowski.model.job.JobDao;
import com.tgrajkowski.model.job.daily.JobDaily;
import com.tgrajkowski.model.job.active.title.ActiveTitle;
import com.tgrajkowski.model.job.active.user.ActiveUser;
import com.tgrajkowski.model.user.User;
import com.tgrajkowski.model.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    @Autowired
    private JobDaoIml jobDaoIml;

    @Autowired
    private JobDao jobDao;

    @Autowired
    private JobMapper jobMapper;

    @Autowired
    private UserDao userDao;

    public List<JobDaily> getJobsForEachDay() {
        return jobDaoIml.findjobsForEachDay();
    }

    public List<JobDaily> findDataForMonthlyChart() {
        return jobDaoIml.findDataForMonthlyChart();
    }

    public List<ActiveUser> findTheMostActiveUsers() {
        return jobDaoIml.findTheMostActiveUsers();
    }

    public List<ActiveTitle> findTheMostActiveTitle() {
        return jobDaoIml.findTheMostActiveTitle();
    }

    public JobDto addNewJob(JobDto jobDto) {
        Job job = jobMapper.mapToJob(jobDto);
        User user = userDao.findByLogin(jobDto.getUser());
        user = setDefaultUserIfNull(user);
        job.setUsers(user);
        jobDao.save(job);
        return jobMapper.mapToJobDto(job);
    }

    private User setDefaultUserIfNull(User user) {
        if (user==null)  user = userDao.findByLogin("tomek");
        return user;
    }
}
