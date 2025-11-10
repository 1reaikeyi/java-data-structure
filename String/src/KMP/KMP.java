package KMP;

public class KMP {
    public int[] getNext(String pattern) {
        int length = pattern.length();
        int[] next = new int[length];

        // next[0]表示前1个字符，没有真前缀和真后缀，所以为0
        next[0] = 0;
        // j表示当前计算的位置，i表示当前要比较的位置
        int j = 0;
        for (int i = 1; i < length; i++) {
            // 如果当前比较的字符不相等，回退j到前一个next值
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            }

            // 如果当前比较的字符相等，j加1
            if (pattern.charAt(i) == pattern.charAt(j)) {
                j++;
            }

            // 记录当前位置的next值
            next[i] = j;
        }

        return next;
    }
    public void print(int[] next) {
        System.out.print("next数组: [");
        for (int i = 0; i < next.length; i++) {
            System.out.print(next[i]);
            if (i < next.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


}