package com.example.Restful.dal.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Restful.dal.repository.SeckillRepository;
import com.example.Restful.dal.vo.ServerResponse;

@Service
public class SeckillService {
	@Autowired
	private SeckillRepository seckillRepository;

	public ServerResponse<?> getSeckillList() {
		System.out.println("getSeckillList");
		return ServerResponse.createBySuccess(seckillRepository.findAll());
	}

	public ServerResponse<?> getDetail(Long seckillId) {
		System.out.println("getDetail");
		return ServerResponse.createBySuccess(seckillRepository.findById(seckillId));
	}

	public ServerResponse<?> exportSeckillUrl(Long seckillId) {
		System.out.println("exportSeckillUrl");
		return ServerResponse.createBySuccess(seckillRepository.findById(seckillId));
	}

}
