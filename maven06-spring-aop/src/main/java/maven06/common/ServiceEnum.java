/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月8日 下午6:54:49
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package maven06.common;

import java.util.HashMap;
import java.util.Map;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月8日 下午6:54:49
 */
public enum ServiceEnum {
	HELLO1("HELLO1", "service1", "test1"), HELLO2("HELLO2", "service2", "test2"), HELLO3("HELLO3", "service3", "test3");

	private ServiceEnum(String productNo, String serviceName, String method) {
		this.productNo = productNo;
		this.serviceName = serviceName;
		this.method = method;
	}

	private String productNo;
	private String serviceName;
	private String method;

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	private static final Map<String, ServiceEnum> map = new HashMap<String, ServiceEnum>();

	static {
		ServiceEnum[] serviceEnums = values();
		for (ServiceEnum serviceEnum : serviceEnums) {
			map.put(serviceEnum.getProductNo(), serviceEnum);
		}
	}

	public static Map<String, ServiceEnum> getServiceEnum() {
		return map;
	}

	public static boolean isExistProductNo(String productNo) {
		if (map.containsKey(productNo)) {
			return true;
		}
		return false;
	}

}
