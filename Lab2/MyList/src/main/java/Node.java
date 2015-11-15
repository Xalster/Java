/**
 * Created by Alek on 15.11.2015.
 */
public class Node {
    Node next;
    Object data;

    public Node(Object dataN){

        next = null;
        data = dataN;
    }

    public Node(Object dataN, Node nextN){

        next = nextN;
        data = dataN;
    }

    public Object getData(){
        return data;
    }

    public void setData(Object dataN){
        data = dataN;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node nextN){
        next = nextN;
    }
}
