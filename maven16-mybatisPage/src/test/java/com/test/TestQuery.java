package com.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.github.pagehelper.PageHelper;
import com.torch.test.dal.mapper.OrderMapper;
import com.torch.test.dal.model.OrderModel;
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
	@Autowired
	@Qualifier("orderMapper")
	private OrderMapper orderMapper;

	// @Test
	// public void query() {
	// System.out.println(orderService.queryOrderModelById("1"));
	// }

	@Test
	public void queryPage() {
		try {
			// 設定分業
			PageHelper.startPage(1, 1);
			// 的下一行sql就會是分頁
			List<OrderModel> list = orderMapper.selectByPageNumSize();
			System.out.println(list);
			PageHelper.startPage(2, 1);
			// 的下一行sql就會是分頁
			List<OrderModel> list2 = orderMapper.selectByPageNumSize();
			System.out.println(list2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
