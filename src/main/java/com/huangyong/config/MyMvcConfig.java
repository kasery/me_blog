package com.huangyong.config;

import com.huangyong.interceptor.AdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns("/css/*");
        registration.excludePathPatterns("/css2/*");
        registration.excludePathPatterns("/css3/*");
        registration.excludePathPatterns("/css4/*");
        registration.excludePathPatterns("/css5/*");
        registration.excludePathPatterns("/editor/**");
        registration.excludePathPatterns("/font-awesome-4.7.0/**");
        registration.excludePathPatterns("/img/**");
        registration.excludePathPatterns("/js/**");
        registration.excludePathPatterns("/layui/**");
        registration.excludePathPatterns("/uploads/**");

        registration.excludePathPatterns("/log");
        registration.excludePathPatterns("/login");
        registration.excludePathPatterns("/kaptcha");
        registration.excludePathPatterns("/index");
        registration.excludePathPatterns("/BlogContent");
        registration.excludePathPatterns("/LinkContent");
        registration.excludePathPatterns("/blog/**");
        registration.excludePathPatterns("/txt/**");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/log").setViewName("login");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/BlogContent").setViewName("BlogContent");
        registry.addViewController("/LinkContent").setViewName("LinkContent");

        registry.addViewController("/back").setViewName("BackStage");
        registry.addViewController("/addblog").setViewName("addBlog");
        registry.addViewController("/blogmanage").setViewName("BlogManage");
        registry.addViewController("/comment").setViewName("commentManage");
        registry.addViewController("/category").setViewName("category");
        registry.addViewController("/tag").setViewName("tag");
        registry.addViewController("/link").setViewName("link");
        registry.addViewController("/set").setViewName("set");
        registry.addViewController("/pass").setViewName("pass");
        registry.addViewController("/edit").setViewName("edit");
        registry.addViewController("/addcategory").setViewName("addcategory");
        registry.addViewController("/reply").setViewName("reply");
        registry.addViewController("/editcat").setViewName("editcategory");
        registry.addViewController("/tagedit").setViewName("tagedit");
        registry.addViewController("/addtag").setViewName("addtag");
        registry.addViewController("/addlink").setViewName("addlink");
        registry.addViewController("/editlink").setViewName("editlink");
    }
    // 文件保存在真实目录/upload/下，
    // 访问的时候使用虚路径/upload，比如文件名为1.png，就直接/upload/1.png就ok了。
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:D:/uploads/");
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer pathMatchConfigurer) {

    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer contentNegotiationConfigurer) {

    }

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer asyncSupportConfigurer) {

    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {

    }

    @Override
    public void addFormatters(FormatterRegistry formatterRegistry) {

    }

    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {

    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry viewResolverRegistry) {

    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> list) {

    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> list) {

    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> list) {

    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> list) {

    }

    @Override
    public Validator getValidator() {
        return null;
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
