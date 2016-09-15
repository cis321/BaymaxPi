package co.uniandes.serverBaymaxPi.domain.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;

/**
 * Log event entitie.
 * @author LeanFactory
 *
 */
public class LogEvent {

    ////////////////////////
    // Attributes
    ////////////////////////
	
	private String id;

	private int logLevel;

	private String microServiceName;
	
	private final LocalDateTime eventDate;

	private String className;

	private String methodName;

	private String logDescription;

	private IException exception;
	
	private String transactionId;
	
	

    ////////////////////////
    // Constructor
    ////////////////////////
    
	/**
	 * Constructor.
	 * @param id
	 * @param logLevel
	 * @param microServiceName
	 * @param className
	 * @param methodName
	 * @param logDescription
	 * @param exception
	 * @param transactionId
	 * @param eventDate
	 */
	@JsonCreator
	public LogEvent(@JsonProperty("_id") String id,
			@JsonProperty("logLevel") int logLevel,
			@JsonProperty("microServiceName") String microServiceName,
			@JsonProperty("className") String className,
			@JsonProperty("methodName") String methodName,
			@JsonProperty("logDescription") String logDescription,
			@JsonProperty("exception") IException exception,
			@JsonProperty("transactionId") String transactionId, 
			@JsonProperty("eventDate") LocalDateTime eventDate) {

		this.logLevel = logLevel;
		this.microServiceName = microServiceName;
		this.className = className;
		this.methodName = methodName;
		this.logDescription = logDescription;
		this.exception = exception;
		this.transactionId = transactionId;
		this.eventDate = eventDate;

	}
	
	////////////////////////
	// Public Methods
	////////////////////////


	public int getLogLevel() {
		return logLevel;
	}

	public String getMicroServiceName() {
		return microServiceName;
	}

	public String getClassName() {
		return className;
	}

	public String getMethodName() {
		return methodName;
	}

	public String getLogDescription() {
		return logDescription;
	}

	public IException getException() {
		return exception;
	}

	public String getId() {
		return id;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}
}
