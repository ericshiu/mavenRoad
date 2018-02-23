package com.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.torch.test.service.OrderService;

/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月22日 上午10:33:31
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月22日 上午10:33:31
 */
public class TestQuery extends BaseTxTest {
	@Autowired
	@Qualifier("test.OrderService")
	private OrderService orderService;

	@Test
	public void query() {
		log.info("[{}]OrderModel", orderService.queryOrderModelById("1"));
	}

}
