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

select sum(ano1), sum(ano2), sum(balance1), sum(balance2) from
(select count(*) ano1, 0 ano2, BALANCE balance1, 0 balance2 from ACCOUNT where ANO = '111-005' group by BALANCE
union all
select 0 ano1, count(*) ano2, 0 balance1, BALANCE balance2 from ACCOUNT where ANO = '111-006' group by BALANCE);
