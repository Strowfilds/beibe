CREATE DATABASE web2_beibe;

CREATE USER web2 WITH PASSWORD 'web2';

GRANT ALL PRIVILEGES ON DATABASE "web2_beibe" to web2;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO web2; 

CREATE TABLE tb_estado (
    id_estado INT NOT NULL UNIQUE, 
    sigla_estado CHAR(2) NOT NULL UNIQUE,
    nome_estado VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_estado)
);

CREATE TABLE tb_cidade (
    id_cidade SERIAL,
    nome_cidade VARCHAR(50) NOT NULL, 
    id_estado INT,   
    PRIMARY KEY (id_cidade),
    FOREIGN KEY (id_estado) REFERENCES tb_estado (id_estado)
);

CREATE TABLE tb_tipo_usuario (
    id_tipo_usuario INT NOT NULL UNIQUE,
    nome_tipo_usuario VARCHAR(15),
    PRIMARY KEY (id_tipo_usuario)
);

CREATE TABLE tb_usuario (
    id_usuario SERIAL,
    nome_usuario VARCHAR(70) NOT NULL,
    cpf_usuario VARCHAR(11) NOT NULL UNIQUE,
    email_usuario VARCHAR(100) UNIQUE NOT NULL,
    telefone_usuario VARCHAR(14) NOT NULL,
    senha_usuario CHAR(64) NOT NULL,    
    id_tipo_usuario INT NOT NULL,
    PRIMARY KEY (id_usuario),    
    FOREIGN KEY (id_tipo_usuario) REFERENCES tb_tipo_usuario (id_tipo_usuario)
);

CREATE TABLE tb_endereco (
    id_endereco SERIAL,
    rua_endereco VARCHAR(50) NOT NULL,
    numero_endereco INT,
    complemento_endereco VARCHAR(50),
    bairro_endereco VARCHAR(50) NOT NULL,
    cep_endereco VARCHAR(9) NOT NULL,
    id_cidade INT NOT NULL,
    id_estado INT NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id_endereco),
    FOREIGN KEY (id_cidade) REFERENCES tb_cidade (id_cidade),
    FOREIGN KEY (id_estado) REFERENCES tb_estado (id_estado),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id_usuario)
);

CREATE TABLE tb_categoria (
    id_categoria SERIAL,
    nome_categoria VARCHAR(30) NOT NULL,
    PRIMARY KEY (id_categoria)
);

CREATE TABLE tb_produto (
    id_produto SERIAL,
    nome_produto VARCHAR(50) NOT NULL,    
    descricao_produto VARCHAR(1000) NOT NULL,
    id_categoria INT NOT NULL,
    peso_categoria INT NOT NULL,
    PRIMARY KEY (id_produto),
    FOREIGN KEY (id_categoria) REFERENCES tb_categoria (id_categoria)
);

CREATE TABLE tb_tipo_atendimento (
    id_tipo_atendimento INT NOT NULL UNIQUE,
    nome_tipo_atendimento VARCHAR(50) NOT NULL,
    PRIMARY KEY (id_tipo_atendimento)
);

CREATE TABLE tb_atendimento (
    id_atendimento SERIAL,
    data_hora_atendimento TIMESTAMP NOT NULL,
    atendimento_aberto BOOLEAN NOT NULL,    
    descricao_atendimento VARCHAR(1000),
    solucao_atendimento VARCHAR(1000),	
    id_produto INT NOT NULL,
    id_tipo_atendimento INT NOT NULL,
    id_usuario INT NOT NULL,
    PRIMARY KEY (id_atendimento),
    FOREIGN KEY (id_produto) REFERENCES tb_produto (id_produto),
    FOREIGN KEY (id_tipo_atendimento) REFERENCES tb_tipo_atendimento (id_tipo_atendimento),
    FOREIGN KEY (id_usuario) REFERENCES tb_usuario (id_usuario)
);