/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 下午7:06:28
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven06.service;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 下午7:06:28
 */
@Service("service2")
public class service2 {

	public String test2(Map<String, Object> allServiceNeededParams) {
		return "test2";
	}

}
