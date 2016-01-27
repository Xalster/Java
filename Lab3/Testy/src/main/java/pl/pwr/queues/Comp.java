package pl.pwr.queues;


import pl.pwr.User;

import java.util.Comparator;

public class Comp implements Comparator<User> {//to jest komparator dla kolejki Priorytetowej

    public int compare(User user1, User user2) {

        if (user1.getPriority() == user2.getPriority())
            return Integer.valueOf(user1.getId()).compareTo(user2.getId());
        else if (user1.getPriority() < user2.getPriority())
            return 1;
        else if (user1.getPriority() > user2.getPriority())
            return -1;
        else
            return 0;
    }
}
