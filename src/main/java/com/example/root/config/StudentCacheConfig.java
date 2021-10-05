package com.example.root.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class StudentCacheConfig {
	
	@Bean
	public Config cacheConfig() {
		return new Config().setInstanceName("hazel-instance")
				.addMapConfig(new MapConfig().setName("student-cache").setTimeToLiveSeconds(3000));
	}

}
