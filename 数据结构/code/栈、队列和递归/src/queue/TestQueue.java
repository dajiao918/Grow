package queue;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-28 10:50
 **/
public class TestQueue {
}

class Queue<T>{

    private int front, rear;
    private Object[] element;
    public static final int MIN_CAPACITY = 16;

    public Queue(int length) {
        if (length < MIN_CAPACITY) {
            length = MIN_CAPACITY;
        }
        this.front = rear = 0;//设置队列为空
        this.element = new Object[length];
    }

    public Queue() {
        this(MIN_CAPACITY);
    }

    public boolean isEmpty() {
        return this.front == rear;
    }

    public void add(T t) {

        if (t == null) {
            throw  new NullPointerException();
        }
        Object[] temp = element;
        //判断队列是否已满
        if (this.front == (this.rear+1)%this.element.length) {
            element = new Object[temp.length * 2];
            int j = 0;
            //i从front队头开始复制元素，当i=rear 时，元素已经遍历完成，这样就能保证队头和队尾顺序不乱
            for (int i = this.front; i != this.rear; i = (i+1) % temp.length) {
                element[j] = temp[i];
                j++;
            }
            this.front = 0;
            this.rear = j;
        }
        this.element[this.rear] = t;
        this.rear = (this.rear+1) % this.element.length;
    }

    public T peek() {
        if (!isEmpty()) {
            return (T) this.element[front];
        }
        return null;
    }

    public T pop() {
        if (!isEmpty()) {
            T t = (T) this.element[front];
            front = (front+1) % this.element.length;
            return t;
        }
        return null;
    }
}
