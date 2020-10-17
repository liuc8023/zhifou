package com.springcloud.zhifou.customer.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger api文档地址：/swagger-ui.html
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

    /**
     * 构建一个Docket类
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(false)
                .pathMapping("/")
                //加载api信息
                .apiInfo(apiInfo())
                .select()
                //这里采用包含注解的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //对所有路径进行监控
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建 api文档的详细信息方法,这里配置的信息都会显示在页面上
     * @return
     */
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("客户中心 Rest Api")
                //文档描述
                .description("客户中心隶属于新一代业务枢纽系统，对外提供客户信息维护和查询服务")
                .termsOfServiceUrl("https://github.com/liuc8023/zhifou")
                //创建人信息
                .contact(new Contact("卡布奇诺的味道", "https://blog.csdn.net/lc1010078424", "1010078424@qq.com"))
                //版本
                .version("1.0")
                .build();
    }


}

