package stack;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-27 22:18
 **/
public class TestStack {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        String pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}

class Stack<T>{

    private Object[] element; //存储数据
    int n; //指向栈顶
    public static final int MIN_CAPACITY = 16;

    public Stack(int length) {
        if (length < MIN_CAPACITY) {
            length = MIN_CAPACITY;
        }
        element = new Object[length];
        n = -1;
    }

    public Stack() {
        this(MIN_CAPACITY);
    }

    //入栈操作
    public void push(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        //判断栈是否空间已满
        Object[] temp = element;
        if (this.n == element.length - 1) {
            element = new Object[temp.length * 2];
            for (int i = 0; i < temp.length; i++) {
                element[i] = temp[i];
            }
        }
        //由于n初始化为-1，先让n++
        this.n ++;
        this.element[n] = t;
    }

    public int size() {
        return this.n + 1;
    }

    //出栈操作
    public T pop() {
        if (!isEmpty()) {
            T t = (T) this.element[this.n];
            this.n --;
            return t;
        }
        return null;
    }

    //获取栈顶元素，但不删除
    public T peek() {
        if (!isEmpty()) {
            return (T) element[this.n];
        }
        return null;
    }

    public boolean isEmpty() {
        return this.n < 0;
    }
}