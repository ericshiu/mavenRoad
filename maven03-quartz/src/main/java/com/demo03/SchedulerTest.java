/*******************************************************************************
 *Project Key : CPPII
 * Create on 2017年12月13日 下午5:56:41
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package com.demo03;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user 胖胖 2017年12月13日 下午5:56:41
 */
public class SchedulerTest {

	/**
	 * <p>TODO</p>
	 * 
	 * @throws SchedulerException
	 * 
	 * @user 胖胖 2017年12月13日 下午5:56:41
	 */
	public static void main(String[] args) throws SchedulerException {
		// new JobDetail(執行哪個)
		JobDetail JobDetail = JobBuilder.newJob(JobTest.class).withIdentity("fat").build();

		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("myfat").startNow()
				.withSchedule(CronScheduleBuilder.cronSchedule("/1 * * * * ? *")).build();

		SchedulerFactory sFactory = new StdSchedulerFactory();
		Scheduler scheduler = sFactory.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(JobDetail, trigger);

	}

}
