-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 20 Maj 2021, 11:11
-- Wersja serwera: 10.4.17-MariaDB
-- Wersja PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `przesylki`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tpackage`
--

CREATE TABLE `tpackage` (
  `id` int(11) NOT NULL,
  `code` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `sendFrom` int(11) NOT NULL,
  `sendTo` int(11) NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tpackage`
--

INSERT INTO `tpackage` (`id`, `code`, `date`, `sendFrom`, `sendTo`, `status`) VALUES
(1, 'AADD', '12-01-2021', 1, 2, 'NADANY'),
(2, 'SSTT', '06-03-2020', 2, 1, 'DORECZONY'),
(3, 'QQEE', '09-06-2020', 2, 1, 'NADANY'),
(4, 'QQWW', '29-05-2020', 1, 2, 'W_DORECZENIU');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuser`
--

CREATE TABLE `tuser` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `lastName` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tuser`
--

INSERT INTO `tuser` (`id`, `address`, `lastName`, `name`, `phone`) VALUES
(1, 'ul. Cicha 132 m. 16\r\n62-200 GNIEZNO', 'Nowak', 'Janina', '123456789'),
(2, 'ul. Niepodleglosci 132 m. 16\r\n62-200 GNIEZNO', 'Kowalski', 'Jan', '321654987');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `tuseradmin`
--

CREATE TABLE `tuseradmin` (
  `id` int(11) NOT NULL,
  `login` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pass` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Zrzut danych tabeli `tuseradmin`
--

INSERT INTO `tuseradmin` (`id`, `login`, `pass`) VALUES
(1, 'admin', 'admin'),
(2, 'nowak', 'nowak');

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `tpackage`
--
ALTER TABLE `tpackage`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `tuser`
--
ALTER TABLE `tuser`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `tuseradmin`
--
ALTER TABLE `tuseradmin`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT dla zrzuconych tabel
--

--
-- AUTO_INCREMENT dla tabeli `tpackage`
--
ALTER TABLE `tpackage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT dla tabeli `tuser`
--
ALTER TABLE `tuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `tuseradmin`
--
ALTER TABLE `tuseradmin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
