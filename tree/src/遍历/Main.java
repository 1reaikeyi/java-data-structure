package 遍历;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
       TreeNode tree = new TreeNode(
               new TreeNode(new TreeNode(4),2, null),
                       1,
               new TreeNode(new TreeNode(5), 3, new TreeNode(6))

       );
       printPreOrder(tree);
        System.out.println("####################");
       printInOrder(tree);
        System.out.println("####################");
        printPostOrder(tree);
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

}