package trees.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import trees.NotRecursiveTree;
import trees.RecursiveTree;
import trees.Tree;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public abstract class EqualsTests {
    @Test
    void equalsNull() {
        // Arrange.
        Tree tree1 = createTree();

        // Act!
        var result = tree1.equals(null);

        // Assert.
        assertFalse(result);
    }

    private static int[][] positiveData() {
        return new int[][]{
                {},
                {3},
                {3, 1},
                {3, 1, 0},
                {3, 1, 0, 2, 5, 4}
        };
    }

    @MethodSource("positiveData")
    @ParameterizedTest
    void equalsPositiveTest(int[] elements) {
        // Arrange.
        Tree tree1 = createTree();
        Tree tree2 = createTree();
        for (var e : elements) {
            tree1.add(e);
            tree2.add(e);
        }

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertTrue(result);
    }

    static Arguments[] negativeData() {
        return new Arguments[]{
                arguments(new int[]{1, 2}, new int[]{3, 4}),
                arguments(new int[]{1, 2}, new int[]{1, 4}),
                arguments(new int[]{}, new int[]{3, 4}),
                arguments(new int[]{3, 2, 1}, new int[]{1, 2, 3}),
                arguments(new int[]{5, 6}, new int[]{6})
        };
    }

    @MethodSource("negativeData")
    @ParameterizedTest
    void equalsNegativeTest(int[] elementsTree1, int[] elementsTree2) {
        // Arrange.
        Tree tree1 = createTree();
        Tree tree2 = createTree();
        for (var e : elementsTree1) {
            tree1.add(e);
        }
        for (var e : elementsTree2) {
            tree2.add(e);
        }

        // Act!
        var result = tree1.equals(tree2);

        // Assert.
        assertFalse(result);
    }

    abstract Tree createTree();
}

@DisplayName("Рекурсивное сравнение деревьев")
class EqualsRecursiveTests extends EqualsTests{

    @Override
    Tree createTree() {
        return new RecursiveTree();
    }

}

@Disabled
@DisplayName("Нерекурсивное сравнение деревьев")
class EqualsNotRecursiveTests extends EqualsTests{

    @Override
    Tree createTree() {
        return new NotRecursiveTree();
    }
}