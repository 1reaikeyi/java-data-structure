package 哈夫曼树;

import java.util.PriorityQueue;

public class Tree {

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
        @Override
        public String toString() {
            return "HuffmanNode{"+weight +
                    "}";
        }
    }
    private HuffmanNode root;

    public Tree(int[] weights) {
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
        Tree.printTree(root);

    }
    public static void printTree(HuffmanNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root + "\t");
        printTree(root.left);
        printTree(root.right);
    }


    // 测试方法
    public static void main(String[] args) {
        // 测试用例1：多个权值（常规场景）
        int[] weights1 = {3, 1, 4, 2, 5};
        System.out.println("=== 测试用例1：权值数组 [3,1,4,2,5] ===");
        Tree tree1 = new Tree(weights1);

        // 测试用例2：单个权值（边界场景）
        int[] weights2 = {7};
        System.out.println("\n=== 测试用例2：权值数组 [7] ===");
        Tree tree2 = new Tree(weights2);


        // 测试用例3：两个权值（简单场景）
        int[] weights3 = {2, 3};
        System.out.println("\n=== 测试用例3：权值数组 [2,3] ===");
        Tree tree3 = new Tree(weights3);


        // 测试用例4：含0权值（特殊场景）
        int[] weights4 = {0, 1, 2};
        System.out.println("\n=== 测试用例4：权值数组 [0,1,2] ===");
        Tree tree4 = new Tree(weights4);
    }
}