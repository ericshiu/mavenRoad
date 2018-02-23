/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月22日 上午10:48:26
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package com.torch.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.torch.soofa.core.common.BaseService;
import com.torch.test.dal.mapper.OrderMapper;
import com.torch.test.dal.model.OrderModel;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月22日 上午10:48:26
 */
@Service("test.OrderService")
public class OrderService extends BaseService {
	@Autowired
	@Qualifier("orderMapper")
	private OrderMapper orderMapper;

	public OrderModel queryOrderModelById(String id) {
		return orderMapper.queryOrderModelById(id);
	}

}
