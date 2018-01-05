package com.example.demo.coutmapper;

import com.example.demo.entity.fialRecordEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


public interface FailRecordMapper {

	/**
	 * 查询消费失败的消息记录
	 * @param  status
	 * @return
	 */
	 List<fialRecordEntity>  selectFailRecord(@Param("status") Integer status);

}
