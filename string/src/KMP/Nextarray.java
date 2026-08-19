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
        for (String pattern : testPatterns) {
            System.out.println("模式串: " + pattern);
            int[] next = kmp.getNext(pattern);
            kmp.print(next);
            System.out.println();
        }

    }
}
