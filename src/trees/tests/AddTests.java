package trees.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trees.Node;
import trees.NotRecursiveTree;
import trees.RecursiveTree;
import trees.Tree;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AddTests{
    @Test
    void addRoot(){
        // Arrange.
        Tree tree = createTree();

        // Act!
        tree.add(0);

        // Assert.
        assertEquals(0, tree.getRoot().getValue());
    }

    @Test
    void copyDeepRoot(){
        //Arrange
        Tree original = createTree();
        original.add(3);

        
        //Act
        var cloned = original.copyDeep();
        
        //Assert
        assertNotNull(cloned);
        assertNotEquals(original.getRoot(), cloned.getRoot());
        assertEquals(original.getRoot().getValue(), cloned.getRoot().getValue());
    }

    @Test
    void copyDeepRootAndLeftRight(){
        //Arrange
        Tree tree1 = createTree();
        tree1.add(3);
        tree1.add(1);
        tree1.add(2);

        //Act
        var tree2 = tree1.copyDeep();

        //Assert
        assertEquals(tree1.getRoot().getLeft().getRight().getValue(), tree2.getRoot().getLeft().getRight().getValue());
    }



    protected abstract Tree createTree();

    @Test
    void addOneLeftAtRoot() {
        // Arrange.
        var tree = createTree();
        tree.add(2);

        // Act!
        tree.add(1);


        // Assert.
        assertNotNull(tree.getRoot().getLeft());
        assertEquals(1, tree.getRoot().getLeft().getValue());

        assertNull(tree.getRoot().getRight());
        assertNull(tree.getRoot().getLeft().getLeft());
        assertNull(tree.getRoot().getLeft().getRight());
    }

    @Test
    void addOneRightAtRoot() {
        // Arrange.
        var tree = createTree();
        tree.add(3);

        // Act!
        tree.add(5);

        // Assert.
        assertNotNull(tree.getRoot().getRight());
        assertEquals(5, tree.getRoot().getRight().getValue());

        assertNull(tree.getRoot().getLeft());
        assertNull(tree.getRoot().getRight().getLeft());
        assertNull(tree.getRoot().getRight().getRight());
    }

    @Test
    void addOneLeftAtLeft() {
        // Arrange.
        var tree = createTree();
        tree.add(3);
        tree.add(1);

        // Act!
        tree.add(0);

        // Assert.
        assertNotNull(tree.getRoot().getLeft().getLeft());
        assertEquals(0, tree.getRoot().getLeft().getLeft().getValue());
    }

    @Test
    void addOneRightAtLeftLeft() {
        // Arrange.
        var tree = createTree();
        tree.add(4);
        tree.add(2);
        tree.add(0);

        // Act!
        tree.add(1);

        // Assert.
        Node actual = tree.getRoot().getLeft().getLeft().getRight();
        assertNotNull(actual);
        assertEquals(1, actual.getValue());
    }

    @Test
    void addDuplicate() {
        // Arrange
        var tree = createTree();
        tree.add(3);
        tree.add(2);
        tree.add(4);

        // Act
        tree.add(3);

        // Assert
        assertNull(tree.getRoot().getRight().getLeft());
    }


}

@DisplayName("Рекурсивное добавление элемента")
class AddRecursiveTests extends AddTests{
    @Override
    protected Tree createTree() {
        return new RecursiveTree();
    }
}

@Disabled
@DisplayName("Нерекурсивное добавление элемента")
class AddNotRecursiveTests extends AddTests{
    @Override
    protected Tree createTree() {
        return new NotRecursiveTree();
    }
}
