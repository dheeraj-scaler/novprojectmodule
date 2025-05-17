package com.scaler.novprojectmodule.configs;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisTemplateConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        // Create an object of RedisTemplate and define datatype of k, v
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        // Setting the connection factory here
        template.setConnectionFactory(jedisConnectionFactory());
        return template;
    }
}
// product -> "PRODUCT_" + productId
// category -> "CATEGORY_" + catId

// 1. An object of JedisConnectionFactory : Manages the connection to redis
// 2 Create an object of RedisTemplate