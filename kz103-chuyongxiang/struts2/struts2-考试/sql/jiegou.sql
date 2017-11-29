------------------------------------------------
-- Export file for user SCOTT                 --
-- Created by Captain on 2017/11/29, 14:32:30 --
------------------------------------------------

spool jiegou.log

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
alter table SCOTT.TBL_JD
  add primary key (JDID)
  disable;

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
prompt Creating sequence SYS_C005245
prompt =============================
prompt
create sequence SCOTT.SYS_C005245
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_C005246
prompt =============================
prompt
create sequence SCOTT.SYS_C005246
minvalue 1
maxvalue 999999999999999999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_C005291
prompt =============================
prompt
create sequence SCOTT.SYS_C005291
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence SYS_C005294
prompt =============================
prompt
create sequence SCOTT.SYS_C005294
minvalue 1
maxvalue 999999999999999999999999999
start with 81
increment by 1
cache 20;


spool off
