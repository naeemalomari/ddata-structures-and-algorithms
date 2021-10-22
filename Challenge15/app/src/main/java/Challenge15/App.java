/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Challenge15;

import ktree.KTree;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {


        BinarySearchTree<Integer> binarySearchContains = new BinarySearchTree<>();
        binarySearchContains.insert(20);
        binarySearchContains.insert(8);
        binarySearchContains.insert(100);
        binarySearchContains.insert(4);
        binarySearchContains.insert(16);
        binarySearchContains.insert(27);
        binarySearchContains.insert(85);

        System.out.println(binarySearchContains.contains(100));
//        System.out.println(binarySearchContains);

        binarySearchContains.inorderTraversal();
        System.out.println("");
        binarySearchContains.orderPost();
        System.out.println("");
        binarySearchContains.preOder200();
        System.out.println("");

        System.out.println(binarySearchContains.contains(23));

        BinarySearchTree<Integer> binarySearchTree2 = new BinarySearchTree<>();

        binarySearchTree2.insert(5); // Change this number to compare between the two trees .

        System.out.println(binarySearchTree2.compareTo(binarySearchContains));
        System.out.println(binarySearchContains.compareTo(binarySearchTree2));
        System.out.println(binarySearchTree2.compareTo(binarySearchContains));


        BinarySearchTree<Integer> binarySearchTreeMax = new BinarySearchTree<>();
        binarySearchTreeMax.insert(19);
        binarySearchTreeMax.insert(8);
        binarySearchTreeMax.insert(4);
        binarySearchTreeMax.insert(16);
//        binarySearchTreeMax.insert(16);
//        binarySearchTreeMax.insert(270);
//        binarySearchTreeMax.insert(250);
//        binarySearchTreeMax.insert(220);
//        binarySearchTreeMax.insert(210);
//        binarySearchTreeMax.insert(85);
        System.out.println(binarySearchTreeMax.maxNumberInTree());

        BinarySearchTree<Integer> binaryBreadthTree = new BinarySearchTree<>();
        binaryBreadthTree.insert(16);
        binaryBreadthTree.insert(50);
        binaryBreadthTree.insert(40);
        binaryBreadthTree.insert(100);
//        binaryBreadthTree.insert(801);
//        binaryBreadthTree.insert(803);
//        binaryBreadthTree.insert(800);
//        binaryBreadthTree.insert(5);
//        binaryBreadthTree.insert(16);
//        binaryBreadthTree.insert(270);
//        binaryBreadthTree.insert(2);
//        binaryBreadthTree.insert(7);
//        binaryBreadthTree.insert(85);
        ArrayList<Integer> list ;
        list = binaryBreadthTree.levelOrder(binaryBreadthTree);
        System.out.println(list);
//        BinarySearchTree.CompareDirectoriesFilesNum(binaryBreadthTree,binarySearchTreeMax );
//        System.out.println(binarySearchTree2.compareTo(binarySearchContains));
        System.out.println(binaryBreadthTree.compare(binaryBreadthTree,binarySearchTreeMax));





        KTree kTree = new KTree(1);

        kTree.add(1);
        kTree.add(2);
        kTree.add(3);
        kTree.add(5);
        kTree.add(15);

        System.out.println(kTree);
        System.out.println(kTree.fizzBuzzTree(kTree));

    }
    }