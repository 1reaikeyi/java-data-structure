package d希尔排序;

import java.util.Arrays;
import java.util.Random;

public class fuben {
    public static void main(String[] args) {
        int[] array = {6,4,5,2,3,1};
        System.out.println("排序前：Arrays.toString(array) = " + Arrays.toString(array));
        shellSort(array);
    }

    public static void shellSort(int[] array) {
        int len = array.length;
        /**
         * len = 6,gap = 3,i = 3
         * temp = array[3]=2,j = 3
         * 第一组：6，3，
         * 第二组：4,3
         * 第三组：5,2

         */
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int temp = array[i];
                int j = i;
                while (j - gap >= 0 && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    System.out.println("1排序后：Arrays.toString(array) = " + Arrays.toString(array));
                    j = j - gap;
                }
                array[j] = temp;
                System.out.println("2--排序后：Arrays.toString(array) = " + Arrays.toString(array));
            }
            System.out.println("---------------------排序后：Arrays.toString(array) = " + Arrays.toString(array));
        }
        /**
         * D:\a.java\java23\bin\java.exe --enable-preview "-javaagent:D:\a.java\intellij2024.1.4\IntelliJ IDEA 2024.1.4\lib\idea_rt.jar=56800:D:\a.java\intellij2024.1.4\IntelliJ IDEA 2024.1.4\bin" -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath D:\a.maven-java\javacode\数据结构\out\production\pai d希尔排序.fuben
         * 排序前：Arrays.toString(array) = [6, 4, 5, 2, 3, 1]
         * 1排序后：Arrays.toString(array) = [6, 4, 5, 6, 3, 1]
         * 2--排序后：Arrays.toString(array) = [2, 4, 5, 6, 3, 1]
         * 1排序后：Arrays.toString(array) = [2, 4, 5, 6, 4, 1]
         * 2--排序后：Arrays.toString(array) = [2, 3, 5, 6, 4, 1]
         * 1排序后：Arrays.toString(array) = [2, 3, 5, 6, 4, 5]
         * 2--排序后：Arrays.toString(array) = [2, 3, 1, 6, 4, 5]
         * ---------------------排序后：Arrays.toString(array) = [2, 3, 1, 6, 4, 5]
         * 2--排序后：Arrays.toString(array) = [2, 3, 1, 6, 4, 5]
         * 1排序后：Arrays.toString(array) = [2, 3, 3, 6, 4, 5]
         * 1排序后：Arrays.toString(array) = [2, 2, 3, 6, 4, 5]
         * 2--排序后：Arrays.toString(array) = [1, 2, 3, 6, 4, 5]
         * 2--排序后：Arrays.toString(array) = [1, 2, 3, 6, 4, 5]
         * 1排序后：Arrays.toString(array) = [1, 2, 3, 6, 6, 5]
         * 2--排序后：Arrays.toString(array) = [1, 2, 3, 4, 6, 5]
         * 1排序后：Arrays.toString(array) = [1, 2, 3, 4, 6, 6]
         * 2--排序后：Arrays.toString(array) = [1, 2, 3, 4, 5, 6]
         * ---------------------排序后：Arrays.toString(array) = [1, 2, 3, 4, 5, 6]
         *
         * 进程已结束，退出代码为 0
         */
    }
}
