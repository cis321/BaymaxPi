package co.uniandes.serverBaymaxPi;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration.Dynamic;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import co.certicamara.authmanager.client.filter.RequestFilter;
import co.certicamara.authmanager.client.provider.TokenDTOProvider;
import co.uniandes.serverBaymaxPi.api.resources.ContentResource;
import co.uniandes.serverBaymaxPi.domain.business.ContentBusiness;
import co.uniandes.serverBaymaxPi.infrasctructure.config.ContentManagerConfig;
import co.uniandes.serverBaymaxPi.infrasctructure.config.MongoDBConfig;
import co.uniandes.serverBaymaxPi.persistence.db.datamappers.ContentDataMapper;
import io.dropwizard.Application;
import io.dropwizard.java8.Java8Bundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * This class represents the entry point of the application.
 * 
 * @author LeanFactory
 */
public class ContentManager extends Application<ContentManagerConfig> {

    private MongoClient mongoClient;

    /////////////////////////
    // Attributes
    /////////////////////////

    ///////////////////////////////////
    // Init
    //////////////////////////////////

    /**
     * Main method
     * 
     * @param args
     */
    public static void main(String[] args) {

        try {

            ContentManager auditorManager = new ContentManager();
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

        MongoDatabase mongoDatabase = getMongoDatabase(contentManagerConfig);

        // Add authentication and authorization filter
        addAuthManagerFilterAndProvider(environment,
                contentManagerConfig.getContentManagerServiceClients().getAutheoUrl());

        initializeCORSSettings(environment);
        configureJacksonObjectMapper(environment);
        ObjectMapper objectMapper = environment.getObjectMapper();
        ContentDataMapper contentDataMapper = new ContentDataMapper(objectMapper);
        ContentBusiness contentBusiness = new ContentBusiness(contentDataMapper, mongoDatabase);
        
        environment.jersey().register(new ContentResource(contentBusiness));
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
                "X-Requested-With,Content-Type,Content-Length,Accept,Origin,Authorization");
        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
    }

    /**
     * Authentication filter
     * 
     * @param environment
     */
    private void addAuthManagerFilterAndProvider(Environment environment, String authManagerUri) {

        String urlPattern = "/*";

        environment.servlets().addFilter("autheoFilter", new RequestFilter(authManagerUri + "/tokens"))
                .addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, urlPattern);
        environment.jersey().register(TokenDTOProvider.class);
    }

    private MongoDatabase getMongoDatabase(ContentManagerConfig contentManagerConfig) throws UnknownHostException {

        List<MongoCredential> credentialsList = new ArrayList<MongoCredential>();

        final MongoDBConfig mongoDBConfig = contentManagerConfig.getMongoDBConfig();

        MongoCredential credential = MongoCredential.createCredential(mongoDBConfig.getDbUser(),
                mongoDBConfig.getDbName(), mongoDBConfig.getDbPassword().toCharArray());
        credentialsList.add(credential);

        List<String> addresses = mongoDBConfig.getDbAddresses();
        List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
        for (String address : addresses) {
			serverAddresses.add(new ServerAddress( address));
		}
        mongoClient = new MongoClient(serverAddresses, credentialsList);
        return mongoClient.getDatabase(mongoDBConfig.getDbName());
    }
}
