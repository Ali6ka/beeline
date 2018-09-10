package kg.edu.iaau.beeline.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import kg.edu.iaau.beeline.other.MasterPreparer;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
public class BeanConfig
{
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);

        return mapper;
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler(new String[]{"/assets/**"})
                .addResourceLocations(new String[]{"/assets/"}).setCachePeriod(31556926);
    }

    @Bean
    public MasterPreparer masterPreparer() {
        return new MasterPreparer();
    }

    @Bean
    public TilesConfigurer tilesConfigurer()
    {
        TilesConfigurer tc = new TilesConfigurer();
        tc.setDefinitions(new String[]{"/WEB-INF/tiles.xml"});
        tc.setCheckRefresh(true);
        tc.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
        return tc;
    }
}
