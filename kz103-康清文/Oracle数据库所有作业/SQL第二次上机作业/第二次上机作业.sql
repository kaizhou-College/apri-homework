--创建表空间
create tablespace stuSpace -- 表空间名称
datafile 'D:\oradata\orcl\stuSpace.dbf' -- 表空间对应的数据
size 32m --初始大小
autoextend on --自动增长打开，
next 32m maxsize 1024m --每次增长32，最大到1G

--创建Oracle用户
create user stuDBA identified by stu
default tablespace stuSpace      -----将表空间stuSpace设置为用户stuDBA的默认表空间

grant dba to stuDBA  ----为用户stuDBA授予DBA角色

--数据添加
select * from StudentInfo
方式一
insert into StudentInfo(StuID,StuNumber,StuName,StuAge,StuSex,StuCard,StuJoinTime,StuAddress) values
(seq_StudentInfo.Nextval,'001','火云邪神',18,'男','430105198905022032','01-3月-07','长沙市开福区');

方式二
insert into StudentInfo values
(seq_StudentInfo.Nextval,'002','东方不败',20,'男','430104198703012011','10-3月-07','长沙市湘潭',null);

insert into StudentInfo values
(seq_StudentInfo.Nextval,'003','小李飞车',18,'男','420106198912064044','02-3月-07','广东佛山',null);

insert into StudentInfo values
(seq_StudentInfo.Nextval,'004','樱桃肉丸子',18,'女','420106198908061085','06-3月-07','长沙市岳麓区',null)


--添加班主任信息
select * from TeacherInfo

insert into TeacherInfo values
(seq_TeacherInfo.Nextval,'唐三藏','13907311119','tsz@yahoo.com')

insert into TeacherInfo values
(seq_TeacherInfo.Nextval,'擎天柱','13907315200','qtz@yahoo.com')

--主外键约束

alter table studentinfo add constraint fk_studentinfo
foreign key(SClassID) references ClassInfo (ClassID)

alter table ClassInfo add constraint fk_ClassInfo
foreign key(CTeacherID) references TeacherInfo (TeacherID)


alter table StudentExam add constraint fk_StudentExam
foreign key(EStuID) references StudentInfo (StuID)






--查询班主任ID，然后修改信息表
insert into ClassInfo values
(Seq_Classinfo.Nextval,'07034',(select TeacherID from TeacherInfo where TeacherName='擎天柱'),'s1')
update StudentInfo set SClassID=(select ClassID from ClassInfo where ClassNumber='07034')where StuName='火云邪神' or StuName='小李飞车';

insert into ClassInfo values
(Seq_Classinfo.Nextval,'07038',(select TeacherID from TeacherInfo where TeacherName='唐三藏'),'s1')
update StudentInfo set SClassID=(select ClassID from ClassInfo where ClassNumber='07038')where StuName='东方不败' or StuName='樱桃肉丸子';

insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='火云邪神'),'sql','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='火云邪神'),'java','56');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='小李飞车'),'sql','90');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='小李飞车'),'java','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='樱桃肉丸子'),'sql','95');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='樱桃肉丸子'),'java','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='东方不败'),'sql','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='东方不败'),'java','90');

--删除东方不败考试信息
delete from StudentExam where EStuID=(select StuID from StudentInfo where StuName='东方不败');

