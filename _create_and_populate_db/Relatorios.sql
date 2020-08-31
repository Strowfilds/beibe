------------------------------------------------------
--RELATÓRIO DE DADOS DE TODOS OS FUNCIONÁRIOS(GERENTE)
------------------------------------------------------

SELECT nome_usuario, cpf_usuario, email_usuario, telefone_usuario FROM tb_usuario 
WHERE id_tipo_usuario = 2 ORDER BY nome_usuario

------------------------------------------------------
--RELATÓRIO DE PRODUTOS MAIS RECLAMADOS(GERENTE)
------------------------------------------------------

SELECT
  pr.nome_produto,
  (SELECT COUNT(id_atendimento) FROM tb_atendimento ad where ad.id_produto = pr.id_produto) 
FROM
  tb_produto pr
ORDER BY COUNT DESC
LIMIT 3

------------------------------------------------------
--RELATÓRIO DE RECLAMAÇÕES ABERTAS(GERENTE)
------------------------------------------------------


SELECT us.nome_usuario, us.cpf_usuario, us.email_usuario, ad.data_hora_atendimento,ad.descricao_atendimento, pr.nome_produto  FROM tb_atendimento AS ad
JOIN tb_usuario AS us ON us.id_usuario = ad.id_usuario 
JOIN tb_produto AS pr ON ad.id_produto = pr.id_produto
WHERE atendimento_aberto = true AND ad.data_hora_atendimento BETWEEN ? AND ?
ORDER BY data_hora_atendimento DESC

------------------------------------------------------
--RELATÓRIO DE RECLAMAÇÕES(GERENTE)
------------------------------------------------------

SELECT ad.data_hora_atendimento,ad.descricao_atendimento   FROM tb_atendimento AS ad
JOIN tb_tipo_atendimento AS tad ON ad.id_tipo_atendimento = tad.id_tipo_atendimento
WHERE tad.id_tipo_atendimento = 1 AND atendimento_aberto = ?
ORDER BY data_hora_atendimento DESC