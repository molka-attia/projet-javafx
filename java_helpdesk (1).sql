-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : sam. 09 déc. 2023 à 11:49
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `java_helpdesk`
--

-- --------------------------------------------------------

--
-- Structure de la table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
CREATE TABLE IF NOT EXISTS `ticket` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `description` varchar(100) NOT NULL,
  `priorite` varchar(100) NOT NULL,
  `datecreation` date NOT NULL,
  `etat` varchar(100) NOT NULL,
  `solution` varchar(100) NOT NULL,
  `datecloture` date DEFAULT NULL,
  `responsable` int(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ticket`
--

INSERT INTO `ticket` (`id`, `description`, `priorite`, `datecreation`, `etat`, `solution`, `datecloture`, `responsable`) VALUES
(2, 'testetete', 'Haute', '2023-12-08', 'non cloturer', '', '3924-01-15', NULL),
(4, 'aj', 'Moyenne', '2023-12-09', 'non cloturer', '', NULL, NULL),
(5, 'la', 'Faible', '2023-12-09', 'non cloturer', 'solution1', NULL, NULL),
(6, 'testjuste', 'Faible', '2023-12-09', 'non cloturer', '', NULL, 1),
(8, 'prob', 'Moyenne', '2023-12-09', 'non cloturer', '', NULL, 1);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `tel` varchar(100) NOT NULL,
  `poste` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `groupe` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `password`, `tel`, `poste`, `type`, `groupe`) VALUES
(2, 'nom', 'h', 'h', 'j', 'k', 'j', 'user', 0),
(3, 'ben', 'sahartour', 'sahar@', 'ko', '15415', 'tech', 'user', 0),
(8, 'techhh', 'atattataa', 'tock', '1245', 'kkfdsfs', 'tititi', 'tech', 2),
(10, 'te', 'f', 's', 's', 's', 's', 'tech', 1),
(11, 'ta', 'az', 'z', 'az', 'az', 'za', 'tech', 1),
(12, 'alalal', 'za', 'azaz', 'azea', 'zaza', 'za', 'tech', 1),
(13, 'lalalala', 'a', 'asa', 'zdza', 'sqs', 'aea', 'tech', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
