# **Linux**  

## **基本命令**  

* 当前目录：`cd .`

* 回到上一级目录：`cd ..`  

* 回到上一次的工作目录： `cd -`  

* 回到用户目录：`cd ~`

* 显示当前目录： `pwd`  

* 创建文件：`touch hello`  

* 切换root用户：`sudo -s`    退出：`exit`  

* 添加用户(需要root权限)：`sudo useradd username`  

* 删除用户(需要root权限)：`sudo userdel username`

* 添加用户(-m 自动建立用户的家目录, -s 指定Shell)：`sudo useradd username -m -s /bin/bash`  

* 设置密码：`sudo passwd username`  

* 切换用户：`su - username`  

* 查看当前登录用户：`who`  

* 查看当前操作账号用户：`whoami`  

* 查看当前用户所有的用户组：`groups`  

* 查看用户所属的用户相关信息：`id`  

* 为用户添加sudo：`sudo usermod study -G sudo`  

* 打印文本信息：`cat /file`  

* 打印用户配置文件：`cat /etc/passwd`  

* 打印用户组配置文件：`cat /etc/group`  

* 打印密码信息：`cat /etc/shadow`  

* 列出当前目录中所有的文件：`ls`  

* 列出当前目录中所有的文件包含隐藏文件：`ls -a`  

* 列出当前目录中所有的文件包含详细信息：`ls -l`  

* 列出当前目录中所有的文件包含隐藏文件和详细信息等于`ls -a -l`：`ll`  

* 修改文件权限：`chmod (u/g/o/a)(+/-)(r/w/x) file`  

* 使用数字修改文件权限（r=4，w=2,x=1),修改回-rw-rw-r--：`chmod 664 file`  

* 修改文件的拥有者：`sudo chown root file`  

* 修改文件的所属组：`sudo chgrp root file`  

* 创建目录：`mkdir study1`  

* 复制上一级的文件到该目录下：`cp ../DS student`  

* 对整个目录进行复制：`cp -r study1 study1_copied`  

* 移动文件：`mv DS study2`  

* 移动目录：`mv study1 study2`  

* 移动文件实现改名：`mv DS test1`  

* 删除目录：`rm -r study1`  

* 删除所有以txt结尾的文件：`rm *.txt`  

* 查找以s开头的文件：`sudo find /etc -name 's*'`

* 查找系统管理：`top` 再按f设置排序或显示哪些参数(按d设置显示，按s设置排序，按q关闭设置)  

* 查看内存使用情况：`free` 后面可加-m或-g设置单位  

* 查看磁盘信息：`lsblk`  

* 查看磁盘实体情况：`sudo fdisk -l`  

* 挂载U盘到u-test目录下：`sudo mount dev/sdb1 u-DS`  

* 取消挂载：`sudo umount dev/sdb1`  

* 查看当前进程：`ps`

* 查看所有进程：`ps -ef`

* 杀死进程：`kill -9 PID`

* 关机：`sudo shutdown`  加-c表示取消

* 立刻关机：`sudo shutdown now`  

* 打包文件：`tar -zcvf DS.tar.gz *.txt`  
-z表示以gzip格式进行操作，-c表示对文件进行压缩，-v可以在处理过程中输出一些日志信息，-f表示对普通文件进行操作  

* 解压文件：`tar -zxvf DS.tar.gz` -x表示进行解压操作