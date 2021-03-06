package co.uniandes.serverSensor.infrasctructure.config;

public class ContentManagerLogPublishQueuesInfo implements IStandarQueueConfig{
    
 // //////////////////////
    // Attributes
    // //////////////////////

    private String workExchange;

    private String workExchangeType;

    private String workQueue;

    private boolean workQueueDurable;

    private boolean workQueueExclusive;

    private boolean workQueueAutoDelete;

    // //////////////////////
    // Constructor
    // //////////////////////

    // //////////////////////
    // Public Methods
    // //////////////////////

    public String getWorkExchange() {
        return workExchange;
    }

    public String getWorkExchangeType() {
        return workExchangeType;
    }

    public String getWorkQueue() {
        return workQueue;
    }

    public boolean isWorkQueueDurable() {
        return workQueueDurable;
    }

    public boolean isWorkQueueExclusive() {
        return workQueueExclusive;
    }

    public boolean isWorkQueueAutoDelete() {
        return workQueueAutoDelete;
    }
}
