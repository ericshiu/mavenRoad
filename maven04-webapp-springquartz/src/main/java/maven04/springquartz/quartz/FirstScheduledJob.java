/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 上午10:55:56
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven04.springquartz.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 上午10:55:56
 * @SuppressWarnings 排除警告
 */
public class FirstScheduledJob extends QuartzJobBean {
	@SuppressWarnings("unused")
	private AnotherBean anotherBean;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		this.anotherBean.printAnotherMessage();
	}

	public void setAnotherBean(AnotherBean anotherBean) {
		this.anotherBean = anotherBean;
	}

}
