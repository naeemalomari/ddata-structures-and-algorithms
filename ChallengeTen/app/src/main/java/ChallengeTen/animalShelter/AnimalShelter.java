package ChallengeTen.animalShelter;

import ChallengeTen.queue.structure.Queue;

public class AnimalShelter {

    Queue cat = new Queue();
    Queue dog = new Queue();


    public void enqueue(Animal animal) {
        if (animal instanceof Cat) {
            cat.enqueue(animal.getType());
        } else if (animal instanceof Dog) {
            dog.enqueue(animal.getType());
        } else {
            System.out.println("THIS IS NOT EITHER CAT NOR DOG");
        }
    }

    public String dequeue(String pref) {
        if (pref.equals("cat") && !cat.isEmpty()) {
            return cat.dequeue();
        } else if (pref.equals("dog") && !dog.isEmpty()) {
            return dog.dequeue();
        } else {
           return null;
        }
    }

    @Override
    public String toString() {
        return cat.toString() + "<--FirstQueue--SecondQueue-->" + dog.toString();
     }



}
