package com.example.demo.message;

import java.io.Serializable;

public class MessageVo implements  Serializable {

	 public MessageVo(){}
	private  Integer userId;
	private  Integer  count;
	private   Integer recordId;
	private  Integer  consumerStatus;

	public  MessageVo(Integer userId,Integer count,Integer recordId){
		this.userId=userId;
		this.count=count;
		this.recordId=recordId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public Integer getConsumerStatus() {
		return consumerStatus;
	}

	public void setConsumerStatus(Integer consumerStatus) {
		this.consumerStatus = consumerStatus;
	}




}
