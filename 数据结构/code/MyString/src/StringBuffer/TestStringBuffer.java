package StringBuffer;

import javax.sql.rowset.spi.SyncResolver;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-27 11:33
 **/
public class TestStringBuffer {
}

final class MyStringBuffer{

    private char[] value;
    private int n;//记录数组长度

    public MyStringBuffer(int capacity) {
        value = new char[capacity];
        this.n = 0;
    }

    public MyStringBuffer(){
        this(16);
    }
    //以字符串常量构造串
    public MyStringBuffer(String s) {
        //调用构造器
        this(s.length() + 16);
        this.n = s.length();
        for (int i = 0; i < this.n; i++) {
            this.value[i] = s.charAt(i);
        }
    }
    //返回数组的元素个数，也就是字符串个数
    public int length() {
        return this.n;
    }
    //返回数组的长度
    public int capacity() {
        return this.value.length;
    }
    //以value数组从0到n构造字符串
    public synchronized String toString() {
        return new String(this.value, 0, this.n);
    }
    //返回地i个字符
    public synchronized char charAt(int i) {
        if (i >= 0 && i < this.n) {
            return this.value[i];
        } else {
            throw new IndexOutOfBoundsException("i = " + i);
        }
    }
    //设置第i个字符为c
    public synchronized void setCharAt(int i, char c) {
        if (i >= 0 && i < this.n) {
            this.value[i] = c;
        } else {
            throw new IndexOutOfBoundsException("i = " + i);
        }
    }

    public synchronized MyStringBuffer insert(int i, String s) {

        //只能从第一位到最后一位插
        if (i >= 0 && i <= this.n) {
            if (s == null) {
                s = "";//s为空，按照空串处理
            }
            char[] temp = value;
            //如果数组的长度不够两个串加起来的长度，需要扩容
            if (this.value.length < this.n + s.length()) {
                this.value = new char[(this.n + s.length()) * 2];//两倍于两串加起来之和
                for (int j = 0; j < i; j++) {
                    value[i] = temp[i];
                }
            }
            //由于temp和value指向同一个数组，将从最后一个字符开始移动s.length()，一直到第i个字符
            for (int j = this.n - 1; j >= i; j--) {
                value[j+s.length()] = temp[j];
            }
            //插入s串
            for (int j = 0; j < s.length(); j++) {
                value[j+i] = s.charAt(j);
            }
            //更新n的长度
            this.n = n + s.length();
            return this;
        }else {
            throw new IndexOutOfBoundsException("i=" + i);
        }
    }
    //从尾部连接s串
    public synchronized MyStringBuffer append(String s) {
        return this.insert(this.n, s);
    }
    //删除begin到end-1之间的子串
    public synchronized MyStringBuffer delete(int begin, int end) {

        if (begin >= 0 && begin < this.n && end >= 0 && begin <= end) {
            //end长度容错
            if (end > this.n) {
                end = this.n;
            }
            //将 end开始之后的子串复制到前面，但end之后的子串并没有去掉
            for (int i = 0; i < n - end; i++) {
                this.value[i+begin] = this.value[end + i];
            }
            //刷新n的长度
            this.n = n - (end - begin);
            return this;
        }
        else {
            throw new IndexOutOfBoundsException();
        }
    }
}
