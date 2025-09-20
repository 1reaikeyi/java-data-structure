package 实现;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Node<E> implements Stack<E>,Iterable<E>{
        private E data;
        private Node<E> next;  // 修正：next应该是Node类型，而不是E类型
        private int size;
        private int capacity;
        private Node<E> top;  // 栈顶指针，替代head
        public Node() {
            this.size = 0;
            this.top = null;
        }

        public Node(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.top = null;
        }

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean isFull() {
            return size == capacity;
        }

        // 入栈操作
        @Override
        public boolean push(E value) {
            if (isFull()) {
                return false;  // 栈满，无法入栈
            }
            // 创建新节点，新节点的next指向当前栈顶
            Node<E> newNode = new Node<>(value, top);
            top = newNode;  // 更新栈顶指针
            size++;
            return true;
        }

        // 出栈操作
        @Override
        public E pop() {
            if (isEmpty()) {
                return null;  // 栈空，无法出栈
            }
            E data = top.data;  // 获取栈顶数据
            top = top.next;  // 更新栈顶指针
            size--;
            return data;
        }
        @Override
        public E peek() {
            if (isEmpty()) {
                return null;  // 栈空
            }
            return top.data;
        }
        @Override
        public Iterator<E> iterator() {
            return new Iterator<E>() {
                private Node<E> current = top;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public E next() {
                    E value = current.data;
                    current = current.next;  // 移动到下一个节点
                    return value;
                }
            };
        }
    }
