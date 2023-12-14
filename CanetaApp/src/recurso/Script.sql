drop database if exists papelaria;
create database if not exists papelaria;
use papelaria1;

create table modelo(
codigo int auto_increment primary key,
descricao varchar(50)
);

create table caneta(
codigo int auto_increment primary key,
codigo_modelo int,
cor varchar(50),
ponta decimal(2,1),
carga int,
tampada boolean,
foreign key (codigo_modelo) references modelo(codigo)
);