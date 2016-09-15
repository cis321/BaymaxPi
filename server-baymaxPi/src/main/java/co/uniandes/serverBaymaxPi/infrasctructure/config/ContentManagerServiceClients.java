package co.uniandes.serverBaymaxPi.infrasctructure.config;

/**
 * Auditor manager service client.
 * @author LeanFactory.
 */
public class ContentManagerServiceClients {

    ////////////////////////
    // Attributes
    ////////////////////////
    
    private String autheoUrl;

    ////////////////////////
    // Constructor
    ////////////////////////
    
    private ContentManagerServiceClients(){
        
    }

    ////////////////////////
    // Public Methods
    ////////////////////////
    
    public String getAutheoUrl() {
        return autheoUrl;
    }
}
