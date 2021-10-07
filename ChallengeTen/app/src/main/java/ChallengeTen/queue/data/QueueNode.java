package ChallengeTen.queue.data;

public class QueueNode {

    private String data;
    private QueueNode next;

    public QueueNode(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "data='" + data + '\'' +
                ", next=" + next +
                '}';
    }
}
