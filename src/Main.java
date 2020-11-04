class Node {

    public int value;
    public Node left;
    public Node right;

    public Node(int value, Node left, Node right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this.value = value;
    }

    public static void printSorted(Node root) {
        if (root == null) return;
        printSorted(root.right);
        System.out.println(root.value);
        printSorted(root.left);
    }

    public static void add(Node root, int i) {
        if (root.value == i) return;
        if (i < root.value) {
            if (root.left != null) {
                add(root.left, i);
            } else {
                root.left = new Node(i);
            }
        } else {
            if (root.right != null) {
                add(root.right, i);
            } else {
                root.right = new Node(i);
            }
        }
    }

    public static Node addAlt(Node root, int newValue){
        if (root == null) 
            return new Node(newValue);
        if(newValue < root.value)
            root.left = addAlt(root.left, newValue);
        else if(newValue > root.value) 
            root.right = addAlt(root.right, newValue);
        return root;
    }

    public static void addWithoutRec(Node root, int newValue) {
        if(root.value == newValue) return;
        while (root != null){
            if(newValue < root.value){
                if(root.left == null) {
                    root.left = new Node(newValue);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right == null) {
                    root.right = new Node(newValue);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

    }

    public static Node find(Node root, int targetValue) {
        if (targetValue < root.value) {
            if (root.left == null) return null;
            return find(root.left, targetValue);
        }
        if (targetValue > root.value){
            if (root.right == null) return null;
            return find(root.right, targetValue);
        }
        return root;
    }

    public static Node findWithOutRec(Node root, int targetValue) {
        while (root != null){
            if (targetValue == root.value) return root;
            if (targetValue < root.value) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}


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
