# Linux

## 虚拟机的安装

* vm

## centos的安装

* 。。。

### vmtools创建windows和centos的共享文件夹

* 首先安装vmtools

* 在虚拟机点击安装中，然后复制vmtools的安装文件

* 到centos系统的：计算机-》文件系统-》opt-》下粘贴此安装文件

* 然后在当前文件夹中启动终端，输入以下命令行

* ```shell
  ll #查看当前目录的所有文件
  tar -zxvf VMware + Tab键 + 回车 #解压vmware文件夹
  cd vmware-tools-distrib #调用此文件夹
  ./vmware-install.pl #开始安装，一路回车即可
  ```

* 然后重启centos

* 命令行 --- **reboot**

### 创建共享文件夹

* 在window中创建一个文件夹myshare
* 然后在vm菜单中点击虚拟机-》设置-》共享-》共享文件夹-》总是打开-》找到myshare文件夹目录-》完成
* 在centos找到计算机-》mnt-》hgfs-》找到myshare即可

## Linux的目录结构

* Linux的文件系统是采用层级式的树状目录结构，**在此结构中最上层目录是 --- "/"**，然后在此目录下再创建其他目录。
* **在Linux世界中，一切皆文件**

## 远程登录Linux系统

* 安装xShell5工具
* 由于实际开发的时候，Linux系统在特定的位置，如果要部署项目或者是修改项目都需要远程登录Linux系统
* 安装好xShell5之后，直接在文件-》新建-》然后连接到Linux的ip地址，协议是SSH，端口号也不须改变
* 登录用户名和密码，连接即可用命令行操作

## vi和vim模式

![](F:\javaWeb\资料\截图\30.png)

### **常用快捷键**

* 复制光标所在行 -- 》**yy** --  复制当前行向下的4行（包括当前行）-- 》 **5yy**  -- 粘贴 --》**p**
* 删除当前行--》**dd**--- 删除当前行向下的4行（包括当前行）-- 》 **5dd**
* 撤销 --》**u**
* 显示文件的行号--》 **:set nu**  -- 取消行号的显示 --》 **:set no nu** 
* 在文件中查找某个单词 --》 **/单词**   **输入n就是查找下一个**
* 到达文档的最末行--》**G**  ---  到达文档的第一行--》**gg** --- 到达文档的指定行 --》**行数**  再按 **shift + g**
* 保存文件--》 **:wq**     没有修改直接退出--》**:q**  有修改但不想保存退出---》**:q!**

## 开机、重启和用户登录注销

### 关机、重启命令

* **shutdown**
  * **shutdown -h now ：立即关机**
  * **shutdown -h 1：一分钟后关机**
  * **shutdown -r now：立即重启**
* **halt：等价于关机**
* **reboot：重启系统**
* **sync：把内存的数据同步到磁盘中，一般在关机或者重启之前都会使用此命令，防止文件的流失**

### 用户登录和注销

* 登录时尽量少用root用户登录，因为root用户是系统管理员，拥有最大的权限，避免操作失误，可以利用普通用户登录，登录后再用"su - 用户名"命令来切换系统管理员身份

* **logout：注销当前用户**

## 用户管理

* Linux系统是一个多用户多任务的操作系统，任何一个要是用此系统资源的用户，都需要向系统管理员申请一个账户，然后以这个账户登录系统
* Linux用户需要属于至少一个组

### 添加用户

* 语法：

* 此操作需要系统管理员的权限

  ```shell
  useradd 用户名 #创建一个用户，指定用户名
  passwd 用户名 #给用户创建密码
  useradd -d 指定目录 指定用户 #在指定的目录下创建用户
  
  example：
  useradd LaoYu
  passwd LaoYu
  ...指定密码
  useradd -d /home/MyGirl XiaoMin
  passwd XiaoMin
  ...
  ```

* 说明：当用户创建成功后，会自动的创建和用户同名的家目录

* ```shell
  passwd 用户名 //可以给指定用户修改密码
  ```

### 删除用户

* 语法：

* ```shell
  userdel 用户名 //删除指定用户 但不删除用户的家目录
  userdel -r 用户名 //删除用户名及家目录
  
  example：
  -rw-r--r--. 1 root    root       0 11月 25 21:18 hello
  drwx------. 4 LaoYu   LaoYu   4096 11月 27 01:20 LaoYu
  drwx------. 4 XiaoMin XiaoMin 4096 11月 27 01:43 myGirl
  drwx------. 4 test1   test1   4096 11月 27 01:43 test1
  drwx------. 4 test2   test2   4096 11月 27 01:43 test2
  [root@hadoop home]# userdel test1
  [root@hadoop home]# userdel -r test2
  [root@hadoop home]# ll
  总用量 12
  -rw-r--r--. 1 root    root       0 11月 25 21:18 hello
  drwx------. 4 LaoYu   LaoYu   4096 11月 27 01:20 LaoYu
  drwx------. 4 XiaoMin XiaoMin 4096 11月 27 01:43 myGirl
  drwx------. 4     502     502 4096 11月 27 01:43 test1
  
  ```

