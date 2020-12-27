package String;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-27 10:08
 **/
public class TestMyString {

    public static void main(String[] args) {
        String s = new String("12");
        s = "123";
        System.out.println(s);
    }
}

final class MyString implements Comparable<MyString> {

    //私有字符变量，只能一次赋值
    private final char[] value;

    public MyString() {
        this.value = new char[0];
    }

    //字符串常量构造串
    public MyString(String s) {
        this.value = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            value[i] = s.charAt(i);
        }
    }

    //以value字符的i开头的n个字符串构造串  i <= value.length < n
    //检查i和n的边界，超过value的长度抛出异常
    public MyString(char[] value, int i, int n) {
        if (i >= 0 && n >=0 && i+n <= value.length) {
            this.value = new char[n];
            for (int j = 0; j < n; j++) {
                this.value[j] = value[j+i];
            }
        } else {
            throw new IndexOutOfBoundsException("i = " + i + ", n = " + n);
        }
    }

    //以传入的字符数组构造字符串
    public MyString(char[] value) {
        this.value = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = value[i];
        }
    }

    public int length(){
        return this.value.length;
    }

    //获取指定的字符
    public char charAt(int i) {
        if (i >=0 && i < this.length()) {
            return this.value[i];
        } else {
            throw new IndexOutOfBoundsException("i = " + i);
        }
    }

    //获取指定的字符子串
    public MyString subString(int begin, int end) {

        if (begin >= 0 && end >= 0 && begin + end <= this.value.length) {
            return new MyString(this.value,begin,end);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public MyString concat(MyString s) {

        if (s == null || s.equals("")) {
            //深拷贝。new一个新对象
            return new MyString(this.value);
        }
        char[] buff = new char[this.value.length + s.length()];
        int i;
        //拷贝this字符串
        for (i = 0; i < this.value.length; i++) {
            buff[i] = this.value[i];
        }
        //拷贝s字符串
        for (int j = 0; j < s.length(); j++) {
            buff[i+j] = s.value[j];
        }
        //调用构造器，返回连接字符串
        return new MyString(buff);
    }

    @Override
    public int compareTo(MyString myString) {

        for (int i = 0; i < this.value.length && i < myString.length(); i++) {
            if (this.value[i] != myString.value[i]) {
                return this.value[i] - myString.value[i];
            }
        }
        return this.value.length - myString.length();
    }
}
