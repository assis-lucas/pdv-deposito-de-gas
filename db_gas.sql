-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_gas
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.31-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bkp`
--

DROP TABLE IF EXISTS `bkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bkp` (
  `mes_bkp` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bkp`
--

LOCK TABLES `bkp` WRITE;
/*!40000 ALTER TABLE `bkp` DISABLE KEYS */;
INSERT INTO `bkp` VALUES ('03');
/*!40000 ALTER TABLE `bkp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `telefone` varchar(9) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `bairro` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('11111111','Cleiton','Rua alameda clieton, 527','azul'),('12345678','KJJKJKJJKJKJKJKJK','ASDASDASDASDASD','Jd boa esperança'),('123456789','kk eae men','R. alameda cleiton','SANTA RITA GARÇA'),('33010184','fatima','rua ipiranga,2041- em frente ao ed damasco','alto'),('33025444','valeria','rua sao tomaz de aquino,435','vila monteiro'),('33333333','cleiton arruda','rua cleiton campos cleber, 5220','jd ceu'),('34110289','isabela','av maria nacifi curiacos,25','jd ipanema'),('34111632','adriana','av rio das pedras,1411','jd ipanema'),('34118974','luciana','rua jurandir sotto,207','asturias'),('34130208','maria ines','rua romario nery,160','sao luis'),('34141482','carmen','rua dos gavioes,32','chapadao'),('34143416','tereza','rua antonio da silva mendes campos,30','unileste'),('34212876','jose piveta','rua athaulpa vaz de melo,45','vila rezende'),('34213666','bianca','rua dos papoulas,65','nova piracicaba'),('34215016','maria ines','rua americo vespucio,535','algodoal'),('34215147','vanilda','av santa lidia,728','areiao'),('34221388','marcia','rua capivari, 97','jaragua'),('34225667','maria de lourdes','av independencia,3506','independencia'),('34243252','ivani','av eurico gaspar dutra,1880','eldorado 1'),('34253139','ana maria','rua guaratingueta,70','parque piracicaba'),('34324668','tatiane','av duque de caxias,595','sao dimas'),('34340101','helenice','rua padre lopes,860','sao dimas'),('34341110','clusa','rua monte pascoal,157','jd ibirapuera'),('34341536','neuza','rua benjamin,3084','paulista'),('34343116','helena','rua jose pinto de almeida,1982','centro'),('34345905','antonio','rua doutor alvin,1861','sao judas'),('34349843','flavia','rua bom pastor,119','vila cristina'),('34412864','Lucas A',' R. de teste, 312','Vale valverde'),('34518787','Cliente de Teste','R. de teste, 312','Vale valverde'),('34713843','luciane','rua fernando febeliano da costa,908','sao dimas'),('39275110','alexandra','rua doutor osorio de sousa,97','independencia'),('44444444','Cleiton Junior','R. Cristiano Cleber Arruda, 552','JD Esperança'),('55555555','jascnkawvnf','rua ajqfnqwjfnwq ','JJJJJJ'),('66666666','cleiton rastafari','rua cleiton da silva pinto, 53','jd rasta'),('981686889','reinaldo','rua manuel serafin dos santos,66','santa rosa'),('983601103','marcia','travessa particular alberto ramos,152','jd sao paulo'),('983723340','Cliente de Teste','R. de Teste, 515','Vale valverde'),('983723343','vemvqmw','qwfwqf','fwqwfq'),('983723345','dasddas','asdsa','asdasddas'),('983723346','cleton','rua alameda luz 536','agua branca jjjjjjj'),('983723399','kkkjjkkj','rua jj eae men 53','jjjj'),('983735699','joao cleber','rua teste 53','jd teste'),('986028377','graça','rua princesa leopoldina,59','algodoal'),('991931977','maria','rua do porto,1883- é no calçadão','centro'),('992538147','cecilia','av armando salles de oliveira,940','centro'),('993031433','charlie','rua lourenço ducatti, 528 casa 4','vila rezende'),('994950688','adriana','rua mario bruneli,110','terras 2'),('996410411','Ligia Cristina','R. Marechal deodoro, 5868 TORRE 3 AP 21','Alto'),('996629321','ilda','rua copo de leite,26','canta galo'),('998368837','araci','rua engenheiro agronomo romano curi,401','caxambu'),('99882063','debora','rua pedro zalunardo zanin,433','pauliceia'),('999999999','JJJ EAE MEN','TESTE','JD CLEITON LUZ');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forma_pgto`
--

DROP TABLE IF EXISTS `forma_pgto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forma_pgto` (
  `id_pgto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_pgto`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forma_pgto`
--

LOCK TABLES `forma_pgto` WRITE;
/*!40000 ALTER TABLE `forma_pgto` DISABLE KEYS */;
INSERT INTO `forma_pgto` VALUES (1,'Dinheiro'),(2,'Cartão de Crédito'),(3,'Cartão de Débito'),(4,'Cheque');
/*!40000 ALTER TABLE `forma_pgto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motoristas`
--

DROP TABLE IF EXISTS `motoristas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `motoristas` (
  `id_motorista` int(11) NOT NULL AUTO_INCREMENT,
  `nome_motorista` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_motorista`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motoristas`
--

LOCK TABLES `motoristas` WRITE;
/*!40000 ALTER TABLE `motoristas` DISABLE KEYS */;
INSERT INTO `motoristas` VALUES (1,'Oscar','Ativo'),(2,'Gilliard','Inativo');
/*!40000 ALTER TABLE `motoristas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao_prod` varchar(20) DEFAULT NULL,
  `valorpadrao` decimal(10,0) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'GAS P13',78,'Ativo'),(2,'GAS P20',100,'Inativo'),(3,'GAS P45',150,'Inativo');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(15) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'admin','123','administrador'),(2,'1','1','usuario');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valorpadrao`
--

DROP TABLE IF EXISTS `valorpadrao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `valorpadrao` (
  `valor` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valorpadrao`
--

LOCK TABLES `valorpadrao` WRITE;
/*!40000 ALTER TABLE `valorpadrao` DISABLE KEYS */;
INSERT INTO `valorpadrao` VALUES (78);
/*!40000 ALTER TABLE `valorpadrao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendas` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `telefone` varchar(9) DEFAULT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `observacao` varchar(50) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `id_motorista` int(11) DEFAULT NULL,
  `dt` date DEFAULT NULL,
  `hora` varchar(10) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `id_pgto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_venda`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
INSERT INTO `vendas` VALUES (19,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-03-02','19:34',1,120,2,1),(20,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-07-05','19:35',1,70,1,1);
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas_bkp`
--

DROP TABLE IF EXISTS `vendas_bkp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendas_bkp` (
  `id_venda` int(11) NOT NULL AUTO_INCREMENT,
  `telefone` varchar(9) DEFAULT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `observacao` varchar(50) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `id_motorista` int(11) DEFAULT NULL,
  `dt` date DEFAULT NULL,
  `hora` varchar(10) DEFAULT NULL,
  `id_produto` int(11) DEFAULT NULL,
  `valor` decimal(10,0) DEFAULT NULL,
  `qtd` int(11) DEFAULT NULL,
  `id_pgto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_venda`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas_bkp`
--

LOCK TABLES `vendas_bkp` WRITE;
/*!40000 ALTER TABLE `vendas_bkp` DISABLE KEYS */;
INSERT INTO `vendas_bkp` VALUES (1,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-07-02','21:06',1,78,1,1),(2,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-07-02','21:13',3,78,1,1),(3,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-07-02','21:15',3,80,1,1),(4,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-07-02','21:26',1,78,1,1),(5,'34412867','Cliente de Teste','R. de teste, 312','','Vale valverde',1,'2018-07-02','21:26',1,78,1,2),(6,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-07-02','21:33',2,100,1,1),(7,'34518787','Cliente de Teste','R. de teste, 312','','Vale valverde',1,'2018-07-02','22:24',3,150,1,1),(8,'34412864','Lucas A','R de teste, 312','','Vale valverde',1,'2018-07-04','18:51',1,78,1,1),(9,'34518787','Cliente de Teste','R. de teste, 312','','Vale valverde',1,'2018-07-04','18:51',3,2,1,1),(10,'34518787','Cliente de Teste','R. de teste, 312','','Vale valverde',1,'2018-07-04','18:51',3,300,2,1),(11,'34518787','Cliente de Teste','R. de teste, 312','','Vale valverde',1,'2018-07-04','18:52',2,200,2,1),(13,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-08-01','19:31',1,78,1,1),(14,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-09-05','19:32',1,78,1,1),(15,'34518787','Cliente de Teste','R. de teste, 312','','Vale valverde',1,'2018-09-05','19:32',1,78,1,1),(16,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-10-10','19:33',1,78,1,1),(17,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-01-02','19:34',1,78,1,1),(18,'983723340','Cliente de Teste','R. de Teste, 515','','Vale valverde',1,'2018-02-02','19:34',1,78,1,1);
/*!40000 ALTER TABLE `vendas_bkp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-06  0:05:26
