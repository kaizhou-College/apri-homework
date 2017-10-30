delete from USERS;
delete from TYPES;
delete from STREET;
delete from DISTRICT;
insert into DISTRICT (ID, NAME)
values (1001, '东城');
insert into DISTRICT (ID, NAME)
values (1002, '西城');
insert into DISTRICT (ID, NAME)
values (1003, '石景山');
insert into DISTRICT (ID, NAME)
values (1006, '朝阳');
insert into DISTRICT (ID, NAME)
values (1000, '丰台');
insert into DISTRICT (ID, NAME)
values (1004, '海淀');

insert into STREET (ID, NAME, DISTRICT_ID)
values (1000, '知春路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1001, '中关村大街', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1002, '学院路', 1004);
insert into STREET (ID, NAME, DISTRICT_ID)
values (1003, '朝阳路', 1006);

insert into TYPES (ID, NAME)
values (1000, '一室一厅');
insert into TYPES (ID, NAME)
values (1001, '一室两厅');
insert into TYPES (ID, NAME)
values (1002, '两室一厅');
insert into TYPES (ID, NAME)
values (1003, '两室两厅');
insert into TYPES (ID, NAME)
values (1004, '三室一厅');
insert into TYPES (ID, NAME)
values (1005, '三室两厅');
insert into TYPES (ID, NAME)
values (1006, '四室一厅');
insert into TYPES (ID, NAME)
values (1007, '四室两厅');
insert into TYPES (ID, NAME)
values (1008, '四十三厅');

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

insert into house(id,title,price) values(seq_id.nextval,'中关村两居',5000);
insert into house(id,title,price,street_id) values(seq_id.nextval,'知春路一居',4000,1000);
update house set street_id=1001 where id=2;
commit;


