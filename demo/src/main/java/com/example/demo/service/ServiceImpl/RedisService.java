package com.example.demo.service.ServiceImpl;

import com.example.demo.service.IRedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisService implements IRedisService {

	@Resource
	private RedisTemplate<String,Object> redisTemplate;


	@Override
	public void set(String key, Object value) {
		ValueOperations<String,Object> vo=redisTemplate.opsForValue();
		vo.set(key,value);

	}

	@Override
	public Object get(String key) {
		ValueOperations<String,Object> vo=redisTemplate.opsForValue();
		return  vo.get(key);
	}
}
