package ru.mrsu.cookbook.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import ru.mrsu.cookbook.controller.ExceptionHandler;

@Configuration
@ConditionalOnMissingBean(
        annotation = {ControllerAdvice.class}
)
public class ExceptionHandlerConfig {
    public ExceptionHandlerConfig() {
    }

    @Bean
    public ExceptionHandler exceptionHandler() {
        return new ExceptionHandler();
    }
}
