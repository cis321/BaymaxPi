package co.uniandes.serverSensor.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentImageGeneric {

	private byte[] file;
	private final String documentTempId;
	private final String fileName;
	private final String position;
	private boolean isNew;

	@JsonCreator
	public ContentImageGeneric(@JsonProperty("file") byte[] file, @JsonProperty("documentTempId") String documentTempId,
			@JsonProperty("fileName") String fileName, @JsonProperty("position") String position, @JsonProperty("isNew") boolean isNew) {
		this.file = file;
		this.documentTempId = documentTempId;
		this.fileName = fileName;
		this.position = position;
		this.isNew = isNew;
	}

	public byte[] getFile() {
		return file;
	}
	
	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getDocumentTempId() {
		return documentTempId;
	}

	public String getFileName() {
		return fileName;
	}

	public String getPosition() {
		return position;
	}
	
	public boolean getIsNew() {
		return isNew;
	}
	
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}

}
