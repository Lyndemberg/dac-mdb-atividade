/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.mdbweb.service.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author romulo
 */
public class SchedulerInitializer {
    
    public static void startTaskScheduler(){
        SchedulerFactory shedFact = new StdSchedulerFactory();
        try {
            Scheduler scheduler = shedFact.getScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(ScheduledProductSearch.class)
                    .withIdentity("ScheduledProductSearchJOB", "grupo01")
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("ScheduledProductSearchTRIGGER", "grupo01")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?"))
                    .build();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
    }
    
}
