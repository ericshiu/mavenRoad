package com.example.Restful.dal.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Seckill implements Serializable {
	@Id
	private long seckillID;

	@Column(nullable = false)
	private String name;

	private Date startTime;

	private Date endTime;

	@Column(nullable = false) // 映射为字段，值不能为空
	private Date createTime;

	public long getSeckillID() {
		return seckillID;
	}

	public void setSeckillID(long seckillID) {
		this.seckillID = seckillID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Seckill [seckillID=" + seckillID + ", name=" + name + ", startTime=" + startTime + ", endTime="
				+ endTime + ", createTime=" + createTime + "]";
	}

}
