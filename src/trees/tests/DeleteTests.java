package trees.tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import trees.NotRecursiveTree;
import trees.RecursiveTree;
import trees.Tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public abstract class DeleteTests {
    abstract Tree createTree();

    @Test
    void DeleteRootNull(){
        // Arrange.
        var original = createTree();
        var cloned = original.copyDeep();

        // Act!
        var changed = original.delete(3);

        // Assert.
        assertEquals(changed, cloned);
    }

    @Test
    void DeleteRoot(){
        // Arrange.
        var original = createTree();
        original.add(3);
        var cloned = original.copyDeep();


        // Act!
        var changed = original.delete(3);

        // Assert.
        assertNotEquals(changed, cloned);
    }

    @Test
    void DeleteRootDeep(){
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
        var changed = original.delete(4);
        changed.add(4);


        // Assert.
        assertEquals(changed, cloned);

    }

    @Test
    void DeleteRootMean(){
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
        var changed = original.delete(5);
        changed.add(5);


        // Assert.
        assertNotEquals(changed, cloned);

    }
}

@DisplayName("Рекурсивное удаление элементов")
class DeleteRecursiveTests extends DeleteTests{

    @Override
    Tree createTree(){
    return new RecursiveTree();
    }

}

@Disabled
@DisplayName("Рекурсивное удаление элементов")
class DeleteNotRecursiveTests extends DeleteTests{

    @Override
    Tree createTree(){
        return new NotRecursiveTree();
    }

}