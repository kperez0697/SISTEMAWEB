-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 14-07-2022 a las 02:29:29
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ventasI`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `CategoriaProducto`
--

CREATE TABLE `CategoriaProducto` (
  `IdCategoria` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `CategoriaProducto`
--

INSERT INTO `CategoriaProducto` (`IdCategoria`, `Nombre`) VALUES
(1, 'Medicina'),
(2, 'HigieneMasculina'),
(5, 'Infantil');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `Dni` varchar(8) DEFAULT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Direccion` varchar(244) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`IdCliente`, `Dni`, `Nombres`, `Direccion`) VALUES
(17, '2', 'Juan Guerrero Solis', 'Los Alamos'),
(18, '1', 'Maria Rosas Villanueva', 'Los Laureles 234'),
(19, '3', 'Andres de Santa Cruz', 'Av. La Frontera 347'),
(20, '4', 'Andres Mendoz', 'Chosica, Lurigancho'),
(22, '56473', 'Will', '98765321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `IdCompras` int(10) NOT NULL,
  `IdProveedor` int(10) NOT NULL,
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `tipoDocumento` varchar(50) NOT NULL,
  `subtotal` float NOT NULL,
  `igv` float NOT NULL,
  `total` float NOT NULL,
  `fecha` date NOT NULL,
  `NroDocumento` varchar(244) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_compras`
--

CREATE TABLE `detalle_compras` (
  `IdDetalleCompras` int(10) NOT NULL,
  `IdCompra` int(10) NOT NULL,
  `IdProducto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_ventas`
--

CREATE TABLE `detalle_ventas` (
  `IdDetalleVentas` int(11) UNSIGNED NOT NULL,
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Cantidad` int(11) UNSIGNED DEFAULT NULL,
  `PrecioVenta` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_ventas`
--

INSERT INTO `detalle_ventas` (`IdDetalleVentas`, `IdVentas`, `IdProducto`, `Cantidad`, `PrecioVenta`) VALUES
(1, 1, 2, 5, 11),
(2, 2, 3, 2, 15),
(3, 3, 2, 5, 11),
(4, 4, 1, 5, 2.5),
(5, 5, 3, 1, 15),
(6, 6, 3, 2, 15),
(7, 7, 1, 3, 2.5),
(8, 8, 1, 2, 2.5),
(9, 9, 1, 1, 2.5),
(10, 10, 2, 1, 11),
(11, 12, 2, 1, 11),
(12, 13, 2, 1, 11),
(13, 14, 2, 2, 11),
(14, 14, 3, 1, 15),
(15, 15, 2, 1, 11),
(16, 16, 2, 1, 11),
(17, 17, 2, 4, 11),
(18, 18, 4, 3, 4.5),
(19, 19, 1, 3, 2.5),
(20, 19, 3, 2, 15),
(21, 20, 1, 3, 2.5),
(22, 20, 2, 1, 11),
(23, 20, 4, 2, 4.5),
(24, 21, 2, 1, 11),
(25, 21, 4, 3, 4.5),
(26, 22, 1, 1, 2.5),
(27, 22, 3, 3, 15),
(28, 23, 1, 1, 2.5),
(29, 24, 2, 1, 11),
(30, 25, 2, 1, 11);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `Dni` varchar(8) NOT NULL,
  `Nombres` varchar(255) DEFAULT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Rol` varchar(1) NOT NULL,
  `User` varchar(8) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`IdEmpleado`, `Dni`, `Nombres`, `Telefono`, `Rol`, `User`) VALUES
