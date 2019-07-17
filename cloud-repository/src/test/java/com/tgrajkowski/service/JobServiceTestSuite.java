package com.tgrajkowski.service;

import com.tgrajkowski.model.JobMapper;
import com.tgrajkowski.model.job.Job;
import com.tgrajkowski.model.job.JobDao;
import com.tgrajkowski.model.job.JobDaoIml;
import com.tgrajkowski.model.job.JobDto;
import com.tgrajkowski.model.user.User;
import com.tgrajkowski.model.user.UserDao;
import com.tgrajkowski.service.JobService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class JobServiceTestSuite {
    @InjectMocks
    private JobService jobService;

    @Mock
    private JobDaoIml jobDaoIml;

    @Mock
    private JobDao jobDao;

    @Mock
    private JobMapper jobMapper;

    @Mock
    private UserDao userDao;

    @Test
    public void addNewJob() {
        System.out.println("Logic logic logic");
        //Given
        JobDto jobDto = new JobDto();
        jobDto.setTitle("title");
        Date date = new Date();
        jobDto.setDate(date);
        jobDto.setUser("user");

        JobDto jobDtoReturn = new JobDto();
        jobDtoReturn .setTitle("title");
        Date dateReturn = new Date();
        jobDtoReturn.setDate(dateReturn);
        jobDtoReturn.setUser("user");
        jobDtoReturn.setId(1L);

        Job job = new Job();
        Date jobDate = new Date();
        job.setDate(jobDate);
        job.setTitle("Title");
        Mockito.when(jobMapper.mapToJob(jobDto)).thenReturn(job);

        User user = new User();
        Mockito.when(userDao.findByLogin("user")).thenReturn(user);
        Mockito.when(jobMapper.mapToJobDto(job)).thenReturn(jobDtoReturn);

        // When
        JobDto result = jobService.addNewJob(jobDto);
        // Then
        Assert.assertEquals(dateReturn, result.getDate());
        Assert.assertEquals(Long.valueOf(1), result.getId());
        Assert.assertEquals("title", result.getTitle());
        Assert.assertEquals("user", result.getUser());


    }
}
