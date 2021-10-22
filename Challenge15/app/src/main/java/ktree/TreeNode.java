package ktree;


import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {

    public T value;
    public List<TreeNode> children = new ArrayList<>();

    public TreeNode(T value) {
        this.value = value;
    }


    public void addChild(TreeNode child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{ value = ");
        result.append(value);
        result.append(" Children: [");
        for (TreeNode ch : children) {
            result.append("\n child: ");
            result.append(ch);
        }
        result.append("]");
//        result.append(" }");

        return result.toString();
    }
}