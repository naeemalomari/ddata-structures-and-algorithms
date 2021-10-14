package Challenge15;


import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> root;
    List<Integer> postOrderList = new ArrayList<>();
    List<Integer> preOrderList = new ArrayList<>();


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
        } else if(data.compareTo(root.getData()) > 0) {
            if (root.getRightNode() == null) {
                root.setRightNode(binaryNode);
            } else {
                insertHelper(data, root.getRightNode());
            }
        }
    }
///////////////////////////////////////////////CONTAINS\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    public boolean contains(T data){
        BinaryNode<T> binaryNode1 = root;

        while (binaryNode1 != null) {
            if(data.compareTo(binaryNode1.getData()) > 0)
                binaryNode1 = binaryNode1.getRightNode();
            else if (data.compareTo(binaryNode1.getData()) < 0)
                binaryNode1 = binaryNode1.getLeftNode();
            else
                return true;
        }
        return false;
    }
////////////////////////////////////////////////////postOrder\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
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
        System.out.print(root.getData() + " -> ");
        postOrderList.add((Integer) root.getData());
    }
//////////////////////////////////////////////////////////////PRE--ORDER\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    public void preOder200() {
        if (isEmpty()) {
            return;
        }

        preOrder(root);
    }
    public void preOrder(BinaryNode<T>  root){

        if(root == null){
            return;
        }

        System.out.print(root.getData() + " -> ");
        preOrderList.add((Integer) root.getData());

        preOrder(root.getLeftNode());

        preOrder(root.getRightNode());
    }

    ////////////////////////////////////////////////////////////////////////////
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +'}';
    }

}
