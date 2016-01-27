package pl.pwr.queues;

/**
 * Created by Ola on 2015-11-19.
 */
public class PriorityStack extends QueueAbstract {
    public PriorityStack() {
        super(new Compstack());

    }
}
