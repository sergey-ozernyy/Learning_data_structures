package trees.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trees.NotRecursiveTree;
import trees.RecursiveTree;
import trees.Tree;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class CopyTests {

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

    abstract Tree createTree();
}

@DisplayName("Рекурсивное копирование дерева")
class CopyRecursiveTests extends CopyTests{

    @Override
    Tree createTree() {
        return new RecursiveTree();
    }

}

@Disabled
@DisplayName("Нерекурсивное копирование дерева")
class CopyNotRecursiveTests extends CopyTests{

    @Override
    Tree createTree() {
        return new NotRecursiveTree();
    }
}
