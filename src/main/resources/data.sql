Drop table if exists employees;

create table employees (id int AUTO_INCREMENT primary key,
first_name varchar(250) not null,
last_name varchar(250) not null,
mail varchar(250) not null,
password varchar(250) not null);

insert into employees (first_name, last_name, mail, password) values
('kom','Martial', 'martialkom123@gmail.com','secret'),
('Tagne', 'Ledoux', 'ledouxtagne@gmail.com', 'passe');