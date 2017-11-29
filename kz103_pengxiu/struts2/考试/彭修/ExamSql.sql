
spool baishi.log

prompt
prompt Creating table TBL_FWLX
prompt =======================
prompt
create table SCOTT.TBL_FWLX
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
alter table SCOTT.TBL_FWLX
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

prompt
prompt Creating table TBL_FWXX
prompt =======================
prompt
create table SCOTT.TBL_FWXX
(
  FWID        NUMBER not null,
  UUID        NUMBER,
  JDID        NUMBER,
  LXID        NUMBER,
  SHI         NUMBER,
  TING        NUMBER,
  FWXX        VARCHAR2(2000),
  ZJ          NUMBER(20,2),
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
alter table SCOTT.TBL_FWXX
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

prompt
prompt Creating table TBL_JD
prompt =====================
prompt
create table SCOTT.TBL_JD
(
  JDID NUMBER not null,
  JD   VARCHAR2(50),
  QXID NUMBER
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
alter table SCOTT.TBL_JD
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

prompt
prompt Creating table TBL_QX
prompt =====================
prompt
create table SCOTT.TBL_QX
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
alter table SCOTT.TBL_QX
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

prompt
prompt Creating table TBL_USER
prompt =======================
prompt
create table SCOTT.TBL_USER
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
alter table SCOTT.TBL_USER
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

prompt
prompt Creating sequence FWID
prompt ======================
prompt
create sequence SCOTT.FWID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence FWLX
prompt ======================
prompt
create sequence SCOTT.FWLX
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence FWXX
prompt ======================
prompt
create sequence SCOTT.FWXX
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence JDID
prompt ======================
prompt
create sequence SCOTT.JDID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence LXID
prompt ======================
prompt
create sequence SCOTT.LXID
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence QX
prompt ====================
prompt
create sequence SCOTT.QX
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;


spool off


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
values (1, '������');
insert into TBL_FWLX (LXID, FWLX)
values (2, 'ƽ��');
insert into TBL_FWLX (LXID, FWLX)
values (3, '��ͨסլ');
insert into TBL_FWLX (LXID, FWLX)
values (4, '��Ԣ');
insert into TBL_FWLX (LXID, FWLX)
values (5, '����');
commit;
prompt 5 records loaded
prompt Loading TBL_FWXX...
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (41, 1, 13, 2, 2, 3, '��ʵ��ʵ', 2220, '������', to_date('28-11-2017', 'dd-mm-yyyy'), '18074540017', '��');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (42, 1, 13, 2, 2, 3, '��ʵ��ʵ', 2220, '������', to_date('28-11-2017', 'dd-mm-yyyy'), '18074540017', '��');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (43, 1, 13, 4, 3, 3, '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '�� ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '', 2220, '������', to_date('28-11-2017', 'dd-mm-yyyy'), '110', '����');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (21, 2, 13, 2, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2016', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (61, 41, 2, 5, 2, 3, '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || 'Ư���� ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || ' ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '', 2220, 'һ�޸���', to_date('29-11-2017', 'dd-mm-yyyy'), '110', '����');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (23, 2, 14, 5, 2, 1, '����������', 10123.12, 'ɱ�ֲ�', to_date('12-12-2016', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (24, 2, 2, 1, 1, 1, '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '���' || chr(9) || '' || chr(9) || ' ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '', 2220, 'С��', to_date('12-12-2016', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (25, 2, 8, 1, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (26, 2, 13, 4, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('28-11-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (27, 2, 14, 5, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (28, 2, 2, 1, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (29, 2, 15, 1, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (30, 2, 2, 3, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (31, 2, 2, 2, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (32, 2, 2, 4, 2, 1, '����������', 10123.12, 'ɱ�ֲ�̫��', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
commit;
prompt 15 records loaded
prompt Loading TBL_JD...
insert into TBL_JD (JDID, JD, QXID)
values (13, '�йش�', 8);
insert into TBL_JD (JDID, JD, QXID)
values (14, '������ѧ', 8);
insert into TBL_JD (JDID, JD, QXID)
values (15, '�廪��ѧ', 8);
insert into TBL_JD (JDID, JD, QXID)
values (1, '����·���Ž�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (2, '����·���Ž�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (3, '����·һ�Ž�', 7);
insert into TBL_JD (JDID, JD, QXID)
values (4, '����·�ĺŽ�', 6);
insert into TBL_JD (JDID, JD, QXID)
values (5, '����·��Ž�', 5);
insert into TBL_JD (JDID, JD, QXID)
values (6, '����·���Ž�', 4);
insert into TBL_JD (JDID, JD, QXID)
values (7, '����·�ߺŽ�', 3);
insert into TBL_JD (JDID, JD, QXID)
values (8, '����·�˺Ž�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (9, '����·�źŽ�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (10, '����·ʮ�Ž�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (11, '����·ʮ�Ž�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (12, '����·ʮһ�Ž�', 2);
commit;
prompt 15 records loaded
prompt Loading TBL_QX...
insert into TBL_QX (QXID, QX)
values (8, '����');
insert into TBL_QX (QXID, QX)
values (1, '������');
insert into TBL_QX (QXID, QX)
values (2, 'Т����');
insert into TBL_QX (QXID, QX)
values (3, '������');
insert into TBL_QX (QXID, QX)
values (4, '����');
insert into TBL_QX (QXID, QX)
values (5, '������');
insert into TBL_QX (QXID, QX)
values (6, '����');
insert into TBL_QX (QXID, QX)
values (7, '����');
commit;
prompt 8 records loaded
prompt Loading TBL_USER...
insert into TBL_USER (UUID, UNAME, UPASS)
values (1, 'yjy', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (2, 'user', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (21, 'qw', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (41, 'zx', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (42, 'post', '123');
commit;
prompt 5 records loaded
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
