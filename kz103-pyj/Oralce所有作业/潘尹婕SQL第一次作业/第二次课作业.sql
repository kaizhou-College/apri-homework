--Ĭ��
alter table classinfo modify ClassGrade default 'S1'
--�Զ�����
create sequence seq_studentinfo
create sequence seq_classinfo
create sequence seq_studentexam
create sequence seq_teacherinfo
--StudentInfo��������

insert into studentinfo values(seq_studentinfo.nextval,'001','����а��',18,'��','430105198905022032','01-3��-07','��ɳ�п�����',null)
insert into studentinfo values(seq_studentinfo.nextval,'002','��������',20,'��','430104198703012011','10-3��-07','������̶',null)
insert into studentinfo values(seq_studentinfo.nextval,'003','С��ɳ�',18,'��','420106198912064044','02-3��-07','�㶫��ɽ',null)
insert into studentinfo values(seq_studentinfo.nextval,'004','ӣ��������',18,'Ů','420106198908061085','06-3��-07','��ɳ����´��',null)
commit
--classinfo����
--�Ӱ�������Ϣ���в��Ұ����� ������������ID����༶��Ϣ������Ӱ༶��Ϣ

insert into classinfo values(seq_classinfo.nextval,07034,(select TeacherID  from Teacherinfo where  teachername='������' ),'S1');
commit

insert into classinfo values(seq_classinfo.nextval,07038,(select TeacherID  from Teacherinfo where  teachername='������'),'S1');
commit
--��ѧԱ��Ϣ���У���ѧԱ������а�񡯺͡�С��ɳ�������Ϣ�С��༶ID��һ��ֵ�޸�Ϊ07034���Ӧ�İ༶ID
update studentinfo set SClassID=41
       where StuName in('����а��','С��ɳ�');
commit



--Teacherinfo����
insert into teacherinfo values(seq_teacherinfo.nextval,'������','13907311119','tsz@yahoo.com');
insert into teacherinfo values(seq_teacherinfo.nextval,'������','13907315200','qtz@yahoo.com');
commit

--StudentExam����
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

--ɾ��
delete from studentexam where ESTUID = 22
commit

