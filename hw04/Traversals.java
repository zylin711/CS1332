import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        List<T> traversal = new ArrayList<>();
        preorderHelper(root, traversal);
        return traversal;
    }

    private void preorderHelper(TreeNode<T> node, List<T> traversal) {
        if (node == null) {
            return;
        }
        traversal.add(node.getData());
        preorderHelper(node.getLeft(), traversal);
        preorderHelper(node.getRight(), traversal);
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        List<T> traversal = new ArrayList<>();
        inorderHelper(root, traversal);
        return traversal;
    }

    private void inorderHelper(TreeNode<T> node, List<T> traversal) {
        if (node == null) {
            return;
        }
        inorderHelper(node.getLeft(), traversal);
        traversal.add(node.getData());
        inorderHelper(node.getRight(), traversal);
    }

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        List<T> traversal = new ArrayList<>();
        postorderHelper(root, traversal);
        return traversal;
    }

    private void postorderHelper(TreeNode<T> node, List<T> traversal) {
        if (node == null) {
            return;
        }
        postorderHelper(node.getLeft(), traversal);
        postorderHelper(node.getRight(), traversal);
        traversal.add(node.getData());
    }
}