package com.project.spring;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com")
@PropertySources({
        @PropertySource("jdbcConnection.properties"),
        @PropertySource("general.cfg.properties"),
        @PropertySource("url.properties")   }   )
public class SpringConfig {
}
