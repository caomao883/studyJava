package com.uestc.autowried;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.kfit.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.converter.HttpMessageConverter;
@SpringBootApplication
public class AppTest {
    /**
     * 在这里我们使用 @Bean注入 fastJsonHttpMessageConvert
     * @return
     */
    @Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 1、需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();

        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);

        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);


        HttpMessageConverter<?> converter = fastConverter;
        return new HttpMessageConverters(converter);
    }


    /**
     * 这是springloader的配置方式：-javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
     * @param args
     */
    public static void main(String[] args) {
		/*
		 * 在main方法进行启动我们的应用程序.
		 */
        SpringApplication.run(AppTest.class, args);
    }
}
