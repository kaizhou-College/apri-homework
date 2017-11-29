prompt PL/SQL Developer import file
prompt Created on 2017��11��29�� by WTG
set feedback off
set define off
prompt Creating TBL_FWLX...
create table TBL_FWLX
(
  LXID NUMBER not null,
  FWLX VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table TBL_FWLX
  add primary key (LXID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating TBL_FWXX...
create table TBL_FWXX
(
  FWID        NUMBER not null,
  UUID        NUMBER,
  JDID        NUMBER,
  LXID        NUMBER,
  SHI         NUMBER,
  TING        NUMBER,
  FWXX        VARCHAR2(2000),
  ZJ          NUMBER(10,2),
  TITLE       VARCHAR2(70) not null,
  PUBLISHDATE DATE,
  TELEPHONE   VARCHAR2(50),
  LXR         VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table TBL_FWXX
  add primary key (FWID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating TBL_JD...
create table TBL_JD
(
  JDID NUMBER not null,
  JD   VARCHAR2(50),
  QXID NUMBER not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table TBL_JD
  add primary key (JDID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating TBL_QX...
create table TBL_QX
(
  QXID NUMBER not null,
  QX   VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table TBL_QX
  add primary key (QXID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Creating TBL_USER...
create table TBL_USER
(
  UUID  NUMBER not null,
  UNAME VARCHAR2(50) not null,
  UPASS VARCHAR2(50) not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table TBL_USER
  add primary key (UUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for TBL_FWLX...
alter table TBL_FWLX disable all triggers;
prompt Disabling triggers for TBL_FWXX...
alter table TBL_FWXX disable all triggers;
prompt Disabling triggers for TBL_JD...
alter table TBL_JD disable all triggers;
prompt Disabling triggers for TBL_QX...
alter table TBL_QX disable all triggers;
prompt Disabling triggers for TBL_USER...
alter table TBL_USER disable all triggers;
prompt Deleting TBL_USER...
delete from TBL_USER;
commit;
prompt Deleting TBL_QX...
delete from TBL_QX;
commit;
prompt Deleting TBL_JD...
delete from TBL_JD;
commit;
prompt Deleting TBL_FWXX...
delete from TBL_FWXX;
commit;
prompt Deleting TBL_FWLX...
delete from TBL_FWLX;
commit;
prompt Loading TBL_FWLX...
insert into TBL_FWLX (LXID, FWLX)
values (1, '��ͨסլ');
insert into TBL_FWLX (LXID, FWLX)
values (2, '������');
insert into TBL_FWLX (LXID, FWLX)
values (3, 'ƽ��');
insert into TBL_FWLX (LXID, FWLX)
values (4, '��Ԣ');
insert into TBL_FWLX (LXID, FWLX)
values (5, '����');
commit;
prompt 5 records loaded
prompt Loading TBL_FWXX...
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (4, 1, 1, 1, 4, 1, '����һ��', 15000, '������������', to_date('29-11-2017', 'dd-mm-yyyy'), '17629988658', '������');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (1, 1, 2, 1, 1, 1, 'һ��һ��', 5000, 'ѧ����������', to_date('02-12-2017', 'dd-mm-yyyy'), '13123413361', '������');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (2, 2, 3, 1, 2, 2, '��������', 10000, 'ѧ����������', to_date('30-11-2017', 'dd-mm-yyyy'), '37312884355', '��Ůʿ');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (3, 1, 4, 1, 3, 1, '����һ��', 15000, '������������', to_date('29-11-2017', 'dd-mm-yyyy'), '17629988658', '������');
commit;
prompt 4 records loaded
prompt Loading TBL_JD...
insert into TBL_JD (JDID, JD, QXID)
values (1, '�йش�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (2, '������ѧ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (3, '�廪��ѧ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (4, '�ϵ�', 4);
insert into TBL_JD (JDID, JD, QXID)
values (5, '����·', 3);
insert into TBL_JD (JDID, JD, QXID)
values (6, '����', 5);
insert into TBL_JD (JDID, JD, QXID)
values (7, 'ѧԺ·', 7);
insert into TBL_JD (JDID, JD, QXID)
values (8, '��ֱ����', 6);
insert into TBL_JD (JDID, JD, QXID)
values (9, '������', 4);
commit;
prompt 9 records loaded
prompt Loading TBL_QX...
insert into TBL_QX (QXID, QX)
values (1, '����');
insert into TBL_QX (QXID, QX)
values (2, '����');
insert into TBL_QX (QXID, QX)
values (3, '����');
insert into TBL_QX (QXID, QX)
values (4, '����');
insert into TBL_QX (QXID, QX)
values (5, '����');
insert into TBL_QX (QXID, QX)
values (6, '����');
insert into TBL_QX (QXID, QX)
values (7, 'ͨ��');
insert into TBL_QX (QXID, QX)
values (8, '��̨');
commit;
prompt 8 records loaded
prompt Loading TBL_USER...
insert into TBL_USER (UUID, UNAME, UPASS)
values (5, '������', '333');
insert into TBL_USER (UUID, UNAME, UPASS)
values (2, '������', '111');
insert into TBL_USER (UUID, UNAME, UPASS)
values (1, '��С��', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (21, '�豭', '555');
insert into TBL_USER (UUID, UNAME, UPASS)
values (22, '����', '666');
insert into TBL_USER (UUID, UNAME, UPASS)
values (3, 'С��', '222');
insert into TBL_USER (UUID, UNAME, UPASS)
values (4, '������', '333');
commit;
prompt 7 records loaded
prompt Enabling triggers for TBL_FWLX...
alter table TBL_FWLX enable all triggers;
prompt Enabling triggers for TBL_FWXX...
alter table TBL_FWXX enable all triggers;
prompt Enabling triggers for TBL_JD...
alter table TBL_JD enable all triggers;
prompt Enabling triggers for TBL_QX...
alter table TBL_QX enable all triggers;
prompt Enabling triggers for TBL_USER...
alter table TBL_USER enable all triggers;
set feedback on
set define on
prompt Done.
