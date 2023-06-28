create database `luoan-forum-service-db` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_bin_unicode_ci';
use `luoan-forum-service-db`;

-- 用户信息表 --
drop table if exists user_info;
create table user_info (
                           id bigint unsigned not null auto_increment comment '用户id',
                           name varchar(20) unique not null comment '用户昵称',
                           sex int not null default 0 comment '性别 {0: 未知, 1: 男, 2: 女}, 默认0',
                           avatar varchar(255) not null comment '用户头像',
                           ip_info json comment 'ip信息',
                           status int unsigned not null default 1 comment '状态 {0: 拉黑, 1: 正常}, 默认1',
                           last_opt_time timestamp not null default current_timestamp comment '最后上线时间',
                           create_time timestamp not null default current_timestamp comment '创建时间',
                           update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                           primary key (id) using btree,
                           unique index uniq_name (name) using btree,
                           index idx_create_time (create_time) using btree,
                           index idx_update_time (update_time) using btree
) engine = innodb comment = '用户表' row_format = dynamic;

-- 黑名单表 --
drop table if exists black;
create table black (
                       id bigint unsigned not null auto_increment comment '黑名单id',
                       type int not null comment '拉黑类型 {1: 用户id, 2: ip地址}',
                       target varchar(32) not null comment '源目标',
                       create_time timestamp not null default current_timestamp comment '创建时间',
                       update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                       primary key (id) using btree,
                       unique idx_type_target (type, target) using btree
) engine = innodb row_format = dynamic comment '黑名单';

-- 权限表 --
drop table if exists role;
create table role (
                      id bigint unsigned not null auto_increment comment '权限id',
                      name varchar(20) not null comment '角色名称',
                      create_time timestamp not null default current_timestamp comment '创建时间',
                      update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                      primary key (id) using btree
) engine = innodb row_format = dynamic comment '权限表';
insert into role (name)
values ('超级管理员'),
       ('官方管理员'),
       ('普通用户');

-- 用户权限表 --
drop table if exists user_role;
create table user_role (
                           id bigint unsigned not null auto_increment comment '用户权限id',
                           role_id bigint unsigned not null comment '权限id',
                           uid bigint unsigned not null comment '用户id',
                           create_time timestamp not null default current_timestamp comment '创建时间',
                           update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                           primary key (id) using btree,
                           index idx_role_id (role_id) using btree,
                           index idx_uid (uid) using btree
) engine = innodb row_format = dynamic comment '用户权限表';

-- 用户消息主表 --
drop table if exists user_main_msg;
create table user_main_msg (
                               id bigint unsigned not null auto_increment comment '主消息id',
                               sender_id bigint unsigned not null comment '消息发送者用户id',
                               getter_id bigint unsigned not null comment '消息接收者用户id',
                               content varchar(1024) not null comment '消息体',
                               reply_msg_id bigint unsigned comment '回复消息id',
                               gap_count int comment '回复消息的间隔行数',
                               type int not null default 1 comment '消息类型 {1: 文本, 2: 文件}',
                               msg_status int not null default 1 comment '消息状态 {0: 消息撤回, 1: 消息正常}',
                               status int not null default 1 comment '消息状态 {0: 删除, 1: 正常}',
                               create_time timestamp not null default current_timestamp comment '创建时间',
                               update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                               primary key (id) using btree,
                               index idx_sender_id (sender_id) using btree,
                               index idx_getter_id (getter_id) using btree,
                               index idx_create_time (create_time) using btree,
                               index idx_update_time (update_time) using btree
) engine = innodb row_format = dynamic comment '主消息表';

-- 用户消息从表 --
drop table if exists user_sub_msg;
create table user_sub_msg (
                              id bigint unsigned not null auto_increment comment '从消息id',
                              msg_id bigint unsigned not null comment '主消息id',
                              sender_id bigint unsigned not null comment '消息发送者用户id',
                              getter_id bigint unsigned not null comment '消息接收者用户id',
                              content varchar(1024) not null comment '消息体',
                              reply_msg_id bigint unsigned comment '回复消息id',
                              gap_count int comment '回复消息的间隔行数',
                              type int not null default 1 comment '消息类型 {1: 文本, 2: 文件}',
                              msg_status int not null default 1 comment '消息状态 {0: 消息撤回, 1: 消息正常}',
                              status int not null default 1 comment '消息状态 {0: 删除, 1: 正常}',
                              create_time timestamp not null default current_timestamp comment '创建时间',
                              update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                              primary key (id) using btree,
                              index idx_sender_id (sender_id) using btree,
                              index idx_getter_id (getter_id) using btree,
                              index idx_create_time (create_time) using btree,
                              index idx_update_time (update_time) using btree
) engine = innodb row_format = dynamic comment '从消息表';

