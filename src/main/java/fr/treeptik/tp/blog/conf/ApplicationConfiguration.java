package fr.treeptik.tp.blog.conf;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationConfiguration implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MyApplicationContext.class);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",	new DispatcherServlet(rootContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		dispatcher.setAsyncSupported(true);

//		FilterRegistration.Dynamic security = servletContext.addFilter("springSecurityFilterChain",	new DelegatingFilterProxy());
//		EnumSet<DispatcherType> securityDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ASYNC);
//
//		security.addMappingForUrlPatterns(securityDispatcherTypes, false, "/*");
//		security.setAsyncSupported(true);
//		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}