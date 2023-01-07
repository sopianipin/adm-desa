package id.co.admin.desa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket policyApi() {
	
		
		return new Docket(DocumentationType.SWAGGER_2)
				.pathMapping("/")
				.select()
				.paths(regex("/api/v1.*")).build()
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
