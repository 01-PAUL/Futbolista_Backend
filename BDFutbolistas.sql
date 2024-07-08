-- Crear la base de datos
CREATE DATABASE DBFutbolistas;

-- Usar la base de datos
USE DBFutbolistas;

-- Crear la tabla de posiciones
CREATE TABLE `posicion` (
  `idPosicion` INT AUTO_INCREMENT PRIMARY KEY,
  `descripcion` varchar(45) NOT NULL
);

-- Crear la tabla de futbolistas
CREATE TABLE `futbolista` (
  `idFutbolista` INT AUTO_INCREMENT PRIMARY KEY,
  `nombres` varchar(45) NOT NULL,
  `apellidos` VARCHAR(100) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `caracteristicas` VARCHAR(100) NOT NULL,
  `idPosicion` INT,
  FOREIGN KEY (`idPosicion`) REFERENCES `posicion` (`idPosicion`)
);

-- Insertar datos de prueba en la tabla posicion
INSERT INTO `posicion` (`descripcion`) VALUES ('Arquero'),('Defensa'),('Mediocampista'),('Delantero');

-- Insertar datos de prueba en la tabla futbolista
INSERT INTO `futbolista` (`nombres`,`apellidos`,`fechaNacimiento`,`caracteristicas`,`idPosicion`) 
VALUES ('Lionel', 'Messi', '1987-06-24', 'Gran habilidad técnica y visión de juego', 4),
('Sergio', 'Ramos', '1986-03-30', 'Defensa fuerte y líder en el campo', 2);
