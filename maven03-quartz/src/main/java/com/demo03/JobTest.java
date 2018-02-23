/*******************************************************************************
 *Project Key : CPPII
 * Create on 2017年12月13日 下午5:57:07
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package com.demo03;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user 胖胖 2017年12月13日 下午5:57:07
 */
public class JobTest implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {

		String requestTime = new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());

		System.out.println(requestTime);
	}

}
