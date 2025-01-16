import java.util.List;

public class TraversalsTest {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(50);
        TreeNode<Integer> node25 = new TreeNode<>(25);
        TreeNode<Integer> node100 = new TreeNode<>(100);
        TreeNode<Integer> node10 = new TreeNode<>(10);
        TreeNode<Integer> node75 = new TreeNode<>(75);
        TreeNode<Integer> node125 = new TreeNode<>(125);
        TreeNode<Integer> node110 = new TreeNode<>(110);

        root.setLeft(node25);
        root.setRight(node100);
        node25.setLeft(node10);
        node100.setLeft(node75);
        node100.setRight(node125);
        node125.setLeft(node110);

        Traversals<Integer> traversals = new Traversals<>();

        // Test Pre-order Traversal
        List<Integer> preorderResult = traversals.preorder(root);
        System.out.println("Pre-order Traversal: " + preorderResult);
        // Expected: [50, 25, 10, 100, 75, 125, 110]

        // Test In-order Traversal
        List<Integer> inorderResult = traversals.inorder(root);
        System.out.println("In-order Traversal: " + inorderResult);
        // Expected: [10, 25, 50, 75, 100, 110, 125]

        // Test Post-order Traversal
        List<Integer> postorderResult = traversals.postorder(root);
        System.out.println("Post-order Traversal: " + postorderResult);
        // Expected: [10, 25, 75, 110, 125, 100, 50]
    }
}