* 一般在删除用户时不会删除家目录，因为家目录中可能有大量数据，需要保留

### 查看用户信息指令

``` shell
id 用户名 //查看用户名的信息
su - 用户名 //切换用户，到高权限用户切换到低权限用户时，不需要密码，反之需要密码
exit //退到登录用户
whodami //查看当前用户名
who am i //查看当前登录的用户

example：
[root@hadoop home]# id root //查看root用户名的信息
uid=0(root) gid=0(root) 组=0(root)
[root@hadoop home]# id LaoYu //查看LaoYu用户名的信息
uid=500(LaoYu) gid=500(LaoYu) 组=500(LaoYu)
[root@hadoop home]# id XiaoMin //查看XiaoMin用户名的信息
uid=501(XiaoMin) gid=501(XiaoMin) 组=501(XiaoMin)
[root@hadoop home]# su - LaoYu //切换到LaoYu用户
[LaoYu@hadoop ~]$ id root
uid=0(root) gid=0(root) 组=0(root)
[LaoYu@hadoop ~]$ cd /root/
-bash: cd: /root/: 权限不够
[LaoYu@hadoop ~]$ su - rooot
su: 用户rooot 不存在
[LaoYu@hadoop ~]$ su - root
密码：
su: 密码不正确
[LaoYu@hadoop ~]$ su - root
密码：
[root@hadoop ~]# su - XiaoMin
[XiaoMin@hadoop ~]$ whoami //查看当前用户名
XiaoMin
[XiaoMin@hadoop ~]$ who am i //查看当前登录的用户
root     pts/0        2020-11-27 01:43 (192.168.235.1)
[XiaoMin@hadoop ~]$ who am I
root     pts/0        2020-11-27 01:43 (192.168.235.1)

```

### 添加组-删除组

* 语法：

```shell
groupadd 组名 //添加组
groupdel 组名 //删除组
useradd -g 组名 用户名 //添加用户大到指定组
usermod -g 组名 用户名 //修改用户到指定组

example：
[root@hadoop ~]# groupadd study
[root@hadoop ~]# 
[root@hadoop ~]# groupdel study
[root@hadoop ~]# 
[root@hadoop ~]# groupadd myGirl
[root@hadoop ~]# 
[root@hadoop ~]# usermod -g myGirl XiaoMin
[root@hadoop ~]# 
[root@hadoop ~]# id XiaoMin
uid=501(XiaoMin) gid=502(myGirl) 组=502(myGirl)
[root@hadoop ~]# useradd -g myGirl LaoYu
useradd：用户“LaoYu”已存在
[root@hadoop ~]# 
[root@hadoop ~]# cd /home/
[root@hadoop home]# ll
总用量 12
-rw-r--r--. 1 root    root       0 11月 25 21:18 hello
drwx------. 4 LaoYu   LaoYu   4096 11月 27 02:32 LaoYu
drwx------. 4 XiaoMin XiaoMin 4096 11月 27 01:43 myGirl
drwx------. 4     502 myGirl  4096 11月 27 01:43 test1

```

### 用户和组的配置文件

* /etc/passwd文件
  * 用户的配置文件，记录用户的各种信息
  * 每行含义--用户名：口令：用户标识符：组标识符：注释性描述：主目录：登录shell

```shell
/etc/passwd

用户名：加密密码：用户标识符：组标识符：注释性描述：主目录：登录shell
LaoYu:x:500:500::/home/LaoYu:/bin/bash
XiaoMin:x:501:502::/home/myGirl:/bin/bash
```

* /etc/shadow
  * 口令的配置文件
  * 每行含义--登录名：加密口令：最后一次修改时间：最小时间间隔：最大事件间隔：警告时间：不活动时间：失效时间：标志
* /etc/group文件
  * 组的配置文件，记录Linux包含组的信息
  * 每行含义--组名：口令：组标志符：组内用户列表

## Linux实用指令

### 运行级别

0. 关机

1. 单用户模式
2. 多用户无网络模式
3. 多用户有网络模式
4. 保留级别
5. 图形化界面
6. 重启

* 常用级别是3和5，要更改默认的运行级别，需要更改配置文件--**/etc/inittab** 的--**id：5：initdefault**--这一行

* 可以在终端在中输入 init + id 来切换运行级别

```shell
init 3  //切换到运行级别3
然后需要重新登录，再使用命令行切换回来
init 5  即可
```

* 当忘记root密码时，就可以进入单用户模式，修改root密码
* passwd --- root

