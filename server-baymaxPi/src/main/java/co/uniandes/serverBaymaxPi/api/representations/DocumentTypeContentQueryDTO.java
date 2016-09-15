package co.uniandes.serverBaymaxPi.api.representations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.uniandes.serverBaymaxPi.domain.entities.DocumentTypeContent;

public class DocumentTypeContentQueryDTO {

    /////////////////////////
    // Attributes
    ////////////////////////

    private final List<DocumentTypeContent> listDocumentTypeView;
    private final Long total;

    /////////////////////////
    // Constructor
    /////////////////////////
    @JsonCreator
    public DocumentTypeContentQueryDTO(
            @JsonProperty("listDocumentTypeView") List<DocumentTypeContent> listDocumentTypeView,
            @JsonProperty("total") Long total) {
        this.listDocumentTypeView = listDocumentTypeView;
        this.total = total;
    }

    ////////////////////////
    // Public Methods
    ////////////////////////
    public List<DocumentTypeContent> getListDocumentTypeView() {
        return listDocumentTypeView;
    }

    public Long getTotal() {
        return total;
    }
}