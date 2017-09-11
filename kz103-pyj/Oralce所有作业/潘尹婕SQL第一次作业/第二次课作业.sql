--默认
alter table classinfo modify ClassGrade default 'S1'
--自动增长
create sequence seq_studentinfo
create sequence seq_classinfo
create sequence seq_studentexam
create sequence seq_teacherinfo
--StudentInfo插入数据

insert into studentinfo values(seq_studentinfo.nextval,'001','火云邪神',18,'男','430105198905022032','01-3月-07','长沙市开福区',null)
insert into studentinfo values(seq_studentinfo.nextval,'002','东方不败',20,'男','430104198703012011','10-3月-07','湖南湘潭',null)
insert into studentinfo values(seq_studentinfo.nextval,'003','小李飞车',18,'男','420106198912064044','02-3月-07','广东佛山',null)
insert into studentinfo values(seq_studentinfo.nextval,'004','樱桃肉丸子',18,'女','420106198908061085','06-3月-07','长沙市岳麓区',null)
commit
--classinfo插入
--从班主任信息表中查找班主任 ‘擎天柱’的ID，向班级信息表中添加班级信息

insert into classinfo values(seq_classinfo.nextval,07034,(select TeacherID  from Teacherinfo where  teachername='擎天柱' ),'S1');
commit

insert into classinfo values(seq_classinfo.nextval,07038,(select TeacherID  from Teacherinfo where  teachername='唐三藏'),'S1');
commit
--在学员信息表中，将学员‘火云邪神’和‘小李飞车’的信息中‘班级ID’一项值修改为07034班对应的班级ID
update studentinfo set SClassID=41
       where StuName in('火云邪神','小李飞车');
commit



--Teacherinfo插入
insert into teacherinfo values(seq_teacherinfo.nextval,'唐三藏','13907311119','tsz@yahoo.com');
insert into teacherinfo values(seq_teacherinfo.nextval,'擎天柱','13907315200','qtz@yahoo.com');
commit

--StudentExam插入
select stuid ,stuname from studentinfo 
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',21,'SQL',80);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',21,'Java',56);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',23,'SQL',90);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',23,'Java',80);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',24,'SQL',95);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',24,'Java',80);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',22,'SQL',80);
insert into studentexam  values(seq_studentexam.nextval,'S1_2007070801',22,'Java',90);
commit

--删除
delete from studentexam where ESTUID = 22
commit

