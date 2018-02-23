package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapper.OrderMapper;

@RestController
public class OrderController {
	@Autowired
	private OrderMapper orderMapper;

	@RequestMapping("/select")
	public String selectAll() {
		return orderMapper.queryOrderModelById("1").toString();
	}

}
