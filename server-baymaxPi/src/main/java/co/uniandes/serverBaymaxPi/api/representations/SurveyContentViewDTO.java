package co.uniandes.serverBaymaxPi.api.representations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class SurveyContentViewDTO {

	/**
	 * Form schema used to create a procedure form when a user is going to send
	 * a new request.
	 */
	private final JsonNode surveyFormSchema;

	@JsonCreator
	public SurveyContentViewDTO(@JsonProperty("surveyFormSchema") JsonNode processFormSchema) {
		this.surveyFormSchema = processFormSchema;
	}

	public JsonNode getSurveyFormSchema() {
		return surveyFormSchema;
	}
}
