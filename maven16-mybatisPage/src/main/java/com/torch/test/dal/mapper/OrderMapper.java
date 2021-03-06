/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月22日 上午10:13:22
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package com.torch.test.dal.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.torch.test.dal.model.OrderModel;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月22日 上午10:13:22
 */
@Repository
public interface OrderMapper {
	OrderModel queryOrderModelById(@Param("id") String id);

	List<OrderModel> selectByPageNumSize();
}
