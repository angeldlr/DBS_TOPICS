DROP DATABASE DBLibreria;
CREATE DATABASE DBLibreria;
USE DBLibreria;
CREATE TABLE editorial(
    editorialNom VARCHAR(50) PRIMARY KEY,
    direccion VARCHAR(100) NOT NULL,
    telefono VARCHAR(50) NOT NULL
);
CREATE TABLE libro(
	idLibro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    editorialNom VARCHAR(100) NOT NULL,
    FOREIGN KEY fkEditorial(editorialNom)
    REFERENCES editorial(editorialNom) ON UPDATE CASCADE ON DELETE NO ACTION
);
CREATE TABLE autoresLibro(
	idLibro INT,
    nombreAutor VARCHAR(60) NOT NULL,
    PRIMARY KEY(idLibro,nombreAutor)
);
CREATE TABLE sucursalBiblioteca(
	idSucursal INT PRIMARY KEY AUTO_INCREMENT,
    nombreSucursal VARCHAR(70) NOT NULL,
    direccion VARCHAR(200) NOT NULL
);
CREATE TABLE copiasLibro(
	idLibro INT NOT NULL,
    idSucursal INT NOT NULL,
    numeroCopias INT NOT NULL,
    PRIMARY KEY(idLibro,idSucursal),
    FOREIGN KEY fkLibro(idLibro) REFERENCES libro(idLibro) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY fkSucursal(idSucursal) REFERENCES sucursalBiblioteca(idSucursal) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE lector(
	numTarjeta INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(60) NOT NULL,
    direccion VARCHAR(200) NOT NULL,
    telefono VARCHAR(50) NOT NULL
);

CREATE TABLE prestamo(
	idLibro INT NOT NULL,
    idSucursal INT NOT NULL,
    numTarjeta INT NOT NULL,
    fechaSalida DATE NOT NULL,
    fechaDevolucion DATE NOT NULL,
    PRIMARY KEY (idLibro,idSucursal,numTarjeta),
    FOREIGN KEY fkLibroPrestamo(idLibro) REFERENCES libro(idLibro) ON UPDATE CASCADE ON DELETE NO ACTION,
    FOREIGN KEY fkSucursalPrestamo(idSucursal) REFERENCES sucursalBiblioteca(idSucursal) ON UPDATE CASCADE ON DELETE NO ACTION,
	FOREIGN KEY fkLectorPrestamo(numTarjeta) REFERENCES lector(numTarjeta) ON UPDATE CASCADE ON DELETE NO ACTION
);
/*Querys inserción editoriales*/
INSERT INTO `DBLibreria`.`editorial`
(`editorialNom`,
`direccion`,
`telefono`)
VALUES
('Acantilado','Blas Pascal 44, Colonia: Polanco','12-33-25-46-30');

INSERT INTO `DBLibreria`.`editorial`
(`editorialNom`,
`direccion`,
`telefono`)
VALUES
('Alamdia','Nativitas 44, Colonia: Laguna del volcan','49-34-56-53-11');

INSERT INTO `DBLibreria`.`editorial`
(`editorialNom`,
`direccion`,
`telefono`)
VALUES
('Alfaguara','Concepcio Ortega 18, Colonia: Pensador Mexicao','42-15-17-02');

INSERT INTO `DBLibreria`.`editorial`
(`editorialNom`,
`direccion`,
`telefono`)
VALUES
('Nevsky','Vince Cuackford 125, Colonia: Lancaster','10-03-11-11-21');
/*Querys inserción de Libros*/
INSERT INTO `DBLibreria`.`libro`
(`idLibro`,
`titulo`,
`editorialNom`)
VALUES
(null,
'El fin del mundo y un despiadado país de las maravillas',
'Alamdia');
INSERT INTO `DBLibreria`.`libro`
(`idLibro`,
`titulo`,
`editorialNom`)
VALUES
(null,
'La fortaleza dígital',
'Acantilado');
INSERT INTO `DBLibreria`.`libro`
(`idLibro`,
`titulo`,
`editorialNom`)
VALUES
(null,
'El perfume',
'Nevsky');
/*Querys inserción autores*/
INSERT INTO `DBLibreria`.`autoresLibro`
(`idLibro`,
`nombreAutor`)
VALUES
(1,
'Haruki Murakami');
INSERT INTO `DBLibreria`.`autoresLibro`
(`idLibro`,
`nombreAutor`)
VALUES
(2,
'Dan Brown');
INSERT INTO `DBLibreria`.`autoresLibro`
(`idLibro`,
`nombreAutor`)
VALUES
(3,
'Patrick Suskind');
/*Insercion de Lectores*/
INSERT INTO `DBLibreria`.`lector`
(`numTarjeta`,
`nombre`,
`direccion`,
`telefono`)
VALUES
(null,
'Angel De La Rosa',
'Calle Wallaby,42,Sydney',
'55-33-99-44-22');

INSERT INTO `DBLibreria`.`lector`
(`numTarjeta`,
`nombre`,
`direccion`,
`telefono`)
VALUES
(null,
'Jackson Carter Gutierritos',
'Soldedad 200,33,Ecatepec Edo de México',
'30-24-36-77-11');

INSERT INTO `DBLibreria`.`lector`
(`numTarjeta`,
`nombre`,
`direccion`,
`telefono`)
VALUES
(null,
'Mariana Gonzáles',
'Matamoros,32,Morelia Mich',
'2-45-27-08');
/*Query sucursales*/
INSERT INTO `DBLibreria`.`sucursalBiblioteca`
(`idSucursal`,
`nombreSucursal`,
`direccion`)
VALUES
(null,
'Apodaca',
'Apodaca 34, Buenavista, Ciudad de México, CDMX');

INSERT INTO `DBLibreria`.`sucursalBiblioteca`
(`idSucursal`,
`nombreSucursal`,
`direccion`)
VALUES
(null,
'Baileys',
'Mariano Escobedo 34, Ciudad de México, CDMX');

INSERT INTO `DBLibreria`.`sucursalBiblioteca`
(`idSucursal`,
`nombreSucursal`,
`direccion`)
VALUES
(null,
'Zacatenco ESCOM',
'Av. Juan de Dios Bátiz 444, Nueva Industrial Vallejo, Ciudad de México, CDMX');

/*Query inserción copias libro */
INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(1,
1,
2);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(1,
2,
4);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(1,
3,
4);


INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(2,
1,
10);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(2,
2,
8);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(2,
3,
9);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(3,
1,
9);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(3,
2,
7);

INSERT INTO `DBLibreria`.`copiasLibro`
(`idLibro`,
`idSucursal`,
`numeroCopias`)
VALUES
(3,
3,
2);
/*Vistas del que pueden funcionar para el sistema*/
CREATE OR REPLACE VIEW librosDisponiblesVista AS
	SELECT a.idLibro,a.titulo,d.nombreAutor,b.idSucursal,c.nombreSucursal,b.numeroCopias
	FROM libro a
	INNER JOIN copiasLibro b ON a.idLibro = b.idLibro
	INNER JOIN sucursalBiblioteca c ON b.idSucursal = c.idSucursal
    INNER JOIN autoresLibro d ON d.idLibro = a.idLibro;
    
/*Trigger*/
/*Procedures*/
DELIMITER //
CREATE PROCEDURE nuevoPrestamo(IN libro INT,IN autor VARCHAR(60),IN sucursal INT,IN numLector INT)
BEGIN
	DECLARE librosDisponibles INT;
    
    DECLARE exit handler for sqlexception
	  BEGIN
		GET DIAGNOSTICS CONDITION 1
        @p1=RETURNED_SQLSTATE,@p2=MESSAGE_TEXT;
        select @p1,@p2;
	  ROLLBACK;
	END;

	DECLARE exit handler for sqlwarning
	 BEGIN
		GET DIAGNOSTICS CONDITION 1
        @p1=RETURNED_SQLSTATE,@p2=MESSAGE_TEXT;
        select @p1,@p2;
	 ROLLBACK;
	END;
    START TRANSACTION;
    INSERT INTO `DBLibreria`.`prestamo` (`idLibro`,`idSucursal`,`numTarjeta`,`fechaSalida`,`fechaDevolucion`)
    VALUES(libro,sucursal,numLector,curdate(),adddate(curdate(),INTERVAL 21 DAY));

    /*Obtenemos el número de libros disponibles*/
    /*SELECT numeroCopias INTO librosDisponibles 
    FROM librosDisponiblesVista
	WHERE idLibro=libro and idSucursal=sucursal and nombreAutor=autor;
    /*Verificamos la disponibilidad*/
    /*IF librosDisponibles=0 THEN 
		INSERT INTO `DBLibreria`.`sucursalBiblioteca`
		(`idSucursal`,
		`nombreSucursal`,
		`direccion`)
		VALUES
		();
    END IF;*/
    COMMIT;
    #SELECT librosDisponibles;
END //
DELIMITER ;
/*Para invocar al procedure*/
#call nuevoPrestamo(2,'Dan Brown',2,1);
#call nuevoPrestamo(3,'Patrick Suskind',2,1);