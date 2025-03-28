package in.oxidane.work.done.common.config;

import in.oxidane.work.done.common.interceptor.LoggingInterceptor;
import in.oxidane.work.done.common.wrapper.CachedBodyHttpServletRequest;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

    private final LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingInterceptor);
    }

    @Bean
    public FilterRegistrationBean<Filter> requestResponseLoggingFilter() {
        FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<>();
        Filter loggingFilter = new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                throws ServletException, IOException {
                if (request.getRequestURI().contains("/api/")) {
                    CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(request);
                    ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(response);
                    try {
                        filterChain.doFilter(cachedBodyHttpServletRequest, wrappedResponse);
                    } finally {
                        wrappedResponse.copyBodyToResponse();
                    }
                } else {
                    filterChain.doFilter(request, response);
                }
            }
        };

        registration.setFilter(loggingFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registration.setName("requestResponseLoggingFilter");
        return registration;
    }

}
