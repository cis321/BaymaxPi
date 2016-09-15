package co.uniandes.serverBaymaxPi.domain.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SurveyContent {

	////////////////////////
	// Attributes
	////////////////////////
    
	private final String id;

	private final String surveyFormSchema;

	/////////////////////////
	// Constructor
	/////////////////////////
	
	@JsonCreator
	public SurveyContent(@JsonProperty("_id") String id, @JsonProperty("surveyFormSchema") String processFormSchema) {
		this.id = id;
		this.surveyFormSchema = processFormSchema;
	}

	////////////////////////
	// Public Methods
	///////////////////////
	
	public String getId() {
		return id;
	}

	public String getSurveyFormSchema() {
		return surveyFormSchema;
	}

}
