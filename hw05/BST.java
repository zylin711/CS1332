import java.util.NoSuchElementException;

/**
 * Your implementation of a BST.
 */
public class BST<T extends Comparable<? super T>> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private BSTNode<T> root;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the data to the tree.
     *
     * This must be done recursively.
     *
     * The new data should become a leaf in the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        root =  addRecursive(root, data);
    }

    private BSTNode<T> addRecursive(BSTNode<T> node, T data) {
        if (node == null) {
            size++;
            return new BSTNode<>(data);
        }
        int comparision = data.compareTo(node.getData());
        if (comparision < 0) {
            node.setLeft(addRecursive(node.getLeft(),data));
        } else if (comparision > 0) {
            node.setRight(addRecursive(node.getRight(), data));
        }
        return node;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * This must be done recursively.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Do NOT return the same data that was passed in. Return the data that
     * was stored in the tree.
     *
     * Hint: Should you use value equality or reference equality?
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null.");
        }
        BSTNode<T> dummy = new BSTNode<>(null);
        root = removeRecursive(root, data, dummy);
        if (dummy.getData() == null) {
            throw new NoSuchElementException("Data not found in the tree.");
        }
        size--;
        return dummy.getData();
    }

    private BSTNode<T> removeRecursive(BSTNode<T> node, T data, BSTNode<T> dummy) {
        if (node == null) {
            return null;
        }
        int comparision = data.compareTo(node.getData());
        if (comparision < 0) {
            node.setLeft(removeRecursive(node.getLeft(), data, dummy));
        } else if (comparision > 0) {
            node.setRight(removeRecursive(node.getRight(), data, dummy));
        } else {
            dummy.setData(node.getData());
            if (node.getLeft() ==  null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) {
                return node.getRight();
            }
            if (node.getRight() == null) {
                return node.getLeft();
            }
            BSTNode<T> successorDummy = new BSTNode<>(null);
            node.setRight(removeSuccessor(node.getRight(), successorDummy));
            node.setData(successorDummy.getData());
        }
        return node;
    }

    private BSTNode<T> removeSuccessor(BSTNode<T> node, BSTNode<T> dummy) {
        if (node.getLeft() == null) {
            dummy.setData(node.getData());
            return node.getRight();
        }
        node.setLeft(removeSuccessor(node.getLeft(), dummy));
        return node;
    }

    /**
     * Returns the root of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        // DO NOT MODIFY THIS METHOD!
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return The size of the tree
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}
