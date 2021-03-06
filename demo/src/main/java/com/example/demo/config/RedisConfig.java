package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisConfig extends CachingConfigurerSupport {

	@Bean
	public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate){
		 CacheManager cacheManager= new RedisCacheManager(redisTemplate);
		 return  cacheManager;
	}

	@Bean
	public  RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
		RedisTemplate<String,String> redisTemplate= new RedisTemplate<String, String>();
		redisTemplate.setConnectionFactory(factory);
		return  redisTemplate;
	}


}
