package 遍历;

public class PrintTreenode {
    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(node6, 4, null);
        TreeNode node5 = new TreeNode(node7, 5, null);
//        TreeNode node2 = new TreeNode(node8, 2, node4);
        TreeNode node2 = new TreeNode(null, 2, node4);
        //        TreeNode node3 = new TreeNode(node8, 3, node5);
        TreeNode node3 = new TreeNode(null, 3, node5);
        TreeNode tree = new TreeNode(node2, 1, node3);
        /**
         *         1       // 根节点（第1层）
         *       /   \
         *      2     3    // 第2层
         *       \     \
         *        4     5  // 第3层
         *       /     /
         *      6     7    // 第4层
         */
       printPreOrder(tree);
        System.out.println("####################");

       printInOrder(tree);
        System.out.println("####################");
        printPostOrder(tree);
        System.out.println("####################");
        printLevel(tree,4);
    }
    public static void printPreOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先访问当前节点
        System.out.print(node.val + "\t");
        // 再递归遍历左子树
        printPreOrder(node.left);
        // 最后递归遍历右子树
        printPreOrder(node.right);

    }
    public static void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先递归遍历左子树
        printInOrder(node.left);
        // 再访问当前节点
        System.out.print(node.val + "\t");
        // 最后递归遍历右子树
        printInOrder(node.right);

    }
    public static void printPostOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        // 先递归遍历左子树
        printInOrder(node.left);
        // 再递归遍历右子树
        printInOrder(node.right);
        // 最后访问当前节点
        System.out.print(node.val + "\t");
    }
    public static void printLevel(TreeNode root, int level) {
        if (root == null) {
            return; // 空节点直接返回
        }

            // 到达目标层，打印当前节点值
            System.out.print(root.val + "\t");
        if (level > 1) {
            // 未到目标层，递归遍历左、右子树（层数减1，向深层推进）
            printLevel(root.left, level - 1);
            printLevel(root.right, level - 1);
        }
    }

}
/***
 *
 */
