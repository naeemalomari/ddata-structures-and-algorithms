package ChallengeTen.stack.structure;

import ChallengeTen.stack.data.StackNode;

public class Stack {
    public StackNode top;

    public Stack() {

    }

    /**
     *  Code Challenge 10 Stack
     */

    public void push(String data) {
        if (isEmpty()) {
            StackNode node = new StackNode(data);
            top = node;
        } else {
            StackNode node = new StackNode(data);
            node.setNext(top);
            top = node;
        }
    }

    public String pop() {
        if (isEmpty()) {
            return "The Stack Is Empty";
        } else {
            String data = top.getData();
            top = top.getNext();
            return data;
        }
    }

    public String peek() {
        if (isEmpty()) {
            return "The Stack Is Empty";
        } else {
            return top.getData();
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public Integer getMax(){
        if(top == null) return 0;

        int value =0;
        while( top != null ){

            if(Integer.parseInt(top.getData()) >  value ){
                value=Integer.parseInt(top.getData());
            }
            this.pop();
        }
        return value;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }
}
