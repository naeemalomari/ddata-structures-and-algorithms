/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ChallengeTen;

import ChallengeTen.LinkedList.structure.LinkedList;
import ChallengeTen.hashTable.HashTable;
import ChallengeTen.queue.structure.Queue;
import ChallengeTen.stack.PseudoQueue;
import ChallengeTen.stack.structure.Stack;

public class App {

    public static void main(String[] args) {

//        HashTable<String, Integer> studentAllowances = new HashTable<>();
//        studentAllowances.add("John", 300);
//        studentAllowances.add("Sally", 400);
//        studentAllowances.add("Tom", 200);
//        studentAllowances.add("Jade", 100);
//        studentAllowances.add("Doa", 600);
//        studentAllowances.add("Farah", 700);
//        studentAllowances.add("Jason", 90000);
//        studentAllowances.add("Morgan", 800);
//        studentAllowances.add("Naim", 1000);
//        studentAllowances.add("Qusai", 1500);
//        studentAllowances.add("Deyaa", 10000);
//        studentAllowances.add("Naim", 1000);
//
//        System.out.println("The size is => " + studentAllowances.getSize());
//        System.out.println("The Sally allowance is => " + studentAllowances.get("Sally"));
//        System.out.println("Delete Sally => " + studentAllowances.remove("Sally"));
//        System.out.println("The size is => " + studentAllowances.getSize());
//        System.out.println("contains or not ---> " + studentAllowances.contain("Naim"));
//        System.out.println("contains or not ---> " + studentAllowances.contain("Osaid"));
//

        LinkedList linkedList = new LinkedList();
        linkedList.append("D");
        linkedList.append("E");
        linkedList.append("V");
//        linkedList.append("N");
//        linkedList.append("A");
//        linkedList.append("I");
//        linkedList.append("M");
        linkedList.insertBefore("V", "N");
        System.out.println(linkedList);

//        linkedList.append("N");
//        LinkedList linkedList1 = new LinkedList();
//        linkedList1.append("0");
//        linkedList1.append("C");
//        linkedList1.append("U");
//        linkedList1.append("S");
//        linkedList1.append("N");
//        linkedList1.append("A");
//        linkedList1.append("I");
//        linkedList1.append("M");
//        System.out.println(linkedList.zipLists(linkedList, linkedList1));
//        linkedList1.append("A");
//        linkedList1.append("N");
//        System.out.println(linkedList.palindrome());
//    linkedList.append("N");
//    System.out.println(linkedList);
//    System.out.println(linkedList.include("N"));
//    System.out.println(linkedList.include("P"));
//    linkedList.insertBefore("A", "M");
//    linkedList.insertBefore("M", "E");
//    System.out.println(linkedList);
//    linkedList.insertAfter("N", "OOP");
//    System.out.println(linkedList);
//    System.out.println(linkedList.kth(-1));
//        System.out.println(linkedList.kth(3));
//      LinkedList linkedList1 =new LinkedList();
//    linkedList1.append("E");
//      linkedList1.append("E");
//    System.out.println(linkedList);
//    System.out.println(linkedList1);

//    System.out.println("N E A E M");
//    System.out.println(linkedList.reversedLinkedList(linkedList));

////
////        stackReturns();
////        queueReturns();
////        pseudoQueue();
//        AnimalShelter animalShelter =new AnimalShelter();
//        Animal dog =new Dog();
//        animalShelter.enqueue(dog);
////        animalShelter.enqueue(dog);
////        animalShelter.enqueue(dog);
////        animalShelter.enqueue(dog);
//        Animal cat=new Cat();
////        animalShelter.enqueue(cat);
////        animalShelter.enqueue(cat);
////        animalShelter.enqueue(dog);
//        animalShelter.enqueue(cat);
//        System.out.println(animalShelter.dequeue("cat"));
//        System.out.println(animalShelter);
//        System.out.println(animalShelter.dequeue("dog"));
//        System.out.println(animalShelter);
//
//        StackAndQueue stackAndQueue =new StackAndQueue();
//        System.out.println(stackAndQueue.validateBrackets("{{{mynameisnaeem}}}"));
//        System.out.println(stackAndQueue.validateBrackets("{{{mynameisnaeem}"));
//        System.out.println(stackAndQueue.validateBrackets("{()}"));
//

//        Stack stack1=new Stack();
//        stack1.push("5");
//        stack1.push("2");
//        stack1.push("3");
//        stack1.push("4");
//        stack1.push("1");
//
//        System.out.println(stack1.getMax());
//



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

    ///////////////////////CHALLENGE14B//////////////////////////////////
//    public static String DuckDuckGoose(int k, String... string) {
//
//
//        GenericQueue<String> queue = new GenericQueue<>();
//
//        for (String s : string) {
//            queue.enQueue(s);
//        }
//
//        while (queue.getFront().getNext() != null) {
//            for (int i = 1; i < k; i++) {
//                queue.enQueue(queue.deQueue(null));
//            }
//            queue.deQueue(null);
//        }
//
//        return queue.peek();
//
//
//    }
}
