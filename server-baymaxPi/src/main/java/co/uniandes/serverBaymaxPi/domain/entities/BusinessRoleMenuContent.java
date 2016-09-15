package co.uniandes.serverBaymaxPi.domain.entities;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * System role menu content data object transfer.
 * 
 * @author LeanFactory
 */
public class BusinessRoleMenuContent {

    /////////////////////////
    // Attributes
    /////////////////////////

    private String _id;

    private final String businessRoleId;

    private final List<MenuItem> itemsEnabled;
    
    private final List<MenuItem> itemsDisabled;

    /////////////////////////
    // Constructor
    /////////////////////////

    /**
     * Constructor.
     * 
     * @param _id
     * @param businessRoleId
     * @param menuAuthorizationItem
     */
    @JsonCreator
    public BusinessRoleMenuContent(@JsonProperty("_id") String _id, @JsonProperty("businessRoleId") String businessRoleId,
            @JsonProperty("itemsEnabled") List<MenuItem> itemsEnabled, @JsonProperty("itemsDisabled") List<MenuItem> itemsDisabled) {

        this._id = _id;
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

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

}
