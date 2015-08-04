drop database if exists exemploJDBC;
create database exemploJDBC;
use exemploJDBC;

create table contato(
idcontato		integer			auto_increment,
nome			varchar(50)		not null,
telefone		varchar(20)		not null,
email			varchar(50)		not null,
dataCadastro	date			not null,
primary key (idcontato));

show tables;
desc contato;