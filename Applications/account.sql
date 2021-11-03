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

select ANO, OWNER, BALANCE from ACCOUNT
where ANO = '111-001'

union all

select ANO, OWNER, BALANCE from ACCOUNT
where ANO = '111-004'
;

update ACCOUNT set BALANCE = BALANCE - 10000
where ANO = '111-001';

select BALANCE from ACCOUNT where ANO = '111-005'
union all
select BALANCE from ACCOUNT where ANO = '111-006';
