package KMP;

public class Nextarray {
    public static void main(String[] args) {
        KMP kmp = new KMP();
        String[] testPatterns = {

                "ABABCABAA",
                "ABCDABD",
                "AAAA",
                "ABCDE"
        };
        //  1   2   3   4   5   6   7   8    9
        // "A   B   A   B   C   A   B   A    A",
        /**[0, 0, 1, 2, 0, 1, 2, 3, 1]
         *  0   0   1   2   0  0
         *
         *  2
         *  前缀集合：{"A"}
         *  后缀集合：{"B"}
         *  3
         *  前缀集合：{"A", "AB"}
         * 后缀集合：{"A", "BA"}
         *  4
         *  前缀集合：{"A", "AB", "ABA"}
         * 后缀集合：{"B", "AB", "BAB"}
         *  5
         *  前缀集合：{"A", "AB", "ABA", "ABAB"}
         * 后缀集合：{"C", "BC", "ABC", "BABC"}
         *  6
         *  前缀集合：{"A", "AB", "ABA", "ABAB", "ABABC"}
         * 后缀集合：{"A", "CA", "BCA", "ABCA", "BABCA"}
         * 7
         * 前缀集合：{"A", "AB", "ABA", "ABAB", "ABABC", "ABABCA"}
         * 后缀集合：{"B", "AB", "CAB", "BCAB", "ABCAB", "BABCAB"}
         *
         */
        for (String pattern : testPatterns) {
            System.out.println("模式串: " + pattern);
            int[] next = kmp.getNext(pattern);
            kmp.print(next);
            System.out.println();
        }
        /**
         * 模式串: ABABCABAA
         * next数组: [0, 0, 1, 2, 0, 1, 2, 3, 1]
         *
         * 模式串: ABCDABD
         * next数组: [0, 0, 0, 0, 1, 2, 0]
         *
         * 模式串: AAAA
         * next数组: [0, 1, 2, 3]
         *
         * 模式串: ABCDE
         * next数组: [0, 0, 0, 0, 0]
         */
    }
}
