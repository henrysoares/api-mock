package com.hensoares;

import com.hensoares.infrastructure.util.YamlPropertySourceFactory;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan
@ComponentScan
@EnableJpaRepositories
@Configuration
@PropertySources({
        @PropertySource(
                value = "classpath:application_core.yml",
                factory = YamlPropertySourceFactory.class)
})
public class ModuleLoader {
}
