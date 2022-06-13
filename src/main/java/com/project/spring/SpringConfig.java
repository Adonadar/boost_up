package com.project.spring;

import org.springframework.context.annotation.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com")
@PropertySources({
        @PropertySource("jdbc_connection.properties"),
        @PropertySource("url.properties")   }   )
public class SpringConfig {
}
