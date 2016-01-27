package pl.pwr.queues;

/**
 * Created by Ola on 2015-11-19.
 */
public class PriorityQueue extends QueueAbstract {

    public PriorityQueue() {

        super(new pl.pwr.queues.Comp());
    }
}
