package trees;

public class NotRecursiveTree extends Tree {

    @Override
    public void add(int value) {
        if (getRoot() == null) {
            setRoot(new Node(value));
        }
        addInternal(getRoot(), value);

    }

    void addInternal(Node root, int value) {
        while (true) {
            if (value < root.getValue()) {
                if (root.getLeft() != null) {
                    root = root.getLeft();
                } else {
                    root.setLeft(new Node(value));
                    return;
                }
            } else if (value > root.getValue()) {
                if (root.getRight() != null) {
                    root = root.getRight();
                } else {
                    root.setRight(new Node(value));
                    return;
                }
            } else {
                return;
            }
        }
    }
}

