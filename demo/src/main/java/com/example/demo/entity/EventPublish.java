package com.example.demo.entity;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.Serializable;

/**
 * 存储用户更新记录-2017年12月6日-lzj
 */
public class EventPublish  implements Serializable{

	private  Integer  consumeStatus;
	private  String id;
	private  Integer sendStatus;
	private  String payload;
	private  String enentType;
	private  UserEntity userEntity;

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}



	public  EventPublish(String id, String payload, String enentType,Integer consumeStatus,Integer sendStatus){
             this.consumeStatus=consumeStatus;
             this.id=id;
             this.payload=payload;
             this.enentType=enentType;
             this.sendStatus=sendStatus;
	}

	public Integer getConsumeStatus() {
		return consumeStatus;
	}

	public void setConsumeStatus(Integer consumeStatus) {
		this.consumeStatus = consumeStatus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(Integer sendStatus) {
		this.sendStatus = sendStatus;
	}

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getEnentType() {
		return enentType;
	}

	public void setEnentType(String enentType) {
		this.enentType = enentType;
	}



}
