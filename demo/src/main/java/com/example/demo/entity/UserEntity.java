package com.example.demo.entity;


import java.io.Serializable;

public class UserEntity  implements Serializable{
	private  String userId;
	private  String userName;
	private  Integer age;
	private  Integer count;

	public  UserEntity(){
	}

	public String getEnumCount() {
		return enumCount;
	}

	public void setEnumCount(String enumCount) {
		this.enumCount = enumCount;
	}

	private  String enumCount;


	public String getuserId() {
		return userId;
	}
	public UserEntity(String userId,String userName){
		this.userId=userId;
		this.userName=userName;
	}

	public void setuserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	
	
}
