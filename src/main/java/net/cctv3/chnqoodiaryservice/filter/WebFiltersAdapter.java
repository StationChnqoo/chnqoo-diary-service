package net.cctv3.chnqoodiaryservice.filter;

import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

// https://spring.io/blog/2015/06/08/cors-support-in-spring-framework
// https://stackoverflow.com/questions/48721428/springmvc-interceptors-makes-cors-annaotion-and-interceptors-fail-to-handle-cros

@SpringBootConfiguration
public class WebFiltersAdapter implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new WebFilters());
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*.action");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (HttpMessageConverter<?> converter : converters) {
            if (converter instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter jsonConverter =
                        (MappingJackson2HttpMessageConverter) converter;
                jsonConverter.getObjectMapper().configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false);
            }
        }
    }
}