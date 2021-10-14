/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Challenge15;

import com.sun.source.tree.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void emptyTreeTest() {
        BinarySearchTree<Integer> binaryTreeTest = new BinarySearchTree<>();

        assertEquals("BinarySearchTree{root=null, postOrderList=[], preOrderList=[]}", binaryTreeTest.toString());
    }

    @Test
    public void singleRootTreeTest() {
        BinarySearchTree<Integer> binaryTreeTest = new BinarySearchTree<>();
        binaryTreeTest.insert(7);

        assertEquals("BinarySearchTree{root=BinaryNode{data=7, leftNode=null, rightNode=null}, postOrderList=[], preOrderList=[]}", binaryTreeTest.toString());
    }

    @Test
    public void addSingleLeftRightTreeTest() {
        BinarySearchTree<Integer> binaryTreeTest = new BinarySearchTree<>();
        binaryTreeTest.insert(7);
        binaryTreeTest.insert(9);
        binaryTreeTest.insert(10);

        assertEquals("BinarySearchTree{root=BinaryNode{data=7, leftNode=null, rightNode=BinaryNode{data=9, leftNode=null, rightNode=BinaryNode{data=10, leftNode=null, rightNode=null}}}, postOrderList=[], preOrderList=[]}", binaryTreeTest.toString());

    }


    @Test
    public void preOrderTest() {
        BinarySearchTree<Integer> binaryTreeTest = new BinarySearchTree<>();
        binaryTreeTest.insert(7);
        binaryTreeTest.insert(9);
        binaryTreeTest.insert(10);
        binaryTreeTest.preOder200();
        assertEquals("BinarySearchTree{root=BinaryNode{data=7, leftNode=null, rightNode=BinaryNode{data=9, leftNode=null, rightNode=BinaryNode{data=10, leftNode=null, rightNode=null}}}, postOrderList=[], preOrderList=[7, 9, 10]}", binaryTreeTest.toString());

    }

    @Test
    public void inorderTest() {
        BinarySearchTree<Integer> binaryTreeTest = new BinarySearchTree<>();
        binaryTreeTest.insert(7);
        binaryTreeTest.insert(9);
        binaryTreeTest.insert(10);
        binaryTreeTest.inorderTraversal();

        assertEquals("BinarySearchTree{root=BinaryNode{data=7, leftNode=null, rightNode=BinaryNode{data=9, leftNode=null, rightNode=BinaryNode{data=10, leftNode=null, rightNode=null}}}, postOrderList=[], preOrderList=[]}", binaryTreeTest.toString());

    }

    //
    @Test
    public void postorderTest() {
        BinarySearchTree<Integer> binaryTreeTest = new BinarySearchTree<>();
        binaryTreeTest.insert(12);
        binaryTreeTest.insert(15);
        binaryTreeTest.insert(11);
        binaryTreeTest.insert(7);
        binaryTreeTest.insert(9);
        binaryTreeTest.insert(10);
        binaryTreeTest.insert(42);
        binaryTreeTest.insert(75);
        binaryTreeTest.insert(10);
        binaryTreeTest.preOder200();
        assertEquals("BinarySearchTree{root=BinaryNode{data=12, leftNode=BinaryNode{data=11, leftNode=BinaryNode{data=7, leftNode=null, rightNode=BinaryNode{data=9, leftNode=null, rightNode=BinaryNode{data=10, leftNode=null, rightNode=null}}}, rightNode=null}, rightNode=BinaryNode{data=15, leftNode=null, rightNode=BinaryNode{data=42, leftNode=null, rightNode=BinaryNode{data=75, leftNode=null, rightNode=null}}}}, postOrderList=[], preOrderList=[]}", binaryTreeTest.toString());

    }

}
