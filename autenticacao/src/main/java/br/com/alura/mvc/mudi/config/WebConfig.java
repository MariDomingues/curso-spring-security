package br.com.alura.mvc.mudi.config;

import br.com.alura.mvc.mudi.interceptor.AcessoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new AcessoInterceptor()).addPathPatterns("/**");
    }
}
