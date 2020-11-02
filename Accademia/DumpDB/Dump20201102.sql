CREATE DATABASE  IF NOT EXISTS `scuola` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `scuola`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: scuola
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Insegnanti`
--

DROP TABLE IF EXISTS `Insegnanti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Insegnanti` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `data_di_nascita` datetime NOT NULL,
  `CF` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `citta` varchar(45) NOT NULL,
  `via` varchar(45) NOT NULL,
  `cap` varchar(6) NOT NULL,
  `id_regione` int NOT NULL,
  `titolo_di_studio` varchar(45) DEFAULT NULL,
  `costo_orario` varchar(45) NOT NULL,
  `partita_iva` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  UNIQUE KEY `partita_iva_UNIQUE` (`partita_iva`),
  KEY `FKregioneInsegnanti_idx` (`id_regione`),
  CONSTRAINT `FKregioneInsegnanti` FOREIGN KEY (`id_regione`) REFERENCES `Regioni` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Insegnanti`
--

LOCK TABLES `Insegnanti` WRITE;
/*!40000 ALTER TABLE `Insegnanti` DISABLE KEYS */;
/*!40000 ALTER TABLE `Insegnanti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Regioni`
--

DROP TABLE IF EXISTS `Regioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Regioni` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Regioni`
--

LOCK TABLES `Regioni` WRITE;
/*!40000 ALTER TABLE `Regioni` DISABLE KEYS */;
INSERT INTO `Regioni` VALUES (1,'Lombardia');
/*!40000 ALTER TABLE `Regioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Strumenti_didattici`
--

DROP TABLE IF EXISTS `Strumenti_didattici`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Strumenti_didattici` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Strumenti_didattici`
--

LOCK TABLES `Strumenti_didattici` WRITE;
/*!40000 ALTER TABLE `Strumenti_didattici` DISABLE KEYS */;
INSERT INTO `Strumenti_didattici` VALUES (10,'computer');
/*!40000 ALTER TABLE `Strumenti_didattici` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Studenti`
--

DROP TABLE IF EXISTS `Studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Studenti` (
  `id` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  `cognome` varchar(45) NOT NULL,
  `data_di_nascita` varchar(45) NOT NULL,
  `CF` varchar(15) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `citta` varchar(45) NOT NULL,
  `via` varchar(45) NOT NULL,
  `cap` varchar(6) NOT NULL,
  `id_regione` int NOT NULL,
  `titolo_studio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `CF_UNIQUE` (`CF`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  KEY `FKregione_idx` (`id_regione`),
  KEY `FKregionestudenti_idx` (`id_regione`),
  CONSTRAINT `FKregionestudenti` FOREIGN KEY (`id_regione`) REFERENCES `Regioni` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Studenti`
--

LOCK TABLES `Studenti` WRITE;
/*!40000 ALTER TABLE `Studenti` DISABLE KEYS */;
INSERT INTO `Studenti` VALUES (1,'gabri','Gognome','19940502','gbada44355355','gabry@email.com','3333333','Milano','via l','10210',1,'diploma'),(2,'Claudio','Verdi','19940502','gcala44355355','claudio@email.com','3333344','Milano','via l','10210',1,'diploma');
/*!40000 ALTER TABLE `Studenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abilita`
--

DROP TABLE IF EXISTS `abilita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abilita` (
  `id` int NOT NULL,
  `abilità` varchar(45) NOT NULL,
  `id_area` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_abilita_aree_abilita_idx` (`id_area`),
  CONSTRAINT `FK_abilita_aree_abilita` FOREIGN KEY (`id_area`) REFERENCES `aree_abilità` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilita`
--

LOCK TABLES `abilita` WRITE;
/*!40000 ALTER TABLE `abilita` DISABLE KEYS */;
/*!40000 ALTER TABLE `abilita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abilita_insegnanti`
--

DROP TABLE IF EXISTS `abilita_insegnanti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abilita_insegnanti` (
  `id_insegnante` int NOT NULL,
  `id_abilita` int NOT NULL,
  `livello_di_abilità` int NOT NULL,
  PRIMARY KEY (`id_insegnante`,`id_abilita`),
  KEY `FKabilita_i_idx` (`id_abilita`),
  CONSTRAINT `FKabilita_i` FOREIGN KEY (`id_abilita`) REFERENCES `abilita` (`id`),
  CONSTRAINT `FKinsegnanti` FOREIGN KEY (`id_insegnante`) REFERENCES `Insegnanti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilita_insegnanti`
--

LOCK TABLES `abilita_insegnanti` WRITE;
/*!40000 ALTER TABLE `abilita_insegnanti` DISABLE KEYS */;
/*!40000 ALTER TABLE `abilita_insegnanti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `abilita_studente`
--

DROP TABLE IF EXISTS `abilita_studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `abilita_studente` (
  `id_studente` int NOT NULL,
  `id_abilita` int NOT NULL,
  `livello_di_abilità` int NOT NULL,
  `id_iscrizione` int DEFAULT NULL,
  PRIMARY KEY (`id_studente`,`id_abilita`),
  KEY `FKabilitas_idx` (`id_abilita`),
  KEY `FK_abilita_studente_iscrizioni_idx` (`id_iscrizione`),
  CONSTRAINT `FK_abilita_studente_iscrizioni` FOREIGN KEY (`id_iscrizione`) REFERENCES `iscrizioni` (`id`),
  CONSTRAINT `FK_abilita_studente_studente` FOREIGN KEY (`id_studente`) REFERENCES `Studenti` (`id`),
  CONSTRAINT `FKabilita_studente_abilita` FOREIGN KEY (`id_abilita`) REFERENCES `abilita` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `abilita_studente`
--

LOCK TABLES `abilita_studente` WRITE;
/*!40000 ALTER TABLE `abilita_studente` DISABLE KEYS */;
/*!40000 ALTER TABLE `abilita_studente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aree_abilità`
--

DROP TABLE IF EXISTS `aree_abilità`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aree_abilità` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aree_abilità`
--

LOCK TABLES `aree_abilità` WRITE;
/*!40000 ALTER TABLE `aree_abilità` DISABLE KEYS */;
INSERT INTO `aree_abilità` VALUES (1,'grafica','fare disegnini'),(2,'programmazione','conoscere jdbc');
/*!40000 ALTER TABLE `aree_abilità` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `capienza` varchar(45) NOT NULL,
  `virtuale` tinyint NOT NULL,
  `id_software` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`),
  KEY `FK_aula_softwares_idx` (`id_software`),
  CONSTRAINT `FK_aula_softwares` FOREIGN KEY (`id_software`) REFERENCES `softwares` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,'turing','3',0,NULL);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aziende`
--

DROP TABLE IF EXISTS `aziende`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aziende` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `contatto_rappresentante` varchar(45) NOT NULL,
  `citta` varchar(45) DEFAULT NULL,
  `via` varchar(45) DEFAULT NULL,
  `cap` char(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aziende`
--

LOCK TABLES `aziende` WRITE;
/*!40000 ALTER TABLE `aziende` DISABLE KEYS */;
/*!40000 ALTER TABLE `aziende` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario`
--

DROP TABLE IF EXISTS `calendario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calendario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_modulo` int NOT NULL,
  `orario_inizio` datetime NOT NULL,
  `orario_fine` datetime NOT NULL,
  `id_aula` int DEFAULT NULL,
  `argomento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_calendario_aula_idx` (`id_aula`),
  KEY `FK_calendario_corsi_idx` (`id_modulo`),
  CONSTRAINT `FK_calendario_aula` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id`),
  CONSTRAINT `FK_calendario_moduli` FOREIGN KEY (`id_modulo`) REFERENCES `moduli_corso` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario`
--

LOCK TABLES `calendario` WRITE;
/*!40000 ALTER TABLE `calendario` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corsi`
--

DROP TABLE IF EXISTS `corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corsi` (
  `id` int NOT NULL,
  `nome_corso` varchar(45) NOT NULL,
  `id_aula_pref` int NOT NULL,
  `capienza` int NOT NULL,
  `iscrizioni_min` int NOT NULL,
  `finanziato` tinyint NOT NULL,
  `id_azienda` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_corso_UNIQUE` (`nome_corso`),
  KEY `FK_corsi_aziende_idx` (`id_azienda`),
  KEY `FK_corsi_aula_idx` (`id_aula_pref`),
  CONSTRAINT `FK_corsi_aula` FOREIGN KEY (`id_aula_pref`) REFERENCES `aula` (`id`),
  CONSTRAINT `FK_corsi_aziende` FOREIGN KEY (`id_azienda`) REFERENCES `aziende` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi`
--

LOCK TABLES `corsi` WRITE;
/*!40000 ALTER TABLE `corsi` DISABLE KEYS */;
INSERT INTO `corsi` VALUES (1,'Programmazione',1,200,100,1,NULL);
/*!40000 ALTER TABLE `corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interessi`
--

DROP TABLE IF EXISTS `interessi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interessi` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interessi`
--

LOCK TABLES `interessi` WRITE;
/*!40000 ALTER TABLE `interessi` DISABLE KEYS */;
/*!40000 ALTER TABLE `interessi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interessi_studenti`
--

DROP TABLE IF EXISTS `interessi_studenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interessi_studenti` (
  `id_studente` int NOT NULL,
  `id_interessi` int NOT NULL,
  `livello_di_interesse` int NOT NULL,
  PRIMARY KEY (`id_studente`,`id_interessi`),
  KEY `FKinteressi_idx` (`id_interessi`),
  CONSTRAINT `FKinteressi` FOREIGN KEY (`id_interessi`) REFERENCES `interessi` (`id`),
  CONSTRAINT `FKstudenti` FOREIGN KEY (`id_studente`) REFERENCES `Studenti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interessi_studenti`
--

LOCK TABLES `interessi_studenti` WRITE;
/*!40000 ALTER TABLE `interessi_studenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `interessi_studenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `iscrizioni`
--

DROP TABLE IF EXISTS `iscrizioni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `iscrizioni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_corso` int NOT NULL,
  `id_studente` int NOT NULL,
  `valutazione_studente` int DEFAULT NULL,
  `valutazione_corso` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_persona_UNIQUE` (`id_studente`),
  UNIQUE KEY `id_corso_UNIQUE` (`id_corso`),
  UNIQUE KEY `Iscrizione_Unica` (`id_corso`,`id_studente`) COMMENT 'Uno studente si può iscrivere una sola volta ad un dato corso',
  CONSTRAINT `FK_iscrizioni_corsi` FOREIGN KEY (`id_corso`) REFERENCES `corsi` (`id`),
  CONSTRAINT `FK_iscrizioni_studenti` FOREIGN KEY (`id_studente`) REFERENCES `Studenti` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `iscrizioni`
--

LOCK TABLES `iscrizioni` WRITE;
/*!40000 ALTER TABLE `iscrizioni` DISABLE KEYS */;
INSERT INTO `iscrizioni` VALUES (1,1,1,NULL,NULL);
/*!40000 ALTER TABLE `iscrizioni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `moduli_corso`
--

DROP TABLE IF EXISTS `moduli_corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `moduli_corso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  `id_corso` int DEFAULT NULL,
  `id_insegnante` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_moduli_corso_corsi_idx` (`id_corso`),
  KEY `FK_moduli_corsi_insegnanti_idx` (`id_insegnante`),
  CONSTRAINT `FK_moduli_corsi_insegnanti` FOREIGN KEY (`id_insegnante`) REFERENCES `Insegnanti` (`id`),
  CONSTRAINT `FK_moduli_corso_corsi` FOREIGN KEY (`id_corso`) REFERENCES `corsi` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moduli_corso`
--

LOCK TABLES `moduli_corso` WRITE;
/*!40000 ALTER TABLE `moduli_corso` DISABLE KEYS */;
/*!40000 ALTER TABLE `moduli_corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `softwares`
--

DROP TABLE IF EXISTS `softwares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `softwares` (
  `id` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `descrizione` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `softwares`
--

LOCK TABLES `softwares` WRITE;
/*!40000 ALTER TABLE `softwares` DISABLE KEYS */;
/*!40000 ALTER TABLE `softwares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `strumenti_aule`
--

DROP TABLE IF EXISTS `strumenti_aule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `strumenti_aule` (
  `id_aula` int NOT NULL,
  `id_strumento` int NOT NULL,
  `qty` int NOT NULL,
  PRIMARY KEY (`id_aula`,`id_strumento`),
  UNIQUE KEY `id_strumento_UNIQUE` (`id_strumento`),
  CONSTRAINT `FKaula` FOREIGN KEY (`id_aula`) REFERENCES `aula` (`id`),
  CONSTRAINT `FKstrum` FOREIGN KEY (`id_strumento`) REFERENCES `Strumenti_didattici` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `strumenti_aule`
--

LOCK TABLES `strumenti_aule` WRITE;
/*!40000 ALTER TABLE `strumenti_aule` DISABLE KEYS */;
INSERT INTO `strumenti_aule` VALUES (1,10,15);
/*!40000 ALTER TABLE `strumenti_aule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valutazioni_insegnanti`
--

DROP TABLE IF EXISTS `valutazioni_insegnanti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `valutazioni_insegnanti` (
  `id` int NOT NULL,
  `id_studente` int NOT NULL,
  `id_modulo_corso` int NOT NULL,
  `valutazione` int NOT NULL,
  `nota` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_valutazioni_insegnanti_moduli_idx` (`id_modulo_corso`),
  KEY `FK_valutazioni_insegnanti_Studenti_idx` (`id_studente`),
  CONSTRAINT `FK_valutazioni_insegnanti_moduli` FOREIGN KEY (`id_modulo_corso`) REFERENCES `moduli_corso` (`id`),
  CONSTRAINT `FK_valutazioni_insegnanti_Studenti` FOREIGN KEY (`id_studente`) REFERENCES `Studenti` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valutazioni_insegnanti`
--

LOCK TABLES `valutazioni_insegnanti` WRITE;
/*!40000 ALTER TABLE `valutazioni_insegnanti` DISABLE KEYS */;
/*!40000 ALTER TABLE `valutazioni_insegnanti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-02 12:41:04
