package co.uniandes.serverBaymaxPi.domain.entities;

public class TemporalFileInfo {
    
	////////////////////////////////
	// Attributes
	////////////////////////////////
    
	private final String temporalFileId;
    
	private final String path;
    
	////////////////////////////////
	// Constructor
	////////////////////////////////
	
    public TemporalFileInfo(String temporalFileId, String path) {
        
        this.temporalFileId = temporalFileId;
        this.path = path;
    }

    
	////////////////////////////////
	// Getters and Setters
	////////////////////////////////
    
	public String getTemporalFileId() {
		return temporalFileId;
	}

	public String getPath() {
		return path;
	}
    
    
    
}