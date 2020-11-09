package trees;

public class RecursiveTree extends Tree {

    @Override
    public void add(int value) {
        setRoot(addInternal(getRoot(), value));
    }

    Node addInternal(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value < root.getValue()) {
            root.setLeft(addInternal(root.getLeft(), value));
        } else if (value > root.getValue()) {
            root.setRight(addInternal(root.getRight(), value));
        }
        return root;
    }

    @Override
    public Tree copyDeep() {
        Tree tree2 = new RecursiveTree();
        tree2.setRoot(copyDeepNode(getRoot()));
        return tree2;
    }

    protected Node copyDeepNode(Node root) {
        return root == null
                ? null
                : new Node(root.getValue(), copyDeepNode(root.getLeft()), copyDeepNode(root.getRight()));
    }

}
