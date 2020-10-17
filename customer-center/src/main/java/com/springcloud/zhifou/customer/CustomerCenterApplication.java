package com.springcloud.zhifou.customer;

import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 客户中心工程启动类
 * @author liuc
 */
@RestController
@SpringBootApplication(scanBasePackages = {"com.springcloud"},exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan(basePackages ="com.springcloud.zhifou.**.dao")
@EnableOpenApi
@Log4j2
public class CustomerCenterApplication {
    public static void main(String[] args) {
        //下面语句使得日志输出使用异步处理，减小输出日志对性能的影响
        System.setProperty("Log4jContextSelector",
                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(CustomerCenterApplication.class, args);
    }
}
