--user_tab.sql

drop table user_tab;
CREATE TABLE user_tab
(
    user_num       NUMBER          NOT NULL, 
    user_name      VARCHAR2(20)    NULL, 
    user_addr      VARCHAR2(20)    NULL, 
    user_phone1    VARCHAR2(20)    NULL, 
    user_phone2    VARCHAR2(20)    NULL, 
    user_phone3    VARCHAR2(20)    NULL, 
    user_pwd       VARCHAR2(20)    NULL, 
    user_id        VARCHAR2(20)    NULL, 
    CONSTRAINT USER_TAB_PK PRIMARY KEY (user_num)
);
/

drop SEQUENCE user_tab_SEQ;
CREATE SEQUENCE user_tab_SEQ
START WITH 1
INCREMENT BY 1
NOCYCLE
NOCACHE;
/
--↓ 6명의 샘플 데이터
insert into user_tab
values (user_tab_SEQ.nextval,'구본진','동부','010','1111','2222','bonjin','1111');
insert into user_tab
values (user_tab_SEQ.nextval,'김지우','서부','010','3333','4444','jiwoo','1111');
insert into user_tab
values (user_tab_SEQ.nextval,'백기현','남부','010','5555','6666','gihyun','1111');
insert into user_tab
values (user_tab_SEQ.nextval,'윤유빈','북부','010','7777','8888','yoobin','1111');
insert into user_tab
values (user_tab_SEQ.nextval,'이진주','서울특별시','010','9999','0000','jinju','1111');
insert into user_tab
values (user_tab_SEQ.nextval,'정기복','경기도','010','1234','5678','jibok','1111');

insert into user_tab
values (user_tab_SEQ.nextval,'관리자','하늘','010','1234','5678','admin','manager');

select * from user_tab;

--sit_tab
drop table sit_tab;
CREATE TABLE sit_tab
(
    sit_num      NUMBER    NOT NULL, 
    room_num     NUMBER    NULL, 
    sit_check    NUMBER    NULL, 
    CONSTRAINT SIT_TAB_PK PRIMARY KEY (sit_num)
);
/
--MAXVALUE 27에 유의
drop sequence sit_tab_seq;
CREATE SEQUENCE sit_tab_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 27
NOCYCLE
NOCACHE;
/
--열람실1
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
--열람실2
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
--열람실3
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 3, 0);

select * from sit_tab;

