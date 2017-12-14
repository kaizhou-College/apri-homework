--创建表空间
create tablespace hspace 
datafile 'D:\accp\oracle\hspace.dbf'
size 50m
autoextend on
next 2m
maxsize 200m;

--创建用户
--drop user hadmin
create user hadmin identified by tiger
default tablespace hspace;


--设置用户权限
grant connect ,resource to hadmin;

--创建表
create table users
(
       id number(11) primary key,
       name varchar2(20) not null,
       age number(11) not null,
       sex char(2) not null,
       salary number(11,2) not null
)
create sequence seq_uid

create table author
(
       id number(11) primary key,
       name varchar2(50) not null
)

create sequence seq_aid

select * from users

