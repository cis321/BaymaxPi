package co.uniandes.serverBaymaxPi.infrasctructure.config;

/**
 * Configuration of rabbitMQ.
 * 
 * @author LeanFactory
 */
public class ContentManagerRabbitMQConfig {

    ////////////////////////
    // Attributes
    ////////////////////////

    private String host;

    ////////////////////////
    // Constructor
    ////////////////////////

    private ContentManagerRabbitMQConfig() {

    }

    ////////////////////////
    // Public Methods
    ////////////////////////

    public String getHost() {
        return host;
    }
}
