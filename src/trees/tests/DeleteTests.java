package trees.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trees.Node;
import trees.NotRecursiveTree;
import trees.RecursiveTree;
import trees.Tree;

import static org.junit.jupiter.api.Assertions.*;

public abstract class DeleteTests {
    abstract Tree createTree();

    @Test
    void DeleteRootNull() {
        // Arrange.
        var original = createTree();
        var cloned = original.copyDeep();

        // Act!
        original.delete(3);

        // Assert.
        assertEquals(original, cloned);
    }

    @Test
    void DeleteRoot() {
        // Arrange.
        var original = createTree();
        original.add(3);

        // Act!
        original.delete(3);

        // Assert.
        assertNull(original.getRoot());
    }

    @Test
    void DeleteRootNotExisted() {
        // Arrange.
        var original = createTree();
        original.add(3);
        var cloned = original.copyDeep();

        // Act!
        original.delete(4);

        // Assert.
        assertEquals(original, cloned);
    }

    @Test
    void DeleteRootDeepLeft() {
        // Arrange.
        var original = createTree();
        original.add(3);
        original.add(1);
        original.add(0);

        // Act!
        original.delete(1);

        // Assert.
        assertTrue(original.equals(Tree.create(new Node(3,
                new Node(0),
                null))));

    }

    @Test
    void DeleteRootDeepRight() {
        // Arrange.
        var original = createTree();
        original.add(3);
        original.add(1);
        original.add(2);

        // Act!
        original.delete(1);

        // Assert.
        assertTrue(original.equals(Tree.create(new Node(3,
                new Node(2),
                null))));

    }

    @Test
    void DeleteRootDeep() {
        // Arrange.
        var original = createTree();
        original.add(20);
        original.add(4);
        original.add(10);
        original.add(8);
        original.add(15);
        original.add(3);
        original.add(1);
        original.add(2);
        original.add(0);

//        Tree.create(new Node(20,
//                new Node(4,
//                        new Node(3,
//                                new Node(1,
//                                        new Node(0),
//                                        new Node(2)),
//                                null),
//                        new Node(10,
//                                new Node(8),
//                                new Node(15))),
//                null))));

        // Act!
        original.delete(4);

        // Assert.
        assertTrue(original.equals(Tree.create(new Node
                (
                        20,
                        new Node
                                (
                                        10,
                                        new Node
                                                (
                                                        8,
                                                        new Node
                                                                (
                                                                        3,
                                                                        new Node
                                                                                (
                                                                                        1,
                                                                                        new Node(0),
                                                                                        new Node(2)
                                                                                ),
                                                                        null
                                                                ),
                                                        null
                                                ),
                                        new Node(15)
                                ),
                        null))));
    }

    @Test
    void DeleteRootMean() {
        // Arrange.
        var original = createTree();
        original.add(3);
        original.add(1);
        original.add(0);
        original.add(2);
        original.add(5);
        original.add(4);

        var cloned = original.copyDeep();

        // Act!
        original.delete(5);
        original.add(5);


        // Assert.
        assertNotEquals(original, cloned);

    }
}

@DisplayName("Рекурсивное удаление элементов")
class DeleteRecursiveTests extends DeleteTests {

    @Override
    Tree createTree() {
        return new RecursiveTree();
    }

}

@Disabled
@DisplayName("Рекурсивное удаление элементов")
class DeleteNotRecursiveTests extends DeleteTests {

    @Override
    Tree createTree() {
        return new NotRecursiveTree();
    }

}