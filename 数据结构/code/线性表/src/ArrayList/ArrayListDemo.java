package ArrayList;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-25 20:05
 **/
public class ArrayListDemo {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.insert(1,"D");
        System.out.println(arrayList.get(3));
        arrayList.remove(3);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.get(0));
        arrayList.set(0,"");
        System.out.println(arrayList.get(0));
//        System.out.println(arrayList.toString());
    }
}

class ArrayList<T>{ //定义泛型，可以接受任何一种数据类型的元素存储

    private int n;//记录整个元素的个数
    private Object[] element;//底层数组变量，用于存储元素
    private static final int MIN_CAPACITY = 16;//数组的初始长度

    public  ArrayList(){
        this.element = new Object[MIN_CAPACITY];//直接初始化数组
        this.n = 0;//目前还未添加元素。令n=0
    }

    public void add(T t){

        if (t == null){
            return;//传入的值不能是null，不然加个屁
        }
        if (this.n == element.length) {
            Object[] temp = this.element;//此时temp和element指向同一个数组
            //对element进行扩容，申请一个2倍于之前的数组空间
            element = new Object[2 * temp.length];
            //将temp的数据复制
            for (int i = 0; i < temp.length; i++) {
                element[i] = temp[i];
            }
        }
        element[this.n] = t;
        this.n++;
    }

    public T remove(int i) {//返回被删除的元素

        if (i >= 0 && i < this.n) {//必须要进行下标检索
            T temp = (T)this.element[i];//记录被删除的元素
            for (int j = i; j < this.n-1; j ++) {
                this.element[j] = this.element[j+1];//前移可以正序赋值，不会造成自身紊乱
            }
            element[n-1] = null;//最后一个等于null
            this.n --;
            return temp;
        }
        return null;
    }

    public void insert(int i, T t){

        if (t == null){
            return;
        }
        if (i > element.length) {
            i = this.n;//i肯定是不能让他超过数组的容量的，不然插个鬼
        }
        if (i < 0){
            i = 0;//同理，i不能小于0
        }
        Object[] temp = element;//此时temp和element指向同一个数组
        if (this.n == element.length) {
            //对element进行扩容，申请一个2倍于之前的数组空间
            element = new Object[2 * temp.length];
            for (int j = 0; j < i; j++) {
                element[j] = temp[j];//i前面的元素直接复制
            }
        }
        for (int j = this.n - 1; j >= i; j--) {
            element[j+1] = temp[j];//由于两个引用是指向同一个数组，只能倒序复制
        }
        element[i] = t;
        this.n ++;
    }

    public void set(int i, T t) {

        if (t == null) {
            throw new NullPointerException("x==null");//t为空，抛出x==null的异常
        }
        if (i >=0 && i < this.n) {
            this.element[i] = t;
        } else {
            throw new IndexOutOfBoundsException("i=" + i);//抛出数组越界异常
        }
    }

    public int size(){
        return this.n;
    }

    public T get(int i){
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }

    //遍历顺序表
    public String toString(){

        String str = "ArrayList[ ";

        for (int i = 0; i < this.n; i++) {
            str += this.element[i].toString() + ","; //利用元素自己的toString方法
        }
        return str + " ]";
    }

}
