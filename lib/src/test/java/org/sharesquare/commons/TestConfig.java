package org.sharesquare.commons;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@TestConfiguration
@ComponentScan(basePackages = "org.sharesquare.commons")
@EntityScan(basePackages = "org.sharesquare.commons")
public class TestConfig {
}
