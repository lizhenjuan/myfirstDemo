package com.example.demo.service.ServiceImpl;

import com.example.demo.service.IEnum;

public enum  InvitationCodeEnum  implements IEnum{

	INVITATION(1,"邀请者"),

	BE_INVITED(2,"被邀请者"),

	INSTALL(3,"安装")
	;

	// 枚举值
	private final int key;

	// 枚举描述
	private final String desc;


	InvitationCodeEnum(int key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	@Override
	public int key() {
		return key;
	}

	@Override
	public String desc() {
		return desc;
	}


}
