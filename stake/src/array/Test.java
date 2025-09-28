package array;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        SqArray<String> stake = new SqArray<>(6);
        stake.push("元素1");
        stake.push("元素2");
        stake.push("元素3");
        stake.push("元素4");
        System.out.println(stake.peek());
        System.out.println(stake.pop());
        System.out.println(stake.iterator());
        Iterator<String> itreater = stake.iterator();
        while(itreater.hasNext()){
            System.out.print(itreater.next()+"\t");
        }
        System.out.println("-----------");
        System.out.println(stake.pop());

    }
}
