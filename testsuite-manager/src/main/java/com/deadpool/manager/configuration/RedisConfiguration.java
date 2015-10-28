package com.deadpool.manager.configuration;

import com.deadpool.manager.domain.TestSuite;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by roothema on 2015.10.13..
 * Project: rest-api-metrics
 */
@Configuration
public class RedisConfiguration {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, TestSuite> redisTemplate() {
        final RedisTemplate<String, TestSuite> template = new RedisTemplate<String, TestSuite>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericToStringSerializer<TestSuite>(TestSuite.class));
        template.setValueSerializer(new Jackson2JsonRedisSerializer<TestSuite>(TestSuite.class));
        return template;
    }
}
