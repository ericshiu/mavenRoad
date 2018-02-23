package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.command.RespCmmand;

@Controller
public class GateWayController {
	@RequestMapping(value = "alibaba-json.do", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "application/json;charset=utf-8")
	@ResponseBody
	public String alibaba() {
		System.out.println("alibaba");
		RespCmmand resp = new RespCmmand();
		resp.setUserId("aaa111");
		resp.setStatus("1");
		resp.setTradeAmt("100");
		resp.setUserName("小名");
		resp.setOrderNo("SPD123SOOFS");
		return singAndToJsonString(resp);
	}

	public String singAndToJsonString(Object obj) {
		return singAndToJsonString(obj, null, null);
	}

	public String singAndToJsonString(Object obj, String failCode, String failMessage) {
		String result = JSON.toJSONString(obj);
		return result;
	}
}
