/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 下午6:58:36
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven06.service;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.stereotype.Service;

import maven06.common.ServiceEnum;
import maven06.util.SpringBeanUtil;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 下午6:58:36
 */
@Service("ControllerToService")
public class ControllerToService {

	public Object goService(String productNo, Map<String, Object> allServiceNeededParams) {
		try {
			ServiceEnum serviceEnum = ServiceEnum.getServiceEnum().get(productNo);
			Class<?> clazz = SpringBeanUtil.getBeanClass(serviceEnum.getServiceName());
			Method method = clazz.getMethod(serviceEnum.getMethod(), Map.class);
			return method.invoke(SpringBeanUtil.getBean(serviceEnum.getServiceName(), clazz), allServiceNeededParams);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
