-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-12-2022 a las 14:41:46
-- Versión del servidor: 10.4.25-MariaDB
-- Versión de PHP: 7.4.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyeclinica`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `consultorio` varchar(100) NOT NULL,
  `doctor` varchar(100) NOT NULL,
  `analisis` varchar(1000) NOT NULL,
  `servicio` varchar(10) NOT NULL,
  `fecha` varchar(10) NOT NULL,
  `hora` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`id`, `nombre`, `consultorio`, `doctor`, `analisis`, `servicio`, `fecha`, `hora`) VALUES
(5, 'Juan', 'A', 'Fleofe Flores', 'Sangre', 'CONSULTAS ', '2022-12-3', '19:30'),
(6, 'Dimas', 'B', 'Fleofe Flores', 'Sangre', 'CONSULTAS ', '2022-12-9', '19:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apaterno` varchar(100) NOT NULL,
  `amaterno` varchar(100) NOT NULL,
  `edad` int(100) NOT NULL,
  `sexo` varchar(15) NOT NULL,
  `lugar` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `dni` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id`, `nombre`, `apaterno`, `amaterno`, `edad`, `sexo`, `lugar`, `direccion`, `telefono`, `dni`) VALUES
(2, 'Juan', 'Diaz', 'Torres', 25, 'Hombre', 'miraflores', 'av brazil 159', '987456321', 966332563),
(3, 'Ibeth', 'Yeraldine', 'Torres', 20, 'Mujer', 'Lima', 'Lima', '99999', 96633212),
(4, 'Fabrizio', 'Calderón', 'Sánchez', 20, 'Hombre', 'Lima', 'Lima', '9632163', 966332),
(5, 'Dimas', 'Coñez', 'Flores', 20, 'Hombre', 'Lima', 'Lima', '963213693', 96633285),
(7, 'Anthony', 'Luis', 'Perez', 23, 'Hombre', 'Daniel', 'Daniel', '963213693', 716181222),
(8, 'Dimas', 'Daniel', 'Flores', 20, 'Hombre', 'Dimas', 'Dimas', '9632153', 485585),
(9, 'Munares', 'Torres', 'Romero', 20, 'Hombre', 'Lima', 'Lima', '9632123', 414141),
(10, 'admin', 'admin', 'admin', 20, 'Hombre', 'admin', 'admin', '9293939', 45145151),
(11, 'Favian', 'Favian', 'Favian', 20, 'Hombre', 'Favian', 'Favian', '63969696', 110101),
(12, 'Dimas', 'Coñez', 'Flores', 20, 'Hombre', 'Lima', 'Lima', '9632123', 71618122),
(13, 'Daniel', 'Flores', 'Flores', 9, 'Hombre', 'Lima', 'Lima', '9632123', 9632123);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `receta`
--

CREATE TABLE `receta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `nreceta` int(100) NOT NULL,
  `ncitas` int(100) NOT NULL,
  `recetario` varchar(1000) NOT NULL,
  `alergias` varchar(100) NOT NULL,
  `tiposangre` varchar(10) NOT NULL,
  `presion` varchar(100) NOT NULL,
  `estatura` varchar(10) NOT NULL,
  `peso` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `receta`
--

INSERT INTO `receta` (`id`, `nombre`, `nreceta`, `ncitas`, `recetario`, `alergias`, `tiposangre`, `presion`, `estatura`, `peso`) VALUES
(1, 'Dimas', 10, 100, 'Paracetamol', 'Ibupufeno', 'A', '120', '1.72', '86');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `rol` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `correo`, `pass`, `rol`) VALUES
(1, 'admin', 'admin', 'admin', 'Asistente'),
(2, 'anthony', 'anthony', 'admin', 'Asistente'),
(3, 'dimas', 'dimas', 'dimas', 'Asistente'),
(8, 'dimass', 'dimas@fmial.com', 'dimas', 'Asistente'),
(9, 'ibeth', 'ibeth', 'ibeth', 'Doctor'),
(10, 'CuentaAdmin', 'CuentaAdmin', 'CuentaAdmin', 'Asistente');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `receta`
--
ALTER TABLE `receta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `receta`
--
ALTER TABLE `receta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
