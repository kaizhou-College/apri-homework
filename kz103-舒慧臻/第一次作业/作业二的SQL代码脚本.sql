---自动增长
create sequence seq_studentinfo
create sequence seq_classinfo
create sequence seq_Teacherinfo
create sequence seq_studentexam
commit
----插入数据
insert into teacherinfo values(seq_teacherinfo.nextval,'唐三藏','13907311119','tsz@yahoo.com')
insert into teacherinfo values(seq_teacherinfo.nextval,'擎天柱','13907315200','qtz@yahoo.com')
commit
----查找并添加

insert into Classinfo values(seq_classinfo.nextval,07034,(select teacherID from teacherinfo where teachername='擎天柱'),'S1')
commit
-----学生信息表
insert into studentinfo values(seq_studentinfo.nextval,'001','火云邪神',18,'男','4320105198905022032','01-3月-07','长沙市开福区',null)
insert into studentinfo values(seq_studentinfo.nextval,'002','东方不败',20,'男','430104198703012011','02-3月-07','广东佛山',null)
insert into studentinfo values(seq_studentinfo.nextval,'003','小李飞车',18,'男','420106198908064044','06-3月-07','湖南湘潭',null)
insert into studentinfo values(seq_studentinfo.nextval,'004','樱桃肉丸子',18,'女','42010619890861085','02-3月-07','长沙市岳麓区',null)
alter table studentinfo add constraint ck_Stuage
      check (stuage between 16 and 35)
      
alter table studentinfo add constraint ck_stusex
      check (stusex in( '男' , '女'))

-----考试成绩表
---查找学员id

insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '火云邪神'),'SQL',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '火云邪神'),'Java',56)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '小李飞车'),'SQL',90)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '小李飞车'),'Java',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '樱桃肉丸子'),'SQL',95)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '樱桃肉丸子'),'Java',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '东方不败'),'SQL',80)
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select stuid from studentinfo where stuname = '东方不败'),'Java',90)

----修改
update studentinfo set sclassid=3
       where stuname in ('火云邪神' , '小李飞车')
----删除
delete from  studentexam where estuid = (select stuid from studentinfo where stuname = '东方不败' )
