--1、查询所有学员的平均年龄（要求保留两位小数）
select trunc(avg(stuage),2) from studentinfo
--2、查询所有考试的总成绩
select sum(examresult) from studentexam
--3、查询SQL考试的最低分数
select min(examresult) from studentexam where examsubject='SQL'
--4、查询Java考试成绩最高的学员姓名
select stuname from studentinfo where STUID=(select EXAMID from studentexam where examresult=(select max(examresult) from studentexam))
--5、查询学员‘火云邪神’一共参加了几次考试
select count(*)||'次' 几次 from studentexam where estuid=(select stuid from studentinfo stuname='火云邪神')
--6、查询各科目的平均成绩
select examsubject 科目,avg(examresult)  from studentexam
group by examsubject
--7、查询每班级学员的最小年龄
select min(stuage) from studentinfo
group by sclassid
--8、查询考试不及格的人数
select count(*) from studentexam where examsubject<60
--9、查询各学员的总成绩，要求筛选出总成绩在140分以上的
select sum(examresult) from studentexam
group by estuid
having sum(examresult) >= 140
--10、查询男女学员的平均年龄
select avg(stuage) from studentinfo
group by stusex
--11、查询每门功课的平均分，要求显示平均分在80分以上的(包括80分)
select avg(examresult)  from studentexam
group by examsubject
having avg(examresult)>=80
