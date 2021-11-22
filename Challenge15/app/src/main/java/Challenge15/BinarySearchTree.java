package Challenge15;


import com.sun.source.tree.BinaryTree;
import ktree.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements Comparable<BinarySearchTree<T>> {

    BinaryTreeNode<T> root;
    int sum = 0;

    /////////////////////////////////INORDER\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public ArrayList<T> inorderTraversal() { //Left-Root-Right
        if (isEmpty()) {
            return null;
        }
        ArrayList<T> inOrderList = new ArrayList<>();
        traverseInorder(root, inOrderList);
        return inOrderList;
    }

    private void traverseInorder(BinaryTreeNode<T> root, ArrayList<T> inOrderList) {
        if (root == null) return;

        if (root.getLeftNode() != null) {
            traverseInorder(root.getLeftNode(), inOrderList);
        }
        inOrderList.add(root.getData());

        if (root.getRightNode() != null) {
            traverseInorder(root.getRightNode(), inOrderList);
        }
    }

    /////////////////////////////////////////////////////////////////INSERT///////////////////////////////////////
    public void insert(T data) {
        if (isEmpty()) { // tree empty
            root = new BinaryTreeNode<>(data);
        } else {
            insertHelper(data, root);
        }
    }

    private void insertHelper(T data, BinaryTreeNode<T> root) {
        BinaryTreeNode<T> binaryTreeNode = new BinaryTreeNode<>(data);
        if (data.compareTo(root.getData()) < 0) {
            if (root.getLeftNode() == null) {
                root.setLeftNode(binaryTreeNode);
            } else {
                insertHelper(data, root.getLeftNode());
            }
        } else if (data.compareTo(root.getData()) > 0) {
            if (root.getRightNode() == null) {
                root.setRightNode(binaryTreeNode);
            } else {
                insertHelper(data, root.getRightNode());
            }
        }
    }
///////////////////////////////////////////////CONTAINS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public boolean contains(T data) {
        BinaryTreeNode<T> binaryTreeNode1 = root;

        while (binaryTreeNode1 != null) {
            if (data.compareTo(binaryTreeNode1.getData()) > 0)
                binaryTreeNode1 = binaryTreeNode1.getRightNode();
            else if (data.compareTo(binaryTreeNode1.getData()) < 0)
                binaryTreeNode1 = binaryTreeNode1.getLeftNode();
            else
                return true;
        }
        return false;
    }

    ////////////////////////////////////////////////////postOrder\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public ArrayList<T> postOrder() { // Left-Right-Root
        if (isEmpty()) {
            return null;
        }
        ArrayList<T> postOrderList = new ArrayList<>();
        traversePostorder(root, postOrderList);
        return postOrderList;
    }

    private void traversePostorder(BinaryTreeNode<T> root, ArrayList<T> postOrderList) {

        if (root.getLeftNode() != null) {
            traversePostorder(root.getLeftNode(), postOrderList);
        }
        if (root.getRightNode() != null) {
            traversePostorder(root.getRightNode(), postOrderList);
        }
        postOrderList.add(root.getData());
    }

////////////////////////////////////////////////////////////////////////////////


    public int numberOfFile(BinaryTreeNode<T> tree1) {

        if (root == null)
            return 0;
        if (tree1.getLeftNode() == null &&
                tree1.getRightNode() == null) {
            sum = sum + 1;
        }
        if (tree1.getLeftNode() != null)
            numberOfFile(tree1.getLeftNode());
        if (tree1.getRightNode() != null)
            numberOfFile(tree1.getRightNode());
        return sum;
    }

    public boolean compare(BinarySearchTree<T> tree1, BinarySearchTree<T> tree2) {

        int number1 = numberOfFile(tree1.getRoot());
        System.out.println(number1);
        sum = 0;
        int number2 = numberOfFile(tree2.getRoot());
        System.out.println(number2);
        sum = 0;
        return number1 == number2;
    }

