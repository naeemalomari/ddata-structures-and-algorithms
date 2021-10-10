package ChallengeTen.stack;

import ChallengeTen.stack.structure.Stack;

public class PseudoQueue {
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();

    public PseudoQueue(Stack stack1, Stack stack2) {
        this.stack1 = stack1;
        this.stack2 = stack2;
    }


    public void enqueue(String value) {
        stack1.push(value);
    }

    public String dequeue(String value){
        if(stack2.top == null){
            while(stack1.top !=null ){
                stack2.push(stack1.pop());
            }
        }return stack2.pop();
    }
    
    @Override
    public String toString() {
        if (stack1.top == null)
            return stack2.toString();
        else if (stack2.top == null)
            return stack1.toString();
        else return "fill الزفت";
    }
}
