SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "-03:00";


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
  `pergunta1` int NOT NULL,
  `pergunta2` int NOT NULL,
  `pergunta3` int NOT NULL,
  `pergunta4` int NOT NULL,
  `pergunta5` int NOT NULL,
  `data_avaliacao` datetime(6) DEFAULT NULL,
  `diagnostico` varchar(255) DEFAULT NULL,
  `nivel_aderencia` varchar(255) DEFAULT NULL,
  `pontuacao` int(11) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL
);

-- Adicionando chaves primárias e estrangeiras
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`);

ALTER TABLE `formulario`
  ADD PRIMARY KEY (`formulario_id`),
  ADD KEY `FKgoqkutiv3ujq34xuel2uajqt2` (`cliente_id`);

-- Configurando auto incremento para as colunas ID

ALTER TABLE `cliente`
  MODIFY `cliente_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

ALTER TABLE `formulario`
  MODIFY `formulario_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

-- Adicionando constraints de chaves estrangeiras
ALTER TABLE `formulario`
  ADD CONSTRAINT `FKgoqkutiv3ujq34xuel2uajqt2` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`cliente_id`);

COMMIT;
DELIMITER $$

CREATE PROCEDURE `popular_dados`()
BEGIN
    -- Inserir dados na tabela cliente
    INSERT INTO cliente (cnpj, descricao_servico, email, email_cliente, id_contrato, nome_cliente, nome_empresa, nome_gestor, ponto_focal, razao_social, senha, tipo_servico)
    VALUES 
    ('000000000010', 'consultoria', 'email1@teste.com', 'cliente1@empresa.com', 'C001', 'Ana', 'Empresa A', 'Gestor A', 'Ponto Focal A', 'Razao Social A', 'senha1', 'Servico A'),
    ('000000000011', 'manutencao', 'email2@teste.com', 'cliente2@empresa.com', 'C002', 'Bruno', 'Empresa B', 'Gestor B', 'Ponto Focal B', 'Razao Social B', 'senha2', 'Servico B'),
    ('000000000012', 'vendas', 'email3@teste.com', 'cliente3@empresa.com', 'C003', 'Carla', 'Empresa C', 'Gestor C', 'Ponto Focal C', 'Razao Social C', 'senha3', 'Servico C');

    -- Inserir dados na tabela formulario
 INSERT INTO `formulario` (`formulario_id`, `pergunta1`, `pergunta2`, `pergunta3`, `pergunta4`, `pergunta5`, `data_avaliacao`, `diagnostico`, `nivel_aderencia`, `pontuacao`, `cliente_id`) 
 VALUES 
 ('2', '0', '1', '2', '3', '5', '2024-06-22 13:09:49.000000', 'Bom', 'Alto', '12', '3');

END$$

DELIMITER ;

-- Chamando a procedure para popular os dados
CALL popular_dados();
