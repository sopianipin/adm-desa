package id.co.admin.desa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket policyApi() {


		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				.paths(regex("/.*")).build()
				.apiInfo(apiInfo());
	}

	@Bean
	public ApiInfo apiInfo() {
		final ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.title("Dual Source")
		.description("List of all the APIs of Dual Source ");
		return builder.build();
	}

}
