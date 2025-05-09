public class BinarySearchTree<T extends Comparable<T>> {
    private class Node {
        private T data;
        private Node leftChild;
        private Node rightChild;

        /**
         * Node initializer
         *
         * @param data the data field
         */
        Node(T data) {
            this(data, null, null);
        }

        /**
         * initializer with 3 parameters
         *
         * @param data the Node data field
         * @param leftChild the Node leftChild field
         * @param rightChild the Node rightChild field
         */
        Node(T data, Node leftChild, Node rightChild) {
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        /**
         * Get the data field of Node
         *
         * @return the data field
         */
        public T getData() {
            return data;
        }

        /**
         * Get the leftChild field of Node
         *
         * @return the left child field
         */
        public Node getLeftChild() {
            return leftChild;
        }

        /**
         * Get the rightChild field of Node
         *
         * @return the right child field
         */
        public Node getRightChild() {
            return rightChild;
        }

        /**
         * Set the left child of the node
         *
         * @param leftChild the left child
         */
        public void setLeftChild(Node leftChild) {
            this.leftChild = leftChild;
        }

        /**
         * Set the right child of the node
         *
         * @param rightChild the right child
         */
        public void setRightChild(Node rightChild) {
            this.rightChild = rightChild;
        }

        /**
         * Set the data of the node
         *
         * @param data the data field
         */
        public void setData(T data) {
            this.data = data;
        }
    }
    
    private Node root; // root of the binary search tree

    /**
     * the default initializer of the binary search tree
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * make the binary search tree empty
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * check if data is contained in the tree
     *
     * @param data the data to be searched
     * @return if the data is in the tree, return true, otherwise return false
     */
    public boolean contains(T data) {
        return contains(data, root);
    }

    /**
     * a helper method that judges if the data is in the binary search tree
     *
     * @param data the data to be searched from the binary search tree
     * @param n the current root of the binary search tree to be searched
     * @return if data is in the binary search tree with root n,
     * then return true, otherwise return false
     */
    private boolean contains(T data, Node n) {
        if (n == null) {
            return false;
        }
        int ret = data.compareTo(n.getData());
        if (ret == 0) {
            return true;
        } else if (ret < 0) {
            Node leftChild = n.getLeftChild();
            return contains(data, leftChild);
        } else {
            Node rightChild = n.getRightChild();
            return contains(data, rightChild);
        }
    }

    /**
     * find the minimum value in the tree
     *
     * @return the minimum value in the tree
     */
    public T findMin() {
        Node minNode = findMinNode(root);
        if (minNode == null) {
            return null;
        }
        return minNode.getData();
    }

    /**
     * A helper method that find the minimum value in the binary search tree
     *
     * @param currentRoot the root of the binary search tree
     * @return the Node containing the minimum value in the tree
     */
    private Node findMinNode(Node currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        Node left = currentRoot.getLeftChild();
        if (left == null) {
            return currentRoot;
        } else {
            return findMinNode(left);
        }
    }

    /**
     * find the maximum value in the binary search tree
     *
     * @return the maximum value in the tree
     */
    public T findMax() {
        Node maxNode = findMaxNode(root);
        if (maxNode == null) {
            return null;
        }
        return maxNode.getData();
    }

    /**
     * A helper method that find the maximum value in the binary search tree
     *
     * @param currentRoot the root of the binary search tree
     * @return the node containing the maximum value in the tree
     */
    private Node findMaxNode(Node currentRoot) {
        if (currentRoot == null) {
            return null;
        }
        while (currentRoot.getRightChild() != null) {
            currentRoot = currentRoot.getRightChild();
        }
        return currentRoot;
    }

    /**
     * insert the data into the binary search tree
     *
     * @param data the data to be inserted
     */
    public void insert(T data) {
        if (root == null) {
            this.root = new Node(data);
        }
        insert(data, root);
    }

    /**
     * A helper method that insert the data into the current binary search tree
     *
     * @param data the data to be inserted
     * @param currentRoot the root of the current binary search tree
     */
    private void insert(T data, Node currentRoot) {
        int ret = data.compareTo(currentRoot.data);
        if (ret == 0) {
            // the data is already in the tree, do nothing, just return
            return;
        }
        Node newNode = new Node(data);
        if (ret < 0) {
            // insert into the left subtree
            Node left = currentRoot.getLeftChild();
            if (left == null) {
                currentRoot.setLeftChild(newNode);
            } else {
                insert(data, left);
            }
        } else {
            // insert into the right subtree
            Node right = currentRoot.getRightChild();
            if (right == null) {
                currentRoot.setRightChild(newNode);
            } else {
                insert(data, right);
            }
        }
    }

    /**
     * remove the data from the binary search tree
     *
     * @param data the data to be removed
     */
    public void remove(T data) {
        this.root = remove(data, root);
    }

    /**
     * Remove the node containing data from the current binary search tree
     *
     * @param data the data to be removed
     * @param currentRoot the root of the current binary search tree
     * @return the binary search tree after the node removed
     */
    private Node remove(T data, Node currentRoot) {
        if (currentRoot == null) {
            // if the BST is empty, do nothing
            return null;
        }
        int ret = data.compareTo(currentRoot.getData());
        if (ret == 0) {
            // judge if it's leaf
            Node left = currentRoot.getLeftChild();
            Node right = currentRoot.getRightChild();
            if ((left == null) && (right == null)) {
                return null;
            } else if (left != null) {
                // get the rightmost node of the left subtree
                Node rightmost = left;
                Node parent = currentRoot;
                if(rightmost.getRightChild() == null) {
                    // replace the node data with that node data
                    currentRoot.setData(rightmost.getData());
                    // there's no right child for the rightmost node,
                    // so replace the parent's left child with rightmost node's left child
                    parent.setLeftChild(rightmost.getLeftChild());
                } else {
                    while (rightmost.getRightChild() != null) {
                        parent = rightmost;
                        rightmost = rightmost.getRightChild();
                    }
                    // replace the node data with that node data
                    currentRoot.setData(rightmost.getData());
                    // and replace that node with its left child
                    parent.setRightChild(rightmost.getLeftChild());
                }
            } else {
                // get the leftmost node of the right subtree
                Node leftmost = right;
                Node parent =  currentRoot;
                if(leftmost.getLeftChild() == null) {
                    // replace the node with that node
                    currentRoot.setData(leftmost.getData());
                    // there's no left child for the leftmost node,
                    // so replace the parent's right child with leftmost node's right child
                    parent.setRightChild(leftmost.getRightChild());
                } else {
                    while (leftmost.getLeftChild() != null) {
                        parent = leftmost;
                        leftmost = leftmost.getLeftChild();
                    }
                    // replace the node with that node
                    currentRoot.setData(leftmost.getData());
                    // and replace that node with its right child
                    parent.setLeftChild(leftmost.getRightChild());
                }
            }
        } else if (ret < 0) {
            Node left = remove(data, currentRoot.getLeftChild());
            currentRoot.setLeftChild(left);
        } else {
            Node right = remove(data, currentRoot.getRightChild());
            currentRoot.setRightChild(right);
        }
        return currentRoot;
    }


    /**
     * print the search tree
     */
    public void printTree() {
        printTree(root, 0);
    }

    /**
     * A helper method that print the tree from right child to left
     *
     * @param currentRoot the current root of the tree
     * @param depth the depth of the tree
     */
    private void printTree(Node currentRoot, int depth) {
        if (currentRoot == null) {
            return;
        }
        String blank = "-";
        printTree(currentRoot.getRightChild(), depth + 1);
        System.out.println(blank.repeat(depth) + currentRoot.getData());
        printTree(currentRoot.getLeftChild(), depth + 1);
    }

    /**
     * Preorder traverse the tree
     */
    public void preOrderTraverse() {
        preOrderTraverse(root);
    }

    /**
     * PreOrder traverse the tree
     *
     * @param currentRoot the root of the current binary search tree
     */
    private void preOrderTraverse(Node currentRoot) {
        if (currentRoot == null) {
            return;
        }
        System.out.print(currentRoot.getData() + " ");
        preOrderTraverse(currentRoot.getLeftChild());
        preOrderTraverse(currentRoot.getRightChild());
    }

    /**
     * Inorder traverse the tree
     */
    public void inOrderTraverse() {
        inOrderTraverse(root);
    }

    /**
     * InOrder traverse the binary search tree
     *
     * @param currentRoot the root of the current binary search tree
     */
    private void inOrderTraverse(Node currentRoot) {
        if (currentRoot == null) {
            return;
        }
        inOrderTraverse(currentRoot.getLeftChild());
        System.out.print(currentRoot.getData() + " ");
        inOrderTraverse(currentRoot.getRightChild());
    }

    /**
     * Postorder traverse the tree
     */
    public void postOrderTraverse() {
        postOrderTraverse(root);
    }

    /**
     * PostOrder traverse the binary search tree
     *
     * @param currentRoot the root of the current binary search tree
     */
    private void postOrderTraverse(Node currentRoot) {
        if (currentRoot == null) {
            return;
        }
        postOrderTraverse(currentRoot.getLeftChild());
        postOrderTraverse(currentRoot.getRightChild());
        System.out.print(currentRoot.getData() + " ");
    }

    /**
     * check if the binary search tree is empty
     *
     * @return if the binary search tree is empty, return true, otherwise return false
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Judge if the Node is a leaf
     *
     * @param n the Node
     * @return if the Node is leaf, return true, otherwise return false
     */
    private boolean isLeaf(Node n) {
        Node left = n.getLeftChild();
        Node right = n.getRightChild();
        return (left == null) && (right == null);
    }
}
