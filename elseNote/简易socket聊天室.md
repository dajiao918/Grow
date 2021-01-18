## Socket聊天室



​	socket套接字有服务端和客户端之分，只要有正确的ip地址和端口号，服务端和客户端都可以接收和传输数据

​	那么想要实现聊天室，就需要服务端来中转客户端的消息，然后发送给其他的客户端，这样就能实现一个基本的聊天室功能

​	首先就是实现一个服务端能收到一个客户端的发来的消息并且输出到控制台

* 服务端

```java
public class SocketChat {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(1324);
            while (true) {
                //监听客户端的连接
                Socket socket = ss.accept();
                System.out.println(socket.getLocalAddress() + "-" + socket.getLocalPort() + "进入聊天室");
                //启动线程，用于接收客户端的数据并且打印到控制台
                new Thread(new SocketThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketThread implements Runnable{

    Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = br.readLine();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```



* 客户端

```java
public class Client1 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),1324);
            //推送流
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            //读取控制台的输入
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(socket.getLocalAddress() + "成功上线");
            while (true) {
                //传输数据到服务端
                pw.println("客户端1：" + br.readLine());
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```



​	观看上面的代码，可以知道服务端运用了有两个线程，主线程用于监听客户端的请求，副线程用于接收客户端的数据并打印到控制台，这里用到了readLine()函数，这个方法每次只读一行，在遇到回车或者是换行符之前会阻塞，客户端输入数据到控制台之后按下回车键，客户端的readLine()函数读取到了输入的数据，但是不会读取到回车，这时PrintWriter的println函数就给readLine()输送的内容加了一个回车键，这样就避免了服务端的readLine()函数接收到的数据没有回车键而造成阻塞，而while循环是让服务端进行下一次循环，执行readLine()函数，直到客户端的bufferedReader读取到了数据PrintWriter传输过来...pw每次都要flush()刷新缓冲区，不然的话就会造成服务端要等到pw的缓冲区满了之后才能接受到数据

​	接下来就可以实现服务端向客户端推送消息了，这里其实跟客户端推送消息差不多的，首先在线程中建立一个PrintWriter流，运用println方法推送给客户端，而客户端只要有一个接受消息的线程就可以了



```java
/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-18 11:23
 **/
public class SocketChat {

    public static void main(String[] args) {

        try {
            ServerSocket ss = new ServerSocket(1324);
            while (true) {
                Socket socket = ss.accept();
                System.out.println(socket.getLocalAddress() + "-" + socket.getLocalPort() + "进入聊天室");
                new Thread(new SocketThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketThread implements Runnable{

    Socket socket;

    public SocketThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String str = br.readLine();
                System.out.println(str);

                //推送消息给客户端
                PrintWriter pw = new PrintWriter(socket.getOutputStream());
                pw.println(str);
                pw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * @program: IO
 * @description:
 * @author: Mr.Yu
 * @create: 2021-01-18 11:29
 **/
public class Client1 {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),1324);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(socket.getLocalAddress() + "成功上线");
            while (true) {
                pw.println("客户端1：" + br.readLine());
                pw.flush();
                new Thread(new ClientThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientThread implements Runnable{

    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            //接受服务端的消息
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String read = br.readLine();
                //输出到控制台
                System.out.println(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



​	现在已经实现了一个服务端向一个客户端中转消息了，接下来只需要在增加一个客户端就可以了，但是呢这时候服务端推送消息时只是把每个服务端自己的消息又推送了回去，我们要的是客户端之间交互消息，所以这样肯定是不行的，在推送消息的时候我们需要得到所有客户端的socket套接字，然后群发消息...所以在一开始监听客户端连接的时候就应该用一个数据结构将每个客户端存储起来，以便后面消息的推送



* 服务端

```java
public class SocketChat {

    protected static List<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {

            ServerSocket ss = new ServerSocket(1234);
            System.out.println("服务端已连接~~~");
            while (true) {
                Socket socket = ss.accept();
                //记录每一个客户端
                sockets.add(socket);
                System.out.println("客户端" + socket.getLocalAddress() + "--" + socket.getLocalPort() + "进入聊天室");
                new Thread(new SocketThread(socket)).start();
            }
    }
}

class SocketThread implements Runnable{

    Socket socket;

    public SocketThread(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;
        try {
            //将字节流转换为字符流，并用缓冲流包住，方便调用readLine方法
            while (true) {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String readLine = br.readLine();
                System.out.println(readLine);

                //群发消息
                for (Socket socket : SocketChat.sockets) {
                    PrintWriter pw = new PrintWriter(socket.getOutputStream());
                    pw.println(readLine);
                    pw.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
```

* 客户端1

```java
public class Client1 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 1234);
        System.out.println(socket.getLocalAddress() + "成功上线");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream());
        while (true) {
            writer.println("客户端1：" + reader.readLine());
            writer.flush();
            new Thread(new ClientThread(socket)).start();
        }

    }
}

class ClientThread implements Runnable{

    Socket socket;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String readLine = br.readLine();
                System.out.println(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```



* 客户端2

```java
public class Client2 {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),1234);
        System.out.println(socket.getLocalAddress() + "成功上线");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());

        while (true) {
            printWriter.println("客户端2：" + bufferedReader.readLine());
            printWriter.flush();
            new Thread(new ClientThread2(socket)).start();
        }
    }
}

class ClientThread2 implements Runnable{

    Socket socket = null;

    public ClientThread2(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {

                String readLine = bufferedReader.readLine();
                System.out.println(readLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
```



​	在服务端的群发消息的时候客户端1不用接收自己的消息，所以在循环的时候加一个条件，不接收自己的消息就行了

```java
if (this.socket != socket) {
   // 推送消息代码
}
```



​	socket聊天室基本完成，运用到了流，线程，和网络编程，也算对知识有所深入的理解了~~