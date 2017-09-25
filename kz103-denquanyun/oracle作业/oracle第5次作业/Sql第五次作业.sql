--1、查询所有学员从入学到今天，一共度过了多少天 
Select stuname as "姓名",(months_between(sysdate,stujointime)*30) as "天数" from studentinfo
--2．查询你的出生日期到现在相隔的年数（月数/12）
select (months_between(sysdate,'07-9月-1999')/12) as "活了多少年" from dual
--3、查询每月2号入学的学员信息
select * from studentinfo
where extract(day from stujointime)=2
--4、查询所有学员的毕业日期，假定按每个学员入学时间1年半之后将毕业。
select stuname as "姓名",(Add_months(stujointime,18)) as "毕业时间" from studentinfo
--5.查询星期四入学的学员姓名，性别，年龄，班级编号   =5?
select stuname,stusex,stuage,sclassid from studentinfo 
where to_char(stujointime,'day')='星期四' and sclassid=2;
--6、查询‘2007-3-10’之前入学的学员信息
select * from studentinfo
where stujointime<to_date('2007-3-10','yyyy-mm-dd')
--7、查询所有学员姓名的长度
select stuname as "姓名",(length(stuname)) as "名字长度" from studentinfo
--8、查询身份证中第9，10位为‘89’的学员信息（要求使用字符串函数）
select * from studentinfo
where substr(stucard,9,2)='89'
--9、修改班主任信息，将邮箱中的‘yahoo’替换为‘geekgroup’
Select replace(teacheremail,'yahoo','geekgroup') from teacherinfo
--10、编写查询语句去掉字符串‘   爱你我爱你   ’中的空格
select replace('   爱你我爱你   ',' ','') from dual
--11、计算每个学员身份证中字符‘1’出现的次数
select stuname as "姓名",(length(stucard)-length(replace(stucard,'1'))) as "出现1的次数" from studentinfo
--12、求小于-58.9的最大整数
select ceil(-58.9) from dual
--13、求大于78.8的最小整数
select floor(78.8) from dual
--14、求64除以7的余数
select mod(64,7) from dual
--15、查询所有学员入学时间，要求显示格式为‘2007年03月02日’
select stuname as "姓名",(to_char(stujointime,'yyyy"年"mm"月"dd"日"')) as 入学时间 from studentinfo
--16、查询当前时间，要求显示格式为‘22时57:37’
select to_char(sysdate,'hh24"时"mi:ss') from dual
--17、查询2007年入学的学员信息
select * from studentinfo
where extract(year from stujointime)='2007'


--------------------分割线--------------------------------
--1、查询所有学员的平均年龄（要求保留两位小数）
select Round(Avg(stuage),2) from studentinfo 
--2、查询所有考试的总成绩
select sum(examresult) from studentexam
--3、查询SQL考试的最低分数
select min(examresult) from studentexam
where examsubject='SQL'
--4、查询Java考试成绩最高的学员姓名
select stuname from studentinfo
where stuid = (Select estuid from studentexam where examresult=(Select max(examresult) from studentexam where examsubject='Java'))
--5、查询学员‘火云邪神’一共参加了几次考试
select count(*)||'次' as "次数" from studentexam where estuid=(Select stuid from studentinfo where stuname='火云邪神')
--6、查询各科目的平均成绩
select examsubject as "科目",avg(examresult) from studentexam
group by examsubject
--7、查询每个班级学员的最小年龄
select min(stuage) from studentinfo 
group by sclassid
--8、查询考试不及格的人数
select count(*) from(
select estuid ,count(*) from studentexam
where examresult<60
group by estuid)
--9、查询各学员的总成绩，要求筛选出总成绩在140分以上的
select stuname from studentinfo where stuid in(
select estuid from studentexam
group by estuid
having sum(examresult)>=140)
--10、查询男女学员的平均年龄
select stusex as "性别",avg(stuage) from studentinfo
group by stusex
--11、查询每门功课的平均分，要求显示平均分在80分以上的(包括80分)
select examsubject as "科目",avg(examresult) from studentexam
group by examsubject
having avg(examresult)>=80
