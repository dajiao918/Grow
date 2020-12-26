package LinkedList;

import javax.naming.LimitExceededException;
import java.awt.*;
import java.awt.event.MouseWheelListener;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-26 11:01
 **/
public class TestLinkedList {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
//        linkedList.remove(2);
//        linkedList.set(3,"D");
        linkedList.reverse();
        System.out.println(linkedList);
    }
}

class LinkedList<T>{

    Node<T> head = null;

    public LinkedList(){
        this.head = new Node<T>();
    }

    public void add(T t){

        if (t == null){
            throw new NullPointerException("t=null");
        }
        Node<T> node = new Node<>(t);
        //如果头结点的下一个节点为空
        if (head.next == null){
            head.next = node;
            return;
        }
        //head节点不能变，让temp和head同时指向一个对象进项操作
        Node temp = head;
        //不然就让temp一直遍历到最后一个节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void insert(int i, T t) {

        if (t == null) {
            return;
        }
        if (i < 0){
            i = 0;
        }
        if (i > this.size()) {
            i = this.size();
        }
        int j = 0;//定义一个整型变量，和传入的下标进行比较
        Node temp = head;
        while (temp.next != null) {
            //当插入位置i是0，我们得到头结点；当插入位置i是1，我们得到A节点；当插入位置是2，我们得到B节点...
           if (j == i) {
                break;
            }
            j ++;
            temp = temp.next;
        }
        Node<T> node = new Node<>(t);
        //当插入位置是最后一个节点时，temp.next为空，所以需要判断
        if (temp.next != null){
            node.next = temp.next;
        }
        temp.next = node;
    }

    public T remove(int i) {
        if (i >= 0 && i < this.size()) {
            int j = 0;
            Node temp = head;
            while (temp.next != null) {
                if (i == j) {
                    break;
                }
                j ++;
                temp = temp.next;
            }
            T t = (T) temp.t;
            temp.next = temp.next.next;
            return t;
        }
        return null;
    }

    public void set(int i, T t) {

        if (t == null ){
            throw new NullPointerException("t == null");
        }
        if (i < 0 || i >= this.size()) {
            throw new IndexOutOfBoundsException("i = " + i);
        }
        int j = 0;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
            if (j == i) {
                break;
            }
            j ++;
        }
        temp.t = t;
    }

    public void reverse(){
        if (head.next == null) {
            return;
        }
        Node past = null, temp = this.head.next, behind = null;
        while (temp.next != null) {
            behind = temp.next;//首先记录下temp的下一个节点
            temp.next = past;//temp.next等于前一个节点
            past = temp;//记录当前节点，在下一次循环时使用
            temp = behind;
        }
        //遍历完成后，temp=behind已经是最后一个节点，但因为最后一个节点进不去循环，所以需要手动补充
        temp.next = past;
        //令head连接到temp即可
        this.head.next = temp;
    }

    public int size(){

        int i = 0;
        Node temp = head;
        while (temp.next != null){
            i ++;
            temp = temp.next;
        }
        return i;
    }

    public String toString(){
        if (head.next == null){
            System.out.println("此链表为空");
            return null;
        }
        Node temp = head;
        String str = "LinkedList[ ";
        while (temp.next != null) {

            temp = temp.next;
            str += temp + ",";
        }
        return str + " ]";
    }
}

class Node<T>{

    T t;
    Node next;//自身类型的变量，用于连接下一个对象

    public Node() {
    }

    public Node(T t){
        this.t = t;
    }

    @Override
    public String toString() {
        return "Node{" +
                "t=" + t +
                '}';
    }
}