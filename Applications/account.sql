create table account (
	ANO VARCHAR2(200) primary key,
	OWNER VARCHAR2(200),
	BALANCE NUMBER
);

-- alter user BANK default tablespace users quota unlimited on users;

select * from account;

insert into account values ('111-001', '장동호', 20000);

drop table account;

truncate table ACCOUNT;

commit;
