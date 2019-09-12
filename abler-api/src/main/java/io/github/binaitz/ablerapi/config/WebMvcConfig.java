package io.github.binaitz.ablerapi.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig extends WebMvcConfigurationSupport {

    private final TokenStore tokenStore;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        super.addArgumentResolvers(resolvers);
        resolvers.add(userIdHandlerMethodArgumentResolver());
    }

    @Bean
    public UserIdHandlerMethodArgumentResolver userIdHandlerMethodArgumentResolver() {
        return new UserIdHandlerMethodArgumentResolver(tokenStore);
    }
}
