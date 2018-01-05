package com.example.demo.entity;

import java.io.Serializable;

/**
 * 失败记录实体
 */
public class fialRecordEntity  implements Serializable{

	private  Integer id;
	private  String content;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	private  Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}




}
