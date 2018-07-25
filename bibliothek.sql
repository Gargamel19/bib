-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 10. Apr 2016 um 22:10
-- Server-Version: 10.1.10-MariaDB
-- PHP-Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+02:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `bibliothek`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `inventar`
--

CREATE TABLE `inventar` (
  `ID` int(11) NOT NULL,
  `Titel` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Autor` varchar(30) CHARACTER SET utf8 NOT NULL,
  `Genre` varchar(20) CHARACTER SET utf8 NOT NULL,
  `Verfügbar` tinyint(1) NOT NULL,
  `Leihgebühr` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `inventar`
--

INSERT INTO `inventar` (`ID`, `Titel`, `Autor`, `Genre`, `Verfügbar`, `Leihgebühr`) VALUES
(1, 'Mobby Dick', 'Herman Melville', 'Roman', 1, 0),
(2, 'Romeo und Julia', 'Shakespeare', 'Trag?die', 1, 0),
(3, 'Schatzinsel', 'Robert Louis Stevenson', 'Abenteuer', 0, 0),
(4, 'Mobby Dick', 'Herman Melville', 'Roman', 1, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `ID` int(255) NOT NULL,
  `nutzername` varchar(30) CHARACTER SET utf8 NOT NULL,
  `passwort` varchar(20) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`ID`, `nutzername`, `passwort`) VALUES
(1, 'Ferdinand', 'Pa55wort'),
(2, 'Anni', 'Google'),
(3, 'Carl', 'Pesta007'),
(4, 'Papa', 'IPhone'),
(5, 'Caro', 'Felix'),
(6, 'Mama', 'Handy'),
(7, 'Felix', 'Knochen'),
(8, 'Chilli', 'Springen'),
(9, 'Pepper', 'Fressen'),
(10, 'Omi', 'Buch'),
(23, 'Ferdinand', 'ho');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `inventar`
--
ALTER TABLE `inventar`
  ADD PRIMARY KEY (`ID`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `inventar`
--
ALTER TABLE `inventar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT für Tabelle `user`
--
ALTER TABLE `user`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
