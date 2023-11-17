package service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import service.profile.ProfileLogger;
import service.profile.ProfileLoggerLocal;
import service.profile.ProfileLoggerOther;

@Configuration(proxyBeanMethods=false)
@ComponentScan(basePackages = {
    "service.impl",
    "service.mapper"
})
public class ServiceConfig {

    @Profile("local")
    @Bean
    public ProfileLogger profileLogger() {
        return new ProfileLoggerLocal();
    }

    @Profile(("!local"))
    @Bean
    public ProfileLogger profileLoggerOther() {
        return new ProfileLoggerOther();
    }

}
