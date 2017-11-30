prompt PL/SQL Developer import file
prompt Created on 2017年11月30日 by zoe
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
values (1, '精装房');
insert into TBL_FWLX (LXID, FWLX)
values (2, '简装房');
insert into TBL_FWLX (LXID, FWLX)
values (3, '高级公寓');
commit;
prompt 3 records loaded
prompt Loading TBL_FWXX...
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (16, 201, null, null, 2, 1, '更期望很高', 5678, '而且给我2', null, '113', '测');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (11, 201, 29, 1, 4, 2, null, 13000, '日式风格2', to_date('29-11-2017', 'dd-mm-yyyy'), '114', '储');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (10, 1, 19, 2, 2, 1, '服务果然不是', 6900, '大房子', to_date('26-11-2017', 'dd-mm-yyyy'), '110', '彭');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (14, 3, 3, 1, 5, 2, '地区TDJG', 20000, '大家庭', to_date('26-11-2017', 'dd-mm-yyyy'), '110', '轩辕帝');
insert into TBL_FWXX (FWID, UUID, JDID, LXID, SHI, TING, FWXX, ZJ, TITLE, PUBLISHDATE, TELEPHONE, LXR)
values (15, 144, 5, 1, 5, 2, '额的WAGD', 30000, '北京大宅院', to_date('17-11-2017', 'dd-mm-yyyy'), '11234', '潘');
commit;
prompt 5 records loaded
prompt Loading TBL_JD...
insert into TBL_JD (JDID, JD, QXID)
values (1, '中关村', 1);
insert into TBL_JD (JDID, JD, QXID)
values (2, '北京大学', 1);
insert into TBL_JD (JDID, JD, QXID)
values (3, '清华大学', 1);
insert into TBL_JD (JDID, JD, QXID)
values (4, '上地', 1);
insert into TBL_JD (JDID, JD, QXID)
values (5, '白颐路', 1);
insert into TBL_JD (JDID, JD, QXID)
values (6, '西三环', 1);
insert into TBL_JD (JDID, JD, QXID)
values (7, '学院路', 1);
insert into TBL_JD (JDID, JD, QXID)
values (8, '西直门外', 1);
insert into TBL_JD (JDID, JD, QXID)
values (9, '紫竹院', 1);
insert into TBL_JD (JDID, JD, QXID)
values (10, '八里庄', 1);
insert into TBL_JD (JDID, JD, QXID)
values (11, '公主坟', 1);
insert into TBL_JD (JDID, JD, QXID)
values (12, '五道口', 1);
insert into TBL_JD (JDID, JD, QXID)
values (13, '双榆树', 1);
insert into TBL_JD (JDID, JD, QXID)
values (14, '西三旗', 1);
insert into TBL_JD (JDID, JD, QXID)
values (15, '清河', 1);
insert into TBL_JD (JDID, JD, QXID)
values (16, '马连洼', 1);
insert into TBL_JD (JDID, JD, QXID)
values (17, '青龙桥', 1);
insert into TBL_JD (JDID, JD, QXID)
values (18, '香山', 1);
insert into TBL_JD (JDID, JD, QXID)
values (19, '田村路', 1);
insert into TBL_JD (JDID, JD, QXID)
values (20, '永定路', 1);
insert into TBL_JD (JDID, JD, QXID)
values (21, '万寿路', 1);
insert into TBL_JD (JDID, JD, QXID)
values (22, '羊坊店', 1);
insert into TBL_JD (JDID, JD, QXID)
values (23, '甘家口', 1);
insert into TBL_JD (JDID, JD, QXID)
values (24, '北航', 1);
insert into TBL_JD (JDID, JD, QXID)
values (25, '北下关', 1);
insert into TBL_JD (JDID, JD, QXID)
values (26, '北太平庄', 1);
insert into TBL_JD (JDID, JD, QXID)
values (27, '万柳', 1);
insert into TBL_JD (JDID, JD, QXID)
values (28, '东升', 1);
insert into TBL_JD (JDID, JD, QXID)
values (29, '四季青', 1);
insert into TBL_JD (JDID, JD, QXID)
values (30, '西北旺', 1);
insert into TBL_JD (JDID, JD, QXID)
values (31, '温泉镇', 1);
insert into TBL_JD (JDID, JD, QXID)
values (32, '苏家坨', 1);
insert into TBL_JD (JDID, JD, QXID)
values (33, '上庄', 1);
insert into TBL_JD (JDID, JD, QXID)
values (34, '魏公村', 1);
insert into TBL_JD (JDID, JD, QXID)
values (35, '航天桥', 1);
insert into TBL_JD (JDID, JD, QXID)
values (36, '花园路', 1);
insert into TBL_JD (JDID, JD, QXID)
values (37, '动物园', 1);
insert into TBL_JD (JDID, JD, QXID)
values (38, '其他', 1);
insert into TBL_JD (JDID, JD, QXID)
values (298, '河南寨', 15);
insert into TBL_JD (JDID, JD, QXID)
values (39, '亚运村', 2);
insert into TBL_JD (JDID, JD, QXID)
values (40, '三元桥', 2);
insert into TBL_JD (JDID, JD, QXID)
values (41, '建外大街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (42, '国展', 2);
insert into TBL_JD (JDID, JD, QXID)
values (43, '三里屯', 2);
insert into TBL_JD (JDID, JD, QXID)
values (44, '劲松', 2);
insert into TBL_JD (JDID, JD, QXID)
values (45, '燕莎', 2);
insert into TBL_JD (JDID, JD, QXID)
values (46, '团结湖', 2);
insert into TBL_JD (JDID, JD, QXID)
values (47, '京广桥', 2);
insert into TBL_JD (JDID, JD, QXID)
values (48, '望京', 2);
insert into TBL_JD (JDID, JD, QXID)
values (49, '安贞桥', 2);
insert into TBL_JD (JDID, JD, QXID)
values (50, '潘家园', 2);
insert into TBL_JD (JDID, JD, QXID)
values (51, '酒仙桥', 2);
insert into TBL_JD (JDID, JD, QXID)
values (52, '呼家楼', 2);
insert into TBL_JD (JDID, JD, QXID)
values (53, '双井', 2);
insert into TBL_JD (JDID, JD, QXID)
values (54, '垡头', 2);
insert into TBL_JD (JDID, JD, QXID)
values (55, '六里屯', 2);
insert into TBL_JD (JDID, JD, QXID)
values (56, '麦子店', 2);
insert into TBL_JD (JDID, JD, QXID)
values (57, '左家庄', 2);
insert into TBL_JD (JDID, JD, QXID)
values (58, '香河园', 2);
insert into TBL_JD (JDID, JD, QXID)
values (59, '首都机场', 2);
insert into TBL_JD (JDID, JD, QXID)
values (60, '小关', 2);
insert into TBL_JD (JDID, JD, QXID)
values (61, '和平街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (62, '小红门', 2);
insert into TBL_JD (JDID, JD, QXID)
values (63, '十八里店', 2);
insert into TBL_JD (JDID, JD, QXID)
values (64, '豆各庄', 2);
insert into TBL_JD (JDID, JD, QXID)
values (65, '黑庄户', 2);
insert into TBL_JD (JDID, JD, QXID)
values (66, '王四营', 2);
insert into TBL_JD (JDID, JD, QXID)
values (67, '南磨房', 2);
insert into TBL_JD (JDID, JD, QXID)
values (68, '三间房', 2);
insert into TBL_JD (JDID, JD, QXID)
values (69, '管庄', 2);
insert into TBL_JD (JDID, JD, QXID)
values (70, '高碑店', 2);
insert into TBL_JD (JDID, JD, QXID)
values (71, '常营', 2);
insert into TBL_JD (JDID, JD, QXID)
values (72, '平房', 2);
insert into TBL_JD (JDID, JD, QXID)
values (73, '东风', 2);
insert into TBL_JD (JDID, JD, QXID)
values (74, '东坝', 2);
insert into TBL_JD (JDID, JD, QXID)
values (75, '金盏', 2);
insert into TBL_JD (JDID, JD, QXID)
values (76, '将台', 2);
insert into TBL_JD (JDID, JD, QXID)
values (77, '崔各庄', 2);
insert into TBL_JD (JDID, JD, QXID)
values (78, '孙河', 2);
insert into TBL_JD (JDID, JD, QXID)
values (79, '来广营', 2);
insert into TBL_JD (JDID, JD, QXID)
values (80, '太阳宫', 2);
insert into TBL_JD (JDID, JD, QXID)
values (81, '大屯', 2);
insert into TBL_JD (JDID, JD, QXID)
values (82, '奥运村', 2);
insert into TBL_JD (JDID, JD, QXID)
values (83, '国贸', 2);
insert into TBL_JD (JDID, JD, QXID)
values (84, '西坝河', 2);
insert into TBL_JD (JDID, JD, QXID)
values (85, '朝外大街', 2);
insert into TBL_JD (JDID, JD, QXID)
values (86, '红庙', 2);
insert into TBL_JD (JDID, JD, QXID)
values (87, '八里庄', 2);
insert into TBL_JD (JDID, JD, QXID)
values (88, '花家地', 2);
insert into TBL_JD (JDID, JD, QXID)
values (89, '安华桥', 2);
insert into TBL_JD (JDID, JD, QXID)
values (90, '将台路', 2);
insert into TBL_JD (JDID, JD, QXID)
values (91, '其他', 2);
insert into TBL_JD (JDID, JD, QXID)
values (92, '前门', 3);
insert into TBL_JD (JDID, JD, QXID)
values (93, '天坛', 3);
insert into TBL_JD (JDID, JD, QXID)
values (94, '崇文门外', 3);
insert into TBL_JD (JDID, JD, QXID)
values (95, '龙潭湖', 3);
insert into TBL_JD (JDID, JD, QXID)
values (96, '东花市', 3);
insert into TBL_JD (JDID, JD, QXID)
values (97, '体育馆路', 3);
insert into TBL_JD (JDID, JD, QXID)
values (98, '永定门外', 3);
insert into TBL_JD (JDID, JD, QXID)
values (99, '其他', 3);
commit;
prompt 100 records committed...
insert into TBL_JD (JDID, JD, QXID)
values (100, '白广路', 4);
insert into TBL_JD (JDID, JD, QXID)
values (101, '大观园', 4);
insert into TBL_JD (JDID, JD, QXID)
values (102, '菜市口', 4);
insert into TBL_JD (JDID, JD, QXID)
values (103, '虎坊桥', 4);
insert into TBL_JD (JDID, JD, QXID)
values (104, '长椿街', 4);
insert into TBL_JD (JDID, JD, QXID)
values (105, '和平门', 4);
insert into TBL_JD (JDID, JD, QXID)
values (106, '天桥', 4);
insert into TBL_JD (JDID, JD, QXID)
values (107, '宣武门', 4);
insert into TBL_JD (JDID, JD, QXID)
values (108, '大栅栏', 4);
insert into TBL_JD (JDID, JD, QXID)
values (109, '珠市口', 4);
insert into TBL_JD (JDID, JD, QXID)
values (110, '牛街', 4);
insert into TBL_JD (JDID, JD, QXID)
values (111, '白纸坊', 4);
insert into TBL_JD (JDID, JD, QXID)
values (112, '陶然亭', 4);
insert into TBL_JD (JDID, JD, QXID)
values (113, '椿树街道', 4);
insert into TBL_JD (JDID, JD, QXID)
values (114, '广安门内', 4);
insert into TBL_JD (JDID, JD, QXID)
values (115, '广安门外', 4);
insert into TBL_JD (JDID, JD, QXID)
values (116, '其他', 4);
insert into TBL_JD (JDID, JD, QXID)
values (117, '东直门', 5);
insert into TBL_JD (JDID, JD, QXID)
values (118, '北新桥', 5);
insert into TBL_JD (JDID, JD, QXID)
values (119, '交道口', 5);
insert into TBL_JD (JDID, JD, QXID)
values (120, '景山', 5);
insert into TBL_JD (JDID, JD, QXID)
values (121, '东四十条', 5);
insert into TBL_JD (JDID, JD, QXID)
values (122, '工体', 5);
insert into TBL_JD (JDID, JD, QXID)
values (123, '朝阳门', 5);
insert into TBL_JD (JDID, JD, QXID)
values (124, '建国门', 5);
insert into TBL_JD (JDID, JD, QXID)
values (125, '北京站', 5);
insert into TBL_JD (JDID, JD, QXID)
values (126, '和平里', 5);
insert into TBL_JD (JDID, JD, QXID)
values (127, '雍和宫', 5);
insert into TBL_JD (JDID, JD, QXID)
values (128, '东直门外', 5);
insert into TBL_JD (JDID, JD, QXID)
values (129, '王府井', 5);
insert into TBL_JD (JDID, JD, QXID)
values (130, '东单', 5);
insert into TBL_JD (JDID, JD, QXID)
values (131, '东四', 5);
insert into TBL_JD (JDID, JD, QXID)
values (132, '东华门', 5);
insert into TBL_JD (JDID, JD, QXID)
values (133, '安定门', 5);
insert into TBL_JD (JDID, JD, QXID)
values (134, '其他', 5);
insert into TBL_JD (JDID, JD, QXID)
values (135, '白云路', 6);
insert into TBL_JD (JDID, JD, QXID)
values (136, '西便门', 6);
insert into TBL_JD (JDID, JD, QXID)
values (137, '南礼士路', 6);
insert into TBL_JD (JDID, JD, QXID)
values (138, '月坛', 6);
insert into TBL_JD (JDID, JD, QXID)
values (139, '阜成门', 6);
insert into TBL_JD (JDID, JD, QXID)
values (140, '展览路', 6);
insert into TBL_JD (JDID, JD, QXID)
values (141, '西单', 6);
insert into TBL_JD (JDID, JD, QXID)
values (142, '西四', 6);
insert into TBL_JD (JDID, JD, QXID)
values (143, '西直门', 6);
insert into TBL_JD (JDID, JD, QXID)
values (144, '新街口', 6);
insert into TBL_JD (JDID, JD, QXID)
values (145, '什刹海', 6);
insert into TBL_JD (JDID, JD, QXID)
values (146, '地安门', 6);
insert into TBL_JD (JDID, JD, QXID)
values (147, '鼓楼', 6);
insert into TBL_JD (JDID, JD, QXID)
values (148, '德外', 6);
insert into TBL_JD (JDID, JD, QXID)
values (149, '金融街', 6);
insert into TBL_JD (JDID, JD, QXID)
values (150, '西长安街', 6);
insert into TBL_JD (JDID, JD, QXID)
values (151, '德胜门', 6);
insert into TBL_JD (JDID, JD, QXID)
values (152, '其他', 6);
insert into TBL_JD (JDID, JD, QXID)
values (153, '北苑', 7);
insert into TBL_JD (JDID, JD, QXID)
values (154, '中仓', 7);
insert into TBL_JD (JDID, JD, QXID)
values (155, '新华', 7);
insert into TBL_JD (JDID, JD, QXID)
values (156, '玉桥', 7);
insert into TBL_JD (JDID, JD, QXID)
values (157, '永顺', 7);
insert into TBL_JD (JDID, JD, QXID)
values (158, '梨园', 7);
insert into TBL_JD (JDID, JD, QXID)
values (159, '宋庄', 7);
insert into TBL_JD (JDID, JD, QXID)
values (160, '潞城', 7);
insert into TBL_JD (JDID, JD, QXID)
values (161, '张家湾', 7);
insert into TBL_JD (JDID, JD, QXID)
values (162, '台湖', 7);
insert into TBL_JD (JDID, JD, QXID)
values (163, '马驹桥', 7);
insert into TBL_JD (JDID, JD, QXID)
values (164, '西集', 7);
insert into TBL_JD (JDID, JD, QXID)
values (165, '漷县', 7);
insert into TBL_JD (JDID, JD, QXID)
values (166, '永乐店', 7);
insert into TBL_JD (JDID, JD, QXID)
values (167, '其他', 7);
insert into TBL_JD (JDID, JD, QXID)
values (168, '玉泉营', 8);
insert into TBL_JD (JDID, JD, QXID)
values (169, '方庄', 8);
insert into TBL_JD (JDID, JD, QXID)
values (170, '丰台路', 8);
insert into TBL_JD (JDID, JD, QXID)
values (171, '卢沟桥', 8);
insert into TBL_JD (JDID, JD, QXID)
values (172, '太平桥', 8);
insert into TBL_JD (JDID, JD, QXID)
values (173, '长辛店', 8);
insert into TBL_JD (JDID, JD, QXID)
values (174, '云岗', 8);
insert into TBL_JD (JDID, JD, QXID)
values (175, '新村', 8);
insert into TBL_JD (JDID, JD, QXID)
values (176, '右安门', 8);
insert into TBL_JD (JDID, JD, QXID)
values (177, '马家堡', 8);
insert into TBL_JD (JDID, JD, QXID)
values (178, '西罗园', 8);
insert into TBL_JD (JDID, JD, QXID)
values (179, '大红门', 8);
insert into TBL_JD (JDID, JD, QXID)
values (180, '南苑', 8);
insert into TBL_JD (JDID, JD, QXID)
values (181, '东高地', 8);
insert into TBL_JD (JDID, JD, QXID)
values (182, '东铁匠营', 8);
insert into TBL_JD (JDID, JD, QXID)
values (183, '其他', 8);
insert into TBL_JD (JDID, JD, QXID)
values (184, '城北', 9);
insert into TBL_JD (JDID, JD, QXID)
values (185, '城南', 9);
insert into TBL_JD (JDID, JD, QXID)
values (186, '南口', 9);
insert into TBL_JD (JDID, JD, QXID)
values (187, '马池口', 9);
insert into TBL_JD (JDID, JD, QXID)
values (188, '沙河', 9);
insert into TBL_JD (JDID, JD, QXID)
values (189, '回龙观', 9);
insert into TBL_JD (JDID, JD, QXID)
values (190, '天通苑', 9);
insert into TBL_JD (JDID, JD, QXID)
values (191, '流村', 9);
insert into TBL_JD (JDID, JD, QXID)
values (192, '阳坊', 9);
insert into TBL_JD (JDID, JD, QXID)
values (193, '十三陵', 9);
insert into TBL_JD (JDID, JD, QXID)
values (194, '长陵', 9);
insert into TBL_JD (JDID, JD, QXID)
values (195, '南邵', 9);
insert into TBL_JD (JDID, JD, QXID)
values (196, '崔村', 9);
insert into TBL_JD (JDID, JD, QXID)
values (197, '兴寿', 9);
insert into TBL_JD (JDID, JD, QXID)
values (198, '小汤山', 9);
insert into TBL_JD (JDID, JD, QXID)
values (199, '百善', 9);
commit;
prompt 200 records committed...
insert into TBL_JD (JDID, JD, QXID)
values (200, '东小口', 9);
insert into TBL_JD (JDID, JD, QXID)
values (201, '北七家', 9);
insert into TBL_JD (JDID, JD, QXID)
values (202, '其他', 9);
insert into TBL_JD (JDID, JD, QXID)
values (203, '兴丰', 10);
insert into TBL_JD (JDID, JD, QXID)
values (204, '清源', 10);
insert into TBL_JD (JDID, JD, QXID)
values (205, '林校路', 10);
insert into TBL_JD (JDID, JD, QXID)
values (206, '黄村', 10);
insert into TBL_JD (JDID, JD, QXID)
values (207, '西红门', 10);
insert into TBL_JD (JDID, JD, QXID)
values (208, '旧宫', 10);
insert into TBL_JD (JDID, JD, QXID)
values (209, '亦庄', 10);
insert into TBL_JD (JDID, JD, QXID)
values (210, '瀛海', 10);
insert into TBL_JD (JDID, JD, QXID)
values (211, '青云店', 10);
insert into TBL_JD (JDID, JD, QXID)
values (212, '长子营', 10);
insert into TBL_JD (JDID, JD, QXID)
values (213, '采育', 10);
insert into TBL_JD (JDID, JD, QXID)
values (214, '安定', 10);
insert into TBL_JD (JDID, JD, QXID)
values (215, '魏善庄', 10);
insert into TBL_JD (JDID, JD, QXID)
values (216, '礼贤', 10);
insert into TBL_JD (JDID, JD, QXID)
values (217, '榆垡', 10);
insert into TBL_JD (JDID, JD, QXID)
values (218, '庞各庄', 10);
insert into TBL_JD (JDID, JD, QXID)
values (219, '北臧村', 10);
insert into TBL_JD (JDID, JD, QXID)
values (220, '其他', 10);
insert into TBL_JD (JDID, JD, QXID)
values (221, '大峪', 11);
insert into TBL_JD (JDID, JD, QXID)
values (222, '城子街道', 11);
insert into TBL_JD (JDID, JD, QXID)
values (223, '东辛房', 11);
insert into TBL_JD (JDID, JD, QXID)
values (224, '大台', 11);
insert into TBL_JD (JDID, JD, QXID)
values (225, '王平', 11);
insert into TBL_JD (JDID, JD, QXID)
values (226, '龙泉', 11);
insert into TBL_JD (JDID, JD, QXID)
values (227, '永定', 11);
insert into TBL_JD (JDID, JD, QXID)
values (228, '潭柘寺', 11);
insert into TBL_JD (JDID, JD, QXID)
values (229, '王平', 11);
insert into TBL_JD (JDID, JD, QXID)
values (230, '军庄', 11);
insert into TBL_JD (JDID, JD, QXID)
values (231, '妙峰山', 11);
insert into TBL_JD (JDID, JD, QXID)
values (232, '雁翅', 11);
insert into TBL_JD (JDID, JD, QXID)
values (233, '斋堂', 11);
insert into TBL_JD (JDID, JD, QXID)
values (234, '清水', 11);
insert into TBL_JD (JDID, JD, QXID)
values (235, '其他', 11);
insert into TBL_JD (JDID, JD, QXID)
values (236, '八宝山', 12);
insert into TBL_JD (JDID, JD, QXID)
values (237, '古城', 12);
insert into TBL_JD (JDID, JD, QXID)
values (238, '苹果园', 12);
insert into TBL_JD (JDID, JD, QXID)
values (239, '鲁谷', 12);
insert into TBL_JD (JDID, JD, QXID)
values (240, '老山', 12);
insert into TBL_JD (JDID, JD, QXID)
values (241, '八角', 12);
insert into TBL_JD (JDID, JD, QXID)
values (242, '金顶街', 12);
insert into TBL_JD (JDID, JD, QXID)
values (243, '广宁', 12);
insert into TBL_JD (JDID, JD, QXID)
values (244, '五里坨', 12);
insert into TBL_JD (JDID, JD, QXID)
values (245, '其他', 12);
insert into TBL_JD (JDID, JD, QXID)
values (246, '城关', 13);
insert into TBL_JD (JDID, JD, QXID)
values (247, '东风', 13);
insert into TBL_JD (JDID, JD, QXID)
values (248, '向阳', 13);
insert into TBL_JD (JDID, JD, QXID)
values (249, '迎风', 13);
insert into TBL_JD (JDID, JD, QXID)
values (250, '新镇', 13);
insert into TBL_JD (JDID, JD, QXID)
values (251, '星城', 13);
insert into TBL_JD (JDID, JD, QXID)
values (252, '良乡', 13);
insert into TBL_JD (JDID, JD, QXID)
values (253, '琉璃河', 13);
insert into TBL_JD (JDID, JD, QXID)
values (254, '周口店', 13);
insert into TBL_JD (JDID, JD, QXID)
values (255, '长阳', 13);
insert into TBL_JD (JDID, JD, QXID)
values (256, '阎村', 13);
insert into TBL_JD (JDID, JD, QXID)
values (257, '窦店', 13);
insert into TBL_JD (JDID, JD, QXID)
values (258, '韩村河', 13);
insert into TBL_JD (JDID, JD, QXID)
values (259, '石楼', 13);
insert into TBL_JD (JDID, JD, QXID)
values (260, '长沟', 13);
insert into TBL_JD (JDID, JD, QXID)
values (261, '大石窝', 13);
insert into TBL_JD (JDID, JD, QXID)
values (262, '张坊', 13);
insert into TBL_JD (JDID, JD, QXID)
values (263, '十渡', 13);
insert into TBL_JD (JDID, JD, QXID)
values (264, '青龙湖', 13);
insert into TBL_JD (JDID, JD, QXID)
values (265, '河北镇', 13);
insert into TBL_JD (JDID, JD, QXID)
values (266, '佛子庄', 13);
insert into TBL_JD (JDID, JD, QXID)
values (267, '大安山', 13);
insert into TBL_JD (JDID, JD, QXID)
values (268, '史家营', 13);
insert into TBL_JD (JDID, JD, QXID)
values (269, '南窖', 13);
insert into TBL_JD (JDID, JD, QXID)
values (270, '霞云岭', 13);
insert into TBL_JD (JDID, JD, QXID)
values (271, '蒲洼', 13);
insert into TBL_JD (JDID, JD, QXID)
values (272, '其他', 13);
insert into TBL_JD (JDID, JD, QXID)
values (273, '胜利', 14);
insert into TBL_JD (JDID, JD, QXID)
values (274, '光明', 14);
insert into TBL_JD (JDID, JD, QXID)
values (275, '石园', 14);
insert into TBL_JD (JDID, JD, QXID)
values (276, '仁和', 14);
insert into TBL_JD (JDID, JD, QXID)
values (277, '马坡', 14);
insert into TBL_JD (JDID, JD, QXID)
values (278, '牛栏山', 14);
insert into TBL_JD (JDID, JD, QXID)
values (279, '杨镇', 14);
insert into TBL_JD (JDID, JD, QXID)
values (280, '南法信', 14);
insert into TBL_JD (JDID, JD, QXID)
values (281, '后沙峪', 14);
insert into TBL_JD (JDID, JD, QXID)
values (282, '天竺', 14);
insert into TBL_JD (JDID, JD, QXID)
values (283, '北小营', 14);
insert into TBL_JD (JDID, JD, QXID)
values (284, '南彩', 14);
insert into TBL_JD (JDID, JD, QXID)
values (285, '木林', 14);
insert into TBL_JD (JDID, JD, QXID)
values (286, '龙湾屯', 14);
insert into TBL_JD (JDID, JD, QXID)
values (287, '张镇', 14);
insert into TBL_JD (JDID, JD, QXID)
values (288, '大孙各庄', 14);
insert into TBL_JD (JDID, JD, QXID)
values (289, '北务', 14);
insert into TBL_JD (JDID, JD, QXID)
values (290, '李遂', 14);
insert into TBL_JD (JDID, JD, QXID)
values (291, '李桥', 14);
insert into TBL_JD (JDID, JD, QXID)
values (292, '高丽营', 14);
insert into TBL_JD (JDID, JD, QXID)
values (293, '赵全营', 14);
insert into TBL_JD (JDID, JD, QXID)
values (294, '北石槽', 14);
insert into TBL_JD (JDID, JD, QXID)
values (295, '其他', 14);
insert into TBL_JD (JDID, JD, QXID)
values (296, '溪翁庄', 15);
insert into TBL_JD (JDID, JD, QXID)
values (297, '十里堡', 15);
insert into TBL_JD (JDID, JD, QXID)
values (299, '东邵渠', 15);
insert into TBL_JD (JDID, JD, QXID)
values (300, '巨各庄', 15);
commit;
prompt 300 records committed...
insert into TBL_JD (JDID, JD, QXID)
values (301, '大城子', 15);
insert into TBL_JD (JDID, JD, QXID)
values (302, '北庄', 15);
insert into TBL_JD (JDID, JD, QXID)
values (303, '太师屯', 15);
insert into TBL_JD (JDID, JD, QXID)
values (304, '新城子', 15);
insert into TBL_JD (JDID, JD, QXID)
values (305, '古北口', 15);
insert into TBL_JD (JDID, JD, QXID)
values (306, '高岭', 15);
insert into TBL_JD (JDID, JD, QXID)
values (307, '不老屯', 15);
insert into TBL_JD (JDID, JD, QXID)
values (308, '冯家峪', 15);
insert into TBL_JD (JDID, JD, QXID)
values (309, '石城', 15);
insert into TBL_JD (JDID, JD, QXID)
values (310, '西田各庄', 15);
insert into TBL_JD (JDID, JD, QXID)
values (311, '穆家峪', 15);
insert into TBL_JD (JDID, JD, QXID)
values (312, '其他', 15);
insert into TBL_JD (JDID, JD, QXID)
values (313, '龙山', 16);
insert into TBL_JD (JDID, JD, QXID)
values (314, '泉河', 16);
insert into TBL_JD (JDID, JD, QXID)
values (315, '庙城', 16);
insert into TBL_JD (JDID, JD, QXID)
values (316, '雁栖', 16);
insert into TBL_JD (JDID, JD, QXID)
values (317, '杨宋', 16);
insert into TBL_JD (JDID, JD, QXID)
values (318, '北房', 16);
insert into TBL_JD (JDID, JD, QXID)
values (319, '怀北', 16);
insert into TBL_JD (JDID, JD, QXID)
values (320, '渤海镇', 16);
insert into TBL_JD (JDID, JD, QXID)
values (321, '九渡河', 16);
insert into TBL_JD (JDID, JD, QXID)
values (322, '桥梓', 16);
insert into TBL_JD (JDID, JD, QXID)
values (323, '琉璃庙', 16);
insert into TBL_JD (JDID, JD, QXID)
values (324, '汤河口', 16);
insert into TBL_JD (JDID, JD, QXID)
values (325, '宝山', 16);
insert into TBL_JD (JDID, JD, QXID)
values (326, '其他', 16);
insert into TBL_JD (JDID, JD, QXID)
values (327, '延庆', 17);
insert into TBL_JD (JDID, JD, QXID)
values (328, '康庄', 17);
insert into TBL_JD (JDID, JD, QXID)
values (329, '八达岭', 17);
insert into TBL_JD (JDID, JD, QXID)
values (330, '大榆树', 17);
insert into TBL_JD (JDID, JD, QXID)
values (331, '井庄', 17);
insert into TBL_JD (JDID, JD, QXID)
values (332, '永宁', 17);
insert into TBL_JD (JDID, JD, QXID)
values (333, '四海', 17);
insert into TBL_JD (JDID, JD, QXID)
values (334, '千家店', 17);
insert into TBL_JD (JDID, JD, QXID)
values (335, '旧县', 17);
insert into TBL_JD (JDID, JD, QXID)
values (336, '沈家营', 17);
insert into TBL_JD (JDID, JD, QXID)
values (337, '张山营', 17);
insert into TBL_JD (JDID, JD, QXID)
values (338, '大庄科', 17);
insert into TBL_JD (JDID, JD, QXID)
values (339, '香营', 17);
insert into TBL_JD (JDID, JD, QXID)
values (340, '刘斌堡', 17);
insert into TBL_JD (JDID, JD, QXID)
values (341, '珍珠泉', 17);
insert into TBL_JD (JDID, JD, QXID)
values (342, '其他', 17);
insert into TBL_JD (JDID, JD, QXID)
values (343, '滨河', 18);
insert into TBL_JD (JDID, JD, QXID)
values (344, '兴谷', 18);
insert into TBL_JD (JDID, JD, QXID)
values (345, '渔阳', 18);
insert into TBL_JD (JDID, JD, QXID)
values (346, '峪口', 18);
insert into TBL_JD (JDID, JD, QXID)
values (347, '马坊', 18);
insert into TBL_JD (JDID, JD, QXID)
values (348, '金海湖', 18);
insert into TBL_JD (JDID, JD, QXID)
values (349, '平谷镇', 18);
insert into TBL_JD (JDID, JD, QXID)
values (350, '大兴庄', 18);
insert into TBL_JD (JDID, JD, QXID)
values (351, '马昌营', 18);
insert into TBL_JD (JDID, JD, QXID)
values (352, '东高村', 18);
insert into TBL_JD (JDID, JD, QXID)
values (353, '夏各庄', 18);
insert into TBL_JD (JDID, JD, QXID)
values (354, '南独乐河', 18);
insert into TBL_JD (JDID, JD, QXID)
values (355, '镇罗营', 18);
insert into TBL_JD (JDID, JD, QXID)
values (356, '大华山', 18);
insert into TBL_JD (JDID, JD, QXID)
values (357, '刘家店', 18);
insert into TBL_JD (JDID, JD, QXID)
values (358, '王辛庄', 18);
insert into TBL_JD (JDID, JD, QXID)
values (359, '山东庄', 18);
insert into TBL_JD (JDID, JD, QXID)
values (360, '黄松峪', 18);
insert into TBL_JD (JDID, JD, QXID)
values (361, '熊儿寨', 18);
insert into TBL_JD (JDID, JD, QXID)
values (362, '其他', 18);
commit;
prompt 362 records loaded
prompt Loading TBL_QX...
prompt Table is empty
prompt Loading TBL_USER...
insert into TBL_USER (UUID, UNAME, UPASS)
values (201, '水', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (142, '等邓', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (143, '矗矗', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (1, 'admin', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (3, '香香', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (2, '大写', '123');
insert into TBL_USER (UUID, UNAME, UPASS)
values (144, '草莓', '123');
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
