--������ռ�
create tablespace stuSpace -- ��ռ�����
datafile 'D:\oradata\orcl\stuSpace.dbf' -- ��ռ��Ӧ������
size 32m --��ʼ��С
autoextend on --�Զ������򿪣�
next 32m maxsize 1024m --ÿ������32�����1G

--����Oracle�û�
create user stuDBA identified by stu
default tablespace stuSpace      -----����ռ�stuSpace����Ϊ�û�stuDBA��Ĭ�ϱ�ռ�

grant dba to stuDBA  ----Ϊ�û�stuDBA����DBA��ɫ

--�������
select * from StudentInfo
��ʽһ
insert into StudentInfo(StuID,StuNumber,StuName,StuAge,StuSex,StuCard,StuJoinTime,StuAddress) values
(seq_StudentInfo.Nextval,'001','����а��',18,'��','430105198905022032','01-3��-07','��ɳ�п�����');

��ʽ��
insert into StudentInfo values
(seq_StudentInfo.Nextval,'002','��������',20,'��','430104198703012011','10-3��-07','��ɳ����̶',null);

insert into StudentInfo values
(seq_StudentInfo.Nextval,'003','С��ɳ�',18,'��','420106198912064044','02-3��-07','�㶫��ɽ',null);

insert into StudentInfo values
(seq_StudentInfo.Nextval,'004','ӣ��������',18,'Ů','420106198908061085','06-3��-07','��ɳ����´��',null)


--��Ӱ�������Ϣ
select * from TeacherInfo

insert into TeacherInfo values
(seq_TeacherInfo.Nextval,'������','13907311119','tsz@yahoo.com')

insert into TeacherInfo values
(seq_TeacherInfo.Nextval,'������','13907315200','qtz@yahoo.com')

--�����Լ��

alter table studentinfo add constraint fk_studentinfo
foreign key(SClassID) references ClassInfo (ClassID)

alter table ClassInfo add constraint fk_ClassInfo
foreign key(CTeacherID) references TeacherInfo (TeacherID)


alter table StudentExam add constraint fk_StudentExam
foreign key(EStuID) references StudentInfo (StuID)






--��ѯ������ID��Ȼ���޸���Ϣ��
insert into ClassInfo values
(Seq_Classinfo.Nextval,'07034',(select TeacherID from TeacherInfo where TeacherName='������'),'s1')
update StudentInfo set SClassID=(select ClassID from ClassInfo where ClassNumber='07034')where StuName='����а��' or StuName='С��ɳ�';

insert into ClassInfo values
(Seq_Classinfo.Nextval,'07038',(select TeacherID from TeacherInfo where TeacherName='������'),'s1')
update StudentInfo set SClassID=(select ClassID from ClassInfo where ClassNumber='07038')where StuName='��������' or StuName='ӣ��������';

insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='����а��'),'sql','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='����а��'),'java','56');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='С��ɳ�'),'sql','90');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='С��ɳ�'),'java','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='ӣ��������'),'sql','95');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='ӣ��������'),'java','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='��������'),'sql','80');
insert into StudentExam values(seq_studentexam.nextval,'S1_2007070801',(select StuID from StudentInfo where StuName='��������'),'java','90');

--ɾ���������ܿ�����Ϣ
delete from StudentExam where EStuID=(select StuID from StudentInfo where StuName='��������');

