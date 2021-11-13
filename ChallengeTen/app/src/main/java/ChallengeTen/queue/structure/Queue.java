package ChallengeTen.queue.structure;

import ChallengeTen.queue.data.QueueNode;

public class Queue {

    private QueueNode front;
    private QueueNode rear;

    public Queue() {

    }

    /**
     *  Code Challenge 10 Queue
     */

    public void enqueue(String data) {
        if (isEmpty()) {
            QueueNode node = new QueueNode(data);
            front = node;
            rear = node;
        } else {
            QueueNode node = new QueueNode(data);
            rear.setNext(node);
            rear = node;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            return "The Queue Is Empty";
        } else {
            String data = front.getData();
            front = front.getNext();
            return data;
        }
    }



    public  String duckDuckGoose(String[] arr,int k){
        Queue queue=new Queue();
        for (int i=0;i<arr.length;i++) {
            queue.enqueue(arr[i]);
        }
        for (int i=0;i<arr.length-1;i++) {
            for (int j = 1; j < k; j++) {
                queue.enqueue(queue.dequeue());
            }
            queue.dequeue();
        }
        return queue.dequeue();
    }


    public String peek() {
        return front.getData();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public QueueNode getFront() {
        return front;
    }

    public QueueNode getRear() {
        return rear;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "front=" + front +
                ", rear=" + rear +
                '}';
    }
}
