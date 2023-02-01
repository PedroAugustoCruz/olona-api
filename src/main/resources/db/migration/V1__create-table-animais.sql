create table animais(
     id bigint not null auto_increment,
     nome varchar(100) not null,
     preco decimal not null,
     classificacao varchar(100) not null,

     primary key(id)
);