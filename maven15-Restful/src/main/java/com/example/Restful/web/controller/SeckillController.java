package com.example.Restful.web.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Restful.dal.service.imp.SeckillService;
import com.example.Restful.dal.vo.ServerResponse;

@RestController
@RequestMapping("/seckill") // url:模块/资源/{标示}(id)/集合(细分)
public class SeckillController {
	@Autowired
	private SeckillService seckillService;

	@GetMapping("/list")
	public ServerResponse<?> list() {
		System.out.println("123123123");
		// 返回资料json
		return seckillService.getSeckillList();
	}

	@GetMapping("/{seckillId}/detail")
	public ServerResponse<?> detail(@PathParam("seckillId") Long seckillId) {
		System.out.println("detail");
		// 返回资料json
		return seckillService.getDetail(seckillId);
	}

	@PostMapping("/{seckillId}/exposer")
	public ServerResponse<?> exposer(@PathParam("seckillId") Long seckillId) {
		System.out.println("detail");
		// 返回资料json
		return seckillService.getDetail(seckillId);
	}

}
