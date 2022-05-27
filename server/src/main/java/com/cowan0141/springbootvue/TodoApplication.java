package com.cowan0141.springbootvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Collections;
import java.util.stream.Stream;


@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	// Bootstrap some test data into the in-memory database
	@Bean
	ApplicationRunner init(TodoRepository repository){
		return args -> {
			Stream.of("Go to shops", "Eat dinner", "Write coding project", "Wake up at 7am").forEach(name ->{
				Todo todo = new Todo();
				todo.setTitle(name);
				repository.save(todo);
			});
			repository.findAll().forEach(System.out::println);
		};
	}

@Bean
public FilterRegistrationBean simpleCorsFilter(){
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowCredentials(true);

	config.setAllowOrigins(Collections.singletonList("http://localhost:8080"));
	config.setAllowMethods(Collections.singletonList("*"));
	config.setAllowedHeaders(Collections.singletons("*"));
	source.registerCorsConfiguration("/**", config);
	FilterRegistrationBean bean = new FilterRegistrationBean<>(new CorsFilter(source));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean
}


}
