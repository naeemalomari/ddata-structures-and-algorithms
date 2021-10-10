/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ChallengeTen;

import ChallengeTen.queue.structure.Queue;
import ChallengeTen.stack.PseudoQueue;
import ChallengeTen.stack.structure.Stack;

public class App {

    public static void main(String[] args) {

//        stackReturns();
//        queueReturns();
        pseudoQueue();

    }
    public static void stackReturns() {
        Stack stack = new Stack();

        stack.push("A");
        stack.push("A");
        stack.push("Y");
        stack.push("E");
        stack.push("D");

        System.out.println( "The Top Of The Stack is => " + stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
    public static void queueReturns(){
        System.out.println("=========================================");

        Queue queue = new Queue();

        queue.enqueue("M");
        queue.enqueue("O");
        queue.enqueue("H");
        queue.enqueue("A");
        queue.enqueue("M");
        queue.enqueue("M");
        queue.enqueue("A");
        queue.enqueue("D");


        System.out.println("The Front Of The Queue is => " + queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

    }
    public static void pseudoQueue(){

        PseudoQueue trials =new PseudoQueue();
        trials.enqueue("A");
        trials.enqueue("B");
        trials.enqueue("C");
        trials.enqueue("D");
        System.out.println(trials.dequeue());
        System.out.println(trials.dequeue());
        System.out.println(trials);
        trials.enqueue("SSS");
        trials.enqueue("DDD");
        System.out.println(trials);
        System.out.println(trials.dequeue());
        System.out.println(trials);
    }
}
