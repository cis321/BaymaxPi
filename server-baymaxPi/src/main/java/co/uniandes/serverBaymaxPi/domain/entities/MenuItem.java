package co.uniandes.serverBaymaxPi.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Item authorization object
 * @author LeanFactory
 */
public class MenuItem {
    
    /////////////////////////
    // Attributes
    /////////////////////////
    
    private final String itemName;
    
    private final String itemId;
    
    /////////////////////////
    // Constructor
    /////////////////////////
    
    /**
     * Constructor.
     * @param itemId
     * @param authorization
     */
    @JsonCreator
    public MenuItem(@JsonProperty("itemName") String itemName, @JsonProperty("itemId") String itemId){
        
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }
}
