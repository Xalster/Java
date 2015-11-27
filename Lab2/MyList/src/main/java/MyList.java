/**
 * Created by Alek on 15.11.2015.
 */
public class MyList {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(5);
        list.add("Melko");
        list.add(2,"lol");
        list.add(7);
        list.remove(6);
        list.set(2,"dsgx");
        System.out.println(list.size());
        System.out.println(list.get(4));

    }
}
