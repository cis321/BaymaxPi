package co.uniandes.serverBaymaxPi.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentGeneric {

	private final String contentTitle;
	private final String contentText;

	@JsonCreator
	public ContentGeneric(@JsonProperty("contentTitle") String contentTitle,
			@JsonProperty("contentText") String contentText) {
		this.contentTitle = contentTitle;
		this.contentText = contentText;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public String getContentText() {
		return contentText;
	}

}
