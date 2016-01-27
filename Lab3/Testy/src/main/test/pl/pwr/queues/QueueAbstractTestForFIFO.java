package pl.pwr.queues;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import pl.pwr.QueueFactory;
import pl.pwr.User;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Alek on 12/13/2015.
 */
public class QueueAbstractTestForFIFO {
    private QueueAbstract queue;

    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        queue = QueueFactory.create(Type.FIFO);
    }

    @After
    public void tearDown() throws Exception {
        queue = null;
    }

    @Test
    public void shouldAddToFIFOQueueOneElement() throws Exception {
        User user = mock(User.class);
        queue.add(user);
        assertEquals(1, queue.size());
    }

    @Test
    public void shouldGetElementWithHighestPriority() throws Exception {

        User userLowPriority = mock(User.class);
        when(userLowPriority.getPriority()).thenReturn(1);

        User userMediumPriority = mock(User.class);
        when(userMediumPriority.getPriority()).thenReturn(2);

        User userHighPriority = mock(User.class);
        when(userHighPriority.getPriority()).thenReturn(3);

        //Act
        queue.add(userMediumPriority);
        queue.add(userHighPriority);
        queue.add(userLowPriority);

        User user = queue.poll();

        //Assert
        assertEquals(3, user.getPriority());
    }

    @Test
    public void shouldReturn1WhenQueueContains1Object() throws Exception {
        //Arrange
        User user = mock(User.class);
        queue.add(user);

        //Assert
        assertEquals(2, queue.nextId());
    }

    @Test
    public void shouldReturn1WhenOneObjectIsInQueue() throws Exception {
        //Arrange
        User user = mock(User.class);
        queue.add(user);

        //Assert
        assertEquals(1, queue.size());
    }

    @Test
    public void shouldReturnAllOjects() throws Exception {
        //Arrange
        User user = mock(User.class);
        queue.add(user);
        queue.add(user);
        queue.add(user);
        queue.add(user);
        queue.add(user);
        queue.add(user);

        //Act
        java.util.PriorityQueue<User> newQueue = queue.all();

        //Assert
        assertEquals(queue.size(), newQueue.size());
    }
}