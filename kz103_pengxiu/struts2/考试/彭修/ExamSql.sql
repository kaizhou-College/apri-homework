
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
values (1, '地下室');
insert into TBL_FWLX (LXID, FWLX)
values (2, '平房');
insert into TBL_FWLX (LXID, FWLX)
values (3, '普通住宅');
insert into TBL_FWLX (LXID, FWLX)
values (4, '公寓');
insert into TBL_FWLX (LXID, FWLX)
values (5, '别墅');
commit;
prompt 5 records loaded
prompt Loading TBL_FWXX...
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (41, 1, 13, 2, 2, 3, '啊实打实', 2220, '二狗子', to_date('28-11-2017', 'dd-mm-yyyy'), '18074540017', '彭');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (42, 1, 13, 2, 2, 3, '啊实打实', 2220, '二狗子', to_date('28-11-2017', 'dd-mm-yyyy'), '18074540017', '彭');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (43, 1, 13, 4, 3, 3, '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '发 ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '', 2220, '林妹妹', to_date('28-11-2017', 'dd-mm-yyyy'), '110', '彭总');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (21, 2, 13, 2, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2016', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (61, 41, 2, 5, 2, 3, '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '漂亮的 ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || ' ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '', 2220, '一修哥三', to_date('29-11-2017', 'dd-mm-yyyy'), '110', '彭总');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (23, 2, 14, 5, 2, 1, '反正你买不起', 10123.12, '杀手不', to_date('12-12-2016', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (24, 2, 2, 1, 1, 1, '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '这个' || chr(9) || '' || chr(9) || ' ' || chr(9) || '' || chr(9) || '' || chr(9) || '' || chr(9) || '', 2220, '小乔', to_date('12-12-2016', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (25, 2, 8, 1, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (26, 2, 13, 4, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('28-11-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (27, 2, 14, 5, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (28, 2, 2, 1, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (29, 2, 15, 1, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (30, 2, 2, 3, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (31, 2, 2, 2, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (32, 2, 2, 4, 2, 1, '反正你买不起', 10123.12, '杀手不太冷', to_date('12-12-2017', 'dd-mm-yyyy'), '18074874', 'jrx');
commit;
prompt 15 records loaded
prompt Loading TBL_JD...
insert into TBL_JD (JDID, JD, QXID)
values (13, '中关村', 8);
insert into TBL_JD (JDID, JD, QXID)
values (14, '北京大学', 8);
insert into TBL_JD (JDID, JD, QXID)
values (15, '清华大学', 8);
insert into TBL_JD (JDID, JD, QXID)
values (1, '天字路二号街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (2, '天字路三号街', 1);
insert into TBL_JD (JDID, JD, QXID)
values (3, '天字路一号街', 7);
insert into TBL_JD (JDID, JD, QXID)
values (4, '天字路四号街', 6);
insert into TBL_JD (JDID, JD, QXID)
values (5, '天字路五号街', 5);
insert into TBL_JD (JDID, JD, QXID)
values (6, '天字路六号街', 4);
insert into TBL_JD (JDID, JD, QXID)
values (7, '天字路七号街', 3);
insert into TBL_JD (JDID, JD, QXID)
values (8, '天字路八号街', 1);
insert into TBL_JD (JDID, JD, QXID)
values (9, '天字路九号街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (10, '天字路十号街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (11, '天字路十号街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (12, '天字路十一号街', 2);
commit;
prompt 15 records loaded
prompt Loading TBL_QX...
insert into TBL_QX (QXID, QX)
values (8, '海淀');
insert into TBL_QX (QXID, QX)
values (1, '吕梁市');
insert into TBL_QX (QXID, QX)
values (2, '孝义市');
insert into TBL_QX (QXID, QX)
values (3, '天心区');
insert into TBL_QX (QXID, QX)
values (4, '怀化');
insert into TBL_QX (QXID, QX)
values (5, '哈尔滨');
insert into TBL_QX (QXID, QX)
values (6, '北海');
insert into TBL_QX (QXID, QX)
values (7, '常德');
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
