package Challenge15;

public class BinaryTreeNode<T> {
    private T data;

    private BinaryTreeNode<T> leftNode;
    private BinaryTreeNode<T> rightNode;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode() {

    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode<T> leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode<T> getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode<T> rightNode) {
        this.rightNode = rightNode;
    }




    @Override
    public String toString() {
        return "BinaryNode{" +
                "data=" + data +
                ", left=" + leftNode +
                ", right=" + rightNode +
                '}';
    }
}
