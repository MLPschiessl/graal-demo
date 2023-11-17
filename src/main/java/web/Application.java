package web;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportRuntimeHints;
import persistence.config.PersistenceConfig;
import service.config.ServiceConfig;
import web.config.ResourceRegistrar;
import web.config.WebConfig;

@SpringBootApplication(proxyBeanMethods=false,
    scanBasePackageClasses = {
    ServiceConfig.class,
    PersistenceConfig.class,
    WebConfig.class
})
@ImportRuntimeHints(ResourceRegistrar.class)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
