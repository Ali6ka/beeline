package kg.edu.iaau.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@WebAppConfiguration("webapp")
public class WebAppConfig extends WebMvcConfigurerAdapter
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler(new String[]{"/assets/**"})
                .addResourceLocations(new String[]{"/assets/"}).setCachePeriod(31556926);
    }

}
