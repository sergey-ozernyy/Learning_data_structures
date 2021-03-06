package trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

public abstract class Tree {

    private Node root;

    public abstract void add(int value);

    public Node getRoot() {
        return root;
    }
    protected void setRoot(Node root){
        this.root = root;
    }

    public abstract Tree copyDeep();
}


