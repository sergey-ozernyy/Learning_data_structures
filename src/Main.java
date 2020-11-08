
import trees.Node;
import trees.RecursiveTree;
import trees.Tree;

public class Main {

    public static void main(String[] args) {


        var root = new Node(3,
                new Node(1,
                        new Node(0),
                        new Node(2)),
                new Node(5,
                        new Node(4),
                        null));

        var root2 = new Node(3);
        Node.add(root2, 1);
        Node.add(root2, 0);
        Node.add(root2, 2);
        Node.add(root2, 5);
        Node.add(root2, 4);

        Tree tree1 = new RecursiveTree();
        tree1.add(3);
        tree1.add(1);
        tree1.add(0);
        tree1.add(2);
        tree1.add(5);
        tree1.add(4);
        System.out.println("Tree1:");
        Node.printSorted(tree1.getRoot());
        var tree2 = tree1.copyDeep();
        System.out.println("Tree2:");
        Node.printSorted(tree2.getRoot());



    }

}
