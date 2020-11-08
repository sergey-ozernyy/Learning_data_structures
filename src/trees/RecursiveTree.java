package trees;

public class RecursiveTree extends Tree{

    @Override
    public void add(int value) {
        setRoot(addInternal(getRoot(), value));
    }

    Node addInternal(Node root, int value){
        if(root == null) {
            return new Node(value);
        }
        if(value < root.getValue()){
            root.setLeft(addInternal(root.getLeft(), value));
        }
        else if( value > root.getValue()){
            root.setRight(addInternal(root.getRight(), value));
        }
        return root;
    }
}
