# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: localhost    Database: cadma
# ------------------------------------------------------
# Server version 5.1.44-community

DROP DATABASE IF EXISTS `cadma`;
CREATE DATABASE `cadma` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `cadma`;

#
# Source for table clientes
#

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE `clientes` (
  `codCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `tipoCliente` varchar(10) DEFAULT NULL,
  `cpfCnpj` varchar(18) DEFAULT NULL,
  `rgInsEstadual` varchar(30) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(70) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `email` varchar(70) DEFAULT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Dumping data for table clientes
#

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Luciano Carrafa Benfica','Física','105.589.555-55','1458','Rua1',145,'Centro','','Pinheiros','ES','(27) 4588-5555','');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table empresa
#

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `codEmpresa` int(11) NOT NULL AUTO_INCREMENT,
  `nomeEmpresa` varchar(60) DEFAULT NULL,
  `cnpj` varchar(18) DEFAULT NULL,
  `insEstadual` varchar(30) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(70) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `telefone` varchar(13) DEFAULT NULL,
  `homePage` varchar(60) DEFAULT NULL,
  `email` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`codEmpresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table empresa
#

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table funcionarios
#

DROP TABLE IF EXISTS `funcionarios`;
CREATE TABLE `funcionarios` (
  `codFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `codEmpresa` int(11) DEFAULT NULL,
  `funcionario` varchar(70) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `endereco` varchar(60) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `bairro` varchar(60) DEFAULT NULL,
  `cidade` varchar(60) DEFAULT NULL,
  `uf` varchar(2) DEFAULT NULL,
  `complemento` varchar(40) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `cargo` varchar(40) DEFAULT NULL,
  `usuario` varchar(80) DEFAULT NULL,
  `senha` varchar(80) DEFAULT NULL,
  `resenha` varchar(80) DEFAULT NULL,
  `tipoUser` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table funcionarios
#

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,NULL,'Luciano carrafa','111.111.111-11','1111','11111',111,'1111','1111','AC','1111','(11) 1111-1111','11111','1111','111','1111','Administrador');
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table itens_pedido
#

DROP TABLE IF EXISTS `itens_pedido`;
CREATE TABLE `itens_pedido` (
  `codItensPedido` int(11) NOT NULL AUTO_INCREMENT,
  `codPedido` int(11) DEFAULT NULL,
  `codProduto` int(11) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valorUni` float DEFAULT NULL,
  PRIMARY KEY (`codItensPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table itens_pedido
#

LOCK TABLES `itens_pedido` WRITE;
/*!40000 ALTER TABLE `itens_pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `itens_pedido` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table pedidos
#

DROP TABLE IF EXISTS `pedidos`;
CREATE TABLE `pedidos` (
  `codPedido` int(11) NOT NULL AUTO_INCREMENT,
  `codFuncionario` int(11) DEFAULT NULL,
  `codCliente` int(11) DEFAULT NULL,
  `situacao` varchar(12) DEFAULT NULL,
  `tipoPedido` varchar(6) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `observacao` text,
  `codEmpresa` int(11) DEFAULT NULL,
  `valorPago` double(9,2) DEFAULT NULL,
  `diferenca` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`codPedido`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table pedidos
#

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table produtos
#

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE `produtos` (
  `codProduto` int(11) NOT NULL AUTO_INCREMENT,
  `produto` varchar(60) DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valorUnit` double(9,2) DEFAULT NULL,
  `especificacao` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`codProduto`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table produtos
#

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'Notebook Acer',10,1550,'HD 500 GB 8 Gb memoria win 7');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