-- 群聊主消息表 --
drop table if exists group_main_msg;
create table group_main_msg (
                                id bigint unsigned not null auto_increment comment '群聊主消息id',
                                group_id bigint unsigned not null comment '群聊id',
                                from_uid bigint unsigned not null comment '消息发送者uid',
                                content varchar(1024) not null comment '消息体',
                                reply_msg_id bigint unsigned comment '回复消息id',
                                gap_count int comment '回复消息的间隔行数',
                                type int not null default 1 comment '消息类型 {1: 文本, 2: 文件}',
                                msg_status int not null default 1 comment '消息状态 {0: 消息撤回, 1: 消息正常}',
                                status int not null default 1 comment '消息状态 {0: 删除, 1: 正常}',
                                create_time timestamp not null default current_timestamp comment '创建时间',
                                update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                                primary key (id) using btree,
                                index idx_group_id (group_id) using btree,
                                index idx_from_id (from_uid) using btree,
                                index idx_reply_msg_id (reply_msg_id) using btree,
                                index idx_create_time (create_time) using btree,
                                index idx_update_time (update_time) using btree
) engine = innodb row_format = dynamic comment '群聊主消息表';

-- 群聊从消息表 --
drop table if exists group_sub_msg;
create table group_sub_msg (
                               id bigint unsigned not null auto_increment comment '群聊从消息id',
                               group_msg_id bigint unsigned not null comment '群聊主消息id',
                               group_id bigint unsigned not null comment '群聊id',
                               from_uid bigint unsigned not null comment '消息发送者uid',
                               content varchar(1024) not null comment '消息体',
                               reply_msg_id bigint unsigned comment '回复消息id',
                               gap_count int comment '回复消息的间隔行数',
                               type int not null default 1 comment '消息类型 {1: 文本, 2: 文件}',
                               msg_status int not null default 1 comment '消息状态 {0: 消息撤回, 1: 消息正常}',
                               status int not null default 1 comment '消息状态 {0: 删除, 1: 正常}',
                               create_time timestamp not null default current_timestamp comment '创建时间',
                               update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                               primary key (id) using btree,
                               index idx_group_id (group_id) using btree,
                               index idx_from_id (from_uid) using btree,
                               index idx_reply_msg_id (reply_msg_id) using btree,
                               index idx_create_time (create_time) using btree,
                               index idx_update_time (update_time) using btree
) engine = innodb row_format = dynamic comment '群聊从消息表';

-- 动态表 -- 贴 stick
drop table if exists dynamic;
create table dynamic (
                         id bigint unsigned not null auto_increment comment '动态id',
                         uid bigint unsigned not null comment '动态发布用户id',
                         title varchar(32) not null comment '动态标题',
                         content varchar(10240) not null comment '动态内容',
                         label_id bigint unsigned comment '动态标签',
                         pictures varchar(2048) comment '动态图片',
                         ip_info json not null comment '当前ip信息',
                         status int not null default 1 comment '动态状态 {0: 删除, 1: 正常}',
                         create_time timestamp not null default current_timestamp comment '创建时间',
                         update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                         primary key (id) using btree,
                         index idx_uid (uid) using btree,
                         index idx_label_id (label_id) using btree
) engine = innodb row_format = dynamic comment '动态表';

-- 动态评论表 --
drop table if exists dynamic_comment;
create table dynamic_comment (
                                 id bigint unsigned not null auto_increment comment '评论id',
                                 uid bigint unsigned not null comment '评论发表用户id',
                                 content varchar(1024) not null comment '评论内容',
                                 ip_info json not null comment '当前ip信息',
                                 status int not null default 1 comment '评论状态 {0: 删除, 1: 正常}',
                                 create_time timestamp not null default current_timestamp comment '创建时间',
                                 update_time timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
                                 primary key (id) using btree,
                                 index idx_uid (uid) using btree
) engine = innodb row_format = dynamic comment '动态评论表';

