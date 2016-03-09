package fr.treeptik.tp.blog.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(value = { DatabaseConfiguration.class, ServicesConfiguration.class, DispatcherServletConfiguration.class })
@ComponentScan(basePackages = { "fr.treeptik.tp.blog" })
@PropertySource(value = "classpath:/fr/treeptik/tp/blog/config.properties")
public class MyApplicationContext  {


}