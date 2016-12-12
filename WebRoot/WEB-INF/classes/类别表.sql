insert into content (price,title,icon,abstract,text) values (1234,"aaa","http://img3.imgtn.bdimg.com/it/u=1545943533,2271147102&fm=21&gp=0.jpg","aaa","aaa");

drop database if exists shop;

create database shop default character set utf8;

use shop;

drop table if exists category;

create table category
(
   /* 类别编号,自动增长 */
   id  int not null auto_increment,
   /* 类别名称 */
   type varchar(20),
   /* 类别是否为热点类别,热点类别才有可能显示在首页 */
   hot  bool default false,
   /* 设置类别编号为主键 */
   primary key (id)
);
select * from account;

insert into category (type,hot) values ("女装",true);
insert into category (type,hot) values ("男装",true);
insert into category (type,hot) values ("童装",true);
select * from category;