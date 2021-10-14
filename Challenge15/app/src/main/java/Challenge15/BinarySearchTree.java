package Challenge15;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> root;
    List<Integer> postOrderList = new ArrayList<>();
    List<Integer> preOrderList = new ArrayList<>(); // FOR TEST

    public void insert(T data) {
        if (isEmpty()) { // tree empty
            root = new BinaryNode<>(data);
        } else {
            insertHelper(data, root);
        }
    }

    public void inorderTraversal() {
        if (isEmpty()) {
            return;
        }

        traverseInorder(root);
    }

    private void traverseInorder(BinaryNode<T> root) {
        if (root.getLeftNode() != null) { // traverse left
            traverseInorder(root.getLeftNode());
        }

        // visit / print the root of the tree (root could be a sub-tree)
        System.out.print(root.getData() + " -> ");

        if (root.getRightNode() != null) { // traverse right
            traverseInorder(root.getRightNode());
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
        } else if(data.compareTo(root.getData()) > 0) {
            if (root.getRightNode() == null) {
                root.setRightNode(binaryNode);
            } else {
                insertHelper(data, root.getRightNode());
            }
        }
    }


    public boolean contains(T data){
        while (root != null) {
            if(data.compareTo(root.getData()) > 0)
                root = root.getRightNode();
            else if (data.compareTo(root.getData()) < 0)
                root = root.getLeftNode();
            else
                return true;
        }
        return false;
    }

    public void orderPost() {
        if (isEmpty()) {
            return;
        }

        postOrder(root);
    }


    public void postOrder( BinaryNode<T>  root){

        if(root == null){
            return;
        }
        postOrder(root.getLeftNode());
        postOrder(root.getRightNode());
        System.out.print(root.getData() + " ");
        postOrderList.add((Integer) root.getData());
    }

    public void preOder() {
        if (isEmpty()) {
            return;
        }

        preOrder(root);
    }
    public void preOrder(BinaryNode<T>  root){

        if(root == null){
            return;
        }

        System.out.print(root.getData() + " ");
        preOrderList.add((Integer) root.getData());

        preOrder(root.getLeftNode());

        preOrder(root.getRightNode());
    }
    public boolean isEmpty() {
        return root == null;
    }
}
