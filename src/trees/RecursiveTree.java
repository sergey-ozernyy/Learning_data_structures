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
        Tree cloned = new RecursiveTree();
        cloned.setRoot(copyDeepNode(getRoot()));
        return cloned;
    }

    @Override
    public Boolean equals(Tree target) {
        if (target == null) {
            return false;
        }
        return equalsInternal(target.getRoot(), this.getRoot());
    }

    private Boolean equalsInternal(Node root1, Node root2) {
        return (root1 == null && root2 == null)
                ||
                (root1 != null && root2 != null
                        && root1.getValue() == root2.getValue()
                        && equalsInternal(root1.getLeft(), root2.getLeft())
                        && equalsInternal(root1.getRight(), root2.getRight()));
    }

    protected Node copyDeepNode(Node root) {
        return root == null
                ? null
                : new Node(root.getValue(), copyDeepNode(root.getLeft()), copyDeepNode(root.getRight()));
    }

}
