-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-03-2026
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `futbol`
--
CREATE DATABASE IF NOT EXISTS `futbol` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `futbol`;

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `equipos`
--
CREATE TABLE `equipos` (
  `idEquipo` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `ciudad` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Inserciones iniciales en `equipos`
INSERT INTO `equipos` (`idEquipo`, `nombre`, `ciudad`) VALUES
(1, 'Real Madrid', 'Madrid'),
(2, 'FC Barcelona', 'Barcelona'),
(3, 'Atletico Madrid', 'Madrid');

-- --------------------------------------------------------
--
-- Estructura de tabla para la tabla `futbolistas`
--
CREATE TABLE `futbolistas` (
  `dni` varchar(8) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido` varchar(40) NOT NULL,
  `salario` int(11) NOT NULL,
  `idEquipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Inserciones iniciales en `futbolistas`
INSERT INTO `futbolistas` (`dni`, `nombre`, `apellido`, `salario`, `idEquipo`) VALUES
('12345678', 'Sergio', 'Ramos', 50000, 1),
('87654321', 'Lionel', 'Messi', 60000, 2),
('11223344', 'Antoine', 'Griezmann', 45000, 3);

--
-- Índices para tablas volcadas
--

-- Índices de la tabla `equipos`
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`idEquipo`);

-- Índices de la tabla `futbolistas`
ALTER TABLE `futbolistas`
  ADD PRIMARY KEY (`dni`);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;