package co.uniandes.serverBaymaxPi.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DocumentTypeContentView {
    //////////////////////
    // Attributes
    //////////////////////

    private final String idName;

    private final String labelName;

    /////////////////////////
    // Constructor
    /////////////////////////
    @JsonCreator
    public DocumentTypeContentView(
            @JsonProperty("idName")String idName,
            @JsonProperty("labelName")String labelName) {
        this.idName = idName;
        this.labelName = labelName;
    }

    ////////////////////////
    // Public Methods
    ///////////////////////

    public String getIdName() {
        return idName;
    }

    public String getLabelName() {
        return labelName;
    }
}
