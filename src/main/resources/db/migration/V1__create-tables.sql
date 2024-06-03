SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "-03:00";

-- Criando a tabela `avaliacao`
CREATE TABLE `avaliacao` (
  `id_avaliacao` bigint(20) NOT NULL,
  `data_avaliacao` datetime(6) DEFAULT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  `nivel_aderencia` varchar(255) DEFAULT NULL,
  `pontuacao` int(11) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `formulario_id` bigint(20) DEFAULT NULL
);

-- Criando a tabela `cliente` com a coluna `cliente_id`
CREATE TABLE `cliente` (
  `cliente_id` bigint(20) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `descricao_servico` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `email_cliente` varchar(255) DEFAULT NULL,
  `id_contrato` varchar(255) DEFAULT NULL,
  `nome_cliente` varchar(255) DEFAULT NULL,
  `nome_empresa` varchar(255) DEFAULT NULL,
  `nome_gestor` varchar(255) DEFAULT NULL,
  `ponto_focal` varchar(255) DEFAULT NULL,
  `razao_social` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `tipo_servico` varchar(255) DEFAULT NULL
);

-- Criando a tabela `formulario`
CREATE TABLE `formulario` (
  `formulario_id` bigint(20) NOT NULL,
  `possui_controle` boolean NOT NULL,
  `vet_resposta` tinyblob DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
);

-- Adicionando chaves primárias e estrangeiras
ALTER TABLE `avaliacao`
  ADD PRIMARY KEY (`id_avaliacao`),
  ADD KEY `FKpogwypj6dq5o1p5vu3q31lifm` (`cliente_id`),
  ADD KEY `FK19rbwxhbpk4tvm6nl826qd1vm` (`formulario_id`);

ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`);

ALTER TABLE `formulario`
  ADD PRIMARY KEY (`formulario_id`),
  ADD KEY `FKgoqkutiv3ujq34xuel2uajqt2` (`cliente_id`);

-- Configurando auto incremento para as colunas ID
ALTER TABLE `avaliacao`
  MODIFY `id_avaliacao` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `cliente`
  MODIFY `cliente_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `formulario`
  MODIFY `formulario_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

-- Adicionando constraints de chaves estrangeiras
ALTER TABLE `avaliacao`
  ADD CONSTRAINT `FK19rbwxhbpk4tvm6nl826qd1vm` FOREIGN KEY (`formulario_id`) REFERENCES `formulario` (`formulario_id`),
  ADD CONSTRAINT `FKpogwypj6dq5o1p5vu3q31lifm` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`);

ALTER TABLE `formulario`
  ADD CONSTRAINT `FKgoqkutiv3ujq34xuel2uajqt2` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`);

COMMIT;

DELIMITER $$

CREATE PROCEDURE `inserir_dados`()
BEGIN
    -- Inserir dados na tabela cliente
    INSERT INTO cliente (cliente_id, cnpj, descricao_servico, email, email_cliente, id_contrato, nome_cliente, nome_empresa, nome_gestor, ponto_focal, razao_social, senha, tipo_servico)
    VALUES 
    (1, '000000000000', 'construcao', 'testeExemplo@teste.com', 'testeExemplo@cliente1.com', '**', 'Beatriz', 'Ong', 'Teste 1', 'Bea', 'tutu', 123, 'Beat'),
    (2, '000000000001', 'construcao', 'testExemplo@test.com', 'testeExemplo@cliente2.com', '**', 'Jorge', 'Brast', 'Teste 2', 'Jor', 'Atta', 234, 'Teste'),
    (3, '000000003211', 'construcao', 'testExemplo@test.com', 'testeExemplo@cliente3.com', '***', 'Erick', 'Emprabel', 'Teste 3', 'Eri', 'Atta', 345, 'Tes');

    -- Inserir dados na tabela formulario
    INSERT INTO formulario (formulario_id, possui_controle, vet_resposta, cliente_id)
    VALUES 
    (1, 1, 
        '[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21]', 1),
    (2, 1, 
        '[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]', 2),
    (3, 1, 
        '[2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2]', 1);

    -- Inserir dados na tabela avaliacao
    INSERT INTO avaliacao (id_avaliacao, data_avaliacao, diagnostico, nivel_aderencia, pontuacao, cliente_id, formulario_id)
    VALUES 
    (1, '2024-02-26 23:41:00', 'Diagnostico 1', 'Aderencia 1', 100, 1, 1),
    (2, '2024-02-11 23:41:00', 'Diagnostico 2', 'Aderencia 2', 90, 2, 2),
    (3, '2024-03-30 23:41:00', 'Diagnostico 3', 'Aderencia 3', 80, 1, 3);
END$$

DELIMITER ;
CALL inserir_dados();

DELIMITER $$

CREATE PROCEDURE `inserir_dados_cliente`()
BEGIN
    -- Inserir dados na tabela cliente
    INSERT INTO cliente (cliente_id, cnpj, descricao_servico, email, email_cliente, id_contrato, nome_cliente, nome_empresa, nome_gestor, ponto_focal, razao_social, senha, tipo_servico)
    VALUES 
    (4, '111111111111', 'logistica', 'cliente1@teste.com', 'cliente1@empresa.com', 'abc', 'Carlos', 'Logistica', 'Carlos Silva', 'Car', 'Log Ltda', 456, 'Logistica'),
    (5, '222222222222', 'varejo', 'cliente2@teste.com', 'cliente2@empresa.com', 'def', 'Mariana', 'Varejo', 'Mariana Souza', 'Mar', 'Var SA', 789, 'Vendas'),
    (6, '333333333333', 'tecnologia', 'cliente3@teste.com', 'cliente3@empresa.com', 'ghi', 'Rafael', 'Tecno', 'Rafael Mendes', 'Raf', 'Tec Ltda', 101, 'Tecnologia');
END$$

DELIMITER ;
