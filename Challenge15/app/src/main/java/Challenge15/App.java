/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Challenge15;

public class App {
    public static void main(String[] args) {


        BinarySearchTree<Integer> binarySearchContains = new BinarySearchTree<>();
        binarySearchContains.insert(23);
        binarySearchContains.insert(8);
        binarySearchContains.insert(42);
        binarySearchContains.insert(4);
        binarySearchContains.insert(16);
        binarySearchContains.insert(27);
        binarySearchContains.insert(85);


        binarySearchContains.inorderTraversal();
        System.out.println("");
        binarySearchContains.orderPost();
        System.out.println("");
        binarySearchContains.preOder200();
        System.out.println("");
        System.out.println(binarySearchContains.contains(7));


    }
}
