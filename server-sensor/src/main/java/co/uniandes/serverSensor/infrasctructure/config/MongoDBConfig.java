package co.uniandes.serverSensor.infrasctructure.config;

import java.util.List;

public class MongoDBConfig {

    ////////////////////////
    // Attributes
    ////////////////////////
    
    private String dbUser;
    
    private String dbName;
    
    private String dbPassword;

    private List<String> dbAddresses;

    ////////////////////////
    // Constructor
    ////////////////////////
    
    private MongoDBConfig(){
        
    }

    ////////////////////////
    // Public Methods
    ////////////////////////
    
    public String getDbName() {
        return dbName;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public List<String> getDbAddresses() {
        return dbAddresses;
    }
}
