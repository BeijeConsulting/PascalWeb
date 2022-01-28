-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: domus
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `annuncio`
--

DROP TABLE IF EXISTS `annuncio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `annuncio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `venditore_id` int NOT NULL,
  `edificio_id` int DEFAULT NULL,
  `piantina_id` int DEFAULT NULL,
  `indirizzo_id` int NOT NULL,
  `tipo_immobile` enum('CASA','NUOVA COSTRUZIONE','COMMERCIALE','TERRENO','GARAGE','STANZA','POSTO LETTO','CANTINA SOLAIO','POSTO BARCA') NOT NULL,
  `tipo_annuncio` enum('VENDITA','AFFITTO','AFFITTO BREVE') NOT NULL,
  `prezzo` int DEFAULT NULL,
  `mq` int NOT NULL,
  `locali` int DEFAULT NULL,
  `bagni` int DEFAULT NULL,
  `tot_piani` int DEFAULT NULL,
  `piano` int DEFAULT NULL,
  `ascensore` bit(1) DEFAULT NULL,
  `posti_auto` int DEFAULT NULL,
  `balcone` bit(1) DEFAULT NULL,
  `terrazzo` bit(1) DEFAULT NULL,
  `giardino` enum('NO','COMUNE','PRIVATO') DEFAULT NULL,
  `condizione` enum('NUOVO','BUONO','DA RISTRUTTURARE') DEFAULT NULL,
  `classe_energetica` enum('G','F','E','D','C','B','A O SUP') DEFAULT NULL,
  `riscaldamento` enum('NO','CENTRALIZZATO','AUTONOMO') DEFAULT NULL,
  `aria_condizionata` enum('NO','CENTRALIZZATA','AUTONOMA','PREDISPOSIZIONE') DEFAULT NULL,
  `arredamento` enum('NON ARREDATO','PARZIALMENTE ARREDATO','ARREDATO') DEFAULT NULL,
  `piscina` bit(1) DEFAULT NULL,
  `portineria` bit(1) DEFAULT NULL,
  `anno_costruzione` smallint DEFAULT NULL,
  `stato_rogito` enum('OCCUPATO','LIBERO','NUDA PROPRIETA','AFFITTATO') NOT NULL,
  `visita_guidata` bit(1) NOT NULL DEFAULT b'0',
  `descrizione_lunga` text,
  `virtual_tour` bit(1) NOT NULL DEFAULT b'0',
  `create_timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_145` (`venditore_id`),
  KEY `FK_227` (`indirizzo_id`),
  KEY `FK_243` (`piantina_id`),
  KEY `annuncio_padre_idx` (`edificio_id`),
  CONSTRAINT `annuncio_padre` FOREIGN KEY (`edificio_id`) REFERENCES `annuncio` (`id`),
  CONSTRAINT `FK_143` FOREIGN KEY (`venditore_id`) REFERENCES `utente` (`id`),
  CONSTRAINT `FK_225` FOREIGN KEY (`indirizzo_id`) REFERENCES `indirizzo` (`id`),
  CONSTRAINT `FK_241` FOREIGN KEY (`piantina_id`) REFERENCES `foto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annuncio`
--

LOCK TABLES `annuncio` WRITE;
/*!40000 ALTER TABLE `annuncio` DISABLE KEYS */;
INSERT INTO `annuncio` VALUES (2,9,NULL,NULL,2,'CASA','VENDITA',2222,222,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'OCCUPATO',_binary '\0',NULL,_binary '\0','2022-01-28 13:41:55'),(3,9,NULL,NULL,3,'CASA','VENDITA',212,333,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'OCCUPATO',_binary '\0',NULL,_binary '\0','2022-01-28 13:41:55'),(4,9,NULL,NULL,4,'CASA','VENDITA',222,222,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'OCCUPATO',_binary '\0',NULL,_binary '\0','2022-01-28 13:41:55');
/*!40000 ALTER TABLE `annuncio` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-28 18:00:04
