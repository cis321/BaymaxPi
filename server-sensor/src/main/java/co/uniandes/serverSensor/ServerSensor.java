package co.uniandes.serverSensor;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import co.uniandes.serverSensor.api.resources.SensorResource;
import co.uniandes.serverSensor.domain.business.SensorBusiness;
import co.uniandes.serverSensor.infrasctructure.config.ContentManagerConfig;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * This class represents the entry point of the application.
 * 
 * @author LeanFactory
 */
public class ServerSensor extends Application<ContentManagerConfig> {

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {

        try {

            ServerSensor auditorManager = new ServerSensor();
            auditorManager.run(args);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    public void initialize(Bootstrap<ContentManagerConfig> bootstrap) {

        bootstrap.addBundle(new Java8Bundle());
    }

    @Override
    public void run(ContentManagerConfig contentManagerConfig, Environment environment) throws Exception {

        initializeCORSSettings(environment);
        configureJacksonObjectMapper(environment);
        SensorBusiness sensorBusiness = new SensorBusiness();
        SensorResource sensorResource = new SensorResource(sensorBusiness);
        
        environment.jersey().register(sensorResource);
    }

    ///////////////////////////////////
    // Private Methods
    //////////////////////////////////

    private void configureJacksonObjectMapper(Environment environment) {

        ObjectMapper objectMapper = environment.getObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

    /**
     * Allows the application to support CORS requests.
     * 
     * @param environment
     *            The object that contains the environment configuration.
     */
    private void initializeCORSSettings(Environment environment) {

        Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        filter.setInitParameter(CrossOriginFilter.ALLOW_CREDENTIALS_PARAM, "true");
        filter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "OPTIONS,HEAD,GET,POST,PUT,DELETE,PATCH");
        filter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM,
                "X-Requested-With,Content-Type,Content-Length,Accept,Origin,Authorization, Access-Control-Allow-Origin");
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }
}
