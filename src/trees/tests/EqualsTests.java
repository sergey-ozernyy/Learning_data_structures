package trees.tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import trees.RecursiveTree;
import trees.Tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EqualsTests {
    @Test
    void equalsNull(){
        // Arrange.
        Tree tree1 = createTree();

        // Act!
        var result = tree1.equals(null);

        // Assert.
        assertFalse(result);
    }

    @Test
    void equalsEmptyTree(){
        // Arrange.
        Tree tree1 = createTree();
        Tree tree2 = createTree();

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertTrue(result);
    }

    @Test
    void equalsTreeWithRoot(){
        // Arrange.
        Tree tree1 = createTree();
        tree1.add(3);
        Tree tree2 = createTree();
        tree2.add(3);

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertTrue(result);
    }

    @Test
    void equalsTreeWithRootLeftRight(){
        // Arrange.
        Tree tree1 = createTree();
        tree1.add(3);
        tree1.add(1);
        tree1.add(2);

        Tree tree2 = createTree();
        tree2.add(3);
        tree2.add(1);
        tree2.add(2);

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertTrue(result);
    }

    @Test
    void equalsTree(){
        // Arrange.
        Tree tree1 = createTree();
        tree1.add(3);
        tree1.add(1);
        tree1.add(2);
        tree1.add(0);
        tree1.add(5);
        tree1.add(4);

        Tree tree2 = createTree();
        tree2.add(3);
        tree2.add(1);
        tree2.add(2);
        tree2.add(0);
        tree2.add(5);
        tree2.add(4);

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertTrue(result);
    }

    private static int[][] positiveData() {
        return new int[][]{
                {},
                {3},
                {3,1},
                {3,1,0},
                {3,1,0,2,5,4}
        };
    }

    @MethodSource ("positiveData")
    @ParameterizedTest
    void equalsPositiveTest(int[] elements){
        // Arrange.
        Tree tree1 = createTree();
        Tree tree2 = createTree();
        for (var e:elements) {
            tree1.add(e);
            tree2.add(e);
        }

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertTrue(result);
    }

    private Tree createTree() {
        return new RecursiveTree();
    }
}
