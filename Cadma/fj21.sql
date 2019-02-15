# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: fj21
# ------------------------------------------------------
# Server version 5.1.44-community

CREATE DATABASE `fj21` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `fj21`;

#
# Source for table clientes
#

CREATE TABLE `clientes` (
  `codCliente` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(90) DEFAULT NULL,
  `TipoPessoa` varchar(11) DEFAULT NULL,
  `cpfCnpj` varchar(20) DEFAULT NULL,
  `rg` varchar(20) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `complemento` varchar(80) DEFAULT NULL,
  `cidade` varchar(80) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `email` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`codCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

#
# Dumping data for table clientes
#

INSERT INTO `clientes` VALUES (1,'Luciano',NULL,'111.111.111-11','123456','Rua 1','101','Centro','Casa','Pinheiros',NULL,'(99) 9999-9999','vitiazze2.0@gmail.com');
INSERT INTO `clientes` VALUES (2,'Bybbyana Lissani Carrafa',NULL,'222.222.222-22','123455','Rua 2','200','Centro','Escritorio','Pinheiros',NULL,'(33) 3333-3333','bya@bya');
INSERT INTO `clientes` VALUES (3,'Geucineia Carrafa',NULL,'444.444.444-44','1223','Rua 1','101','Centro','Casa','Pinheiros',NULL,'(33) 3333-3333','vania@vania');
INSERT INTO `clientes` VALUES (5,'Vitiazze',NULL,'111.111.111-11','1111111','rua 125','14','Cebtro','em frentea rua','kinglópolis',NULL,NULL,'sdsdsdsdsd');
INSERT INTO `clientes` VALUES (6,'Jéssica Braga',NULL,'   .   .   -  ','','','','','','','AL','(  )     -    ','');
INSERT INTO `clientes` VALUES (7,'Luciano Carrafa Benfica',NULL,'   .   .   -  ','','','','','','',NULL,'(  )     -    ','');
INSERT INTO `clientes` VALUES (8,'Tiririca','Física','555.555.555-55','','','','','','','AC','(00) 0000-0000','');
INSERT INTO `clientes` VALUES (9,'dioma','Física','777.777.777-77','88888','rua do dindin','157','Distritofederal','algum lugar','Brasilia','DF','(15) 7157-1571','dilma@monicacomcebolinha');

#
# Source for table funcionarios
#

CREATE TABLE `funcionarios` (
  `codFunc` int(11) NOT NULL AUTO_INCREMENT,
  `funcionario` varchar(80) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `rg` varchar(30) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  `cidade` varchar(50) DEFAULT NULL,
  `uf` char(2) DEFAULT NULL,
  `telefone` varchar(14) DEFAULT NULL,
  `cargo` varchar(80) DEFAULT NULL,
  `usuario` varchar(80) DEFAULT NULL,
  `senha` varchar(15) DEFAULT NULL,
  `resenha` varchar(15) DEFAULT NULL,
  `tipoUser` varchar(15) DEFAULT NULL,
  `complemento` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`codFunc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

#
# Dumping data for table funcionarios
#

INSERT INTO `funcionarios` VALUES (1,'Luciano Carrafa Benfica','111.111.111-11','1111111','Rua monte alverner','469','Galiléia','Pinheiros','ES','(27) 9278-6473','Analista de Sistemas','vitiazze',NULL,NULL,'Administrador','Casa');
INSERT INTO `funcionarios` VALUES (3,'','   .   .   -  ','','','','','','AC','(  )     -    ','','',NULL,NULL,'Comum','');
INSERT INTO `funcionarios` VALUES (4,'Bybbyana Lisani Carrafa','222.222.222-22','88888','Rua Monte alverner ','469','Galileia','Pinheiros','ES','(88) 8888-8888','Presidenta','Bya',NULL,NULL,'usuário ADM','Casa');
INSERT INTO `funcionarios` VALUES (5,'','   .   .   -  ','','','','','','AC','(  )     -    ','','',NULL,NULL,'Comum','');
INSERT INTO `funcionarios` VALUES (6,'teste','   .   .   -  ','','','','','','AC','(  )     -    ','','',NULL,NULL,'Comum','');

#
# Source for table produtos
#

CREATE TABLE `produtos` (
  `codProduto` int(11) NOT NULL AUTO_INCREMENT,
  `produto` varchar(255) DEFAULT NULL,
  `quantidade` varchar(10) DEFAULT NULL,
  `especificacao` varchar(255) DEFAULT NULL,
  `valorUnit` double(9,2) DEFAULT NULL,
  PRIMARY KEY (`codProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

#
# Dumping data for table produtos
#

INSERT INTO `produtos` VALUES (15,'Notebook Acer','12','2 Gb HD, 4 Gb Memória',1500);

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
