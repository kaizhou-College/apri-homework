--查询所有学员从入学到今天，一共度过了多少天
select months_between(sysdate,STUJOINTIME)* 30 from studentinfo


--查询你的出生日期到现在相隔的年数（月数/12）
select months_between(sysdate,'20-6月-1998')/12 from dual


--查询每月2号入学的学员信息
select * from studentinfo where extract(day from STUJOINTIME)=2


--查询所有学员的毕业日期，假定按每个学员入学时间1年半之后将毕业。
select add_months(STUJOINTIME,18) from studentinfo


--查询星期四入学的学员姓名，性别，年龄，班级编号 
select stuname,stusex,stuage,sclassid from studentinfo where to_char(STUJOINTIME,'day')='星期四'and sclassid=2


--查询‘2007-3-10’之前入学的学员信息
select * from studentinfo where to_char(STUJOINTIME,'yyyy-mm-dd')<'2007-03-10'


--查询所有学员姓名的长度()
select length(STUNAME) from studentinfo


--查询身份证中第9，10位为‘89’的学员信息（要求使用字符串函数）
select * from studentinfo where substr(STUCARD,instr(stucard,'89'),2)='89'


--修改班主任信息，将邮箱中的‘yahoo’替换为‘geekgroup’
select replace(TEACHEREMAIL,'yahoo','geekgroup') from teacherinfo


--编写查询语句去掉字符串‘   爱你我爱你   ’中的空格
select trim   ('  爱你我爱你  ') from dual


--计算每个学员身份证中字符‘1’出现的次数
select length(STUCARD) - length(replace(STUCARD,'1')) from studentinfo


--求小于-58.9的最大整数
select floor(-58.9) from dual


--求大于78.8的最小整数
select ceil(78.8) from dual


--求64除以7的余数
select mod(64,7) from dual


--查询所有学员入学时间，要求显示格式为‘2007年03月02日’
select to_char(STUJOINTIME,'yyyy"年"mm"月"dd"日"') from studentinfo


--查询当前时间，要求显示格式为‘22时57:37’
select to_char(sysdate,'hh24"时"mi:ss') from dual


--查询2007年入学的学员信息
select * from studentinfo where Extract(year from STUJOINTIME)=2007


--查询所有学员的平均年龄（要求保留两位小数）
select trunc(avg(STUAGE),2) from studentinfo


--查询所有考试的总成绩
select sum(EXAMRESULT) from studentexam 


--查询SQL考试的最低分数
select min(EXAMRESULT) from studentexam


--查询Java考试成绩最高的学员姓名
select b.stuname from
(select estuid from studentexam where examresult=
(select max(examresult) from studentexam where examsubject='Java'))a,
studentinfo b 
where a.estuid=b.stuid


--查询学员‘火云邪神’一共参加了几次考试
select count(*) from studentinfo , studentexam where studentinfo.stuid=studentexam.estuid and stuname='火云邪神'


--查询各科目的平均成绩
select EXAMSUBJECT, avg(EXAMRESULT) from studentexam group by EXAMSUBJECT


--查询每个班级学员的最小年龄
select sclassid,min(stuage) from studentinfo group by sclassid


--查询考试不及格的人数
select count(*) from studentexam where EXAMRESULT<60


--查询各学员的总成绩，要求筛选出总成绩在140分以上的
select sum(examresult) ,estuid  from studentexam  group by estuid having sum(examresult)>140


--查询男女学员的平均年龄
select stusex,avg(stuage) from studentinfo group by stusex


--查询每门功课的平均分，要求显示平均分在80分以上的(包括80分)
select * from (select avg(examresult)total from studentexam group by EXAMSUBJECT)where total>80
