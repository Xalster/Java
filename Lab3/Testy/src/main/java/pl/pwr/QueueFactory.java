package pl.pwr;

import pl.pwr.queues.PriorityQueue;
import pl.pwr.queues.PriorityStack;
import pl.pwr.queues.QueueAbstract;
import pl.pwr.queues.Type;

/**
 * Created by Alek on 2015-11-19.
 */
public class QueueFactory {

    public static QueueAbstract create(Type type) {
        return type == Type.FIFO ? new PriorityQueue() : new PriorityStack();
    }
}