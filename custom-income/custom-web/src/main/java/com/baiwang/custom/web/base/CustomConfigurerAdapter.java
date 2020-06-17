package com.baiwang.custom.web.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 *file: CustomWebMvcConfigurerAdapter.java
 * Created by jiaobuchong on 12/23/15.
 */
@Configuration   //标注此文件为一个配置项，spring boot才会扫描到该配置。该注解类似于之前使用xml进行配置
@EnableWebMvc
public class CustomConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO: 注册拦截器
//        registry.addInterceptor(new SinglePointInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/test/**");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 设置时间格式
        Gson gson = new GsonBuilder()
                //.excludeFieldsWithoutExposeAnnotation()
                .setDateFormat("yyyy'-'MM'-'dd' 'HH':'mm':'ss")
                .create();
        GsonHttpMessageConverter gsonConverter = new GsonHttpMessageConverter();
        gsonConverter.setGson(gson);

        converters.removeIf(httpMessageConverter -> httpMessageConverter
                instanceof MappingJackson2HttpMessageConverter); // 删除MappingJackson2HttpMessageConverter
        // 添加GsonHttpMessageConverter
        converters.add(gsonConverter);
    }

}
