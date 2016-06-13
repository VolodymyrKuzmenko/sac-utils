package ua.kpi.compsys;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.kpi.compsys.configuration.SacUtilApiConfiguration;
import ua.kpi.compsys.configuration.SacUtilsApiSpringConfiguration;

import javax.ws.rs.Path;

public class SacUtilsApiApplication extends Application<SacUtilApiConfiguration> {
    public static void main(String[] args) throws Exception {
        new SacUtilsApiApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<SacUtilApiConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle());
        bootstrap.addBundle(new SwaggerBundle<SacUtilApiConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(SacUtilApiConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(SacUtilApiConfiguration configuration,
                    Environment environment) throws ClassNotFoundException {
        ApplicationContext context = getSpringApplicationContext();
        for (Object resource : context.getBeansWithAnnotation(Path.class).values()) {
            environment.jersey().register(resource);
        }

    }

    public ApplicationContext getSpringApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SacUtilsApiSpringConfiguration.class);
        context.start();
        return context;
    }
}
