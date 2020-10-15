package com.springcloud.zhifou.customer;

import com.springcloud.kernel.common.utils.UtilValidate;
import lombok.extern.log4j.Log4j2;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author liuc
 */
@RestController
@SpringBootApplication(scanBasePackages = {"com.springcloud.zhifou"},exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan(basePackages ="com.springcloud.zhifou.**.dao")
@EnableSwagger2
@Log4j2
public class CustomerCenterApplication {
    public static void main(String[] args) {
        //下面语句使得日志输出使用异步处理，减小输出日志对性能的影响
        System.setProperty("Log4jContextSelector",
                "org.apache.logging.log4j.core.async.AsyncLoggerContextSelector");
        SpringApplication.run(CustomerCenterApplication.class, args);
    }

    @GetMapping(value="/hello")
    public String hello(){
        if (UtilValidate.areEqual("","")) {
            log.info("23423424");
        }
        //默认日志级别为info
        log.debug("debug");
        log.info("info");
        log.error("error");
        log.warn("warn");
        return "Hello World";
    }
}
