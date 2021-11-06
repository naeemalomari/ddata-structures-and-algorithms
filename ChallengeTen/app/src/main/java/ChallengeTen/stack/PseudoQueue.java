package ChallengeTen.stack;

import ChallengeTen.stack.structure.Stack;


public class PseudoQueue {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public void enqueue(String value) {
        stack1.push(value);
    }

    public String dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return "Empty";
        }
        if (stack2.top == null) {
            while (stack1.top != null) {
                stack2.push(stack1.pop());
            }
        }
        String value = stack2.pop();
        if (stack1.top == null) {
            while (stack2.top != null) {
                stack1.push(stack2.pop());
            }
        }
        return value;
    }

    @Override
    public String toString() {
        return "stack1=" + stack1;
    }
    
}