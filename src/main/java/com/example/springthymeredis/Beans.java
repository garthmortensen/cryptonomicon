package com.example.springthymeredis;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

public class Beans {
	
	// FYI: @Bean makes global objects that you can use all over the place, if you wire them in
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		//JedisConnectionFactory jf = new JedisConnectionFactory();
		//jf.setHostName("localhost");
		//jf.setPort(6379);
		//return jf;
		return new JedisConnectionFactory();
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate(){
		RedisTemplate<String, Object> template = new RedisTemplate();
		template.setConnectionFactory(jedisConnectionFactory());
		return template;		
	}
}