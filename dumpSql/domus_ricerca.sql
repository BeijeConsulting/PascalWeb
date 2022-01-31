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
-- Table structure for table `ricerca`
--

DROP TABLE IF EXISTS `ricerca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ricerca` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utente_id` int NOT NULL,
  `tipo_annuncio` enum('vendita','affitto','affitto breve') NOT NULL,
  `tipo_immobile` enum('casa','nuova costruzione','commerciale','terreno','garage','stanza','posto letto','cantina solaio','posto barca') NOT NULL,
  `tipo_ricerca` enum('comune','mappa','tempo da') NOT NULL,
  `tipo_mappa` enum('cerchio','poligono') DEFAULT NULL,
  `comune` varchar(45) DEFAULT NULL,
  `frazione` varchar(45) DEFAULT NULL,
  `raggio` double DEFAULT NULL,
  `centro_id` int DEFAULT NULL,
  `prezzo_min` int DEFAULT NULL,
  `prezzo_max` int DEFAULT NULL,
  `mq_min` int DEFAULT NULL,
  `mq_max` int DEFAULT NULL,
  `locali_min` int DEFAULT NULL,
  `locali_max` int DEFAULT NULL,
  `bagni_min` enum('1','2','3','4','5+') DEFAULT NULL,
  `piano` enum('1','2','3','4','5') DEFAULT NULL,
  `ascensore` bit(1) DEFAULT NULL,
  `posti_auto` enum('1','2','3') DEFAULT NULL,
  `balcone` bit(1) DEFAULT NULL,
  `terrazzo` bit(1) DEFAULT NULL,
  `giardino` enum('comune','privato') DEFAULT NULL,
  `condizione` enum('nuovo','buono','da_ristrutturare') DEFAULT NULL,
  `classe_energetica` enum('g','f','e','d','c','b','a o sup') DEFAULT NULL,
  `riscaldamento` enum('no','centralizzato','autonomo') DEFAULT NULL,
  `aria_condizionata` enum('no','centralizzata','autonoma','predisposizione') DEFAULT NULL,
  `arredamento` enum('non arredato','parzialmente arredato','arredato') DEFAULT NULL,
  `piscina` bit(1) DEFAULT NULL,
  `portineria` bit(1) DEFAULT NULL,
  `anno_costruzione` smallint DEFAULT NULL,
  `stato_rogito` enum('occupato','libero','nuda proprieta','affittato') DEFAULT NULL,
  `visita_guidata` bit(1) DEFAULT NULL,
  `virtual_tour` bit(1) DEFAULT NULL,
  `ultimo_timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `FK_301` (`centro_id`),
  KEY `utente_id_idx` (`utente_id`),
  CONSTRAINT `FK_299` FOREIGN KEY (`centro_id`) REFERENCES `punto` (`id`),
  CONSTRAINT `ricerca_ibfk_1` FOREIGN KEY (`centro_id`) REFERENCES `punto` (`id`),
  CONSTRAINT `utente_id` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ricerca`
--

LOCK TABLES `ricerca` WRITE;
/*!40000 ALTER TABLE `ricerca` DISABLE KEYS */;
/*!40000 ALTER TABLE `ricerca` ENABLE KEYS */;
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
