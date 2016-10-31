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
    
	public static final String CS_GET_TENANT_CONFIG_BUSINESS_EXCEPTION = "CS_GET_TENANT_CONFIG_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_REPORT_DESCRIPTIONS_BUSINESS_EXCEPTION = "CS_GET_REPORT_DESCRIPTIONS_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_ASYNC_CONFIG_BUSINESS_EXCEPTION = "CS_GET_ASYNC_CONFIG_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_SYSTEM_CONFIG_BUSINESS_EXCEPTION = "CS_GET_SYSTEM_CONFIG_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_EMAIL_TEMPLATE_BUSINESS_EXCEPTION = "CS_GET_EMAIL_TEMPLATE_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_TENANT_SMPT_CONFIG_INVALID_PARAMS = "CS_GET_TENANT_SMPT_CONFIG_INVALID_PARAMS";
	
	public static final String CS_GET_TENANT_PARAMS_CONFIG_INVALID_PARAMS = "CS_GET_TENANT_PARAMS_CONFIG_INVALID_PARAMS";
	
	public static final String CS_GET_TENANT_ID_BUSINESS_EXCEPTION = "CS_GET_TENANT_ID_BUSINESS_EXCEPTION";
	
	public static final String CS_GET_CONTENT_BUSINESS_EXCEPTION = "CS_GET_CONTENT_BUSINESS_EXCEPTION";
	
	///////////////////
	// Local Constants
	///////////////////
	
	private static final int BUSINESS_EXCEPTION_STATUS_CODE = 418;
    
	public int getStatusCode(IException exception) {
	    
        int statusCode;

        if (exception instanceof TechnicalException) {

            statusCode = Response.Status.INTERNAL_SERVER_ERROR.getStatusCode();

        } else {

            statusCode = BUSINESS_EXCEPTION_STATUS_CODE;

        }
        
        return statusCode;
    }

	
    
}