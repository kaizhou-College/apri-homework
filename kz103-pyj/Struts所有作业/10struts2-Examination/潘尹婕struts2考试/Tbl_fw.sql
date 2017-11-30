prompt PL/SQL Developer import file
prompt Created on 2017��11��30�� by zoe
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
  ZJ          NUMBER(8,3),
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
values (1, '��װ��');
insert into TBL_FWLX (LXID, FWLX)
values (2, '��װ��');
insert into TBL_FWLX (LXID, FWLX)
values (3, '�߼���Ԣ');
commit;
prompt 3 records loaded
prompt Loading TBL_FWXX...
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (16, 201, null, null, 2, 1, '�������ܸ�', 5678, '���Ҹ���2', null, '113', '��');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (11, 201, 29, 1, 4, 2, null, 13000, '��ʽ���2', to_date('29-11-2017', 'dd-mm-yyyy'), '114', '��');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (10, 1, 19, 2, 2, 1, '�����Ȼ����', 6900, '����', to_date('26-11-2017', 'dd-mm-yyyy'), '110', '��');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (14, 3, 3, 1, 5, 2, '����TDJG', 20000, '���ͥ', to_date('26-11-2017', 'dd-mm-yyyy'), '110', '��ԯ��');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (15, 144, 5, 1, 5, 2, '���WAGD', 30000, '������լԺ', to_date('17-11-2017', 'dd-mm-yyyy'), '11234', '��');
commit;
prompt 5 records loaded
prompt Loading TBL_JD...
insert into TBL_JD (JDID, JD, QXID)
values (1, '�йش�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (2, '������ѧ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (3, '�廪��ѧ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (4, '�ϵ�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (5, '����·', 1);
insert into TBL_JD (JDID, JD, QXID)
values (6, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (7, 'ѧԺ·', 1);
insert into TBL_JD (JDID, JD, QXID)
values (8, '��ֱ����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (9, '����Ժ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (10, '����ׯ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (11, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (12, '�����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (13, '˫����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (14, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (15, '���', 1);
insert into TBL_JD (JDID, JD, QXID)
values (16, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (17, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (18, '��ɽ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (19, '���·', 1);
insert into TBL_JD (JDID, JD, QXID)
values (20, '����·', 1);
insert into TBL_JD (JDID, JD, QXID)
values (21, '����·', 1);
insert into TBL_JD (JDID, JD, QXID)
values (22, '�򷻵�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (23, '�ʼҿ�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (24, '����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (25, '���¹�', 1);
insert into TBL_JD (JDID, JD, QXID)
values (26, '��̫ƽׯ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (27, '����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (28, '����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (29, '�ļ���', 1);
insert into TBL_JD (JDID, JD, QXID)
values (30, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (31, '��Ȫ��', 1);
insert into TBL_JD (JDID, JD, QXID)
values (32, '�ռ���', 1);
insert into TBL_JD (JDID, JD, QXID)
values (33, '��ׯ', 1);
insert into TBL_JD (JDID, JD, QXID)
values (34, 'κ����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (35, '������', 1);
insert into TBL_JD (JDID, JD, QXID)
values (36, '��԰·', 1);
insert into TBL_JD (JDID, JD, QXID)
values (37, '����԰', 1);
insert into TBL_JD (JDID, JD, QXID)
values (38, '����', 1);
insert into TBL_JD (JDID, JD, QXID)
values (298, '����կ', 15);
insert into TBL_JD (JDID, JD, QXID)
values (39, '���˴�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (40, '��Ԫ��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (41, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (42, '��չ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (43, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (44, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (45, '��ɯ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (46, '�Ž��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (47, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (48, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (49, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (50, '�˼�԰', 2);
insert into TBL_JD (JDID, JD, QXID)
values (51, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (52, '����¥', 2);
insert into TBL_JD (JDID, JD, QXID)
values (53, '˫��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (54, '��ͷ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (55, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (56, '���ӵ�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (57, '���ׯ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (58, '���԰', 2);
insert into TBL_JD (JDID, JD, QXID)
values (59, '�׶�����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (60, 'С��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (61, '��ƽ��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (62, 'С����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (63, 'ʮ�����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (64, '����ׯ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (65, '��ׯ��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (66, '����Ӫ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (67, '��ĥ��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (68, '���䷿', 2);
insert into TBL_JD (JDID, JD, QXID)
values (69, '��ׯ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (70, '�߱���', 2);
insert into TBL_JD (JDID, JD, QXID)
values (71, '��Ӫ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (72, 'ƽ��', 2);
insert into TBL_JD (JDID, JD, QXID)
values (73, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (74, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (75, '��յ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (76, '��̨', 2);
insert into TBL_JD (JDID, JD, QXID)
values (77, '�޸�ׯ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (78, '���', 2);
insert into TBL_JD (JDID, JD, QXID)
values (79, '����Ӫ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (80, '̫����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (81, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (82, '���˴�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (83, '��ó', 2);
insert into TBL_JD (JDID, JD, QXID)
values (84, '���Ӻ�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (85, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (86, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (87, '����ׯ', 2);
insert into TBL_JD (JDID, JD, QXID)
values (88, '���ҵ�', 2);
insert into TBL_JD (JDID, JD, QXID)
values (89, '������', 2);
insert into TBL_JD (JDID, JD, QXID)
values (90, '��̨·', 2);
insert into TBL_JD (JDID, JD, QXID)
values (91, '����', 2);
insert into TBL_JD (JDID, JD, QXID)
values (92, 'ǰ��', 3);
insert into TBL_JD (JDID, JD, QXID)
values (93, '��̳', 3);
insert into TBL_JD (JDID, JD, QXID)
values (94, '��������', 3);
insert into TBL_JD (JDID, JD, QXID)
values (95, '��̶��', 3);
insert into TBL_JD (JDID, JD, QXID)
values (96, '������', 3);
insert into TBL_JD (JDID, JD, QXID)
values (97, '������·', 3);
insert into TBL_JD (JDID, JD, QXID)
values (98, '��������', 3);
insert into TBL_JD (JDID, JD, QXID)
values (99, '����', 3);
commit;
prompt 100 records committed...
insert into TBL_JD (JDID, JD, QXID)
values (100, '�׹�·', 4);
insert into TBL_JD (JDID, JD, QXID)
values (101, '���԰', 4);
insert into TBL_JD (JDID, JD, QXID)
values (102, '���п�', 4);
insert into TBL_JD (JDID, JD, QXID)
values (103, '������', 4);
insert into TBL_JD (JDID, JD, QXID)
values (104, '������', 4);
insert into TBL_JD (JDID, JD, QXID)
values (105, '��ƽ��', 4);
insert into TBL_JD (JDID, JD, QXID)
values (106, '����', 4);
insert into TBL_JD (JDID, JD, QXID)
values (107, '������', 4);
insert into TBL_JD (JDID, JD, QXID)
values (108, '��դ��', 4);
insert into TBL_JD (JDID, JD, QXID)
values (109, '���п�', 4);
insert into TBL_JD (JDID, JD, QXID)
values (110, 'ţ��', 4);
insert into TBL_JD (JDID, JD, QXID)
values (111, '��ֽ��', 4);
insert into TBL_JD (JDID, JD, QXID)
values (112, '��Ȼͤ', 4);
insert into TBL_JD (JDID, JD, QXID)
values (113, '�����ֵ�', 4);
insert into TBL_JD (JDID, JD, QXID)
values (114, '�㰲����', 4);
insert into TBL_JD (JDID, JD, QXID)
values (115, '�㰲����', 4);
insert into TBL_JD (JDID, JD, QXID)
values (116, '����', 4);
insert into TBL_JD (JDID, JD, QXID)
values (117, '��ֱ��', 5);
insert into TBL_JD (JDID, JD, QXID)
values (118, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (119, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (120, '��ɽ', 5);
insert into TBL_JD (JDID, JD, QXID)
values (121, '����ʮ��', 5);
insert into TBL_JD (JDID, JD, QXID)
values (122, '����', 5);
insert into TBL_JD (JDID, JD, QXID)
values (123, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (124, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (125, '����վ', 5);
insert into TBL_JD (JDID, JD, QXID)
values (126, '��ƽ��', 5);
insert into TBL_JD (JDID, JD, QXID)
values (127, 'Ӻ�͹�', 5);
insert into TBL_JD (JDID, JD, QXID)
values (128, '��ֱ����', 5);
insert into TBL_JD (JDID, JD, QXID)
values (129, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (130, '����', 5);
insert into TBL_JD (JDID, JD, QXID)
values (131, '����', 5);
insert into TBL_JD (JDID, JD, QXID)
values (132, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (133, '������', 5);
insert into TBL_JD (JDID, JD, QXID)
values (134, '����', 5);
insert into TBL_JD (JDID, JD, QXID)
values (135, '����·', 6);
insert into TBL_JD (JDID, JD, QXID)
values (136, '������', 6);
insert into TBL_JD (JDID, JD, QXID)
values (137, '����ʿ·', 6);
insert into TBL_JD (JDID, JD, QXID)
values (138, '��̳', 6);
insert into TBL_JD (JDID, JD, QXID)
values (139, '������', 6);
insert into TBL_JD (JDID, JD, QXID)
values (140, 'չ��·', 6);
insert into TBL_JD (JDID, JD, QXID)
values (141, '����', 6);
insert into TBL_JD (JDID, JD, QXID)
values (142, '����', 6);
insert into TBL_JD (JDID, JD, QXID)
values (143, '��ֱ��', 6);
insert into TBL_JD (JDID, JD, QXID)
values (144, '�½ֿ�', 6);
insert into TBL_JD (JDID, JD, QXID)
values (145, 'ʲɲ��', 6);
insert into TBL_JD (JDID, JD, QXID)
values (146, '�ذ���', 6);
insert into TBL_JD (JDID, JD, QXID)
values (147, '��¥', 6);
insert into TBL_JD (JDID, JD, QXID)
values (148, '����', 6);
insert into TBL_JD (JDID, JD, QXID)
values (149, '���ڽ�', 6);
insert into TBL_JD (JDID, JD, QXID)
values (150, '��������', 6);
insert into TBL_JD (JDID, JD, QXID)
values (151, '��ʤ��', 6);
insert into TBL_JD (JDID, JD, QXID)
values (152, '����', 6);
insert into TBL_JD (JDID, JD, QXID)
values (153, '��Է', 7);
insert into TBL_JD (JDID, JD, QXID)
values (154, '�в�', 7);
insert into TBL_JD (JDID, JD, QXID)
values (155, '�»�', 7);
insert into TBL_JD (JDID, JD, QXID)
values (156, '����', 7);
insert into TBL_JD (JDID, JD, QXID)
values (157, '��˳', 7);
insert into TBL_JD (JDID, JD, QXID)
values (158, '��԰', 7);
insert into TBL_JD (JDID, JD, QXID)
values (159, '��ׯ', 7);
insert into TBL_JD (JDID, JD, QXID)
values (160, 'º��', 7);
insert into TBL_JD (JDID, JD, QXID)
values (161, '�ż���', 7);
insert into TBL_JD (JDID, JD, QXID)
values (162, '̨��', 7);
insert into TBL_JD (JDID, JD, QXID)
values (163, '�����', 7);
insert into TBL_JD (JDID, JD, QXID)
values (164, '����', 7);
insert into TBL_JD (JDID, JD, QXID)
values (165, '�t��', 7);
insert into TBL_JD (JDID, JD, QXID)
values (166, '���ֵ�', 7);
insert into TBL_JD (JDID, JD, QXID)
values (167, '����', 7);
insert into TBL_JD (JDID, JD, QXID)
values (168, '��ȪӪ', 8);
insert into TBL_JD (JDID, JD, QXID)
values (169, '��ׯ', 8);
insert into TBL_JD (JDID, JD, QXID)
values (170, '��̨·', 8);
insert into TBL_JD (JDID, JD, QXID)
values (171, '¬����', 8);
insert into TBL_JD (JDID, JD, QXID)
values (172, '̫ƽ��', 8);
insert into TBL_JD (JDID, JD, QXID)
values (173, '������', 8);
insert into TBL_JD (JDID, JD, QXID)
values (174, '�Ƹ�', 8);
insert into TBL_JD (JDID, JD, QXID)
values (175, '�´�', 8);
insert into TBL_JD (JDID, JD, QXID)
values (176, '�Ұ���', 8);
insert into TBL_JD (JDID, JD, QXID)
values (177, '��ұ�', 8);
insert into TBL_JD (JDID, JD, QXID)
values (178, '����԰', 8);
insert into TBL_JD (JDID, JD, QXID)
values (179, '�����', 8);
insert into TBL_JD (JDID, JD, QXID)
values (180, '��Է', 8);
insert into TBL_JD (JDID, JD, QXID)
values (181, '���ߵ�', 8);
insert into TBL_JD (JDID, JD, QXID)
values (182, '������Ӫ', 8);
insert into TBL_JD (JDID, JD, QXID)
values (183, '����', 8);
insert into TBL_JD (JDID, JD, QXID)
values (184, '�Ǳ�', 9);
insert into TBL_JD (JDID, JD, QXID)
values (185, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (186, '�Ͽ�', 9);
insert into TBL_JD (JDID, JD, QXID)
values (187, '��ؿ�', 9);
insert into TBL_JD (JDID, JD, QXID)
values (188, 'ɳ��', 9);
insert into TBL_JD (JDID, JD, QXID)
values (189, '������', 9);
insert into TBL_JD (JDID, JD, QXID)
values (190, '��ͨԷ', 9);
insert into TBL_JD (JDID, JD, QXID)
values (191, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (192, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (193, 'ʮ����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (194, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (195, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (196, '�޴�', 9);
insert into TBL_JD (JDID, JD, QXID)
values (197, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (198, 'С��ɽ', 9);
insert into TBL_JD (JDID, JD, QXID)
values (199, '����', 9);
commit;
prompt 200 records committed...
insert into TBL_JD (JDID, JD, QXID)
values (200, '��С��', 9);
insert into TBL_JD (JDID, JD, QXID)
values (201, '���߼�', 9);
insert into TBL_JD (JDID, JD, QXID)
values (202, '����', 9);
insert into TBL_JD (JDID, JD, QXID)
values (203, '�˷�', 10);
insert into TBL_JD (JDID, JD, QXID)
values (204, '��Դ', 10);
insert into TBL_JD (JDID, JD, QXID)
values (205, '��У·', 10);
insert into TBL_JD (JDID, JD, QXID)
values (206, '�ƴ�', 10);
insert into TBL_JD (JDID, JD, QXID)
values (207, '������', 10);
insert into TBL_JD (JDID, JD, QXID)
values (208, '�ɹ�', 10);
insert into TBL_JD (JDID, JD, QXID)
values (209, '��ׯ', 10);
insert into TBL_JD (JDID, JD, QXID)
values (210, '孺�', 10);
insert into TBL_JD (JDID, JD, QXID)
values (211, '���Ƶ�', 10);
insert into TBL_JD (JDID, JD, QXID)
values (212, '����Ӫ', 10);
insert into TBL_JD (JDID, JD, QXID)
values (213, '����', 10);
insert into TBL_JD (JDID, JD, QXID)
values (214, '����', 10);
insert into TBL_JD (JDID, JD, QXID)
values (215, 'κ��ׯ', 10);
insert into TBL_JD (JDID, JD, QXID)
values (216, '����', 10);
insert into TBL_JD (JDID, JD, QXID)
values (217, '����', 10);
insert into TBL_JD (JDID, JD, QXID)
values (218, '�Ӹ�ׯ', 10);
insert into TBL_JD (JDID, JD, QXID)
values (219, '��갴�', 10);
insert into TBL_JD (JDID, JD, QXID)
values (220, '����', 10);
insert into TBL_JD (JDID, JD, QXID)
values (221, '����', 11);
insert into TBL_JD (JDID, JD, QXID)
values (222, '���ӽֵ�', 11);
insert into TBL_JD (JDID, JD, QXID)
values (223, '������', 11);
insert into TBL_JD (JDID, JD, QXID)
values (224, '��̨', 11);
insert into TBL_JD (JDID, JD, QXID)
values (225, '��ƽ', 11);
insert into TBL_JD (JDID, JD, QXID)
values (226, '��Ȫ', 11);
insert into TBL_JD (JDID, JD, QXID)
values (227, '����', 11);
insert into TBL_JD (JDID, JD, QXID)
values (228, '̶����', 11);
insert into TBL_JD (JDID, JD, QXID)
values (229, '��ƽ', 11);
insert into TBL_JD (JDID, JD, QXID)
values (230, '��ׯ', 11);
insert into TBL_JD (JDID, JD, QXID)
values (231, '���ɽ', 11);
insert into TBL_JD (JDID, JD, QXID)
values (232, '���', 11);
insert into TBL_JD (JDID, JD, QXID)
values (233, 'ի��', 11);
insert into TBL_JD (JDID, JD, QXID)
values (234, '��ˮ', 11);
insert into TBL_JD (JDID, JD, QXID)
values (235, '����', 11);
insert into TBL_JD (JDID, JD, QXID)
values (236, '�˱�ɽ', 12);
insert into TBL_JD (JDID, JD, QXID)
values (237, '�ų�', 12);
insert into TBL_JD (JDID, JD, QXID)
values (238, 'ƻ��԰', 12);
insert into TBL_JD (JDID, JD, QXID)
values (239, '³��', 12);
insert into TBL_JD (JDID, JD, QXID)
values (240, '��ɽ', 12);
insert into TBL_JD (JDID, JD, QXID)
values (241, '�˽�', 12);
insert into TBL_JD (JDID, JD, QXID)
values (242, '�𶥽�', 12);
insert into TBL_JD (JDID, JD, QXID)
values (243, '����', 12);
insert into TBL_JD (JDID, JD, QXID)
values (244, '������', 12);
insert into TBL_JD (JDID, JD, QXID)
values (245, '����', 12);
insert into TBL_JD (JDID, JD, QXID)
values (246, '�ǹ�', 13);
insert into TBL_JD (JDID, JD, QXID)
values (247, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (248, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (249, 'ӭ��', 13);
insert into TBL_JD (JDID, JD, QXID)
values (250, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (251, '�ǳ�', 13);
insert into TBL_JD (JDID, JD, QXID)
values (252, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (253, '������', 13);
insert into TBL_JD (JDID, JD, QXID)
values (254, '�ܿڵ�', 13);
insert into TBL_JD (JDID, JD, QXID)
values (255, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (256, '�ִ�', 13);
insert into TBL_JD (JDID, JD, QXID)
values (257, '��', 13);
insert into TBL_JD (JDID, JD, QXID)
values (258, '�����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (259, 'ʯ¥', 13);
insert into TBL_JD (JDID, JD, QXID)
values (260, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (261, '��ʯ��', 13);
insert into TBL_JD (JDID, JD, QXID)
values (262, '�ŷ�', 13);
insert into TBL_JD (JDID, JD, QXID)
values (263, 'ʮ��', 13);
insert into TBL_JD (JDID, JD, QXID)
values (264, '������', 13);
insert into TBL_JD (JDID, JD, QXID)
values (265, '�ӱ���', 13);
insert into TBL_JD (JDID, JD, QXID)
values (266, '����ׯ', 13);
insert into TBL_JD (JDID, JD, QXID)
values (267, '��ɽ', 13);
insert into TBL_JD (JDID, JD, QXID)
values (268, 'ʷ��Ӫ', 13);
insert into TBL_JD (JDID, JD, QXID)
values (269, '�Ͻ�', 13);
insert into TBL_JD (JDID, JD, QXID)
values (270, 'ϼ����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (271, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (272, '����', 13);
insert into TBL_JD (JDID, JD, QXID)
values (273, 'ʤ��', 14);
insert into TBL_JD (JDID, JD, QXID)
values (274, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (275, 'ʯ԰', 14);
insert into TBL_JD (JDID, JD, QXID)
values (276, '�ʺ�', 14);
insert into TBL_JD (JDID, JD, QXID)
values (277, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (278, 'ţ��ɽ', 14);
insert into TBL_JD (JDID, JD, QXID)
values (279, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (280, '�Ϸ���', 14);
insert into TBL_JD (JDID, JD, QXID)
values (281, '��ɳ��', 14);
insert into TBL_JD (JDID, JD, QXID)
values (282, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (283, '��СӪ', 14);
insert into TBL_JD (JDID, JD, QXID)
values (284, '�ϲ�', 14);
insert into TBL_JD (JDID, JD, QXID)
values (285, 'ľ��', 14);
insert into TBL_JD (JDID, JD, QXID)
values (286, '������', 14);
insert into TBL_JD (JDID, JD, QXID)
values (287, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (288, '�����ׯ', 14);
insert into TBL_JD (JDID, JD, QXID)
values (289, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (290, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (291, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (292, '����Ӫ', 14);
insert into TBL_JD (JDID, JD, QXID)
values (293, '��ȫӪ', 14);
insert into TBL_JD (JDID, JD, QXID)
values (294, '��ʯ��', 14);
insert into TBL_JD (JDID, JD, QXID)
values (295, '����', 14);
insert into TBL_JD (JDID, JD, QXID)
values (296, 'Ϫ��ׯ', 15);
insert into TBL_JD (JDID, JD, QXID)
values (297, 'ʮ�ﱤ', 15);
insert into TBL_JD (JDID, JD, QXID)
values (299, '������', 15);
insert into TBL_JD (JDID, JD, QXID)
values (300, '�޸�ׯ', 15);
commit;
prompt 300 records committed...
insert into TBL_JD (JDID, JD, QXID)
values (301, '�����', 15);
insert into TBL_JD (JDID, JD, QXID)
values (302, '��ׯ', 15);
insert into TBL_JD (JDID, JD, QXID)
values (303, '̫ʦ��', 15);
insert into TBL_JD (JDID, JD, QXID)
values (304, '�³���', 15);
insert into TBL_JD (JDID, JD, QXID)
values (305, '�ű���', 15);
insert into TBL_JD (JDID, JD, QXID)
values (306, '����', 15);
insert into TBL_JD (JDID, JD, QXID)
values (307, '������', 15);
insert into TBL_JD (JDID, JD, QXID)
values (308, '�����', 15);
insert into TBL_JD (JDID, JD, QXID)
values (309, 'ʯ��', 15);
insert into TBL_JD (JDID, JD, QXID)
values (310, '�����ׯ', 15);
insert into TBL_JD (JDID, JD, QXID)
values (311, '�¼���', 15);
insert into TBL_JD (JDID, JD, QXID)
values (312, '����', 15);
insert into TBL_JD (JDID, JD, QXID)
values (313, '��ɽ', 16);
insert into TBL_JD (JDID, JD, QXID)
values (314, 'Ȫ��', 16);
insert into TBL_JD (JDID, JD, QXID)
values (315, '���', 16);
insert into TBL_JD (JDID, JD, QXID)
values (316, '����', 16);
insert into TBL_JD (JDID, JD, QXID)
values (317, '����', 16);
insert into TBL_JD (JDID, JD, QXID)
values (318, '����', 16);
insert into TBL_JD (JDID, JD, QXID)
values (319, '����', 16);
insert into TBL_JD (JDID, JD, QXID)
values (320, '������', 16);
insert into TBL_JD (JDID, JD, QXID)
values (321, '�Ŷɺ�', 16);
insert into TBL_JD (JDID, JD, QXID)
values (322, '����', 16);
insert into TBL_JD (JDID, JD, QXID)
values (323, '������', 16);
insert into TBL_JD (JDID, JD, QXID)
values (324, '���ӿ�', 16);
insert into TBL_JD (JDID, JD, QXID)
values (325, '��ɽ', 16);
insert into TBL_JD (JDID, JD, QXID)
values (326, '����', 16);
insert into TBL_JD (JDID, JD, QXID)
values (327, '����', 17);
insert into TBL_JD (JDID, JD, QXID)
values (328, '��ׯ', 17);
insert into TBL_JD (JDID, JD, QXID)
values (329, '�˴���', 17);
insert into TBL_JD (JDID, JD, QXID)
values (330, '������', 17);
insert into TBL_JD (JDID, JD, QXID)
values (331, '��ׯ', 17);
insert into TBL_JD (JDID, JD, QXID)
values (332, '����', 17);
insert into TBL_JD (JDID, JD, QXID)
values (333, '�ĺ�', 17);
insert into TBL_JD (JDID, JD, QXID)
values (334, 'ǧ�ҵ�', 17);
insert into TBL_JD (JDID, JD, QXID)
values (335, '����', 17);
insert into TBL_JD (JDID, JD, QXID)
values (336, '���Ӫ', 17);
insert into TBL_JD (JDID, JD, QXID)
values (337, '��ɽӪ', 17);
insert into TBL_JD (JDID, JD, QXID)
values (338, '��ׯ��', 17);
insert into TBL_JD (JDID, JD, QXID)
values (339, '��Ӫ', 17);
insert into TBL_JD (JDID, JD, QXID)
values (340, '����', 17);
insert into TBL_JD (JDID, JD, QXID)
values (341, '����Ȫ', 17);
insert into TBL_JD (JDID, JD, QXID)
values (342, '����', 17);
insert into TBL_JD (JDID, JD, QXID)
values (343, '����', 18);
insert into TBL_JD (JDID, JD, QXID)
values (344, '�˹�', 18);
insert into TBL_JD (JDID, JD, QXID)
values (345, '����', 18);
insert into TBL_JD (JDID, JD, QXID)
values (346, '����', 18);
insert into TBL_JD (JDID, JD, QXID)
values (347, '��', 18);
insert into TBL_JD (JDID, JD, QXID)
values (348, '�𺣺�', 18);
insert into TBL_JD (JDID, JD, QXID)
values (349, 'ƽ����', 18);
insert into TBL_JD (JDID, JD, QXID)
values (350, '����ׯ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (351, '���Ӫ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (352, '���ߴ�', 18);
insert into TBL_JD (JDID, JD, QXID)
values (353, '�ĸ�ׯ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (354, '�϶��ֺ�', 18);
insert into TBL_JD (JDID, JD, QXID)
values (355, '����Ӫ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (356, '��ɽ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (357, '���ҵ�', 18);
insert into TBL_JD (JDID, JD, QXID)
values (358, '����ׯ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (359, 'ɽ��ׯ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (360, '������', 18);
insert into TBL_JD (JDID, JD, QXID)
values (361, '�ܶ�կ', 18);
insert into TBL_JD (JDID, JD, QXID)
values (362, '����', 18);
commit;
prompt 362 records loaded
prompt Loading TBL_QX...
prompt Table is empty
prompt Loading TBL_USER...
insert into TBL_USER (UUID, UNAME, UPASS)
values (201, 'ˮ', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (142, '�ȵ�', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (143, '����', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (1, 'admin', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (3, '����', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (2, '��д', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (144, '��ݮ', '123');
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
