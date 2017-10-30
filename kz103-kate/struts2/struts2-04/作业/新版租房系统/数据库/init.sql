delete from USERS;
delete from TYPES;
delete from STREET;
delete from DISTRICT;
insert into DISTRICT (ID, NAME)
values (1001, '����');
insert into DISTRICT (ID, NAME)
values (1002, '����');
insert into DISTRICT (ID, NAME)
values (1003, 'ʯ��ɽ');
insert into DISTRICT (ID, NAME)
values (1006, '����');
insert into DISTRICT (ID, NAME)
values (1000, '��̨');
insert into DISTRICT (ID, NAME)
values (1004, '����');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '֪��·', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '�йش���', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, 'ѧԺ·', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '����·', 1006);

insert into TYPES (ID, NAME)
values (1000, 'һ��һ��');
insert into TYPES (ID, NAME)
values (1001, 'һ������');
insert into TYPES (ID, NAME)
values (1002, '����һ��');
insert into TYPES (ID, NAME)
values (1003, '��������');
insert into TYPES (ID, NAME)
values (1004, '����һ��');
insert into TYPES (ID, NAME)
values (1005, '��������');
insert into TYPES (ID, NAME)
values (1006, '����һ��');
insert into TYPES (ID, NAME)
values (1007, '��������');
insert into TYPES (ID, NAME)
values (1008, '��ʮ����');

insert into USERS (ID, NAME,PASSWORD)
values (1001, 'test1','123');
insert into USERS (ID, NAME,PASSWORD)
values (1002, 'jbit','123');
insert into USERS (ID, NAME,PASSWORD)
values (1000, 'admin','123');
insert into USERS (ID, NAME,PASSWORD)
values (60, 'test2','123');
insert into USERS (ID, NAME,PASSWORD)
values (77, 'test3','123');
commit;

select * from house;

insert into house(id,title,price) values(seq_id.nextval,'�йش�����',5000);
insert into house(id,title,price,street_id) values(seq_id.nextval,'֪��·һ��',4000,1000);
update house set street_id=1001 where id=2;
commit;


