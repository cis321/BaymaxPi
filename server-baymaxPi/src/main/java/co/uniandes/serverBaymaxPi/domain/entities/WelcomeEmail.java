package co.uniandes.serverBaymaxPi.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WelcomeEmail {

    ////////////////////////
    // Attributes
    ////////////////////////
    
    private final String id;
    
    private final String content;

    ////////////////////////
    // Constructor
    ////////////////////////
    
    @JsonCreator
    public WelcomeEmail(@JsonProperty("_id") String id, @JsonProperty("content") String content) {
        
        this.id = id;
        this.content = content;
    }

    ////////////////////////
    // Public Methods
    ////////////////////////
    
    public String getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }

    ////////////////////////
    // Private Methods
    ////////////////////////

}
