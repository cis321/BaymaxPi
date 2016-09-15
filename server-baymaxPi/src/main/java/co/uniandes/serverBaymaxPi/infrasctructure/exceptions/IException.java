package co.uniandes.serverBaymaxPi.infrasctructure.exceptions;

/**
 * The common interface implemented by all the exceptions handled by the system.
 * 
 * @author LeanFactory
 */
public interface IException extends Comparable<IException> {

    /**
     * Gets the error type.
     * @return
     */
    public String getType();

    /**
     * Gets error message. 
     * @return
     */
    public String getErrorMessage();
    
    /**
     * Gets stack trace. 
     * @return
     */
    public String getStackTrace();
}