### 帮助指令

* man -- 接指令
* 可以查看指令的帮助信息
* help -- 指令获取shell内置命令的帮助信息

```shell
man ls
LS(1)                            User Commands                           LS(1)

NAME
       ls - list directory contents

SYNOPSIS
       ls [OPTION]... [FILE]...

DESCRIPTION
       List  information  about the FILEs (the current directory by default).  Sort entries alphabetically
       if none of -cftuvSUX nor --sort.

       Mandatory arguments to long options are mandatory for short options too.


[root@hadoop 桌面]# help cd
cd: cd [-L|-P] [dir]
    Change the shell working directory.
    
    Change the current directory to DIR.  The default DIR is the value of the
    HOME shell variable.
```

### 文件目录类指令

| 指令                             | 功能                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| ***pwd***                        | 查看当前所在目录                                             |
| ***ls***                         | 查看当前目录的文件                                           |
| ***ls -a***                      | 查看当前目录的所有文件(包括隐藏文件)                         |
| ***ls -l***                      | 以列表的形式查看当前目录的文件(排版好看)                     |
| ***cd 目录***                    | 切换工作路径  ..  代表上一个目录       绝对路径：从/目录出发 |
| ***cd ~***  /   ***cd 回车***    | 表示回到家目录                                    相对目录：从当前目录出发 |
| ***mkdir  目录***                | 创建一个目录                                                 |
| ***mkdir  -p  多级目录***        | 创建一个多级目录                                             |
| ***rmdir  目录***                | 删除指定的非空目录                                           |
| ***rm -rf  目录***               | 删除指定目录                                                 |
| ***touch  文件1.txt 文件2.txt*** | 在当前目录创建空文件(可以一次性创建多个文件)                 |
| ***cp  文件.txt   指定目录***    | 拷贝当前目录下的文件夹到指定目录                             |
| ***cp -r 目录   指定目录***      | 拷贝当前目录下的目录到指定目录，-r表示递归拷贝，拷贝全部文件 |

```shell
[root@hadoop home]# ls
hello  LaoYu  myGirl
[root@hadoop home]# touch test.txt  //在当前目录下创建test.txt文件
[root@hadoop home]# ls
hello  LaoYu  myGirl  test.txt
[root@hadoop home]# mkdir GuGe		//在当前目录下创建GuGe目录
[root@hadoop home]# ls
GuGe  hello  LaoYu  myGirl  test.txt
[root@hadoop home]# cp test.txt GuGe  //将当前目录下的test.txt拷贝到当前目录下的GuGe目录下
[root@hadoop home]# cd GuGe
[root@hadoop GuGe]# ls
test.txt
[root@hadoop GuGe]# cd ..  					//回到上一级目录
[root@hadoop home]# ls
GuGe  hello  LaoYu  myGirl  test.txt
[root@hadoop home]# cp hello GuGe         //拷贝一个空目录到GuGe目录
[root@hadoop home]# cd GuGe
[root@hadoop GuGe]# ls
hello  test.txt
[root@hadoop GuGe]# cd ..
[root@hadoop home]# mkdir demo
[root@hadoop home]# ls
demo  GuGe  hello  LaoYu  myGirl  test.txt
[root@hadoop home]# cd demo
[root@hadoop demo]# ls
[root@hadoop demo]# touch a.txt b.txt c.txt   //在当前目录下创建多个文件
[root@hadoop demo]# ls
a.txt  b.txt  c.txt
[root@hadoop demo]# cd ..
[root@hadoop home]# ls
demo  GuGe  hello  LaoYu  myGirl  test.txt
[root@hadoop home]# cp demo GuGe			//这里不能直接拷贝，因为demo目录有文件需要加上 -r
cp: 略过目录"demo"
[root@hadoop home]# cp -r demo GuGe
[root@hadoop home]# cd GuGe/demo
[root@hadoop demo]# ls
a.txt  b.txt  c.txt
[root@hadoop demo]# cd ..
[root@hadoop GuGe]# cd ..
[root@hadoop home]# cp -r demo GuGe			//当需要拷贝时有相同目录的话，需要确定文件的覆盖在前面加上反斜杠就能强制覆盖
cp：是否覆盖"GuGe/demo/c.txt"？ y
cp：是否覆盖"GuGe/demo/b.txt"？ y
cp：是否覆盖"GuGe/demo/a.txt"？ y
[root@hadoop home]# \cd demo GuGe
```

