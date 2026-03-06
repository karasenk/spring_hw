package hw.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
public class AppConfig {
    @Bean
    public ViewResolver viewResolver(){
        ViewResolver viewResolver = new FreeMarkerViewResolver();

        return viewResolver;
    }
}
