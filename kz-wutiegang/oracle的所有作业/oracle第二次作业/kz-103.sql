create sequence seq_STUDENTINFO
insert into STUDENTINFO values(seq_STUDENTINFO.nextval,'001','����а��',18,'��','430105198905022032','01-3��-07','��ɳ�п�����',null);
insert into STUDENTINFO values(seq_STUDENTINFO.Nextval,'002','��������',20,'��','430104198703012011','10-3��-07','������̶',null);
insert into STUDENTINFO values(seq_STUDENTINFO.Nextval,'003','С��ɳ�',18,'��','420106198912064044','02-3��-07','�㶫��ɽ',null);
insert into STUDENTINFO values(seq_STUDENTINFO.Nextval,'004','ӣ��������',18,'Ů','420106198908061085','06-3��-07','��ɳ����´��',null);
create sequence seq_teacherinfo
insert into teacherinfo values(seq_teacherinfo.nextval,'������','13907311119','tsz@yahoo.com');
insert into teacherinfo values(seq_teacherinfo.Nextval,'������','13907315200','qtz@yahoo.com');
create sequence seq_classinfo

insert into classinfo values(seq_classinfo.nextval,'07034',(select TeacherID from teacherinfo where TeacherName='������'),'S1');
update studentinfo set SClassID=(select ClassID from ClassInfo	where ClassNumber='07034') where StuName='����а��' or StuName='С��ɳ�';
insert into classinfo values(seq_classinfo.nextval,'07038',(select TeacherID from teacherinfo where TeacherName='������'),'S1');
update studentinfo set SClassID=22 where StuName='��������' or StuName='ӣ��������';
create sequence seq_studentexam
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='����а��'),'SQL',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='����а��'),'Java',56);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='С��ɳ�'),'SQL',90);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='С��ɳ�'),'Java',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='ӣ��������'),'SQL',95);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='ӣ��������'),'Java',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='��������'),'SQL',80);
insert into studentexam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='��������'),'Java',90);
delete from studentexam where EStuID=(select StuID from StudentInfo where StuName='��������');
