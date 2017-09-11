---
select * from emp

--查询第3页 每页显示5条  带分页
select * from
(select rownum rn, a.* from (select * from emp order by empno) a  )
where rn >10 and rn <= 15


----【1，获取当前系统时间】
select sysdate from dual
----【2，字符串日期转date日志】''
create table test1(d1 date ,d2 timestamp)
select *　from test1
----【2.1默认格式】
insert into test1(d1) values('09-9月-2017')
----【2.2 yyyy-mm-dd格式 ：函数to_date】
insert into test1(d1) values(to_date('2017-9-9','yyyy-mm-dd'))
----【2.3 yyyy-mm-dd hh:mi:ss格式 ：函数to_date】
-----2017-9-9 12:12:12  hh:12小时制   hh24:24小时制
insert into test1(d1) values(to_date('2017-9-9 12:12:12','yyyy-mm-dd  hh:mi:ss'))
insert into test1(d1) values(to_date('2017-9-9 13:12:12','yyyy-mm-dd  hh24:mi:ss'))
----【2.4 yyyy-mm-dd hh:mi:ss格式 ：函数to_timestamp】
----2017-9-9 12:12:12.3333
insert into test1(d1) values(to_date('2017-9-9 12:12:12.3333','yyyy-mm-dd  hh:mi:ss.ff'))
---上面会报错  原因date类型的精度为：秒
insert into test1(d1) values(to_timestamp('2017-9-9 12:12:12.3333','yyyy-mm-dd  hh:mi:ss.ff'))

---【3，add_months(d,n)】
---求出当前时间3个月后的日期
select add_months(sysdate,3) from dual

Round(date[,fmt])，返回四舍五入后的日期值
	fmt为可选项，日期默认舍入为最靠近的那一天。
	如果指定格式为“YEAR”，则舍入到年的开始，即1月1日。
	如果指定格式为“MONTH”，则舍入到月的第一日。
	如果指定格式为“DAY”，则舍入到最近的星期日。
select round(to_date('2017-9-11 11:23:23','yyyy-mm-dd hh24:mi:ss')) from dual
select Extract(year from sysdate) from dual

---求出入职时间超过25年的员工
select * from emp where months_between(sysdate,hiredate)>25*12


---求出2月份入职的员工
select * from emp where Extract(month from hiredate)=2

---截取字符串
select substr('超哥今天真帅！',0,2) from dual
select length('超哥今天真帅！') from dual
select replace('超哥今天真帅！','超哥','焕东') from dual
-- 怒我     65     A                    
-- 就去     97     a
-- 死吧     48     0
Select chr(66) from dual
Select ascii('A') from dual

---字符练习
--1,
select lower(ename) from emp
--2,
select ename from emp where length(ename)>5
--3,
select substr(ename,0,3) from emp
--4,
select replace(ename,'S','5') from emp 
-----求出身份证中1的个数
----'98311928193991991933221'
select length('98311928193991991933221')-length(replace('98311928193991991933221','1')) from dual

select cos(180) from dual
----求余数
select mod(5,3) from dual



---【4，date日期转字符串日期】
select hiredate　from emp  --2071年9月9日
select to_char(hiredate,'yyyy"年"-mm"月"-dd"日"') from emp
select  to_char(sal,'$999,999') from emp  
select * from emp
                                
select ename,sal*12+nvl(comm,0) from emp  


select count(comm) from emp   
