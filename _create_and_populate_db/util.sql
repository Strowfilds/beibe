GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO web2;

GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO web2;

/*
++  Selecionar todos os usuários    
*/
SELECT
	id_usuario, nome_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, id_tipo_usuario
FROM
	tb_usuario;

/*
++  Inserir endereço teste - Deve-se ajustar o id_usuario caso necessário    
*/
INSERT INTO
    tb_endereco (rua_endereco, numero_endereco, complemento_endereco, bairro_endereco, cep_endereco, id_cidade, id_estado, id_usuario)
VALUES
    ('Estrada da Dor', 666, 'Casa do Caralho', 'Paróla', '67105009', 2878, 18, 1);

/*
++  Inserir usuario teste    
*/
INSERT INTO
    tb_usuario (nome_usuario, cpf_usuario, email_usuario, telefone_usuario, senha_usuario, id_tipo_usuario)
VALUES 
	('Zé do Caixão', '81763568407', 'email@email.email', '419127734958', sha256('senha'), 3);
