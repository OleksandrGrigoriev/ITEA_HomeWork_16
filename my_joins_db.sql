create database if not exists my_joins_db;

drop database my_joins_db;

use my_joins_db;

create table employee (
	id int not null unique auto_increment,
    name varchar(30),
    telephone varchar(20),
    primary key (id)
);

insert into employee (name, telephone)
values
('Petrenko M.A.','+380939987711'),
('Teslenko V.B.','+380939987722'),
('Makarov L.O.','+380939987733'),
('Amosov Y.O.','+380939987744'),
('Fedorchuk V.P.','+380939987755');

create table salary_job (
	id int not null unique auto_increment,
	employee_id int not null unique,
    salary int not null,
    job_title varchar(30),
    
    primary key (employee_id),
    foreign key (employee_id) references employee(id)
);

insert into salary_job (employee_id, salary, job_title)
values
(1, 10000, 'director'),
(2, 7000, 'manager'),
(3, 7000, 'manager'),
(4, 5000, 'worker'),
(5, 5000, 'worker');


create table personal_info (
	id int not null unique auto_increment,
	employee_id int not null,
    married bool not null,
    date_birth varchar(20),
    address varchar(50),
    primary key (employee_id),
    foreign key (employee_id) references employee(id)
);

insert into personal_info (employee_id, married, date_birth, address)
values
(1, 1, '13.02.1981', 'some address 1'),
(2, 0, '02.05.1985', 'some address 2'),
(3, 1, '16.08.1990', 'some address 3'),
(4, 1, '09.02.1983', 'some address 4'),
(5, 0, '29.12.1992', 'some address 5');