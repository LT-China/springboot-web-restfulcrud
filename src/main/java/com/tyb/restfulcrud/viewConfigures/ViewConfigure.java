package com.tyb.restfulcrud.viewConfigures;

import com.tyb.restfulcrud.componet.LoginHandlerInterceptor;
import com.tyb.restfulcrud.componet.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: TYB
 * @Date: 2021/2/2 - 02 - 02 - 18:04
 * @Description: springboot-web-restfulcrud
 * @Version: 1.0
 */
@Configuration
public class ViewConfigure implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("/login**").setViewName("login");
        registry.addViewController("/main-dashboard").setViewName("dashboard");
    }

    //将自己创建的信息解析器添加到容器里
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

    //注册拦截器     可否可以写到其他类？？？？？
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/index", "/login**");
    }
}
