package hu.wup.restapitestproject;

import hu.wup.restapitestproject.filters.SpecificUrlPatternFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestapiTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestapiTestProjectApplication.class, args);
    }

    @Bean
    FilterRegistrationBean<SpecificUrlPatternFilter> specificUrlPatternFilterFilterRegistrationBean() {
        final FilterRegistrationBean<SpecificUrlPatternFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new SpecificUrlPatternFilter());
        filterRegistrationBean.addUrlPatterns("/all");

        return filterRegistrationBean;
    }
}
