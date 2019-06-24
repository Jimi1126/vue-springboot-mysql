package com.iconfluence.sms;

import com.github.pagehelper.PageHelper;
import com.iconfluence.sms.context.ApplicationContext;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Properties;

@SpringBootApplication
@MapperScan("com.iconfluence.sms.mapper")
@EnableScheduling //开启定时任务
public class SmsApplication {

  @Bean
  public PageHelper pageHelper(){
    PageHelper pageHelper = new PageHelper();
    Properties properties = new Properties();
    properties.setProperty("offsetAsPageNum","true");
    properties.setProperty("rowBoundsWithCount","true");
    properties.setProperty("reasonable","true");
    properties.setProperty("dialect","mysql");    //配置mysql数据库的方言
    pageHelper.setProperties(properties);
    return pageHelper;
  }

  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SmsApplication.class);
  }

  public static void main(String[] args) throws InterruptedException {
    ConfigurableApplicationContext cac = SpringApplication.run(SmsApplication.class, args);
    ApplicationContext.initialize(cac);
  }

}




