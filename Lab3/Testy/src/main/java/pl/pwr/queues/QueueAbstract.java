package pl.pwr.queues;


import pl.pwr.User;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Alek on 2015-11-19.
 */
public abstract class QueueAbstract {
   private PriorityQueue<User> queue;

    QueueAbstract(Comparator c) {
        queue = new PriorityQueue(10, c);
    }

    public void add (User u){
        queue.add(u);
    }

    public User poll() throws NullPointerException {
        return queue.poll();
    }

    public int nextId() {
        return size() +1;
    }

    public int size() {
       return queue.size();
    }

    public PriorityQueue<User> all(){
        return queue;
    }


}
