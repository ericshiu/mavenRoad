package com.example.Restful.dal.service;

import com.example.Restful.dal.model.Seckill;
import com.example.Restful.dal.vo.ServerResponse;

public interface ISeckillService {
	/**
	 * 秒杀列表
	 * 
	 * @return
	 */
	ServerResponse<Seckill> getSeckillList();

	/**
	 * 单个秒杀记录
	 * 
	 * @param seckillId
	 * @return
	 */
	ServerResponse getById(long seckillId);

	/**
	 * 秒杀开始时输出秒杀接口地址，否则输出开始时间
	 * 
	 * @param seckillId
	 */
	ServerResponse exportSeckillUrl(long seckillId);

	/**
	 * 执行秒杀操作
	 * 
	 * @param seckillId
	 * @param userPhone
	 * @param md5
	 */
	ServerResponse executeSeckill(long seckillId, long userPhone, String md5);

	ServerResponse executeSeckillProcedure(long seckillId, long userPhone, String md5);
}
