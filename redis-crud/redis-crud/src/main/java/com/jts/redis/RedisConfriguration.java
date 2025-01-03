package com.jts.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories

public class RedisConfriguration {

	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration confriguration = new RedisStandaloneConfiguration();
		confriguration.setHostName("localhost");
		confriguration.setPort(6379);
		return new JedisConnectionFactory(confriguration);
	}

	@Bean
	public RedisTemplate<String,Object> template() {
		RedisTemplate<String,Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());

		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();

		return template;
	}



}