(1, '123', 'Raul', '988252459', '2', 'emp01'),
(2, '1234', 'Roman Riquelme', '988252459', '1', 'Jo46'),
(3, '12345', 'Palermo Suarez', '453536458', '1', 'Em22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Privilegios`
--

CREATE TABLE `Privilegios` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(255) CHARACTER SET utf8 NOT NULL,
  `url` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Privilegios`
--

INSERT INTO `Privilegios` (`Id`, `Nombre`, `url`) VALUES
(1, 'Home', 'Controlador?menu=Home'),
(2, 'Producto', 'Controlador?menu=MostrarCategoria&accion=Listar'),
(3, 'Empleado', 'Controlador?menu=Empleado&accion=Listar'),
(4, 'Clientes', 'Controlador?menu=Cliente&accion=Listar'),
(5, 'Nueva Venta', 'Controlador?menu=NuevaVenta&accion=default'),
(6, 'Proveedor', 'Controlador?menu=Proveedor&accion=Listar'),
(7, 'Detalle Venta', 'Controlador?menu=DetalleVenta&accion=Listar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Privilegios_Rol`
--

CREATE TABLE `Privilegios_Rol` (
  `IdRol` varchar(1) CHARACTER SET utf8 NOT NULL,
  `IdPrivilegios` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Privilegios_Rol`
--

INSERT INTO `Privilegios_Rol` (`IdRol`, `IdPrivilegios`) VALUES
('1', 1),
('1', 2),
('1', 5),
('2', 1),
('2', 2),
('2', 3),
('2', 4),
('2', 5),
('2', 6),
('1', 4),
('2', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `IdProducto` int(11) UNSIGNED NOT NULL,
  `Nombres` varchar(244) DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Stock` int(11) UNSIGNED DEFAULT NULL,
  `Categoria` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`IdProducto`, `Nombres`, `Precio`, `Stock`, `Categoria`) VALUES
(1, 'Paracetamol', 2.5, 31, 1),
(2, 'Desodorante Old Spicy', 11, 0, 2),
(3, 'Cetirizina', 15, 19, 1),
(4, 'Compota', 4.5, 12, 5),
(5, 'Pantoprazol', 1.5, 15, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `IdProveedor` int(10) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `ruc` varchar(11) NOT NULL,
  `razonSocial` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`IdProveedor`, `telefono`, `direccion`, `ruc`, `razonSocial`) VALUES
(1, '999888777', 'Ate', '12345432112', 'J&J');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Rol`
--

CREATE TABLE `Rol` (
  `Id` varchar(1) CHARACTER SET utf8 NOT NULL,
  `Nombre` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Rol`
--

INSERT INTO `Rol` (`Id`, `Nombre`) VALUES
('1', 'Empleado'),
('2', 'Administrador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `IdVentas` int(11) UNSIGNED NOT NULL,
  `IdCliente` int(11) UNSIGNED NOT NULL,
  `IdEmpleado` int(10) UNSIGNED NOT NULL,
  `NumeroSerie` varchar(244) DEFAULT NULL,
  `FechaVentas` date DEFAULT NULL,
  `Monto` double DEFAULT NULL,
  `Estado` varchar(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`IdVentas`, `IdCliente`, `IdEmpleado`, `NumeroSerie`, `FechaVentas`, `Monto`, `Estado`) VALUES
(1, 18, 1, '00000001', '2022-06-08', 55, '1'),
(2, 18, 1, '00000002', '2022-06-08', 30, '1'),
(3, 18, 2, '00000003', '2022-06-24', 55, '1'),
(4, 18, 1, '00000004', '2022-06-24', 12.5, '1'),
(5, 18, 1, '00000005', '2022-06-24', 15, '1'),
(6, 17, 1, '00000006', '2022-06-27', 30, '1'),
(7, 20, 1, '00000007', '2022-06-27', 7.5, '1'),
(8, 20, 1, '00000008', '2022-06-27', 5, '1'),
(9, 18, 1, '00000009', '2022-06-27', 2.5, '1'),
(10, 18, 1, '00000010', '2022-06-27', 11, '1'),
(11, 17, 1, '00000011', '2022-06-27', 11, '1'),
(12, 18, 1, '00000012', '2022-06-27', 11, '1'),
(13, 18, 1, '00000013', '2022-06-27', 11, '1'),
(14, 18, 1, '00000014', '2022-06-29', 37, '1'),
(15, 18, 1, '00000015', '2022-06-30', 11, '1'),
(16, 18, 1, '00000016', '2022-06-30', 11, '1'),
(17, 18, 1, '00000017', '2022-06-30', 44, '1'),
(18, 17, 1, '00000018', '2022-06-30', 13.5, '1'),
(19, 17, 1, '00000019', '2022-06-30', 37.5, '1'),
(20, 17, 1, '00000020', '2022-06-30', 27.5, '1'),
(21, 17, 1, '00000021', '2022-06-30', 24.5, '1'),
(22, 17, 1, '00000022', '2022-06-30', 47.5, '1'),
(23, 17, 1, '00000023', '2022-07-01', 2.5, '1'),
(24, 18, 1, '00000024', '2022-07-01', 11, '1'),
(25, 18, 1, '00000025', '2022-07-04', 11, '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `CategoriaProducto`
--
ALTER TABLE `CategoriaProducto`
  ADD PRIMARY KEY (`IdCategoria`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`IdCompras`),
  ADD UNIQUE KEY `IdProveedor` (`IdProveedor`),
  ADD KEY `IdEmpleado` (`IdEmpleado`) USING BTREE;

--
-- Indices de la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD PRIMARY KEY (`IdDetalleCompras`),
  ADD UNIQUE KEY `IdCompra` (`IdCompra`),
  ADD UNIQUE KEY `IdProducto` (`IdProducto`) USING BTREE;

--
-- Indices de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD PRIMARY KEY (`IdDetalleVentas`,`IdVentas`,`IdProducto`),
  ADD KEY `Ventas_has_Producto_FKIndex1` (`IdVentas`),
  ADD KEY `Ventas_has_Producto_FKIndex2` (`IdProducto`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`IdEmpleado`) USING BTREE,
  ADD KEY `Rol` (`Rol`);

--
-- Indices de la tabla `Privilegios`
--
ALTER TABLE `Privilegios`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `Privilegios_Rol`
--
ALTER TABLE `Privilegios_Rol`
  ADD KEY `IdRol` (`IdRol`),
  ADD KEY `IdPrivilegios` (`IdPrivilegios`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`IdProducto`),
  ADD KEY `Categoria` (`Categoria`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`IdProveedor`);

--
-- Indices de la tabla `Rol`
--
ALTER TABLE `Rol`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`IdVentas`),
  ADD KEY `Ventas_FKIndex1` (`IdEmpleado`),
  ADD KEY `Ventas_FKIndex2` (`IdCliente`) USING BTREE;

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `CategoriaProducto`
--
ALTER TABLE `CategoriaProducto`
  MODIFY `IdCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `IdCliente` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `IdCompras` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  MODIFY `IdDetalleCompras` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  MODIFY `IdDetalleVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `IdEmpleado` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `Privilegios`
--
ALTER TABLE `Privilegios`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `IdProducto` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `IdProveedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `IdVentas` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedor` (`IdProveedor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_compras`
--
ALTER TABLE `detalle_compras`
  ADD CONSTRAINT `detalle_compras_ibfk_1` FOREIGN KEY (`IdCompra`) REFERENCES `compras` (`IdCompras`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detalle_compras_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_ventas`
--
ALTER TABLE `detalle_ventas`
  ADD CONSTRAINT `detalle_ventas_ibfk_1` FOREIGN KEY (`IdVentas`) REFERENCES `ventas` (`IdVentas`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `detalle_ventas_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`Rol`) REFERENCES `Rol` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `Privilegios_Rol`
--
ALTER TABLE `Privilegios_Rol`
  ADD CONSTRAINT `privilegios_rol_ibfk_1` FOREIGN KEY (`IdRol`) REFERENCES `Rol` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `privilegios_rol_ibfk_2` FOREIGN KEY (`IdPrivilegios`) REFERENCES `Privilegios` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`Categoria`) REFERENCES `CategoriaProducto` (`IdCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`IdCliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`IdEmpleado`) REFERENCES `empleado` (`IdEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
