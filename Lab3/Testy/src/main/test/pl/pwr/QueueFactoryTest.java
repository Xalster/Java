package pl.pwr;

import junit.framework.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import pl.pwr.queues.PriorityQueue;
import pl.pwr.queues.PriorityStack;
import pl.pwr.queues.QueueAbstract;
import pl.pwr.queues.Type;

import static org.junit.Assert.*;

/**
 * Created by Alek on 12/13/2015.
 */
public class QueueFactoryTest {

    @Test
    public void shouldCreateFIFOQueueWhenPassedFIFOType() throws Exception {
        QueueAbstract queue = QueueFactory.create(Type.FIFO);
        assertTrue(queue instanceof PriorityQueue);
    }

    @Test
    public void shouldCreateLIFOQueueWhenPassedLIFOType() throws Exception {
        QueueAbstract stack = QueueFactory.create(Type.LIFO);
        assertTrue(stack instanceof PriorityStack);
    }
}