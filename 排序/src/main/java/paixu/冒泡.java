package paixu;

import java.util.Arrays;

public class 冒泡 {
   
    public static void sort(int[] a){
        int len=a.length;

        for(int i=0;i<len-1;i++){
            if (a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
        for (int i=0;i<len-2;i++){
            if (a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
        for (int i=0;i<len-3;i++){
            if (a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
        for (int i=0;i<len-4;i++){
            if (a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
        for (int i=0;i<len-5;i++){
            if (a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        }
    }

    public static void main(String[] args) {
        int []arr={5,4,3,2};
        System.out.println(arr.length);
        System.out.println("arr = " + Arrays.toString(arr));
        sort(arr);

        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }
}
