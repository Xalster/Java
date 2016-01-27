package pl.pwr.queues;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.pwr.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alek on 12/13/2015.
 */
public class CompstackTest {

    @Test
    public void WhenUsersHaveThisSamePriorityAndSecondUserHasHigherId_should_Return1() {
        User user1 = mock(User.class);
        when(user1.getPriority()).thenReturn(3);
        when(user1.getId()).thenReturn(1);
        User user2 = mock(User.class);
        when(user2.getPriority()).thenReturn(3);
        when(user2.getId()).thenReturn(2);

        int compareResult = new Compstack().compare(user1, user2);

        assertEquals(1, compareResult);
    }

    @Test
    public void whenUser2HasLowerPriorityThanUser1_should_return1() {
        User user1 = mock(User.class);
        when(user1.getPriority()).thenReturn(3);
        User user2 = mock(User.class);
        when(user2.getPriority()).thenReturn(1);

        int compareResult = new Compstack().compare(user1, user2);

        assertEquals(1, compareResult);
    }
}