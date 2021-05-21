package com.quantiphi.scheduler.job;

import com.opencsv.exceptions.CsvException;
import com.quantiphi.scheduler.dto.User;
import com.quantiphi.scheduler.service.DataReadService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class DataTransferJob implements Job {

    private static final Logger logger = LoggerFactory.getLogger(DataTransferJob.class);

    @Autowired
    private DataReadService dataReadService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("Data Transfer job started.");
        try {
            List<User> userList = dataReadService.readData();
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        logger.info("Data Transfer job completed.");
    }
}
