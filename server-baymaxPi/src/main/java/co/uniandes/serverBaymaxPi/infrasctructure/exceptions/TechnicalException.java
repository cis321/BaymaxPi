package co.uniandes.serverBaymaxPi.infrasctructure.exceptions;

import org.apache.commons.lang.exception.ExceptionUtils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This class represents a technical exception handled by the system.
 * 
 * @author LeanFactory
 */
public class TechnicalException implements IException {

    private final String type;
    private final String errorMessage;
    private final String stackTrace;

    /**
     * Constructor.
     * @param errorMessage
     * @param exception
     */
    @JsonCreator
    public TechnicalException(@JsonProperty("errorMessage") String errorMessage, @JsonProperty("exception") Throwable exception) {
        this.type = ExceptionType.TECHNICAL.getName();
        this.errorMessage = errorMessage;
       
        if (exception != null) {
        
        	this.stackTrace = ExceptionUtils.getStackTrace(exception);
        	
        } else {
        	
        	this.stackTrace = null;
        }
    }
    
    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public int compareTo(IException exception) {

        int answer = 0;

        answer += type.compareToIgnoreCase(exception.getType());
        answer += errorMessage.compareToIgnoreCase(exception.getErrorMessage());

        return answer;
    }

	@Override
	public String getStackTrace() {
		return stackTrace;
	}

}