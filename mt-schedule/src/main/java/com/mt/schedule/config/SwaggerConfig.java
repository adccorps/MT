package com.mt.schedule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by Yeung on 2020/5/26.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
    //  @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled=true;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 是否开启
                .enable(swaggerEnabled).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.mt"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    //设置api信息
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MT-电影院票务系统API文档")
                .description("ADC工作室 | YXQ")
                // 作者信息
                //  .contact(new Contact("oKong", "https://blog.lqdev.cn/", "499452441@qq.com"))
                .version("1.0.0")
                .termsOfServiceUrl("https://github.com/oopsWJ/MT")
                .build();
    }
}