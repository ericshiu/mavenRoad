/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 上午10:57:47
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven04.springquartz.quartz;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 上午10:57:47
 */
@Component("anotherBean")
public class AnotherBean {
	public void printAnotherMessage() {
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss") + "AnotherMessage");
	}
}
