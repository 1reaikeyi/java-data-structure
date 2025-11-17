package 哈夫曼树;

import java.util.PriorityQueue;
import java.util.IllegalFormatException;

public class HuffmanTree {
    // 哈夫曼树节点内部类（实现Comparable接口，支持优先队列排序）
    private static class HuffmanNode implements Comparable<HuffmanNode> {
        int weight;       // 节点权值
        HuffmanNode left;  // 左子节点
        HuffmanNode right; // 右子节点

        // 构造器：创建叶子节点（无左右子树）
        public HuffmanNode(int weight) {
            this.weight = weight;
            this.left = null;
            this.right = null;
        }

        // 重写比较方法：按权值升序排列（满足最小堆需求）
        @Override
        public int compareTo(HuffmanNode o) {
            return this.weight - o.weight;
        }
    }

    private HuffmanNode root; // 哈夫曼树根节点

    /**
     * 构造方法：传入权值数组构建哈夫曼树
     * @param weights 权值数组（不可为空、不可含负数）
     */
    public HuffmanTree(int[] weights) {
        // 输入校验
        if (weights == null || weights.length == 0) {
            throw new IllegalArgumentException("权值数组不能为空或长度为0！");
        }
        for (int weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException("权值不能为负数：" + weight);
            }
        }

        // 1. 初始化优先队列（最小堆），将所有权值转为叶子节点入队
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>();
        for (int weight : weights) {
            minHeap.offer(new HuffmanNode(weight));
        }

        // 2. 构建哈夫曼树：合并最小节点直到队列仅剩1个节点（根节点）
        while (minHeap.size() > 1) {
            // 取出权值最小的两个节点
            HuffmanNode leftNode = minHeap.poll();
            HuffmanNode rightNode = minHeap.poll();

            // 生成新节点（权值=两节点之和，左右子树指向原节点）
            HuffmanNode parentNode = new HuffmanNode(leftNode.weight + rightNode.weight);
            parentNode.left = leftNode;
            parentNode.right = rightNode;

            // 新节点入队，参与下一轮合并
            minHeap.offer(parentNode);
        }

        // 3. 队列中最后一个节点即为根节点
        this.root = minHeap.poll();
    }

    /**
     * 前序遍历（根→左→右）：验证树结构
     */
    public void preOrderTraversal() {
        System.out.print("前序遍历结果：");
        preOrder(root);
        System.out.println();
    }

    // 递归实现前序遍历
    private void preOrder(HuffmanNode node) {
        if (node != null) {
            System.out.print(node.weight + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历（左→根→右）：辅助验证
     */
    public void inOrderTraversal() {
        System.out.print("中序遍历结果：");
        inOrder(root);
        System.out.println();
    }

    // 递归实现中序遍历
    private void inOrder(HuffmanNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.weight + " ");
            inOrder(node.right);
        }
    }

    // 测试方法
    public static void main(String[] args) {
        // 测试用例1：多个权值（常规场景）
        int[] weights1 = {3, 1, 4, 2, 5};
        System.out.println("=== 测试用例1：权值数组 [3,1,4,2,5] ===");
        HuffmanTree tree1 = new HuffmanTree(weights1);
        tree1.preOrderTraversal();  // 输出示例：15 6 3 1 2 3 9 4 5 （结构不唯一，根节点必为15）
        tree1.inOrderTraversal();   // 输出示例：1 3 2 6 3 4 9 5 15

        // 测试用例2：单个权值（边界场景）
        int[] weights2 = {7};
        System.out.println("\n=== 测试用例2：权值数组 [7] ===");
        HuffmanTree tree2 = new HuffmanTree(weights2);
        tree2.preOrderTraversal();  // 输出：7

        // 测试用例3：两个权值（简单场景）
        int[] weights3 = {2, 3};
        System.out.println("\n=== 测试用例3：权值数组 [2,3] ===");
        HuffmanTree tree3 = new HuffmanTree(weights3);
        tree3.preOrderTraversal();  // 输出示例：5 2 3

        // 测试用例4：含0权值（特殊场景）
        int[] weights4 = {0, 1, 2};
        System.out.println("\n=== 测试用例4：权值数组 [0,1,2] ===");
        HuffmanTree tree4 = new HuffmanTree(weights4);
        tree4.preOrderTraversal();  // 输出示例：3 1 0 2
    }
}