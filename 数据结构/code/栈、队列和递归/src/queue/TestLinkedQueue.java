package queue;

import com.sun.org.apache.bcel.internal.generic.POP;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-28 12:08
 **/
public class TestLinkedQueue {
}

class LinkedQueue<T>{

    private Node<T> front, rear;
    public LinkedQueue() {
        this.front = rear = null;
    }

    public boolean isEmpty() {
        return this.front == null && this.rear == null;
    }

    public void add(T t) {
        if (t == null) {
            throw  new NullPointerException();
        }
        Node node = new Node(t);
        if (this.front == null ) {
            this.front = node;
        } else {
            this.rear.next = node;//连接node
        }
        rear = node;//将rear后移
    }

    public T peek() {
        if (!isEmpty()) {
            return this.front.t;
        }
        return null;
    }

    public T pop() {
        if (!isEmpty()) {
            T t = this.front.t;
            this.front = this.front.next;//front后移
            if (front == null) {//如果front后移后为null，将rear也设置为null，此时队列为空
                rear = null;
            }
            return t;
        }
        return null;
    }
}

class Node<T> {

    T t;
    Node next;

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