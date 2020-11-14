package trees;

import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class Tree {
    private Node root;

    public static Tree create(Node node) {
        var tree = new RecursiveTree();
        tree.setRoot(node);
        return tree;
    }

    public Node getRoot() {
        return root;
    }

    protected void setRoot(Node root){
        this.root = root;
    }

    public abstract void add(int value);

    public abstract Tree copyDeep();

    public abstract Boolean equals(Tree target);

    public abstract void delete(int value);
}