| rm -r  目录                      | 递归删除整个目录，但需要判断                               |
| -------------------------------- | ---------------------------------------------------------- |
| **rm -rf  目录**                 | **不需判断，直接删除目录或者文件夹**                       |
| **mv test.txt abc.txt**          | **改变文件名，将当前test.txt改名为abc.txt**                |
| **mv abc.txt /root/**            | **将当前的abc.txt文件夹剪切到/root/下**                    |
| **cat  -n  目录/文件**           | **读取文件，只读不写，-n表示显示行号，会一下显示所有内容** |
| **cat  -n  目录/文件  \|  more** | **一页一页的显示文件，空格显示下一页，enter键显示下一行**  |
| **more 目录/文件**               | **一页一页的显示文件，空格显示下一页，enter键显示下一行**  |
| **less  目录  文件**             | **也是显示文件，主要用于阅读大文件**                       |

```shell
example
[root@hadoop home]# rm test
rm: 无法删除"test": 是一个目录
[root@hadoop home]# rm -f test
rm: 无法删除"test": 是一个目录
[root@hadoop home]# rm -r test
rm：是否进入目录"test"? 
[root@hadoop home]# rm -r test
rm：是否进入目录"test"? y
rm：是否删除普通空文件 "test/c.txt"？
rm：是否删除普通空文件 "test/b.txt"？
rm：是否删除普通空文件 "test/a.txt"？
rm：是否删除目录 "test"？
[root@hadoop home]# rm -rf test
[root@hadoop home]# ls
GuGe  hello  LaoYu  XiaoMin
[root@hadoop home]# vim hello
[root@hadoop home]# mv hello /root/
[root@hadoop home]# cd /root
[root@hadoop ~]# ls
abc.txt  anaconda-ks.cfg  hello  Hello.java  install.log  install.log.syslog  公共的  模板  时间复杂度.bmp  视频  图片  文档  下载  音乐  桌面
[root@hadoop ~]# mv abc.txt /home/
[root@hadoop ~]# cd home
-bash: cd: home: 没有那个文件或目录
[root@hadoop ~]# cd /home
[root@hadoop home]# ls
abc.txt  GuGe  LaoYu  XiaoMin

```

### 追加文件内容与覆盖

```shel
>指令 和 >> 指令
>指令表示重定向，也就是覆盖
>>指令表示追加

ls -l > 文件  （将列表中的内容写入到文件中，（有此文件就覆盖文件，没有此文件就创建并写入））
ls -l >> 文件  （将列表中的追加写入到文件中）
cat 文件1 > 文件2   (将文件1的内容覆盖到文件2中)
cat 文件1 >> 文件2   (将文件1的内容追加到文件2中)
echo "内容" > 文件  （将内容覆盖文件中）
echo "内容" >> 文件  （将内容追加到文件中）

[root@hadoop home]# more a.txt 
hello
[root@hadoop home]# ls -l >> a.txt 
[root@hadoop home]# more a.txt 
hello
总用量 16
-rw-r--r--.  1 root    root       0 11月 30 17:11 abc.txt
-rw-r--r--.  1 root    root       6 12月  7 21:10 a.txt
drwxr-xr-x.  3 root    root    4096 11月 30 17:15 GuGe
drwx------. 25 LaoYu   LaoYu   4096 11月 30 14:15 LaoYu
drwx------.  4 XiaoMin XiaoMin 4096 12月  7 16:48 XiaoMin
[root@hadoop home]# echo "hello" > a.txt 
[root@hadoop home]# more a.txt 
hello
[root@hadoop home]# ls
abc.txt  a.txt  GuGe  LaoYu  XiaoMin
[root@hadoop home]# cat a.txt > b.txt
[root@hadoop home]# more b.txt 
hello
[root@hadoop home]# echo "内容" >> b.txt 
[root@hadoop home]# more b.txt 
hello
内容

```

| echo  “内容” / echo $PATH  | 输出内容                                                     |
| -------------------------- | ------------------------------------------------------------ |
| **head -n 5 文件**         | **查看文件的前五行内容，5可以改变**                          |
| **tail -n 5 文件**         | **查看文件后五行内容，5可以改变**                            |
| **tail -f 文件**           | **实时监控文件的内容，看文件是否会有所变化，Ctrl+c退出此指令** |
| **ln -s  /pot  linkToOpt** | **在当前目录下创建软连接，连接到/opt目录**                   |
| **rm -r linkToOpt**        | **删除软连接，千万不能带/，不然会删除整个软连接连接的目录**  |
| **history**                | **查看历史命令   （!n，可以使用历史的第n的命令）**           |

```shell
[root@hadoop home]# ln -s /opt linkToOpt
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  linkToOpt  XiaoMin
[root@hadoop home]# cd linkToOpt/
[root@hadoop linkToOpt]# ls
rh  VMwareTools-10.0.5-3228253.tar.gz  vmware-tools-distrib
[root@hadoop linkToOpt]# pwd
/home/linkToOpt
[root@hadoop linkToOpt]# cd ..
[root@hadoop home]# rm -r linkToOpt
rm：是否删除符号链接 "linkToOpt"？y
[root@hadoop /]# history
    1  cd /
    2  cd
    3  ll
    4  cd /opt/
    5  ls
    6  tar -zxvf VMwareTools-10.0.5-3228253.tar.gz 
	...
!1  执行  --cd / 命令
```

### 时间日期类

| date                              | 获取当前时间                 |
| --------------------------------- | ---------------------------- |
| **date "+%Y-%m-%d  %H:%M:%S"**    | **显示时间的时分秒，年月日** |
| **date -s "+%Y-%m-%d  %H:%M:%S"** | **修改当前时间为。。。**     |
| **cal 2020**                      | **显示2020的所有月份**       |

### 搜索查找类

| find 指定目录范围  -name  目录名/文件名  | 查找指定目录范围下的文件或者目录                             |
| ---------------------------------------- | ------------------------------------------------------------ |
| **find 指定目录范围  -user   用户**      | **查找指定目录下的用户所有文件**                             |
| **find 指定目录范围 -size  +n/-n/nM(k)** | **查找指定目录下大于/小于/等于n-M(k)的所有文件**             |
| **locate  文件**                         | **locate必须先创建数据库文件，使用指令updatedb，快速查找文件** |

```shell
[root@hadoop home]# find / -name LaoYu
/home/LaoYu
/var/spool/mail/LaoYu
/var/cache/gdm/LaoYu
[root@hadoop home]# find / -user LaoYu
/home/LaoYu
/home/LaoYu/下载
/home/LaoYu/.config
/home/LaoYu/.config/ibus
/home/LaoYu/.config/ibus/bus
/home/LaoYu/.config/ibus/bus/0a083ce4a2fd29c7287b31a800000014-unix-0
...
[root@hadoop home]# find / -name a.txt
/home/GuGe/demo/a.txt
[root@hadoop home]# updatedb
[root@hadoop home]# locate a.txt
/home/GuGe/demo/a.txt
/usr/share/doc/vim-common-7.4.629/README_extra.txt
/usr/share/gnupg/help.ca.txt
/usr/share/gnupg/help.da.txt

```

### 管道符

* **|**   ，将前一个指令的结果交给后一个指令处理   
* **grep** 过滤查找指令

```shell
[root@hadoop home]# cat abc.txt  (查看abc.txt文件内容)
nclsa
yy
jj
ll
uu
yy
,l ,l
lsad

[root@hadoop home]# cat abc.txt | grep yy 
yy
yy
[root@hadoop home]# cat abc.txt | grep -n  yy   (显示行号)
2:yy
6:yy
[root@hadoop home]# vim abc.txt 
[root@hadoop home]# cat abc.txt 
nclsa
yy
jj
ll
uu
yy
,l ,l
lsad
YY
YY
[root@hadoop home]# cat abc.txt | grep -ni  yy   (不区分大小写)
2:yy
6:yy
9:YY

```

### 解压与压缩指令

| gzip  文件                                                   | 压缩文件到当前目录                                   |
| ------------------------------------------------------------ | ---------------------------------------------------- |
| **unzip  文件**                                              | **解压文件到当前目录**                               |
| **zip myText.gz  指定文件**                                  | **压缩指定的文件到当前目录，取名为myText.gz**        |
| **zip -r  myPackage.gz 指定目录**                            | **压缩指定的目录到当前目录，取名为myPackage.gz**     |
| **unzip -d 指定目录  xxxx.gz**                               | **解压xxxx.gz到指定目录**                            |
| **tar -zcvf  xxx.tar.gz  指定的文件或目录**                  | **压缩指定的文件或目录到当前目录，取名为xxx.tar.gz** |
| **z表示支持gzip解压文件  c表示压缩文件或目录  v表示显示操作过程** | **f表示指定压缩文件  x表示解压文件或目录**           |
| **tar -zxvf xxx.tar.gz**                                     | **解压xxx.tar.gz到当前目录**                         |
| **tar -zxvf xxx.tar.gz  -C  指定目录**                       | **解压xxx.tar.gz到指定目录**                         |

* **gzip与gunzip**

```shel

[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  XiaoMin
[root@hadoop home]# gzip b.txt 
[root@hadoop home]# ls
abc.txt  b.txt.gz  GuGe  LaoYu  XiaoMin
[root@hadoop home]# gunzip b.txt.gz 
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  XiaoMin
[root@hadoop home]# gzip abc.txt  b.txt 
[root@hadoop home]# ls
abc.txt.gz  b.txt.gz  GuGe  LaoYu  XiaoMin
[root@hadoop home]# gunzip abc.txt.gz b.txt.gz 
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  XiaoMin

```

* **zip与unzip**

```shel
[root@hadoop home]# zip -r myTest.gz GuGe/
  adding: GuGe/ (stored 0%)
  adding: GuGe/demo.zip (stored 0%)
...省略操作过程
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  myFile.tar.gz  myTest.gz  XiaoMin
[root@hadoop home]# unzip -d /opt/tmp myTest.gz 
Archive:  myTest.gz
   creating: /opt/tmp/GuGe/
...省略操作过程     
[root@hadoop home]# cd /opt/tmp
[root@hadoop tmp]# ls
GuGe

```

* **tar**

``` shell
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zcvf m.tar.gz  abc.txt 
abc.txt
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zcvf m.tar.gz  GuGe/ 
GuGe/
GuGe/demo.zip
...省略操作过程
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zxvf m.tar.gz 
GuGe/
GuGe/demo.zip
...省略操作过程
[root@hadoop home]# ls
abc.txt  b.txt  GuGe  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# rm -rf abc.txt GuGe/
[root@hadoop home]# ls
b.txt  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# ls
b.txt  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zxvf m.tar.gz 
GuGe/
GuGe/demo.zip
...省略操作过程
[root@hadoop home]# ls
b.txt  GuGe  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zcvf b.txt GuGe/
GuGe/
GuGe/demo.zip
...省略操作过程
[root@hadoop home]# ls
b.txt  GuGe  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# rm -rf GuGe/ b.txt 
[root@hadoop home]# ls
LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zxvf m.tar.gz 
GuGe/
GuGe/demo.zip
...省略操作过程
[root@hadoop home]# ls
GuGe  LaoYu  m.tar.gz  myFile.tar.gz  XiaoMin
[root@hadoop home]# tar -zxvf m.tar.gz -C /opt/tmp
GuGe/

```

## 组管理

* **在linux中每个用户都必须属于一个组，不能独立于组外**
* **文件的所有者、所在组、其他组**
* **chown  指定用户  指定文件 --  改变文件的所有者**
* **chgrp  指定组  指定文件  --  改变文件的所在组**

```shell
[root@hadoop ~]# groupadd police    (创建police组)
[root@hadoop ~]# useradd -g police tom   (创建tom用户，添加到police组中)
[root@hadoop ~]# id tom
uid=502(tom) gid=502(police) 组=502(police)
[root@hadoop ~]# su - tom     (切换到tom用户登录)
[tom@hadoop ~]$ pwd    
/home/tom
[tom@hadoop ~]$ touch banana.txt   (创建banana.txt文件)
[tom@hadoop ~]$ ll -ah         
总用量 28K
drwx------. 4 tom  police 4.0K 12月  8 16:16 .
drwxr-xr-x. 6 root root   4.0K 12月  8 16:16 ..
-rw-r--r--. 1 tom(banana.txt文件所有者)  police(banana.txt所在组)    0 12月  8 16:16 banana.txt
[root@hadoop ~]# groupadd bank     
[root@hadoop ~]# useradd -g bank manager
[root@hadoop ~]# id manager
uid=503(manager) gid=503(bank) 组=503(bank)
[root@hadoop ~]# cd /home/tom
[root@hadoop tom]# ll
总用量 0
-rw-r--r--. 1 tom police 0 12月  8 16:16 banana.txt
[root@hadoop tom]# chown manager banana.txt    (改变banana.txt的所有者为mananger)
[root@hadoop tom]# ll
总用量 0
-rw-r--r--. 1 manager police 0 12月  8 16:16 banana.txt
[root@hadoop tom]# chgrp bank banana.txt   (改变banana.txt文件的所在组为bank)
[root@hadoop tom]# ll
总用量 0
-rw-r--r--. 1 manager bank 0 12月  8 16:16 banana.txt
[root@hadoop tom]# usermod -g police  manager  (修改manager成员的所在组为police)
[root@hadoop tom]# ll
总用量 0
-rw-r--r--. 1 manager bank 0 12月  8 16:16 banana.txt
[root@hadoop tom]# usermod -g bank tom
[root@hadoop tom]# ll
总用量 0
-rw-r--r--. 1 manager bank 0 12月  8 16:16 banana.txt

```

### **权限解析

```shell
drwxr-xr-x.  3 root    root    4.0K 12月  8 13:04 GuGe
```

* 解析

* 第0位：(***d***)代表的是目录；若是(***-***)的话代表文件；(***l***)代表链接;(***c***)代表字符设备【键盘..】；(***b***)代表块文件，硬盘
* 第1-3位：***rwx***  --  代表了**文件或者目录所有者**有读的权限(read)，写的权限(write),以及执行的权限(execute)
* 第4-6位：**r-x**  --  代表了**文件所在组的用户**的权限，可读，不可写，可执行
* 第7-9位：**r-x**  --  代表了**文件其他组的用户**的权限，可读，不可写，可执行
* 3 ：如果是文件，表示的是**硬连接的数**；如果是目录则表示的是**该目录的子目录个数**
* 4.0： 不需多说；如果是目录的话，就是4096
* 12 月  8  13:04 ：表示最后一次修改的时间

#### **rwx权限解析

* 作用于文件：
  * r代表可读：**可以读取，查看**
  * w代表可写：**可以修改，但不代表可以删除文件，删除文件的前提是对该文件所在目录有写权限，才能删除文件**
  * x代表可执行：**可以被执行**
* 作用于目录：
  * r代表可读：**ls查看目录内容**
  * w代表可写：**可以修改，在目录中创建、删除、重命名目录**
  * x代表可执行：**可以进入该目录**

##  ***权限管理

```shell
* chmod u=rwx g=rwx o=rwx  文件名/目录
* chmod a=rwx   文件名/目录
* chmod u+w g-r o+x  文件名/目录
* chmod 735   文件名/目录
* chown -R tom 文件名/目录
* chgrp -R bank 文件名/目录
```

* **chmod --  可以用来修改文件或者目录所有者、所在组、其他组的权限**
* **其中   u = 所有者  、 g = 所在组成员 、  o = 其他组成员  、 a 表示所有成员**
* **u = rwx 赋予所有者有rwx权限...**
* **u  +  r  增加所有者r权限...**
* **u  -  r  去掉所有者r权限**
* **735   表示  u=7、g=3、o=5  ；其中r=4，w=2，x=1；r+w=6、r+x=5、w+x=3、r+w+x=7；**
* **chown  - -  可以用来改变文件所有者，加 -R  表示可以对目录及其目录下的所有文件/子目录修改所有者**
* **chgrp- -  可以用来改变文件所在组，加 -R  表示可以对目录及其目录下的所有文件/子目录修改所在组**

example：

```shell
[tom@hadoop home]$ cd GuGe/
[tom@hadoop GuGe]$ touch a.txt
touch: 无法创建"a.txt": 权限不够
[tom@hadoop GuGe]$ exit
logout
[root@hadoop home]# chmod o=rwx GuGe/
[root@hadoop home]# ll
总用量 32
...
drwxr-xrwx.  3 root    root    4096 12月  8 13:04 GuGe
...
[root@hadoop home]# su - tom
[tom@hadoop ~]$ cd ..
[tom@hadoop home]$ cd GuGe/
[tom@hadoop GuGe]$ touch a.txt
[tom@hadoop GuGe]$ ll
总用量 8
-rw-r--r--. 1 tom  bank    0 12月  9 13:13 a.txt
drwxr-xr-x. 2 root root 4096 11月 30 17:15 demo
-rw-r--r--. 1 root root  324 12月  8 12:39 demo.zip
-rw-r--r--. 1 root root    0 11月 30 17:13 hello
-rw-r--r--. 1 root root    0 11月 30 17:12 test.txt
...
[tom@hadoop GuGe]$ cd home
-bash: cd: home: 没有那个文件或目录
[tom@hadoop GuGe]$ cd ..
[tom@hadoop home]$ mkdir kk
mkdir: 无法创建目录"kk": 权限不够
[tom@hadoop home]$ exit
logout
You have new mail in /var/spool/mail/root
[root@hadoop home]# mkdir kk
[root@hadoop home]# cd kk
[root@hadoop kk]# touch a.txt b.txt 
[root@hadoop kk]# ll
总用量 0
-rw-r--r--. 1 root root 0 12月  9 13:17 a.txt
-rw-r--r--. 1 root root 0 12月  9 13:17 b.txt
[root@hadoop kk]# cd ..
[root@hadoop home]# chown -R tom kk
[root@hadoop home]# ll
总用量 36
-rw-r--rw-.  1 root    root       7 12月  9 13:05 a.txt
-rw-r--r--.  1 root    root       0 12月  9 12:58 b.txt
-rw-r--r--.  1 root    root       0 12月  9 12:58 c.txt
drwxr-xrwx.  3 root    root    4096 12月  9 13:14 GuGe
drwxr-xr-x.  2 tom     root    4096 12月  9 13:17 kk
drwx------. 25 LaoYu   LaoYu   4096 11月 30 14:15 LaoYu
drwx------.  4 manager bank    4096 12月  8 16:21 manager
-rwxrwxrwx.  1 root    root     471 12月  8 13:13 m.tar.gz
-rw-r--r--.  #1 root    root     368 12月  8 12:54 myFile.tar.gz

```

### 权限练习

1. 创建 police 组和 bandit 组
2. jack ，Jerry  属于police组；bob，alan属于bandit组
3. jack创建一个文件，自己可以读写，本组人可以读，其他组没有任何权限
4. jack修改该文件，让其他人可以读，本组人可以读写
5. bob投靠警察，看看是否可以读写

```shell
Example:
[jack@hadoop ~]$ touch a.txt
[jack@hadoop ~]$ ll
总用量 0
-rw-r--r--. 1 jack police 0 12月  9 16:25 a.txt
[jack@hadoop ~]$ chmod 640 a.txt 
[jack@hadoop ~]$ ll
总用量 0
-rw-r-----. 1 jack police 0 12月  9 16:25 a.txt
[jack@hadoop ~]$ chmod g=rw,o=r a.txt 
[jack@hadoop ~]$ ll
总用量 0
-rw-rw-r--. 1 jack police 0 12月  9 16:25 a.txt

[bob@hadoop home]$ cd jack
-bash: cd: jack: 权限不够
[bob@hadoop home]$ usermod -g police
-bash: /usr/sbin/usermod: 权限不够

[root@hadoop home]# usermod -g police bob
[root@hadoop home]# chmod g=rwx jack/

[bob@hadoop home]$ ll
drwxrwx---.  4 jack    police  4096 12月  9 16:25 jack
[bob@hadoop home]$ cd jack
-bash: cd: jack: 权限不够
(此时需要重新登录)

[bob@hadoop home]$ cd jack/
[bob@hadoop jack]$ ll
总用量 0
-rw-rw-r--. 1 jack police 0 12月  9 16:25 a.txt
[bob@hadoop jack]$ cat a.txt 
[bob@hadoop jack]$ vim a.txt 
[bob@hadoop jack]$ cat a.txt 
sjsjsj
```

## 任务调度

* crontab -e： 进入任务调度
* crontab  -r：终止任务调度
* crontab -l：列出当前有那些任务调度
* service crontab restart：【重启任务调度】

```shell
[root@hadoop home]# crontab -e
(编辑模式)

*/1 * * * * echo "hello" a.txt

