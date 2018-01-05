package com.example.demo.service.ServiceImpl;

import com.alibaba.fastjson.JSON;
import com.example.demo.coutmapper.CountMapper;
import com.example.demo.coutmapper.FailRecordMapper;
import com.example.demo.entity.EventPublish;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.fialRecordEntity;
import com.example.demo.message.MessageVo;
import com.example.demo.service.IUserService;
import com.example.demo.usermapper.EventPublishMapper;
import com.example.demo.usermapper.UserMapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UserServiceImpl  implements IUserService {


	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CountMapper countMapper;
	@Resource
	private KafkaTemplate<String, Object> kafkaTemplate;
	@Autowired
	private EventPublishMapper eventPublishMapper;
	@Autowired
	private RedisService redisService;
     @Autowired
     private FailRecordMapper failRecordMapper;

	//根据用户ID查询用户信息-test
	 //@Cacheable(value = "userInfoCache",key = "#userId+'_'+  #gender +'_' +#appid+'_CircleCountry'",sync =true )
	// @Cacheable(value = "queryUserInfoById",key = "#userId",sync =true )
	  public  List<UserEntity> queryUserInfoById(String userId){
	 	return  userMapper.queryUserInfoById(userId);
	 }

	/**
	 * 更新用户数量
	 * @param userId
	 * @param count
	 * @return  Integer
	 */

	 public  void   updateUserCount( Integer userId,Integer count) throws Exception {
	 	 //将这条记录插入到记录记录库中。
		 String newUserIdInfo=userId+";"+count.toString();
		 //①插入Message记录(TODO 插入并且返回记录ID)
		 Integer recordId= eventPublishMapper.insertUserCountRecord(newUserIdInfo,"用户更新数量");

		 if(recordId>0){
			 //②更新用户A数量-10
			 Integer num= userMapper.updateUserCount(userId,count);
			 //③发送kafka消息（记录ID，用户ID，减少的数量）
			  kafkaTemplate.send("demo",com.alibaba.fastjson.JSON.toJSONString(new MessageVo(userId,count,recordId)));
			  System.out.println("===已经发送");
		 }
	 }


	/**
	 * 更新用户B的数量
	 * @param userId
	 * @param count
	 * @return
	 */
 public Integer updateCount(Integer userId,Integer count){
 	 return   countMapper.updateCount(userId,count);
 }

	/**
	 * 定时任务--查询成功发送的消息
	 * @return
	 */
	 public  void publishList(Integer state){
		 List<EventPublish> eventPublishList=eventPublishMapper.publishList(state);
        //消费所有未被发送的消息
		 for (EventPublish eventPublish:eventPublishList)
		 {
			 System.out.println("发送kafka Message,其中topic为：demo");
			 //发送消息{记录ID，发送状态，payload,事件类型，消费状态}
			 kafkaTemplate.send("demo", eventPublish.getId()+ eventPublish.getPayload()+eventPublish.getSendStatus()+eventPublish.getConsumeStatus());
			 //之后返回消息
		     System.out.println("=============执行成功了");
		 }

		 //重写之后


	 }

	/**
	 * 定时任务---执行消费失败的记录
	 */
	public  void consumeFailRecord(Integer status) {
		List<fialRecordEntity> list = failRecordMapper.selectFailRecord(status);
		if (list!=null){
			//手动消费
			for (fialRecordEntity fialRecordEntity : list) {
				// 1:未消费，执行消费操作
				String content=fialRecordEntity.getContent();
				System.out.println("========"+content);
				MessageVo messageVo = JSON.parseObject(content, MessageVo.class);
				Integer num = this.updateCount(messageVo.getUserId(), messageVo.getCount());
				System.out.println("==========第二次消费：" + num);
				if (num > 0) {
					//将消费状态更新在redis中
					redisService.set("consumeStatus" + messageVo.getRecordId(), 2);
				}
			}
		}
	}













	/**
	 * 根据记录ID查询未其被消费的记录状态
	 * @param recordId
	 * @return
	 */
	 public  Integer  selectConsumeStateByRecordId(Integer recordId){
	 	return  eventPublishMapper.selectConsumeStateByRecordId(recordId);
	 }


	/**
	 * 插入消费失败记录
	 * @param content
	 * @return
	 */
	public  Integer insertFailureRecord(String content){
	 	return  countMapper.insertFailureRecord(content);
	 }


}


