package co.uniandes.serverSensor.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TemporalDocumentCreatedDTO {

    ////////////////////////
    // Attributes
    ////////////////////////
    
    private final String temporalFileId;
    
    private final String fileName;

    ////////////////////////
    // Constructor
    ////////////////////////
    
    @JsonCreator
    public TemporalDocumentCreatedDTO(@JsonProperty("temporalFileId") String temporalFileId, @JsonProperty("fileName") String fileName) {
        
        this.temporalFileId = temporalFileId;
        this.fileName = fileName;
        
    }

    ////////////////////////
    // Public Methods
    ////////////////////////
    
    public String getTemporalFileId() {
        return temporalFileId;
    }
    
    public String getFileName() {
        return fileName;
    }

    ////////////////////////
    // Private Methods
    ////////////////////////

}
