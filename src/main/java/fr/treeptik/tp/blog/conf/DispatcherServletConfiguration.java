package fr.treeptik.tp.blog.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@ComponentScan("fr.treeptik.tp.blog")
@EnableWebMvc
public class DispatcherServletConfiguration extends WebMvcConfigurerAdapter {

	private final Logger LOGGER = Logger
			.getLogger(DispatcherServletConfiguration.class);

	// 10 Mo max file size
	private static final int MAX_UPLOAD_SIZE = 300 * 1000 * 1000;

	/**
	 * Optimise le chargement des ressources dans les vues
	 */
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//	}
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("");
    }
	
	
	@Bean
	public ViewResolver contentNegotiatingViewResolver() {
		LOGGER.info("Configuring the ContentNegotiatingViewResolver");
		ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
		List<ViewResolver> viewResolvers = new ArrayList<ViewResolver>();

		UrlBasedViewResolver urlBasedViewResolver = new UrlBasedViewResolver();
		urlBasedViewResolver.setViewClass(JstlView.class);
		urlBasedViewResolver.setPrefix("/templates/");
		urlBasedViewResolver.setSuffix("full.jsp");
		viewResolvers.add(urlBasedViewResolver);

		viewResolver.setViewResolvers(viewResolvers);

		List<View> defaultViews = new ArrayList<View>();
		defaultViews.add(new MappingJackson2JsonView());
		viewResolver.setDefaultViews(defaultViews);

		return viewResolver;
	}

	@Bean
	public SessionLocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.FRANCE);
		return localeResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setBasename("message");
		return messageSource;
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LOGGER.debug("Configuring localeChangeInterceptor");
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}

	/**
	 * Gestion des fichiers en upload
	 * @return
	 */
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(MAX_UPLOAD_SIZE);
		return multipartResolver;
	}

	/**
	 * gestion des requêtes
	 * @return
	 */
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		LOGGER.debug("Creating requestMappingHandlerMapping");
		RequestMappingHandlerMapping requestMappingHandlerMapping = new RequestMappingHandlerMapping();
		requestMappingHandlerMapping.setUseSuffixPatternMatch(true);
		Object[] interceptors = { localeChangeInterceptor() };
		requestMappingHandlerMapping.setInterceptors(interceptors);
		return requestMappingHandlerMapping;
	}

	/**
	 * 
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
}