package stack;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-27 22:43
 **/
public class TestLinkedStack {

    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
    }
}

class LinkedStack<T>{

    private Node<T> head;//头结点

    public LinkedStack() {
        this.head = new Node();
    }

    //入栈操作为头插入
    public void push(T t) {

        if (t == null) {
            return;
        }
        Node<T> node = new Node<T>(t);
        if (this.head.next == null) {
            this.head.next = node;
            return;
        }
        ///头插入
        node.next = head.next;
        head.next = node;
    }

    //出栈操作为头删除
    public T pop(){
        if (this.head.next == null) {
            return null;
        }
        Node<T> temp = head.next;
        head.next = head.next.next;
        return temp.t;
    }

    public T peek() {
        if (this.head.next == null) {
            return null;
        }
        return (T) this.head.next.t;
    }

    public boolean isEmpty() {
        return this.head.next == null;
    }

    public int size() {
        int i = 0;
        Node temp = head;
        while (temp.next != null) {
            i ++;
            temp = temp.next;
        }
        return i;
    }
}

class Node<T>{

    T t;//数据域
    Node next;//指针域

    public Node() {
    }

    public Node(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Node{" +
                "t=" + t +
                ", next=" + next +
                '}';
    }
}
