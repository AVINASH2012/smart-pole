
 package com.havells.platform.config;
 
 import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import
 org.springframework.context.annotation.Configuration;
import
 org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import
 org.springframework.scheduling.annotation.EnableAsync;
import
 org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
 
 @Configuration
 
 @EnableAsync
 
 @EnableJpaRepositories public class AsyncConfig {
 
 @Bean("taskExecutor") public Executor taskExecutor() { 
 ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor(); 
 executor.setCorePoolSize(2);
 executor.setMaxPoolSize(2); 
 executor.setQueueCapacity(100);
 executor.setThreadNamePrefix( executor.getThreadNamePrefix()+ "Active thread count : :"+executor.getActiveCount()); 
 executor.initialize(); 
 return executor; 
 } 
}