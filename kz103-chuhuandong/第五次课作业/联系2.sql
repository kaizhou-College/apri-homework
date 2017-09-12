--1、查询所有学员从入学到今天，一共度过了多少天
select stuname as "姓名",(months_between(sysdate,stujointime)*30) as "度过天数" from studentinfo
--2．查询你的出生日期到现在相隔的年数（月数/12）
select (months_between(sysdate,'17-12月-1999')/12) as "相隔年数" from dual
--3.查询每月2号入学的学员信息
select * from studentinfo where extract(day from stujointime)=2
--4.查询所有学员的毕业日期，假定按每个学员入学时间1年半之后将毕业
select stuname as "姓名",add_months(stujointime,18) as "毕业日期" from studentinfo
--5、查询星期四入学的学员姓名，性别，年龄，班级编号   =5?
select 
--6、查询‘2007-3-10’之前入学的学员信息                                                                                                                                                                                                                                                                                                                                                                                          
select * from studentinfo where stujointime<to_date('2007-3-10','yyyy-mm-dd')
--7、查询所有学员姓名的长度
select length(stuname) 长度 from studentinfo
--8、查询身份证中第9，10位为‘89’的学员信息（要求使用字符串函数）
select * from studentinfo where substr(STUCARD,9,2)='89'
--9、修改班主任信息，将邮箱中的‘yahoo’替换为‘geekgroup’
select replace(teacheremail,'yahoo','geekgroup')
--10、编写查询语句去掉字符串‘   爱你我爱你   ’中的空格
select replace('   爱你我爱你   ','   ') from dual
--11、计算每个学员身份证中字符‘1’出现的次数
select length(stucard)-length(replace(stucard,'1')) ci from studentinfo
--12、求小于-58.9的最大整数
select ceil(-58.9) from dual
--13、求大于78.8的最小整数
select floor(78.9) from dual
--14、求64除以7的余数
select mod(64,7) from dual
--15、查询所有学员入学时间，要求显示格式为‘2007年03月02日’
select to_char(stujointime,'yyyy"年"-mm"月"-dd"日"') from studentinfo
--16、查询当前时间，要求显示格式为‘22时57:37’
select to_char(sysdate,'hh24:mi:ss') from dual
--17、查询2007年入学的学员信息
select * from studentinfo where extract(year from stujointime) = 2007
--
