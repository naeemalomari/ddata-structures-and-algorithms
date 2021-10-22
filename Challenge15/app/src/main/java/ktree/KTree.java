package ktree;


import java.util.LinkedList;
import java.util.Queue;

public class KTree <T>{

    TreeNode root = null;
    int nodes = 0;
    int K=0;


    public KTree(int k) {
        if(k<=1) {
            k = 2;
        }
        this.K = k;
    }

    public boolean isEmpty() {

        return root == null;
    }

    public boolean isNotEmpty(){
        return root != null;
    }

    public void add(T value){
        nodes++;
        TreeNode newNode = new TreeNode(value);
        if( isEmpty()){
            root = newNode;
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode currentNode = queue.poll();
            if(currentNode.children.size() < this.K){
                currentNode.addChild(newNode);
                return;
            }
            else {
                queue.addAll(currentNode.children);
            }
        }
    }


    public  KTree<String> fizzBuzzTree(KTree<Integer> kTree){
        KTree<String> outTree = new KTree(kTree.K);

        Queue<TreeNode> queue = new LinkedList<>();
        if(kTree.isNotEmpty()){
            queue.add(kTree.root);
            while(!queue.isEmpty()){

                TreeNode<Integer> currentNode = queue.poll();

                String currentValue;
                if(currentNode.value % 15 == 0 )
                    currentValue = "FizzBuzz";
                else if(currentNode.value % 3 == 0)
                    currentValue="Fizz";
                else if(currentNode.value % 5 == 0)
                    currentValue="Buzz";
                else
                    currentValue=currentNode.value.toString();

                outTree.add(currentValue);

                if(! currentNode.children.isEmpty())
                    queue.addAll(currentNode.children);
            }
        }
        return outTree;
    }
    @Override
    public String toString() {
        return "K-ary tree (K="+this.K+"): {" +
                "\n root=" + root +
                "\nnodes=" + nodes +
                '}';
    }

}
