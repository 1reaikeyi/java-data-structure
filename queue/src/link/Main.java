package link;

import java.util.Iterator;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        Table<String> table = new Table<>(6);
        table.offer("元素1");
        table.offer("元素2");
        table.offer("元素3");
        table.offer("元素4");
        System.out.println("table.head = " + table.head);

        System.out.println("table.tail = " + table.tail);

        Iterator<String> iterator = table.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("table.peek() = " + table.peek());
        table.pull();
        table.pull();
        table.printAll();
    }
}