//
//    public int sumOfOdd() {
//        if (isEmpty()) {
//            return 0;
//        }
//        ArrayList<T> treeList = preOrder();
//        int sum = 0;
//
//        for (int i = 0; i < treeList.size(); i++) {
//            if (Integer.parseInt(treeList.get(i) + "") % 2 != 0) {
//                sum = sum + Integer.parseInt(treeList.get(i) + "");
//            }
//
//        }
//        return sum;
//    }

    //////////////////////////////////////////////////////////////PRE--ORDER\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public ArrayList<T> preOder200() {// Root-Left-Right
        if (isEmpty()) {
            return null;
        }
        ArrayList<T> listPre = new ArrayList<>();
        preOrder(root, listPre);
        return listPre;
    }

    public void preOrder(BinaryTreeNode<T> root, ArrayList<T> listPre) {
        if (root == null) {
            return;
        }
        listPre.add(root.getData());

        if (root.getLeftNode() != null) {
            preOrder(root.getLeftNode(), listPre);
        }
        if (root.getRightNode() != null) {
            preOrder(root.getRightNode(), listPre);
        }

    }
// another solution for the maximum node in the tree if the function takes binaryNode as an argument.

//    public int maximumNumber(BinaryNode<T> root) {
//
//        if (root == null) {
//            return 0;
//        }
//        int result = (Integer) root.getData();
//        int left = maximumNumber(root.getLeftNode());
//        int right = maximumNumber(root.getRightNode());
//        if (left > result) {
//            result = left;
//        }
//        if (right > result) {
//            result = right;
//        }
//        return result;
//    }

    public int maxNumberInTree() {
        if (isEmpty()) return 0;
        int result = 0;
        ArrayList<T> traverse = preOder200();
        for (int i = 0; i < traverse.size(); i++) {
            if (Integer.parseInt(traverse.get(i) + "") > result) {
                result = Integer.parseInt(traverse.get(i) + "");
            }
        }
        return result;
    }
///////////////////////////BreadthFirst /////// LEVEL ORDER ////////////

    public ArrayList<T> levelOrder(BinarySearchTree<T> binaryNode) {

        if (root == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Queue<BinaryTreeNode<T>> treeQueue = new LinkedList<>(); // because queue is an interface.
//        BinaryTreeNode<T> newNode = root;
        treeQueue.add(root);
        while (!treeQueue.isEmpty()) {
            //dequeue
            BinaryTreeNode<T> node = treeQueue.remove();
            list.add(node.getData());
            if (node.getLeftNode() != null) {
                treeQueue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                treeQueue.add(node.getRightNode());
            }
        }
        return list;
    }

    ///////////////////////////////SUM OF ROOTS/////////////////////
    public int PreorderTraversal() {
        if (isEmpty()) {
            return 0;
        }

        sumRoots(root);
        return sum;
    }

    private void sumRoots(BinaryTreeNode<T> root) {
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return;
        }
        sum = sum + (Integer) root.getData();
        System.out.print(root.getData() + " -> ");
        if (root.getLeftNode() != null) {
            sumRoots(root.getLeftNode());
        }

        if (root.getRightNode() != null) {
            sumRoots(root.getRightNode());
        }
    }
///////////////////////////////////////SYMMETRIC/////////////////////////////

    public boolean isSymmetric(BinaryTreeNode<T> root) {

        return isMirror(root, root);
    }

    public boolean isMirror(BinaryTreeNode<T> p, BinaryTreeNode<T> q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return (p.getData() == q.getData())
                && isMirror(p.getRightNode(), q.getLeftNode())
                && isMirror(p.getLeftNode(), q.getRightNode());
    }
////////////////////////////////////////////////////////////

    public BinaryTreeNode<Integer> mergeTrees(BinaryTreeNode<Integer> t1, BinaryTreeNode<Integer> t2) {

        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.data += t2.data;
        t1.leftNode = mergeTrees(t1.getLeftNode(), t2.getLeftNode());
        t1.rightNode = mergeTrees(t1.getRightNode(), t2.getRightNode());

        return t1;
    }

    /////////////////////////////////////////////////////////
// 8- inverting Tree
    public BinaryTreeNode<T> invertTree(BinaryTreeNode<T> root) {
        if (root == null) {
            return root;
        }
        invertTree(root.getLeftNode());
        invertTree(root.getRightNode());

        BinaryTreeNode<T> t = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(t);

        return root;
    }


    ////////////////////////////////////////////////////////////////////////////

    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root + '}';
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }

    @Override
    public int compareTo(BinarySearchTree<T> o) {
        return Integer.compare(root.getData().compareTo(o.getRoot().getData()), 0);
    }
}
