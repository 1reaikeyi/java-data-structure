package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 哈夫曼树实现：支持指定字符序列和权重数组构建树，提供先序遍历
 */
public class HuffmanTree {
    // 哈夫曼树根节点
    private HuffmanNode root;
    public HuffmanTree(String chars, int[] weights) {
        // 1. 合法性校验
        validateInput(chars, weights);

        // 2. 初始化最小堆（优先队列），按节点权重升序排序
        PriorityQueue<HuffmanNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        // 3. 创建所有叶子节点，加入最小堆
        for (int i = 0; i < chars.length(); i++) {
            minHeap.offer(new HuffmanNode(chars.charAt(i), weights[i]));
        }

        // 4. 合并节点，构建哈夫曼树（堆中只剩1个节点时停止）
        while (minHeap.size() > 1) {
            // 取出权重最小的两个节点
            HuffmanNode leftChild = minHeap.poll();
            HuffmanNode rightChild = minHeap.poll();

            // 生成新父节点（权重=两子节点之和，非叶子节点字符用#标记）
            HuffmanNode parentNode = new HuffmanNode('#', leftChild.weight + rightChild.weight);
            parentNode.left = leftChild;
            parentNode.right = rightChild;

            // 父节点入堆，继续合并
            minHeap.offer(parentNode);
        }

        // 5. 堆中剩余节点即为根节点
        this.root = minHeap.poll();
    }

    /**
     * 先序遍历（递归实现）：根 → 左 → 右
     */
    public void preOrderTraversal() {
        System.out.print("先序遍历结果：");
        preOrderRecursive(root);
        System.out.println(); // 换行美化输出
    }

    /**
     * 递归遍历核心逻辑
     */
    private void preOrderRecursive(HuffmanNode node) {
        if (node == null) return;
        // 访问当前节点（输出字符+权重，非叶子节点用#区分）
        System.out.print("(" + node.data + ", " + node.weight + ") ");
        // 递归左子树
        preOrderRecursive(node.left);
        // 递归右子树
        preOrderRecursive(node.right);
    }

    /**
     * 输入合法性校验
     */
    private void validateInput(String chars, int[] weights) {
        if (chars == null || weights == null) {
            throw new IllegalArgumentException("字符序列和权重数组不能为null");
        }
        if (chars.length() != weights.length) {
            throw new IllegalArgumentException("字符序列长度与权重数组长度必须一致");
        }
        if (chars.length() == 0) {
            throw new IllegalArgumentException("字符序列不能为空");
        }
        for (int weight : weights) {
            if (weight < 0) {
                throw new IllegalArgumentException("权重不能为负数");
            }
        }
    }

    /**
     * 哈夫曼树节点类
     */
    private static class HuffmanNode {
        char data;       // 字符（非叶子节点为#）
        int weight;      // 权重
        HuffmanNode left; // 左子树
        HuffmanNode right;// 右子树

        public HuffmanNode(char data, int weight) {
            this.data = data;
            this.weight = weight;
            this.left = null;
            this.right = null;
        }
    }

    // 测试代码
    public static void main(String[] args) {
        // 测试1：普通场景（4个字符，权重不同）
        String chars1 = "abcdefg";
        int[] weights1 = {1, 2, 3, 4,7,9,10};
        System.out.println("=== 测试1：字符序列=" + chars1 + "，权重=" + java.util.Arrays.toString(weights1));
        new HuffmanTree(chars1, weights1).preOrderTraversal();

    }
}