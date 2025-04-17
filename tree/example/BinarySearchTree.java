import java.util.NoSuchElementException;

/**
 * Example implementation of binary search tree on the textbook <Data structure and algorithms analysis in Java>
 */

public class BinarySearchTree<T extends Comparable<? super T>> {
    private static class BinaryNode<T> {
        BinaryNode<T> left, right;
        T data;

        /**
         * constructor with data field
         *
         * @param data the data field value
         */
        BinaryNode(T data) {
            this(data, null, null);
        }

        /**
         * Contructor with data field, left field, right field
         *
         * @param data the data field value
         * @param left the left field value
         * @param right the right field value
         */
        BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    // root of the binary search tree
    private BinaryNode<T> root;

    /**
     * Constructor for the binary search tree
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Make the binary search tree empty
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * Check if the tree is empty
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Check if the data is in the BST
     *
     * @param data the data to search
     * @return if the data is in the BST, return true, otherwise return false
     */
    public boolean contains(T data) {
        return contains(data, root);
    }

    /**
     * A helper method for contains
     *
     * @param data the data to search
     * @param t the current root of the binary search tree
     * @return if the data is in the tree, return true, otherwise return false
     */
    private boolean contains(T data, BinaryNode<T> t) {

    }

    /**
     * Find the minimum value in the binary search tree
     *
     * @return the minimum value in the BST
     */
    public T findMin() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return findMin(root).data;
    }

    /**
     * A helper method for findMin
     *
     * @param t the current root of the binary search tree
     * @return the minimum value in the BST
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {

    }

    /**
     * Insert the data into the binary search tree
     *
     * @param data the data to be inserted
     */
    public void insert(T data) {
        root = insert(data, root);
    }

    /**
     * A helper method for insert
     *
     * @param data the data to be inserted
     * @param t the current root of the binary search tree
     * @return root of the new binary search tree after data inserted
     */
    private BinaryNode<T> insert(T data, BinaryNode<T> t) {

    }

    /**
     * Remove the data from the BST
     *
     * @param data the data to be removed
     */
    public void remove(T data) {
        root = remove(data, root);
    }

    /**
     * A helper method for remove
     *
     * @param data the data to be removed from the binary search tree
     * @param t the current root of the BST
     * @return the root of the tree which data is removed from it
     */
    private BinaryNode<T> remove(T data, BinaryNode<T> t) {

    }

    /**
     * Print the current tree
     */
    public void printTree() {

    }

    /**
     * A helper method that print the current tree, whose root is BinaryNode t
     *
     * @param t the current root of the tree
     */
    private void printTree(BinaryNode<T> t) {

    }
}
