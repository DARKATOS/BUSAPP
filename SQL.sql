CREATE TABLE `bus` (
  `idbus` int(11) NOT NULL AUTO_INCREMENT,
  `placa` varchar(45) DEFAULT NULL,
  `nombre_conductor` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `valor_pasaje` int(11) DEFAULT NULL,
  PRIMARY KEY (`idbus`)
);
DELIMITER ;;
CREATE PROCEDURE `mostrar_buses`()
BEGIN
	select * from bus;
END ;;
DELIMITER ;;

DELIMITER ;;
CREATE PROCEDURE `registrar_bus`(IN  placa VARCHAR(45), IN  nombre_conductor VARCHAR(45), IN tipo VARCHAR(45), IN  valor_pasaje int(45))
BEGIN
    INSERT INTO bus(placa, nombre_conductor, tipo, valor_pasaje) VALUES(placa, nombre_conductor, tipo, valor_pasaje); 
END ;;
DELIMITER ;