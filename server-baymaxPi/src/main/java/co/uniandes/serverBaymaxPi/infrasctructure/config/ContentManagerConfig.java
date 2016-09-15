package co.uniandes.serverBaymaxPi.infrasctructure.config;

import io.dropwizard.Configuration;

/**
 * Auditor manager configuration.
 * @author LeanFactory
 */
public class ContentManagerConfig extends Configuration{

    ////////////////////////
    // Attributes
    ////////////////////////
    
    private MongoDBConfig mongoDBConfig;
    
    private String temporalFilesPath;
    
    private ContentManagerRabbitMQConfig contentManagerRabbitMQConfig;
    
    private ContentManagerServiceClients contentManagerServiceClients;
    
    private ContentManagerLogPublishQueuesInfo contentManagerLogPublishQueuesInfo;
    
    /////////////////////////
    // Constructor
    /////////////////////////
    
    private ContentManagerConfig(){
        
    }
    
    /////////////////////////
    // Getters
    /////////////////////////
    
    public ContentManagerRabbitMQConfig getContentManagerRabbitMQConfig() {
        return contentManagerRabbitMQConfig;
    }

    public ContentManagerServiceClients getContentManagerServiceClients() {
        return contentManagerServiceClients;
    }

    public ContentManagerLogPublishQueuesInfo getContentManagerLogPublishQueuesInfo() {
        return contentManagerLogPublishQueuesInfo;
    }

    public void setContentManagerLogPublishQueuesInfo(ContentManagerLogPublishQueuesInfo contentManagerLogPublishQueuesInfo) {
        this.contentManagerLogPublishQueuesInfo = contentManagerLogPublishQueuesInfo;
    }

    public MongoDBConfig getMongoDBConfig() {
        return mongoDBConfig;
    }

    public void setMongoDBConfig(MongoDBConfig mongoDBConfig) {
        this.mongoDBConfig = mongoDBConfig;
    }
    
    public String getTemporalFilesPath() {
        return temporalFilesPath;
    }
}
