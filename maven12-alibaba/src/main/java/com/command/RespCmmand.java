package com.command;

import com.alibaba.fastjson.annotation.JSONField;

public class RespCmmand {

	@JSONField(name = "USER_ID")
	private String userId;

	@JSONField(name = "USER_NAME")
	private String userName;

	@JSONField(name = "ODER_NO")
	private String orderNo;

	@JSONField(name = "TRADE_AMT")
	private String tradeAmt;

	@JSONField(name = "STATUS")
	private String status;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getTradeAmt() {
		return tradeAmt;
	}

	public void setTradeAmt(String tradeAmt) {
		this.tradeAmt = tradeAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
