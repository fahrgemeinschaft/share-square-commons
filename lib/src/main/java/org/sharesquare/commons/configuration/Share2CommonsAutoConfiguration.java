package org.sharesquare.commons.configuration;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.sharesquare.commons")
@EntityScan(basePackages = "org.sharesquare.commons")
public class Share2CommonsAutoConfiguration {
}
