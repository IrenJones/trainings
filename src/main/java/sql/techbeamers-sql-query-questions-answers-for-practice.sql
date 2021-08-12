CREATE DATABASE ORG;
SHOW DATABASES;
USE ORG;

CREATE TABLE Worker (
	WORKER_ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	FIRST_NAME CHAR(25),
	LAST_NAME CHAR(25),
	SALARY INT(15),
	JOINING_DATE DATETIME,
	DEPARTMENT CHAR(25)
);

INSERT INTO Worker 
	(WORKER_ID, FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
		(001, 'Monika', 'Arora', 100000, '14-02-20 09.00.00', 'HR'),
		(002, 'Niharika', 'Verma', 80000, '14-06-11 09.00.00', 'Admin'),
		(003, 'Vishal', 'Singhal', 300000, '14-02-20 09.00.00', 'HR'),
		(004, 'Amitabh', 'Singh', 500000, '14-02-20 09.00.00', 'Admin'),
		(005, 'Vivek', 'Bhati', 500000, '14-06-11 09.00.00', 'Admin'),
		(006, 'Vipul', 'Diwan', 200000, '14-06-11 09.00.00', 'Account'),
		(007, 'Satish', 'Kumar', 75000, '14-01-20 09.00.00', 'Account'),
		(008, 'Geetika', 'Chauhan', 90000, '14-04-11 09.00.00', 'Admin');

CREATE TABLE Bonus (
	WORKER_REF_ID INT,
	BONUS_AMOUNT INT(10),
	BONUS_DATE DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Bonus 
	(WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
		(001, 5000, '16-02-20'),
		(002, 3000, '16-06-11'),
		(003, 4000, '16-02-20'),
		(001, 4500, '16-02-20'),
		(002, 3500, '16-06-11');
CREATE TABLE Title (
	WORKER_REF_ID INT,
	WORKER_TITLE CHAR(25),
	AFFECTED_FROM DATETIME,
	FOREIGN KEY (WORKER_REF_ID)
		REFERENCES Worker(WORKER_ID)
        ON DELETE CASCADE
);

INSERT INTO Title 
	(WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
 (001, 'Manager', '2016-02-20 00:00:00'),
 (002, 'Executive', '2016-06-11 00:00:00'),
 (008, 'Executive', '2016-06-11 00:00:00'),
 (005, 'Manager', '2016-06-11 00:00:00'),
 (004, 'Asst. Manager', '2016-06-11 00:00:00'),
 (007, 'Executive', '2016-06-11 00:00:00'),
 (006, 'Lead', '2016-06-11 00:00:00'),
 (003, 'Lead', '2016-06-11 00:00:00');
 
 select * from worker where first_name not in('Vipul', 'Satish');
 
 select * from worker where first_name like '%a%';
	select * from worker where first_name regexp(".*[a].*");
 select * from worker where first_name regexp("a$");
 select * from worker where first_name regexp("^(.{5})h$");
 select * from worker where year(joining_date) = 2014 and month(joining_date) = 2;
 
select concat(first_name, " ", last_name) as res from worker where salary between 50000 and 100000 and not exists (
SELECT CONCAT(FIRST_NAME, ' ', LAST_NAME)
FROM worker 
WHERE WORKER_ID IN 
(SELECT WORKER_ID FROM worker 
WHERE Salary BETWEEN 50000 AND 100000));

SELECT CONCAT(FIRST_NAME, ' ', LAST_NAME)
FROM worker 
WHERE WORKER_ID IN 
(SELECT WORKER_ID FROM worker 
WHERE Salary BETWEEN 50000 AND 100000) and not exists(
select concat(first_name, " ", last_name) as res from worker where salary between 50000 and 100000);
 
explain analyze select * from Title where worker_title in('Lead', 'Manager');
explain select * from Title where worker_title in('Lead', 'Manager');

select * from Title where worker_title in('Lead', 'Manager');

with worker_cte as
(select * from Title where worker_title in('Lead', 'Manager'))
select count(*) from worker_cte;

select count(worker_id), department from worker group by department;

select count(worker_id) as cnt, department from worker group by department having cnt > 2;


select first_name, last_name, worker_title from worker 
inner join title
on title.worker_ref_id = worker.worker_id
and worker_title = "Manager";

select * from worker where mod(worker_id, 2) <> 0;

create table workerclone as select * from worker where 1 = 0;

select * from worker order by worker_id desc limit 5;

select max(salary) as total, department from worker group by department;

with cte as
(select max(salary) as total, department as d from worker group by department)
select concat(first_name, " ", last_name), department from worker
inner join cte on total = worker.salary and worker.department = cte.d;


select sum(salary), department from worker group by department;

with cte as
(select distinct salary as s from worker order by salary desc limit 5)
select * from cte order by s asc limit 1;
----------------------------------------------- 

create temporary table positions
select distinct worker_title from Title;

select * from positions;

DELIMITER //
create function myfunc (n int)
returns int

begin
	declare multi int;
    set multi = 3;
    while multi > 0 do
		set n = n + n* multi;
        set multi = multi - 1;
        end while;
        
        return n;
end;
DELIMITER ;

DELIMITER //

CREATE FUNCTION CalcIncome ( starting_value INT )
RETURNS INT

BEGIN
   DECLARE income INT;
   SET income = 0;
   label1: WHILE income <= 3000 DO
     SET income = income + starting_value;
   END WHILE label1;
   RETURN income;
END; //

DELIMITER ;

DROP FUNCTION IF EXISTS simpleFunc;
DELIMITER |
CREATE FUNCTION simpleFunc(name char(50)) RETURNS char(60) DETERMINISTIC
BEGIN
  DECLARE res char(60);
  SET res = concat('aaaaaaaaaa', name);
  RETURN res;
END |

select *, (simpleFunc(first_name)) from worker;


DELIMITER |
CREATE PROCEDURE test()
BEGIN
	select * from worker;
END |
DELIMITER ;

CALL test();


CREATE VIEW dashboard as 
select * from worker where salary > 80000;

select * from dashboard;