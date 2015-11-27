/**
 * Created by Alek on 15.11.2015.
 */
public class MyLinkedList {
    //7 metod
    private Node head;
    private Integer listCount;
    //pusta lista
    public MyLinkedList(){

        head = new Node(null);
        listCount = 0;
    }
    //add: dodaje kolejny element na koncu listy
    public void add(Object data){

        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }
    //add: dodaje element w podanym miejscu listy
    public void add(int index, Object data){

        if(index>listCount)
        {
            System.out.println("Not in List");
        }else {
            Node temp = new Node(data);
            Node current = head;
            for (int i = 1; i < index && current.getNext() != null; i++) {
                current = current.getNext();
            }
            temp.setNext(current.getNext());
            current.setNext(temp);
            listCount++;
        }
    }
    //get: zwraca wartosc z podanego miejsca Listy
    public Object get(int index){

        if(index <= 0 || index > listCount){
            return "Not in List";
        }else {
            Node current = head.getNext();
            for (int i = 1; i < index; i++) {
                if (current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
    }
    //remove: usuwa wybrany element
    public boolean remove(int index){
        if(index < 1 || index > listCount){
            System.out.println("Not in List");
            return false;
        }
        Node current = head;
        for(int i = 1;i < index;i++){
            if(current.getNext() == null){
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--;
        return true;
    }
    //set: zmienia wartosc wybranego elementu
    public void set(int index, Object data){

        Node temp = new Node(data);
        Node current = head;
        if(index <= 0 || index > listCount)
        {
            System.out.println("Not in List");
        }else {
            for (int i = 1; i < index; i++) {
                current = current.getNext();
            }
            temp.setNext(current.getNext().getNext());
            current.setNext(temp);
        }
    }
    //clear: czysci liste
    public void clear(){
        Node temp = new Node(null);
        Node current = head;
        for(int i = 1;i < 1;i++){
            current = current.getNext();
        }
        current.setNext(temp);
        listCount = 0;
    }
    //size: wielkosc listy
    public int size()
    {
        return listCount;
    }
}
