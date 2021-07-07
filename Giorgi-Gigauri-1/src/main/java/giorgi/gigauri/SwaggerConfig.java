package giorgi.gigauri;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket tasks() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Final Exam Docs")
                        .description("JVM 2")
                        .license("Apache 2.0")
                        .version("1.0")
                        .build())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/api.*"))
                .build();
    }
}
