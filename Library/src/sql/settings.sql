
============================================



/////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE reservation_tab
(
    res_num      NUMBER       NOT NULL, 
    sit_num      NUMBER       NULL, 
    user_num     NUMBER       NULL, 
    sit_start    TIMESTAMP    NULL, 
    sit_end      TIMESTAMP    NULL, 
    CONSTRAINT RESERVATION_TAB_PK PRIMARY KEY (res_num)
);

CREATE SEQUENCE reservation_tab_SEQ
START WITH 1
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER reservation_tab_AI_TRG
BEFORE INSERT ON reservation_tab 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT reservation_tab_SEQ.NEXTVAL
    INTO:NEW.res_num
    FROM DUAL;
END;
/




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
    user_id        VARCHAR2(20)    NULL, 
    user_pwd       VARCHAR2(20)    NULL, 
    CONSTRAINT USER_TAB_PK PRIMARY KEY (user_num)
);
/

drop SEQUENCE user_tab_SEQ;
CREATE SEQUENCE user_tab_SEQ
START WITH 1
INCREMENT BY 1;
NOCYCLE
NOCACHE;
/

CREATE OR REPLACE TRIGGER user_tab_AI_TRG
BEFORE INSERT ON user_tab 
REFERENCING NEW AS NEW FOR EACH ROW 
BEGIN 
    SELECT user_tab_SEQ.NEXTVAL
    INTO:NEW.user_num
    FROM DUAL;
END;
/
--�� 6���� ���� ������. ��й�ȣ�� ���� 1111��
insert into user_tab(
values ('������','�λ�','010','1111','2222','admin','1111');
insert into user_tab
values ('������','����','010','1111','2222','bonjin','1111');
insert into user_tab
values ('������','����','010','3333','4444','jiwoo','1111');
insert into user_tab
values ('�����','����','010','5555','6666','gihyun','1111');
insert into user_tab
values ('������','�Ϻ�','010','7777','8888','yoobin','1111');
insert into user_tab
values ('������','����Ư����','010','9999','0000','jinju','1111');
insert into user_tab
values ('���⺹','��⵵','010','1234','5678','jibok','1111');

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

drop sequence sit_tab_seq;
CREATE SEQUENCE sit_tab_SEQ
START WITH 1
INCREMENT BY 1
MAXVALUE 27
NOCYCLE
NOCACHE;
/



insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 1, 0);

insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);
insert into sit_tab values (sit_tab_SEQ.nextval, 2, 0);

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