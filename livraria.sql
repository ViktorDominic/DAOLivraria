use dev211Livraria;

-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 04-Jul-2022 às 14:25
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `livraria`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `enderecoCompleto` varchar(60) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `cnpj` varchar(14) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `compra` (
  `idcliente` int(11) NOT NULL,
  `idlivro` int(11) NOT NULL,
  `dataCompra` date NOT NULL,
  `quantCompra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `ideditora` int(11) NOT NULL,
  `nomeEditora` varchar(45) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `gerente` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `idlivro` int(11) NOT NULL,
  `tituloLivro` varchar(45) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `assunto` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `estoque` int(11) NOT NULL,
  `valor` decimal(10,2) NOT NULL,
  `ideditora` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`),
  ADD UNIQUE KEY `cpf_UNIQUE` (`cpf`),
  ADD UNIQUE KEY `cnpj_UNIQUE` (`cnpj`);

--
-- Índices para tabela `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idcliente`,`idlivro`),
  ADD KEY `fk_cliente_has_livro_livro1_idx` (`idlivro`),
  ADD KEY `fk_cliente_has_livro_cliente1_idx` (`idcliente`);

--
-- Índices para tabela `editora`
--
ALTER TABLE `editora`
  ADD PRIMARY KEY (`ideditora`);

--
-- Índices para tabela `livro`
--
ALTER TABLE `livro`
  ADD PRIMARY KEY (`idlivro`),
  ADD UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  ADD KEY `fk_livro_editora_idx` (`ideditora`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `editora`
--
ALTER TABLE `editora`
  MODIFY `ideditora` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `livro`
--
ALTER TABLE `livro`
  MODIFY `idlivro` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `fk_cliente_has_livro_cliente1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_cliente_has_livro_livro1` FOREIGN KEY (`idlivro`) REFERENCES `livro` (`idlivro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `livro`
--
ALTER TABLE `livro`
  ADD CONSTRAINT `fk_livro_editora` FOREIGN KEY (`ideditora`) REFERENCES `editora` (`ideditora`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
