package co.uniandes.serverSensor.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContentGenericNew {

	private final String id;
	private final String title;
	private final String contentText;

	@JsonCreator
	public ContentGenericNew(@JsonProperty("id") String id, @JsonProperty("title") String title,
			@JsonProperty("contentText") String contentText) {
		this.id = id;
		this.title = title;
		this.contentText = contentText;
	}

	public String getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContentText() {
		return contentText;
	}

}
