package com.baiwang.custom.web.start;

import javax.annotation.Resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//开启通用注解扫描
@ComponentScan(basePackages = {"com.baiwang.platform", "com.baiwang.cloud","com.baiwang.custom.*"})
@MapperScan(basePackages = {"com.baiwang.platform.custom.dao","com.baiwang.custom.common.dao"})
@EnableScheduling//定时任务
@ServletComponentScan//过滤器
public class CustomApplication extends SpringBootServletInitializer{
	
	@Resource
    private RedisTemplate redisTemplate;

    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，所以启动的时候需要实例化该类的一个实例
    @Autowired
    private RestTemplateBuilder builder;

    // 使用RestTemplateBuilder来实例化RestTemplate对象，spring默认已经注入了RestTemplateBuilder实例
    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

    /**
     * 实现SpringBootServletInitializer可以让spring-boot项目在web容器中运行
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
    {
        return application.sources(CustomApplication.class);
    }
    
    public static void main(String[] args)
    {
        SpringApplication.run(CustomApplication.class, args);
        System.out.println("--------------custom-web启动成功！--------------");
    }
}
