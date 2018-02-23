/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 上午10:48:32
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
 * @user xxx 2017年12月8日 上午10:48:32 @Component泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
 */
@Component("MyBean")
public class MyBean {
	public void printMsg() {
		System.out.println(new SimpleDateFormat("yyyy-mm-dd HH:mm:ss") + " MyBean 執行!");
	}

}
