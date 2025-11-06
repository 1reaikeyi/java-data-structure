package link;

import java.util.Iterator;

public class Test {
    public static void main(String[] args) {
        Node<String> stack = new Node<>(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        System.out.println("栈顶元素：" + stack.peek());
        System.out.println("出栈元素：" + stack.pop());
        Iterator<String> iterator = stack.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }
        System.out.println("栈顶元素：" + stack.peek());

    }
}
