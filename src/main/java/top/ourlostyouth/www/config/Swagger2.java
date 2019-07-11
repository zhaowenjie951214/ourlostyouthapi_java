package top.ourlostyouth.www.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration //通过@Configuration注解，让Spring来加载该类配置
@EnableSwagger2 //通过@EnableSwagger2注解来启用Swagger2
public class Swagger2 {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.ourlostyouth.www"))
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo());
    }

    private List<ApiKey> securitySchemes() {
        ApiKey apiKey = new ApiKey("token", "token", "header");
        List<ApiKey> apiKeys = new ArrayList<>();
        apiKeys.add(apiKey);
        return apiKeys;
    }

    private List<SecurityContext> securityContexts() {
        SecurityContext securityContext = SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!login).*$"))
                .build();
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(securityContext);
        return securityContexts;
    }

    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("token", authorizationScopes));
        return securityReferences;
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("MES在线API")
                .description("")
                .termsOfServiceUrl("")
                .contact("浙江晶创自动化设备有限公司")
                .version("1.0")
                .build();
    }
}
