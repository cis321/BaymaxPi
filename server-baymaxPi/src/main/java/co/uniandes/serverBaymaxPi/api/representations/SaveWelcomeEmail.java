package co.uniandes.serverBaymaxPi.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SaveWelcomeEmail {

    ////////////////////////
    // Attributes
    ////////////////////////
    
    private final String content;

    ////////////////////////
    // Constructor
    ////////////////////////

    @JsonCreator
    public SaveWelcomeEmail(@JsonProperty("content") String content) {
        
        this.content = content;
    }

    ////////////////////////
    // Public Methods
    ////////////////////////
    
    public String getContent() {
        return content;
    }

    ////////////////////////
    // Private Methods
    ////////////////////////

}
