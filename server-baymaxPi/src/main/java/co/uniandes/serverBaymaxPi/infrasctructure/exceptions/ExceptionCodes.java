package co.uniandes.serverBaymaxPi.infrasctructure.exceptions;

import javax.ws.rs.core.Response;


/**
 * This class represents a business exception handled by the system.
 * 
 * @author LeanFactory
 */
public  class ExceptionCodes  {

	///////////////////
	// Public Constants
	///////////////////
    
	public static final String CONTENT_MANGER_GET_MENU_CONTENT_BUSINESS_EXCEPTION_NULL_PARAM = "CONTENT_MANGER_GET_MENU_CONTENT_BUSINESS_EXCEPTION_NULL_PARAM";
	
	public static final String CM_SAVE_SURVEY_FORM="CM_SAVE_SURVEY_FORM";
	
	public static final String CM_GET_SURVEY_FORM_EMPTY_BUSINESS_EXCEPTION="CM_GET_SURVEY_FORM_EMPTY_BUSINESS_EXCEPTION";
	
	public static final String CM_REMOVE_SURVEY_FORM_EMPTY_BUSINESS_EXCEPTION="CM_REMOVE_SURVEY_FORM_EMPTY_BUSINESS_EXCEPTION";
	
	public static final String CM_UPDATE_SURVEY_FORM_BUSINESS_EXCEPTION = "CM_UPDATE_SURVEY_FORM_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_CONTENT_BUSINESS_EXCEPTION = "CS_GET_CONTENT_BUSINESS_EXCEPTION";

	public static final String CM_GET_WELCOME_EMAIL_CONTENT_BUSINESS_EXCEPTION = "CM_GET_WELCOME_EMAIL_CONTENT_BUSINESS_EXCEPTION";
	
	public static final String CM_SAVE_VIDEOS ="CM_SAVE_VIDEOS";
	
	public static final String CM_SAVE_DOCUMENT_TYPE_EXISTS = "CM_SAVE_DOCUMENT_TYPE_EXISTS";
	
	public static final String CM_SAVE_DOCUMENT_TYPE_NOT_EXISTS = "CM_SAVE_DOCUMENT_TYPE_NOT_EXISTS";
	
	public static final String CM_UPDATE_DOCUMENT_TYPE_CONTENT = "CM_UPDATE_DOCUMENT_TYPE_CONTENT";

	public static final String DM_CREATE_TEMPORAL_INVALID_FILE_TYPE_EXCEPTION = "DM_CREATE_TEMPORAL_INVALID_FILE_TYPE_EXCEPTION";
	
	///////////////////
	// Local Constants
	///////////////////
	
	private static final int BUSINESS_EXCEPTION_STATUS_CODE = 418;
    
	/**
	 * Gets the status code from an IException.
	 * @param exception
	 * @return
	 */
	public static int getStatusCode(IException exception) {
	    
		if ( exception instanceof TechnicalException ) {
			
		    return Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();
			
		} else {
			
		    return BUSINESS_EXCEPTION_STATUS_CODE ;
		}
	}
}