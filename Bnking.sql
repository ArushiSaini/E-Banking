create database Bankdatabase;
use Bankdatabase;
SET SQL_SAFE_UPDATES = 0;
-- Table 1
create table branch(branchid varchar(20), bname varchar(30),bcity varchar(30),ifsccode varchar(30),
CONSTRAINT branch_branchid_pk PRIMARY KEY(branchid));
insert into branch values('B001','CP Centre','Delhi','ALLIB001');
commit;
select * from branch;

-- Table 2
create table customer(customerid varchar(50),custfname varchar(50),custlname varchar(50),
dtofbirth date,guardianname varchar(100),occupation varchar(30),address varchar(100),
contactno varchar(20),email varchar(30),gender varchar(10),maritalstatus varchar(10),
govtid varchar(50),govtidno varchar(20),citizenship varchar(20),
CONSTRAINT customer_customerid_pk PRIMARY KEY(customerid));
commit;
select * from customer;
update customer set password='1234';
commit;
alter table customer ADD column password varchar(30);
-- Table 3
create table account(accountno varchar (15),customerid varchar(50),
branchid varchar(20),atype varchar(20),openingbalance long,aod date,
astatus varchar(20),pin varchar(20),password varchar(20),ltdttran date,
CONSTRAINT account_accountno_pk PRIMARY KEY(accountno),
CONSTRAINT account_customerid_fk FOREIGN KEY(customerid) REFERENCES customer(customerid),
CONSTRAINT account_branchid_fk FOREIGN KEY(branchid) REFERENCES branch(branchid));
select * from account;
-- select * from account,branch where account.branchid=branch.branchid and accountno='A52582';
-- select * from customer,account,branch where account.branchid=branch.branchid and  customer.customerid=account.customerid and accountno='A52582';
-- select * from customer,account,branch where account.branchid=branch.branchid and  customer.customerid=account.customerid and accountno='A52582';

-- Table 4
create table carddetails(accountno varchar(20),cardtype varchar(50),cardno varchar(50),cardexpiry date,pinno varchar(10),
CONSTRAINT carddetails_cardno_pk PRIMARY KEY(cardno),
CONSTRAINT carddetails_accountno_fk FOREIGN KEY(accountno) REFERENCES account(accountno));
select * from carddetails;

-- Table 5
create table chequedetails (chequeno varchar(50),accountno varchar(20),ifsccode varchar(50), branchid varchar(20),custfname varchar(50),
custlname varchar(50),customerid varchar(50),
CONSTRAINT chequedetails_chequeno_pk PRIMARY KEY(chequeno),
CONSTRAINT chequedetails_accountno_fk FOREIGN KEY(accountno) REFERENCES account(accountno),
CONSTRAINT chequedetails_branchid_fk FOREIGN KEY(branchid) REFERENCES branch(branchid),
CONSTRAINT chequedetails_customerid_fk FOREIGN KEY(customerid) REFERENCES customer(customerid));
select * from chequedetails;

-- Table 6
create table banker(userid varchar(50),pwd varchar(50),branchid varchar(50),
userrole varchar(50),uname varchar(100),
CONSTRAINT banker_userid_pk PRIMARY KEY(userid),
CONSTRAINT banker_branchid_fk FOREIGN KEY(branchid) REFERENCES branch(branchid));
select * from banker;
insert into banker values('A001','abcd','B001','Admin','Ram');
commit;
select * from banker;

-- Table 7
create table trandetails(tnumber VARCHAR(50),accountno VARCHAR(50),dot timestamp,medium_of_transaction VARCHAR(20),
transaction_type VARCHAR(20),transaction_amount INT(7),last_balance int,narration varchar(100),
CONSTRAINT trandetails_tnumber_pk PRIMARY KEY(tnumber),
CONSTRAINT trandetails_accountno_fk FOREIGN KEY(accountno) REFERENCES account(accountno));
select *  from trandetails;