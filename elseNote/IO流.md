# IO流



## File类



​	java.io.File类：文件和文件目录路径的抽象表现形式，与平台无关

​	File能新建、删除、重命名文件和目录，但File不能访问文件内容本身，如果需要访问文件内容，则需要输入输出流

​	想要在java程序中表示一个真实存在的文件或者目录，那么必须有一个File对象。

​	File对象可以作为一个参数传递给流的构造器

​	

​	File类的常用方法

```java
File parDir = new File("E:/workSpace");
if (!parDir.exists()) {
    parDir.mkdir();//如果在盘符中不存在此文件，就创建为目录
}

//创建以parDir为父目录，名为childDir的File对象
File childDir = new File(parDir, "childDir");
if (!childDir.exists()){
    childDir.mkdirs();//如果不存在，这创建为目录
}
//创建以childDir为父目录，名为file的File对象
File file = new File(childDir, "test.txt");
if (!file.exists()) {
    file.createNewFile();//如果不存在，就创建文件
}
```



```java
/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-15 10:53
 **/
public class ExeForFile {

    public static void main(String[] args) {

        //创建目录demo
        File demo = new File("E:/Demo");
        if (!demo.exists()) {
            demo.mkdir();
        }

        //在demo下创建A，B文件
        File a = new File(demo, "A");
        File b = new File(demo, "B");

        a.mkdir();
        b.mkdir();

        //在demo下创建c.jpg文件
        File file = new File(demo, "c.jpg");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取file的文件
        String name = file.getName();
        System.out.println(name);
        //删除a文件
        a.delete();
    }
}
```



## IO



​	I/O技术是非常实用的技术，用于处理设备之间数据的传输，入读写文件，网络传输等

​	按流的角色不同，分为：节点流，处理流

​	

| 分类     | 字节输入流           | 字节输出流            | 字符输入流        | 字符输出流         |
| -------- | -------------------- | --------------------- | ----------------- | ------------------ |
| 抽象基类 | InputStream          | OutputStream          | Reader            | Writer             |
| 访问文件 | FileInputStream      | FileOutputStream      | FileReader        | FileWriter         |
| 访问数组 | ByteArrayInputStream | ByteArrayOutputStream | CharArrayReader   | CharArrayWriter    |
| 缓冲流   | BufferedInputStream  | BufferedOutputStream  | BufferedReader    | BufferedWriter     |
| 转换流   |                      |                       | InputStreamReader | OutputStreamWriter |
| 对象流   | ObjectInputStream    | ObjectOutputStream    |                   |                    |
| 打印流   |                      | PrintStream           |                   | PrintWriter        |



* 节点流：直接从数据源或目的地读写数据

* 缓冲流：不直接连接到数据源目的地，而是连接到已存在的流之上，通过对数据的处理为程序提供更为强大的读写功能
* 程序中打开的文件Io资源不属于内存里的资源，垃圾回收机制无法回收该资源，所以应该显示关闭文件IO资源



### Reader&Writer



* 利用字符流读取文件

```java
/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-15 19:42
 **/
public class TestReader {

    public static void main(String[] args) {

        FileReader fileReader = null;
        try {
            //读取文件
             fileReader = new FileReader(new File("F:/E java.txt"));
             //设置缓冲区
            char[] chars = new char[1000];
            int len;
            //读入文件并输出
            while ((len = fileReader.read(chars)) != -1) {
                System.out.println(new String(chars,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



* 利用字符流写入文件

```java
/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-15 20:03
 **/
public class TestWriter {

    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            //指定路径
            fw = new FileWriter(new File("E:/test.txt"));
            //写入文件
            fw.write("study java good can eat delicious food!!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



### OutputStrean&InputStream

* 读取文件并复制

```java
/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-15 20:12
 **/
public class Test1 {

    @Test
    public void test() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            //读取文件
            fis = new FileInputStream(new File("F:/a.avi"));
            //复制到指定文件路径
            fos = new FileOutputStream(new File("F:/b.avi"));
            //设置缓冲区
            byte[] buff = new byte[1024];
            int len;
            //写入文件
            while ((len = fis.read(buff)) != -1) {
                fos.write(buff, 0, len);//共用118ms
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```





注意点：

* 定义文件路径时，可以用"/"或者"\\\\\";
* 在写入文件时，如果使用构造器FileOurputStream(file)，则目录下的同名文件被覆盖，如果使用构造器FileOutputStream(file,true)，则在目录末端追加文件内容
* 在读取文件时，必须保证文件存在，否则报异常
* 字节流操作字符文件，字节流操作字节文件



### 缓冲流



​	为了提高数据读写的速度，Java Api提供了带缓冲功能的流类，在使用这些流类时，会创建一个内部缓冲区数组，使用8192字节（8kb）的缓冲区。

```java
public class BufferedInputStream extends FilterInputStream {
    private static int DEFAULT_BUFFER_SIZE = 8192;
}
```



​	缓冲流要"套接"在节点流上，根据数据操作单位可以把缓冲流分为：

* BufferedInputStream&BufferedOutputStream
* BufferedReader&BufferedWriter



​	当读取数据时，数据按块读入缓冲区，其后的读操作则直接访问缓冲区

​	但使用缓冲流读取字节文件时，缓冲流会一次性从文件中读取8192kb，存在缓冲区，直到缓冲区装满了，才重新从文件中读取下一个8192kb字节数组

​	向流写入字节时，不会直接写到文件，先写到缓冲区直到缓冲区写满，缓冲流才会把缓冲区中的数据一次性的写到文件中，使用方法flush()可以强制将缓冲区的内容全部写入输出流

​	关闭流时可以直接关闭外层的缓冲流，系统也会自动的帮忙把内部的流关闭

​	

```java
public class TestBuffered {

    @Test
    public void test() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("F:/a.txt")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("F:/b.txt")));
            byte[] buff = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff,0,len);
    //            bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```





### 练习

1. 读入文件，计算其中每一个字符出现的个数并存入到map集合中

```java
/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-15 21:31
 **/
public class ToSecret {

    public static void main(String[] args) {
        FileReader fis = null;

        try {
            fis = new FileReader(new File("f:/a.txt"));
            char[] buff = new char[10];
            int len;
            HashMap<Character, Integer> map = new HashMap<>();
            while ((len = fis.read(buff)) != -1) {

                for (int i = 0; i < buff.length; i ++) {
                    if (map.get(buff[i]) == null) {
                        map.put(buff[i], 1);
                    } else {
                        map.put(buff[i], map.get(buff[i]) + 1);
                    }
                }
            }
            System.out.println(map);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