crontab: installing new crontab
```

| 第一个*     | 表示一小时的第几分钟     |
| ----------- | ------------------------ |
| **第二个*** | **表示一天中的几小时**   |
| **第三个*** | **表示一个月的第几天**   |
| **第四个*** | **表示一年中的第几个月** |
| **第五个*** | **表示星期几**           |

| *       | 代表任何时间，第一个*就代表每一小时的每一分钟都执行命令      |
| ------- | ------------------------------------------------------------ |
| **，**  | **代表不连续的时间，比如0  8,10,12 * * * 就表示每天的12时0分，8时0分，10时0分都执行命令** |
| **-**   | **代表连续的时间范围，比如0 12 * * 1-5  就表示星期一到星期五的12点0分都执行命令** |
| ***/n** | **代表每个多少时间执行一次，比如*/10 * * * * 就表示每个10分钟执行一次** |

* 案例演示：

  1. 每隔一分钟就将“hello”追加到home下的c.txt文件中

  ```shell
  [root@hadoop home]# more myfirst.sh 
  echo "hello" >> /home/b.txt
  [root@hadoop home]# vim myfirst.sh
  (编辑模式)
  echo "hello" >> /home/c.txt
  
  [root@hadoop home]# crontab -l
  */1 * * * *  /home/myfirst.sh
  [root@hadoop home]# more c.txt 
  hello
  [root@hadoop home]# crontab -r
  [root@hadoop home]# crontab -l
  no crontab for root
  ```

  

### 工作的使用指令

* 显示磁盘分区

  ```shell
  [root@hadoop home]# df -l
  Filesystem     1K-blocks    Used Available Use% Mounted on
  /dev/sda3       18244476 3487332  13823720  21% /
  tmpfs            1019188      76   1019112   1% /dev/shm
  /dev/sda1         194241   39358    144643  22% /boot
  /dev/sr0         3824484 3824484         0 100% /media/CentOS_6.8_Final
  
  [root@hadoop home]# du -ach --max-depth=1 /opt
  4.0K	/opt/rh
  214M	/opt/vmware-tools-distrib
  4.0K	/opt/tmp
  69M	/opt/VMwareTools-10.0.5-3228253.tar.gz
  283M	/opt
  283M	总用量
  
  ```

* 统计/home下的文件个数

  ```shell
  ll /home | grep "^-" | wc -l，^-表示以-打头，wc表示统计数量
  ```

* 统计/home下的目录个数

  ```shell
  ll /home | grep "^d" | wc -l
  ```

* 统计/home记home下的所有子目录文件数量

  ```shell
  ll -R /home | grep "^-" wc -l
  ```

* 统计文件夹下目录及子目录的数量

  ```shell
  ll -R /home | grep "^d" | wc -l
  ```

* 以树状显示目录

  ```shell
  
  ```

  ## 进程管理

  ps  -aux  ：查看当前进程

  ps  -aux  |  grep xxx   查看指定的进程

  ps -ef  |  more  可以查看进程的父进程

  