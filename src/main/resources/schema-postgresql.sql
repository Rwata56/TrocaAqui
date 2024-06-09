CREATE TABLE IF NOT EXISTS cliente (
     id serial PRIMARY KEY,
     nome  varchar(50),
     email   varchar(50),
     senha varchar(10),
     senhaC varchar(10)
);