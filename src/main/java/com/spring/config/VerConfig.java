package com.spring.config;

import com.spring.componet.LoginHandlerInterceptor;
import com.spring.componet.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 扩展springMvc的配置
 */
@Configuration
public class VerConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		/*super.addViewControllers(registry);*/
		// 请求url-->视图show.html
		registry.addViewController("/ver").setViewName("show");
	}

	@Bean
	public WebMvcConfigurerAdapter getWebMvcConfigurerAdapter(){
		WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
			@Override
			public void addViewControllers(ViewControllerRegistry registry) {
				registry.addViewController("/").setViewName("login");
				registry.addViewController("/index.html").setViewName("login");
				registry.addViewController("/main.html").setViewName("dashboard");
			}

			//拦截器
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				// 拦截/**所有请求,排除一些登录页面的显示请求
				// springboot静态资源css、js？
				registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
						.excludePathPatterns("/","/index.html","/user/login");
			}
		};
		return adapter;
	}

	@Bean
	public LocaleResolver localeResolver(){
		return new MyLocaleResolver();
	}
}
