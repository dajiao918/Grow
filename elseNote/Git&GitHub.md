# Git&GitHub

##  本地库初始化

```shell
cd /f/workSpaces/test
git init 
cd .git/
ll -a
drwxr-xr-x 1 Administrator 197121   0 12月 23 13:00 ./
drwxr-xr-x 1 Administrator 197121   0 12月 23 12:53 ../
-rw-r--r-- 1 Administrator 197121 179 12月 23 12:55 config
-rw-r--r-- 1 Administrator 197121  73 12月 23 12:53 description
-rw-r--r-- 1 Administrator 197121  23 12月 23 12:53 HEAD
drwxr-xr-x 1 Administrator 197121   0 12月 23 12:53 hooks/
drwxr-xr-x 1 Administrator 197121   0 12月 23 12:53 info/
drwxr-xr-x 1 Administrator 197121   0 12月 23 12:53 objects/
drwxr-xr-x 1 Administrator 197121   0 12月 23 12:53 refs/

```

## 设置签名

> 设置系统签名
>
> 形式：
>
> ​		用户名：tom
>
> ​		email地址：goodmorning1@163.com
>
> 作用：区分不同的开发人员身份
>
> 命令：
>
> *  项目级别/仓库级别：仅在本地仓库范围有效
>
>   ```shell
>   git config user.name tom
>   git config user.email goodmoring123@163.com
>   ```
>
> *  系统用户级别：登录当前操作系统的用户权限范围
>
>   ```shell
>   git config --global user.name tom
>   git config --global user.email goodmoring123@163.com
>   ```
>
> * 优先级：就近原则，项目级别优先于系统级别，二者都有时，采用项目级别
> * 二者必须至少有一个

##	添加提交和查看状态

> 状态查看
>
> * git status
> * 查看工作区，暂存区
>
> 添加操作
>
> * git add
> * 将工作区新建或者修改的文件添加到暂存区
>
> 提交操作
>
> * git commit
> * 将暂存区的内容提交到本地库
>
> 查看历史记录
>
> * git log
>
> ```shell
> commit 9d9e8e145a352279b42d13a84c7719b6d0ba0c29 (HEAD -> master)
> Author: tom <tom12345@outlook.com>
> Date:   Wed Dec 23 13:42:34 2020 +0800
> ```
>
> * git --pretty=oneline
>
> ```shell
> 9d9e8e145a352279b42d13a84c7719b6d0ba0c29 (HEAD -> master) my third moify good.txt
> ```
>
> * git --oneline
>
> ```shell
> 9d9e8e1 (HEAD -> master) my third moify good.txt
> ```
>
> * git reflog
>
> ```shell
> 9d9e8e1 (HEAD -> master) HEAD@{0}: commit: my third moify good.txt
> 4419b3d HEAD@{1}: commit: My second commit and modify good.txt
> 4f8521c HEAD@{2}: commit (initial): myfirst commit new file good.txt
> ```
>
> * 版本的前进后退
>
>   * 基于索引值
>
>     * git reset --hard 局部索引值
>
>     ```shell
>     $ git reflog
>     9d9e8e1 (HEAD -> master) HEAD@{0}: commit: my third moify good.txt
>     4419b3d HEAD@{1}: commit: My second commit and modify good.txt
>     4f8521c HEAD@{2}: commit (initial): myfirst commit new file good.txt
>     
>     Administrator@MICRO-008222013 MINGW64 /f/workSpaces/test (master)
>     $ git reset --hard 4419b3d
>     HEAD is now at 4419b3d My second commit and modify good.txt
>     
>     Administrator@MICRO-008222013 MINGW64 /f/workSpaces/test (master)
>     $ cat good.txt
>     nnlknklnlkn
>     QQQQQ:wq
>     
>     ```
>
>   * 基于**^**，只能后退
>
>     * git reset --hard HEAD^^
>     * 一个^号退一个版本，n个^退n个
>
>   * 基于**~**波浪号，只能后退
>
>     * git reset --hard HEAD~n
>     * 表示退n个版本

## 分支

> * 分支的好处
>   * 同时推进多个功能开发，提高开发效率
>   * 各个分支开发过程中，如果一个分支开发失败，不会影响其他分支的开发，失败的分支重新开发即可
> * 分支操作
>   * 创建分支
>     * git branch 分支名
>   * 查看分支
>     * git branch -v
>   * 切换分支
>     * git checkout 分支名
>   * 合并分支
>     *  切换到接受被修改的分支上
>       * git checkout 分支名(被合并的分支)
>     * git merge  分支名(有修改的分支)
> * 解决分支冲突
>   * 进入文件删除特殊符号
>   * git commit -m "日志信息" 不能带文件名
> * 

## 连接远程库

> * 连接github的时候，由于git默认分支是master，而github的默认分支是main，所以一开始传输远程库的时候需要新建一个main分支
>
>   ```shell
>   git add file(添加到暂存区)
>   git commit -m "your description" file(提交到本地库)
>   git remote add origin ssh地址  (添加ssh地址，免密登录)
>   git branch -M main(将当前的主分支更改成main，Git默认是master)
>   git push origin main(push到远程库)
>   ```
>
> * ssh免密登录细节
>
>   如果有ssh地址的需要删除ssh地址
>
>   ```shell
>   cd ~(进入到家目录)
>   rm -rvf .ssh (删除ssh地址)
>   ssh-keygen -t rsa -C 3070261303@qq.com(github邮箱)
>   cd .ssh/
>   cat id_rsa.pub(查看此文件)
>   复制查到的内容
>   到github账号setting里面设置SSH，在key里面链贴内容，title随意定义一个主题
>   然后回到你的工作目录
>   git remote add origin ssh地址(可以在仓库的code下查询)
>   git remote -v(查看远程地址)
>   ```

## 团队合作

> * clone
>
>   ```shell
>   git clone 项目的地址
>   ```
>
>   此时B将A的仓库克隆下来，但是做了修改之后并不能push到远程库，需要A将B加入到团队。
>
>   在仓库的setting下的**manager access**可以**invite a collaborator**，邀请团队成员，B接受之后才能进行push操作。
>
>   
>
>   * fetch和merge
>
>   ```shell
>   git fetch origin main(把远程内容下载到本地，但并没有改变本地的文件)
>   (此时看不到下载下的文件，需要以下命令)
>   git checkout origin/main(切换到远程分支)
>   cat 文件名
>   (文件内容)
>   git checkout main(切换回本地分支)
>   git merge origin/main(将远程分支合并到本地分支)
>   ```
>
>   * pull=fetch+merge
>
>   ```shell
>   git pull origin main(直接合并，没有查看操作)
>   ```