package pl.pwr.queues;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.pwr.QueueFactory;
import pl.pwr.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alek on 12/13/2015.
 */
public class QueueAbstractTestForLIFO {
    QueueAbstract stack;

    @Before
    public void setUp() throws Exception {
        stack = QueueFactory.create(Type.LIFO);
    }

    @After
    public void tearDown() throws Exception {
        stack = null;
    }

    @Test
    public void shouldAddOneObject() throws Exception {
        User user = mock(User.class);

        stack.add(user);

        assertEquals(1, stack.size());
    }

    @Test
    public void shouldReturnObjectWithTheHighestPriority() throws Exception {
        User userWithLowPriority = mock(User.class);
        when(userWithLowPriority.getPriority()).thenReturn(1);

        User userWithMediumPriority = mock(User.class);
        when(userWithMediumPriority.getPriority()).thenReturn(2);

        User userWithHighPriority = mock(User.class);
        when(userWithHighPriority.getPriority()).thenReturn(3);

        stack.add(userWithHighPriority);
        stack.add(userWithLowPriority);
        stack.add(userWithMediumPriority);

        User user = stack.poll();

        assertEquals(3, user.getPriority());
    }

    @Test
    public void testNextId() throws Exception {

    }

    @Test
    public void testSize() throws Exception {

    }

    @Test
    public void testAll() throws Exception {

    }
}