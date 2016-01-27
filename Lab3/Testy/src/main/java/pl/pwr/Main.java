package pl.pwr;

import pl.pwr.queues.QueueAbstract;
import pl.pwr.queues.Type;

public class Main {

    public static void main(String[] args) {

        Keyboard k = new Keyboard();
        System.out.println("1-FIFO, 2-LIFO");
        k.wybor();
        int queue = k.getWybor();
        QueueAbstract q = QueueFactory.create(queue == 1 ? Type.FIFO : Type.LIFO);
        do {
            System.out.println("1-wyslij 2-odbierz 5-koniec");
            k.wybor();
            int choice = k.getWybor();
            switch (k.getWybor()) {
                case 1:
                    try {
                        System.out.println("Podaj nazwe:");
                        k.tekst();
                        String name = k.getTekst();

                        System.out.print("Podaj priorytet ");
                        int priority;
                        do {
                            System.out.println("3- HIGH, 2- NORMAL, 1-LOW");
                            while (true) {
                                try {
                                    k.wybor();
                                    break;
                                } catch (java.util.InputMismatchException e) {
                                    System.out.println("Zly format! Sprobuj ponownie:");
                                }
                            }
                            priority = k.getWybor();
                        } while (priority < 1 || priority > 3);
                        q.add(new User(q.nextId(), name, priority));
                    } catch (java.lang.IllegalStateException e) {
                        System.out.println("Brak miejsca w kolejce");
                    }
                    break;
                case 2:
                    try {
                        System.out.println(q.poll().getName());
                    } catch (java.lang.NullPointerException e) {
                        System.out.println("Brak elementow do pobrania");
                    }
                    break;
            }
        } while (k.getWybor() != 5);
        String queueName = queue == 1 ? "priority queue" : "stack";
        System.out.print(String.format("Uzytkownicy stoja w %s: ", queueName));
        q.all().forEach(u -> System.out.print(" <- " + u.getName()));
    }
}