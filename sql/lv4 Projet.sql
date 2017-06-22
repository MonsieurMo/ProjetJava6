-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Lun 12 Juin 2017 à 20:25
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  'boulderdash'
--

DELIMITER $$
--
-- Procédures
--
 CREATE PROCEDURE findAllLevels ()  NO SQL
SELECT *
FROM lvl4$$

CREATE PROCEDURE findLvl4ByLigne (IN ligne INT)  NO SQL
SELECT *
FROM lvl4
WHERE lvl4.ligne = ligne$$ 

/* NE FONCTIONNE PAS 
CREATE PROCEDURE findLvl1ByName (IN colonne1 varchar(255), colonne2 varchar(255), colonne3 varchar(255), colonne4 varchar(255), colonne5 varchar(255), colonne6 varchar(255), colonne7 varchar(255), colonne8 varchar(255), colonne9 varchar(255), colonne10 varchar(255), colonne11 varchar(255), colonne12 varchar(255),colonne13 varchar(255), colonne14 varchar(255), colonne15 varchar(255),colonne16 varchar(255), colonne17 varchar(255), colonne18 varchar(255),colonne19 varchar(255), colonne20 varchar(255), colonne21 varchar(255),colonne22 varchar(255), colonne23 varchar(255), colonne24 varchar(255), colonne25 varchar(255), colonne26 varchar(255), colonne27 varchar(255), colonne28 varchar(255), colonne29 varchar(255), colonne30 varchar(255))  NO SQL
SELECT *
FROM lvl4
WHERE lvl4.colonne1 = colonne1$$, lvl4.colonne2 = colonne2$$ AND lvl4.colonne3 = colonne3$$ AND lvl4.colonne4 = colonne4$$ AND lvl4.colonne5 = colonne5$$ AND lvl4.colonne6 = colonne6$$ AND lvl4.colonne7 = colonne7$$ AND lvl4.colonne8 = colonne8$$ AND lvl4.colonne9 = colonne9$$ AND lvl4.colonne10 = colonne10$$ AND lvl4.colonne11 = colonne11$$ AND lvl4.colonne12 = colonne12$$ AND lvl4.colonne13 = colonne13$$ AND lvl4.colonne14 = colonne14$$ AND lvl4.colonne15 = colonne15$$ AND lvl4.colonne16 = colonne16$$ AND lvl4.colonne17 = colonne17$$ AND lvl4.colonne18 = colonne18$$ AND lvl4.colonne19 = colonne19$$ AND lvl4.colonne20 = colonne20$$ AND lvl4.colonne21 = colonne21$$ AND lvl4.colonne22 = colonne22$$ AND lvl4.colonne23 = colonne23$$ AND lvl4.colonne24 = colonne24$$ AND lvl4.colonne25 = colonne25$$ AND lvl4.colonne26 = colonne26$$ AND lvl4.colonne27 = colonne27$$ AND lvl4.colonne28 = colonne28$$ AND lvl4.colonne29 = colonne29$$ AND lvl4.colonne30 = colonne30$$
*/

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table 'lvl4'
--

CREATE TABLE lvl4 (
  ligne int(11) NOT NULL,
  colonne1 varchar(255),
  colonne2 varchar(255),
  colonne3 varchar(255),
  colonne4 varchar(255),
  colonne5 varchar(255),
  colonne6 varchar(255),
  colonne7 varchar(255),
  colonne8 varchar(255),
  colonne9 varchar(255),
  colonne10 varchar(255),
  colonne11 varchar(255),
  colonne12 varchar(255),
  colonne13 varchar(255),
  colonne14 varchar(255),
  colonne15 varchar(255),
  colonne16 varchar(255),
  colonne17 varchar(255),
  colonne18 varchar(255),
  colonne19 varchar(255),
  colonne20 varchar(255),
  colonne21 varchar(255),
  colonne22 varchar(255),
  colonne23 varchar(255),
  colonne24 varchar(255),
  colonne25 varchar(255),
  colonne26 varchar(255),
  colonne27 varchar(255),
  colonne28 varchar(255),
  colonne29 varchar(255),
  colonne30 varchar(255)

) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table 'lvl4'
--

INSERT INTO lvl4 (ligne, colonne1, colonne2, colonne3, colonne4, colonne5, colonne6, colonne7, colonne8, colonne9, colonne10, colonne11, colonne12,colonne13, colonne14, colonne15,colonne16, colonne17, colonne18,colonne19, colonne20, colonne21,colonne22, colonne23, colonne24, colonne25, colonne26, colonne27, colonne28, colonne29, colonne30) VALUES
(1, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5),
(2, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(3, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(5, 5, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 5),
(6, 5, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(7, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 3, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(8, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 3, 4, 3, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(9, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 4, 4, 4, 4, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(10, 5, 1, 1, 1, 1, 1, 1, 1, 1, 5, 4, 4, 4, 4, 4, 4, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1 ,1, 1, 5),
(11, 5, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(12, 5, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(13, 5, 1, 1, 1, 1, 1, 5, 3, 5, 1, 1, 1, 4, 4, 1, 1, 1, 1, 1, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 5),
(14, 5, 1, 1, 1, 1, 5, 1, 1, 1, 5, 2, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 5),
(15, 5, 1, 8, 1, 5, 1, 1, 4, 1, 1, 5, 1, 1, 1, 1, 6, 1, 4, 4, 4, 1, 1, 5, 1, 1, 1, 1, 1, 1, 5),
(16, 5, 1, 1, 5, 3, 1, 4, 4, 4, 1, 1, 5, 1, 1, 1, 1, 1, 4, 1, 4, 1, 1, 1, 5, 2, 1, 1, 1, 1, 5),
(17, 5, 1, 5, 1, 1, 4, 4, 4, 4, 4, 1, 1, 5, 1, 1, 1, 1, 4, 3, 4, 1, 1, 1, 1, 5, 2, 1, 1, 1, 5),
(18, 5, 5, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 5, 2, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1, 5, 1, 1, 1, 5),
(19, 5, 3, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 5),
(20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);

--
-- Index pour les tables exportées
--

--
-- Index pour la table 'lvl4'
--
ALTER TABLE lvl4
  ADD PRIMARY KEY (ligne);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table 'example'
--
ALTER TABLE lvl4
  MODIFY ligne int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
