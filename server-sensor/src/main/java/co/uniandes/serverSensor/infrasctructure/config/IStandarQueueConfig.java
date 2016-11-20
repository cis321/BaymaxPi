package co.uniandes.serverSensor.infrasctructure.config;

/**
 * Interface of queue configuration. 
 * @author LeanFactory
 */
public interface IStandarQueueConfig {
	
    /**
     * Gets work exchange.
     * @return
     */
	public String getWorkExchange();

	/**
	 * Gets work exchange type.
	 * @return
	 */
    public String getWorkExchangeType() ;

    /**
     * Gets work queue.
     * @return
     */
    public String getWorkQueue() ;

    /**
     * Gets boolean if queue is durable.
     * @return
     */
    public boolean isWorkQueueDurable() ;

    /**
     * Gets boolean if queue is exclusive.
     * @return
     */
    public boolean isWorkQueueExclusive() ;

    /**
     * Gets boolean if queue can auto delete.
     * @return
     */
    public boolean isWorkQueueAutoDelete() ;
}
