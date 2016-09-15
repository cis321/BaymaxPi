package co.uniandes.serverBaymaxPi.api.representations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.uniandes.serverBaymaxPi.domain.entities.MenuItem;

/**
 * System role menu content data object transfer.
 * 
 * @author LeanFactory
 */
public class BusinessRoleMenuContentDTO {

    /////////////////////////
    // Attributes
    /////////////////////////

    private final String businessRoleId;

    private final List<MenuItem> itemsEnabled;
    
    private final List<MenuItem> itemsDisabled;

    /////////////////////////
    // Constructor
    /////////////////////////

    /**
     * Constructor.
     * 
     * @param objectId
     * @param businessRoleId
     * @param menuAuthorizationItem
     */
    @JsonCreator
    public BusinessRoleMenuContentDTO(@JsonProperty("businessRoleId") String businessRoleId,
            @JsonProperty("itemsEnabled") List<MenuItem> itemsEnabled, @JsonProperty("itemsDisabled") List<MenuItem> itemsDisabled) {

        this.businessRoleId = businessRoleId;
        this.itemsEnabled = itemsEnabled;
        this.itemsDisabled = itemsDisabled;
    }

    public String getBusinessRoleId() {
        return businessRoleId;
    }

    public List<MenuItem> getItemsDisabled() {
        return itemsDisabled;
    }

    public List<MenuItem> getItemsEnabled() {
        return itemsEnabled;
    }
}
