import static org.junit.Assert.*;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinarySearchTreeTest {
    @Test
    public void TestBSTInit() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        assertTrue(t.isEmpty());
    }

    @Test
    public void TestMakeEmpty() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        for(int i = 0; i < 5; i++) {
            t.insert(i);
        }
        assertFalse(t.isEmpty());
        t.makeEmpty();
        assertTrue(t.isEmpty());
    }

    @Test
    public void TestContains() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        for(int i = 0; i < 5; i++) {
            t.insert(i);
        }
        for(int i = 0; i < 5; i++) {
            assertTrue(t.contains(i));
        }
    }

    @Test
    public void TestFindMinMax() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        int[] nums = {10, 5, 6, 45, 5, 6, 400, 8, 6, 3, 2};
        for (int num : nums) {
            t.insert(num);
        }
        assertEquals(2, (int)t.findMin());
        assertEquals(400, (int)t.findMax());
    }

    @Test
    public void TestRemove() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        int[] nums = {10, 5, 6, 45, 400, 8, 3, 2};
        for (int num : nums) {
            t.insert(num);
        }
        for (int num: nums) {
            System.out.println("Before removing data " + num);
            t.printTree();
            assertTrue(t.contains(num));
            t.remove(num);
            System.out.println("After removing data " + num);
            t.printTree();
            assertFalse(t.contains(num));
        }
    }

    @Test
    public void TestTreeTraverse() {
        BinarySearchTree<Integer> t = new BinarySearchTree<>();
        int[] nums = {8, 5, 45, 3, 2, 6, 400};
        for (int num : nums) {
            t.insert(num);
        }
        t.printTree();
        // redirect the standard output to a string
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(bOut);
        System.setOut(ps);
        // test the preorder traverse
        t.preOrderTraverse();
        System.out.flush();
        assertEquals("8 5 3 2 6 45 400 ", bOut.toString());
        bOut.reset();
        // test the inorder traverse
        t.inOrderTraverse();
        System.out.flush();
        assertEquals("2 3 5 6 8 45 400 ", bOut.toString());
        bOut.reset();
        // test the postorder traverse
        t.postOrderTraverse();
        System.out.flush();
        assertEquals("2 3 6 5 400 45 8 ", bOut.toString());
    }
}
