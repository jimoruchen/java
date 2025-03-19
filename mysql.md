# **MySQL**

## **DDL**

* 创建数据库
```sql
create database study
```
* 切换数据库
```sql
use study
```
* 删除数据库
```sql
drop database study
```
* 制定字符格式
```sql
CREATE DATABASE IF NOT EXISTS study 
       DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
```
* 创建表
```sql
create table student(sid int primary key,
                     name varchar(10) not null,
                     sex enum('男','女') not null default '男'); 
create table teacher(tid int primary key,
                     name varchar(10) not null);
create table teach(tid int not null,
                   sid int not null,
                   constraint f_tid foreign key (tid) references study.teacher(tid),
                   constraint f_sid foreign key (sid) references study.student(sid));
```
* 修改表
```sql
alter table teacher add sex enum('男','女') not null default '男'; 
```
* 删除表
```sql
drop table student;
```

## DML

* 插入数据
```sql
insert into student values(19200121, '小明', '男');
insert into student(sid, name) values(19200122, '小强');
insert into student values(19200123, '小红'), (19200124, '小夏', '女');
```
* 修改数据
```sql
upadte student set name='小刚' where sid=19200122;
```
* 删除数据
```sql
delete from student;    //删除全部数据
delete from student where sid=111;    //删除指定数据
```