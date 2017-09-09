create table StudentInfo(
       StuID number(4),
       StuNumber varchar2(10),
       StuName varchar2(32),
       StuAge number,
       StuSex varchar2(2),
       StuCard varchar2(20),
       StuJoinTime Date,
       StuAddress varchar2(50),
       SClassID number
)
alter table StudentInfo
add constraint pk_stu1 primary key(StuID);

alter table StudentInfo add constraint fk_stu1
foreign key(sclassid) references Classinfo(ClassID)

alter table StudentInfo add constraint ck_stu5
check(stusex in ('男','女'))

alter table StudentInfo modify StuID not null;
alter table StudentInfo modify StuNumber not null;
alter table StudentInfo modify StuName not null;
alter table StudentInfo modify StuSex not null;
alter table StudentInfo modify StuJoinTime not null;

alter table classinfo add constraint fk_stu2
foreign key(classid) references teacherinfo(teacherid)

alter table ClassInfo modify ClassGrade default 'S1'

alter table ClassInfo add constraint pk_stu2
primary key (classid)

alter table StudentExam add constraint ck_stu4
check((ExamResult >0)&&(ExamResult<100))

insert into studentinfo(stuid,stunumber,stuname,stuage,stusex,stucard,stujointime,stuaddress,sclassid) values(seq_stu1.nextval,001,'火云邪神',18,'男','430105198905022032','01-3月-07','长沙市开福区',null);
insert into studentinfo(stuid,stunumber,stuname,stuage,stusex,stucard,stujointime,stuaddress,sclassid) values(seq_stu1.nextval,002,'东方不败',20,'男','430104198703012011','10-3月-07','湖南湘潭',null);
insert into studentinfo(stuid,stunumber,stuname,stuage,stusex,stucard,stujointime,stuaddress,sclassid) values(seq_stu1.nextval,003,'小李飞车',18,'男','420106198912064044','02-3月-07','广东佛山',null);
insert into studentinfo(stuid,stunumber,stuname,stuage,stusex,stucard,stujointime,stuaddress,sclassid) values(seq_stu1.nextval,004,'樱桃肉丸子',18,'女','420106198908061085','06-3月-07','长沙市岳麓区',null);

insert into classinfo(Classid,classnumber,cteacherid,classgrade) values(1,07034,(select teacherid from teacherinfo where TeacherName = '擎天柱'),'S1');
insert into classinfo(Classid,classnumber,cteacherid,classgrade) values(2,07038,(select teacherid from teacherinfo where TeacherName = '唐三藏'),'S1');
update StudentInfo set sclassid = 2 where StuName='东方不败';
update StudentInfo set sclassid = 2 where StuName='樱桃肉丸子';


create sequence seq_stu4
start with 1
increment by 1;
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='火云邪神'),'SQL',80);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='火云邪神'),'java',56);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='小李飞车'),'SQL',90);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='小李飞车'),'java',80);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='樱桃肉丸子'),'SQL',95);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='樱桃肉丸子'),'java',80);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='东方不败'),'SQL',80);
insert into StudentExam(ExamID,ExamNumber,EStuID,ExamSubject,ExamResult) values(seq_stu4.nextval,'S1_2007070801',(select stuid from studentinfo where stuname='东方不败'),'java',90);
delete from StudentExam where EStuID=(select stuid from studentinfo where stuname='火云邪神');
