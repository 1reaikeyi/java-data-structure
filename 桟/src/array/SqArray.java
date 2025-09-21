package array;

import java.util.Iterator;
import java.util.function.Consumer;

public class SqArray<T> implements Stack<T>,Iterable<T> {
    private T[] data;
    private int top = 0;

    public SqArray() {
    }

    public SqArray(int capacity) {
        this.data = (T[]) new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public boolean isFull() {
        return top == data.length;
    }
    //底--------------顶
    // 0  1  2  3  4  5
    //   top=(0+1)

    @Override
    public boolean push(T value) {
        if (isFull()) {
            return false;
        }
        data[top++] = value;
        return true;  // 修复：入栈成功应返回 true
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T value = data[top - 1];
        top--;
        return value;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return data[top - 1];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = top;  // 使用独立的迭代指针

            @Override
            public boolean hasNext() {
                return i>0;  // 正确判断是否还有元素可迭代
            }

            @Override
            public T next() {
                return data[--i];  // 从前往后遍历，不修改top指针
            }
        };
    }
}