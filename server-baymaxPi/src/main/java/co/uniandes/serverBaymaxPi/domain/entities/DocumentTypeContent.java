package co.uniandes.serverBaymaxPi.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentTypeContent {

    //////////////////////
    // Attributes
    //////////////////////
    private final String id;

    private final String idName;

    private final String labelName;

    /////////////////////////
    // Constructor
    /////////////////////////
    @JsonCreator
    public DocumentTypeContent(@JsonProperty("_id")String id, 
            @JsonProperty("idName")String idName,
            @JsonProperty("labelName")String labelName) {
        this.id = id;
        this.idName = idName;
        this.labelName = labelName;
    }

    ////////////////////////
    // Public Methods
    ///////////////////////
    public String getId() {
        return id;
    }

    public String getIdName() {
        return idName;
    }

    public String getLabelName() {
        return labelName;
    }

}
