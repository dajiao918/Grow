package hashtab;

/**
 * @program: 线性表
 * @description:
 * @author: Mr.Yu
 * @create: 2020-12-26 20:35
 **/
public class TestHashTab {

    public static void main(String[] args) {

        HashTab hashTab = new HashTab(8);
        Emp bob = new Emp(1, "bob");
        Emp alan = new Emp(2, "alan");
        Emp siy = new Emp(123, "alan");
        Emp pok = new Emp(569, "alan");
        hashTab.add(bob);
        hashTab.add(alan);
        hashTab.add(siy);
        hashTab.add(pok);
        Emp search = hashTab.search(123);
        System.out.println(search);
        Emp noEmp = hashTab.search(12);
        System.out.println(noEmp);
    }
}

class HashTab<T>{

    EmpLinkedList[] empLinkedLists;
    int size;
    public HashTab(int size) {
        this.size = size;
        //初始化链表数组
        empLinkedLists = new EmpLinkedList[size];
        //必须将每个链表都要实例化！！！
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //写一个简单的散列函数，根据数组大小取余，这样得到的值就会在（ 0 - (size-1)）之间，方便进行检索
    public int getNum(int id) {
        return id % size;
    }

    public void add(Emp emp) {
        if (emp == null) {
            return;
        }

        int num = getNum(emp.id);
        empLinkedLists[num].add(emp);
    }

    public void show(){
        for (int i = 0; i < empLinkedLists.length; i++) {
            System.out.println("第" + i + "条链表为" + empLinkedLists[i]);
        }
    }

    public Emp search(int id) {
        int num = getNum(id);//获取在那一条链表查询
        Emp temp = empLinkedLists[num].head;
        while (temp != null) {
            if (temp.id == id) {
                break;
            }
            temp = temp.next;
        }
        if (temp == null){
            System.out.println("没有此员工！");
        }
        return temp;
    }
}

class Emp{

    int id;
    String name;
    Emp next;

    public Emp() {

    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

class EmpLinkedList{
    Emp head = null;

    public void add(Emp emp){

        if (emp == null){
            throw new NullPointerException("t=null");
        }
        //这里头结点不再不存储数据了，头结点也要对其赋值
        if (head == null){
            head = emp;
            return;
        }
        //head节点不能变，让temp和head同时指向一个对象进项操作
        Emp temp = head;
        //不然就让temp一直遍历到最后一个节点
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = emp;
    }

    public String toString(){
        if (head == null){
            return null;
        }
        Emp temp = head;
        String str = "LinkedList[ ";
        str += head;
        while (temp.next != null) {

            temp = temp.next;
            str += "," + temp;
        }
        return str + " ]";
    }
}

