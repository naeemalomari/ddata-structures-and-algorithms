package ChallengeTen.LinkedList.data;


public class LinkedListNode {


    private String data;

    public LinkedListNode next;

    public LinkedListNode(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

}
