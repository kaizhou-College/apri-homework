----练习二：单行函数练习
select * from studentinfo
select * from teacherinfo
----1、查询所有学员从入学到今天，一共度过了多少天 
select stuname,Ceil(months_between(sysdate,stujointime)*30) as 入学天数 from studentinfo 
----2．查询你的出生日期到现在相隔的年数（月数/12）
select Floor (months_between(sysdate,stujointime)/12) as 相隔年数 from studentinfo
----3、查询每月2号入学的学员信息
select * from studentinfo where Extract(day from stujointime)=2
----4、查询所有学员的毕业日期，假定按每个学员入学时间1年半之后将毕业。
select stuname,add_months(sysdate,18) as 毕业日期 from studentinfo
----5、查询星期四入学的学员姓名，性别，年龄，班级编号   ????????????????????????????????????????
select stuname,stusex,stuage,stunUMber from studentinfo where to_char( StuJointime,'day') ='星期四'
----6、查询‘2007-3-10’之前入学的学员信息
select * from studentinfo where stujointime < ('10-3月-07')
----7、查询所有学员姓名的长度
select stuname,length(stuname) from studentinfo
----8、查询身份证中第9，10位为‘89’的学员信息（要求使用字符串函数）
select * from studentinfo where substr(stucard,9,2)='89'
----9、修改班主任信息，将邮箱中的‘yahoo’替换为‘geekgroup’
select replace(teacheremail , 'yahoo','geekgroup') from teacherinfo
----10、编写查询语句去掉字符串‘   爱你我爱你   ’中的空格
select replace('   爱你我爱你   ',' ','') from dual
----11、计算每个学员身份证中字符‘1’出现的次数
select length(stucard)-length(replace(stucard,'1','')) from studentinfo
----12、求小于-58.9的最大整数
select floor(-58.9) from dual
----13、求大于78.8的最小整数
select Ceil(78.8) from dual
----14、求64除以7的余数
select mod(64,7) from dual
----15、查询所有学员入学时间，要求显示格式为‘2007年03月02日’
select stuname,to_char(stujointime,'yyyy"年"mm"月"dd"日"') from studentinfo
----16、查询当前时间，要求显示格式为‘22时57:37’
select to_char( sysdate,'hh24"时"mi:ss"秒"') from dual
----17、查询2007年入学的学员信息
select * from studentinfo where extract(year from stuJointime)=2007



----练习三：分组函数练习
----1、查询所有学员的平均年龄（要求保留两位小数）
select round(avg(stuage),2) from studentinfo
----2、查询所有考试的总成绩
select ExamsubJect , sum(Examresult) from studentexam
group by examsubject
----3、查询SQL考试的最低分数
select min(Examresult) from studentexam
----4、查询Java考试成绩最高的学员姓名
select a.stuname from studentinfo a,(select estuid from studentexam 
where examresult=(select max(examresult) from studentexam  where examsubject='Java')) b
where b.estuid=a.stuid
----5、查询学员‘火云邪神’一共参加了几次考试
select count(a.estuid)as 参加次数 from studentexam a ,studentinfo b
where a.estuid=b.stuid and b.stuname='火云邪神'
----6、查询各科目的平均成绩
select examsubject , avg(examresult) from studentexam
group by examsubject
----7、查询每个班级学员的最小年龄
select sclassid, min(stuage) from studentinfo
group by sclassid
----8、查询考试不及格的人数
select * from studentexam where examresult<60
----9、查询各学员的总成绩，要求筛选出总成绩在140分以上的
select * from (select s.stuname,sum(examresult) as result  from studentexam a ,studentinfo s 
where  a.Estuid=s.stuid group by s.stuname) where result>140
----10、查询男女学员的平均年龄
select stusex,avg(stuage) from studentinfo
group by stusex
----11、查询每门功课的平均分，要求显示平均分在80分以上的(包括80分)
select examsubject , avg(examresult) as pj from  studentexam 
having avg(examresult)>=80
group by examsubject
