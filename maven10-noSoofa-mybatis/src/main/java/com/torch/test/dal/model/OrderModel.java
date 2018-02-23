/*******************************************************************************
 * Project Key : CPPII
 * Create on 2017年12月22日 上午10:13:48
 * Copyright (c) 2017.炬火數位有限公司版權所有. 
 * 注意：本內容僅限於炬火數位內部傳閱，禁止外洩以及用於其他商業目的
 ******************************************************************************/
package com.torch.test.dal.model;

/**
 * <P>TODO</P>
 * 
 * @version $Id$
 * @user xxx 2017年12月22日 上午10:13:48
 */
public class OrderModel {
	/**
	 * TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String amt;
	private String quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
