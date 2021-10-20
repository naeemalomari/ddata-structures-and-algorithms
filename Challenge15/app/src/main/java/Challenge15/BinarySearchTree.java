package Challenge15;


import com.sun.source.tree.BinaryTree;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements Comparable<BinarySearchTree<T>> {

    BinaryNode<T> root;
    int sum = 0;

    /////////////////////////////////INORDER\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void inorderTraversal() {
        if (isEmpty()) {
            return;
        }

        traverseInorder(root);
    }

    private void traverseInorder(BinaryNode<T> root) {
        if (root.getLeftNode() != null) {
            traverseInorder(root.getLeftNode());
        }

        System.out.print(root.getData() + " -> ");

        if (root.getRightNode() != null) {
            traverseInorder(root.getRightNode());
        }

    }

    /////////////////////////////////////////////////////////////////INSERT///////////////////////////////////////
    public void insert(T data) {
        if (isEmpty()) { // tree empty
            root = new BinaryNode<>(data);
        } else {
            insertHelper(data, root);
        }
    }

    private void insertHelper(T data, BinaryNode<T> root) {
        BinaryNode<T> binaryNode = new BinaryNode<>(data);
        if (data.compareTo(root.getData()) < 0) {
            if (root.getLeftNode() == null) {
                root.setLeftNode(binaryNode);
            } else {
                insertHelper(data, root.getLeftNode());
            }
        } else if (data.compareTo(root.getData()) > 0) {
            if (root.getRightNode() == null) {
                root.setRightNode(binaryNode);
            } else {
                insertHelper(data, root.getRightNode());
            }
        }
    }
///////////////////////////////////////////////CONTAINS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public boolean contains(T data) {
        BinaryNode<T> binaryNode1 = root;

        while (binaryNode1 != null) {
            if (data.compareTo(binaryNode1.getData()) > 0)
                binaryNode1 = binaryNode1.getRightNode();
            else if (data.compareTo(binaryNode1.getData()) < 0)
                binaryNode1 = binaryNode1.getLeftNode();
            else
                return true;
        }
        return false;
    }

    ////////////////////////////////////////////////////postOrder\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public ArrayList<T> orderPost() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<T> listPost = new ArrayList<>();
        postOrder(root, listPost);
        return listPost;
    }

    public void postOrder(BinaryNode<T> root, ArrayList<T> listPost) {

        if (root == null) {
            return;
        }
        postOrder(root.getLeftNode(), listPost);
        postOrder(root.getRightNode(), listPost);
        System.out.print(root.getData() + " -> ");
    }

    public int file(BinaryNode<T> t1) {

//        if (root == null)
//            return 0;

        if (t1.getLeftNode() == null &&
                t1.getRightNode() == null) {
            sum = sum + 1;
        }
        if (t1.getLeftNode() != null)
            file(t1.getLeftNode());
        if (t1.getRightNode() != null)
            file(t1.getRightNode());
//        int sum2 = sum;

        return sum;
    }

    public boolean con(BinarySearchTree<T> t1, BinarySearchTree<T> t2) {

        int a = file(t1.getRoot()) ;
        System.out.println(a);
        sum=0;
        int a2 = file(t2.getRoot()) ;
        System.out.println(a2);
        sum=0;

//        return file(t1.getRoot()) == file(t2.getRoot());
        return a==a2;
    }

    //////////////////////////////////////////////////////////////PRE--ORDER\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public ArrayList<T> preOder200() {
        if (isEmpty()) {
            return null;
        }
        ArrayList<T> listPre = new ArrayList<>();

        preOrder(root, listPre);
        return listPre;
    }

    public void preOrder(BinaryNode<T> root, ArrayList<T> listPre) {
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

    public ArrayList<T> levelOrder(BinarySearchTree<T> binaryNode) {

        if (root == null) {
            return null;
        }
        ArrayList<T> list = new ArrayList<>();
        Queue<BinaryNode<T>> teeQueue = new LinkedList<>();
        BinaryNode<T> newNode = root;
        teeQueue.add(root);
        while (!teeQueue.isEmpty()) {
            //dequeue
            BinaryNode<T> node = teeQueue.remove();
            list.add(node.getData());
            if (node.getLeftNode() != null) {
                teeQueue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                teeQueue.add(node.getRightNode());

            }
        }
        return list;
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

    public BinaryNode<T> getRoot() {
        return root;
    }

    @Override
    public int compareTo(BinarySearchTree<T> o) {
        return Integer.compare(root.getData().compareTo(o.getRoot().getData()), 0);
    }
}
