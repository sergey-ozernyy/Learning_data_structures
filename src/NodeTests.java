import org.junit.jupiter.api.Test;
import trees.Node;

import static org.junit.jupiter.api.Assertions.*;


class NodeTests {

    @Test
    void addOneLeftAtRoot() {
        // Arrange.
        var root = new Node(3);

        // Act!
        Node.add(root, 1);

        // Assert.
        assertNotNull(root.left);
        assertEquals(1, root.left.value);

        assertNull(root.right);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void addOneRightAtRoot() {
        // Arrange.
        var root = new Node(3);

        // Act!
        Node.add(root, 5);

        // Assert.
        assertNotNull(root.right);
        assertEquals(5, root.right.value);

        assertNull(root.left);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void addOneLeftAtLeft() {
        // Arrange.
        var root = new Node(3);
        Node.add(root, 1);

        // Act!
        Node.add(root, 0);

        // Assert.
        assertNotNull(root.left.left);
        assertEquals(0, root.left.left.value);
    }

    @Test
    void addOneRightAtLeftLeft() {
        // Arrange.
        var root = new Node(4);
        Node.add(root, 2);
        Node.add(root, 0);

        // Act!
        Node.add(root, 1);

        // Assert.
        assertNotNull(root.left.left.right);
        assertEquals(1, root.left.left.right.value);
    }

    @Test
    void addDuplicate() {
        // Arrange
        var root = new Node(3);
        Node.add(root, 2);
        Node.add(root, 4);

        // Act
        Node.add(root, 3);

        // Assert
        assertNull(root.right.left);
    }

    //AddALT
    @Test
    void addAltOneLeftAtRoot() {
        // Arrange.
        var root = new Node(3);

        // Act!
        Node.addAlt(root, 1);

        // Assert.
        assertNotNull(root.left);
        assertEquals(1, root.left.value);

        assertNull(root.right);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void addAltOneRightAtRoot() {
        // Arrange.
        var root = new Node(3);

        // Act!
        Node.addAlt(root, 5);

        // Assert.
        assertNotNull(root.right);
        assertEquals(5, root.right.value);

        assertNull(root.left);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void addAltOneLeftAtLeft() {
        // Arrange.
        var root = new Node(3);
        Node.addAlt(root, 1);

        // Act!
        Node.addAlt(root, 0);

        // Assert.
        assertNotNull(root.left.left);
        assertEquals(0, root.left.left.value);
    }

    @Test
    void addAltOneRightAtLeftLeft() {
        // Arrange.
        var root = new Node(4);
        Node.addAlt(root, 2);
        Node.addAlt(root, 0);

        // Act!
        Node.addAlt(root, 1);

        // Assert.
        assertNotNull(root.left.left.right);
        assertEquals(1, root.left.left.right.value);
    }

    @Test
    void addAltDuplicate() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);

        // Act
        Node.addAlt(root, 3);

        // Assert
        assertNull(root.right.left);
    }

    @Test
    void addAltUnic() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);

        // Act
        Node.addAlt(root, 5);

        // Assert
        assertEquals(5, root.right.right.value);

    }

    //Add without recursion
    @Test
    void addWithoutRecOneLeftAtRoot() {
        // Arrange.
        var root = new Node(3);

        // Act!
        Node.addWithoutRec(root, 1);

        // Assert.
        assertNotNull(root.left);
        assertEquals(1, root.left.value);

        assertNull(root.right);
        assertNull(root.left.left);
        assertNull(root.left.right);
    }

    @Test
    void addWithoutRecOneRightAtRoot() {
        // Arrange.
        var root = new Node(3);

        // Act!
        Node.addWithoutRec(root, 5);

        // Assert.
        assertNotNull(root.right);
        assertEquals(5, root.right.value);

        assertNull(root.left);
        assertNull(root.right.left);
        assertNull(root.right.right);
    }

    @Test
    void addWithoutRecOneLeftAtLeft() {
        // Arrange.
        var root = new Node(3);
        Node.addAlt(root, 1);

        // Act!
        Node.addWithoutRec(root, 0);

        // Assert.
        assertNotNull(root.left.left);
        assertEquals(0, root.left.left.value);
    }

    @Test
    void addWithoutRecOneRightAtLeftLeft() {
        // Arrange.
        var root = new Node(4);
        Node.addAlt(root, 2);
        Node.addAlt(root, 0);

        // Act!
        Node.addWithoutRec(root, 1);

        // Assert.
        assertNotNull(root.left.left.right);
        assertEquals(1, root.left.left.right.value);
    }

    @Test
    void addWithoutRecDuplicate() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);

        // Act
        Node.addWithoutRec(root, 3);

        // Assert
        assertNull(root.right.left);
    }

    @Test
    void addWithoutRecUnique() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);

        // Act
        Node.addWithoutRec(root, 5);

        // Assert
        assertEquals(5, root.right.right.value);
    }

    @Test
    void findElement() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);
        Node.addAlt(root, 5);
        var targetValue = 5;

        // Act

        var result = Node.find(root, targetValue);

        //Assert
        assertEquals(targetValue, result.value);
    }

    @Test
    void findNonExElement() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);
        var targetValue = 5;

        // Act

        var result = Node.find(root, targetValue);

        //Assert
        assertNull(result);
    }

    @Test
    void findElementWithOutRec() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);
        var targetValue = 4;

        // Act

        var result = Node.findWithOutRec(root, targetValue);

        //Assert
        assertEquals(targetValue, result.value);
    }

    @Test
    void findNonExElementWithOutRec() {
        // Arrange
        var root = new Node(3);
        Node.addAlt(root, 2);
        Node.addAlt(root, 4);
        var targetValue = 5;

        // Act

        var result = Node.findWithOutRec(root, targetValue);

        //Assert
        assertNull(result);
    }


}
