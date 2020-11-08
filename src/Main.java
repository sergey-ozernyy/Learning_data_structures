import trees.Node;

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
        Node.printSorted(root);
        Node.find(root, 4);


    }

}
