DROP DATABASE IF EXISTS DBLibreria; 
CREATE DATABASE DBLibreria;
#CREATE USER 'dbstp1'@'localhost' identified by 'topics';
#GRANT ALL ON DBLibreria.* TO 'dbstp1'@'localhost';
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
('Acantilado','Blas Pascal 44, Colonia: Polanco','1233254630'),
('Ariel',' CALLE AGUSTIN LARA NO. 69-B COL. EX-NORMAL TUXTEPEC ','8652983143'),
('Alianza',' AV. INDEPENDENCIA NO. 241 COL.CENTRO','6949512401'),
('Síntesis','CARRETERA A LOMA ALTA S/N Agraria','7928443425'),
('Santillana','CALLE ZARAGOZA NO. 1010 Agua Blanca Industrial','8110465074'),
('Cívitas','CALLE MATAMOROS NO. 310 Zoquipan','8298929289'),
('McGraw-Hill','BLVD. BENITO JUAREZ NO. 1466-A Zona Industrial','6913368103'),
('Siglo XXI','CALLE MATAMOROS NO.280 Tonala','7833744080'),
('Springer','Plaza Conceptuàssim casquessin desbrocara, 102 13ºG  Benito Juárez','6803878495'),
('Cátedra','Callejón Mocaràs, 250B 13ºG Belisario Domínguez ','8619828681'),
('Aranzadi',' Cañada , 243A Barrio Analco','7686246615'),
('CSIC','Pasaje Crispàrem enforinyo, 291 Barrio Alto ','670881557'),
('Pirámide','Urbanización Traspunxésseu, 65 16ºG Barrio Nuevo Santa Cruz','8355297673'),
('Crítica','Ronda Mis esblamant exhibeixi, 25 Alamedas de Tesistán','6823132579'),
('Trotta','Av. Cedro, 12B 10ºB Alemeda','667469290'),
('Paidós','Balcones del Cuatro Balcones de Oblatos','7684779204'),
('Bosch','Cuesta Rastrejos, 153B 9ºH Zona Oblatos','6726019483'),
('Marcial Pons','Glorieta Enrajolassis Cruz del Sur','7329738576'),
('Tecnos',' AV. INDEPENDENCIA NO. 779 LOMAS DEL PEDREGAL ','8767954727'),
('Alamdia','Nativitas 44, Colonia: Laguna del volcan','4934565311'),
('Alfaguara','Concepcio Ortega 18, Colonia: Pensador Mexicao','42151702'),
('Nevsky','Vince Cuackford 125, Colonia: Lancaster','1003111121');
/*Querys inserción de Libros*/
INSERT INTO `DBLibreria`.`libro`
(`idLibro`,
`titulo`,
`editorialNom`)
VALUES
(null,'El fin del mundo y un despiadado país de las maravillas','Alamdia'),
(null,'La fortaleza dígital','Acantilado'),
(null,'El perfume','Nevsky'),
(null,'Poema de Gilgamesh','Ariel'),
(null,'Libro de Job (de la Biblia) ','Ariel'),
(null,'Las mil y una noches','Ariel'),
(null,'Saga de Njál ','Ariel'),
(null,'Todo se desmorona','Alianza'),
(null,'Cuentos infantiles','Alianza'),
(null,'Divina Comedia','Alianza'),
(null,'Orgullo y prejuicio','Alianza'),
(null,'Papá Goriot ','Síntesis'),
(null,'Decamerón ','Síntesis'),
(null,'Ficciones ','Síntesis'),
(null,'Cumbres Borrascosas','Síntesis'),
(null,'El extranjero','Síntesis'),
(null,'Poemas ','Síntesis'),
(null,'Viaje al fin de la noche','Síntesis'),
(null,'Don Quijote de la Mancha','Santillana'),
(null,'Los cuentos de Canterbury','Santillana'),
(null,'Relatos cortos ','Santillana'),
(null,'Nostromo ','Santillana'),
(null,'Grandes Esperanzas ','Santillana'),
(null,'Jacques el fatalista','Santillana'),
(null,'Crimen y castigo','Santillana'),
(null,'El idiota ','Cívitas'),
(null,'Los endemoniados','Cívitas'),
(null,'Los hermanos Karamazov','McGraw-Hill'),
(null,'Middlemarch','McGraw-Hill'),
(null,'El hombre invisible','McGraw-Hill'),
(null,'Medea ','McGraw-Hill'),
(null,'¡Absalom, Absalom!','McGraw-Hill'),
(null,'El ruido y la furia','McGraw-Hill'),
(null,'Madame Bovary','Siglo XXI'),
(null,'La educación sentimental','Siglo XXI'),
(null,'Romancero gitano','Springer'),
(null,'Cien años de soledad','Springer'),
(null,'El amor en los tiempos del cólera','Springer'),
(null,'Fausto','Catedra'),
(null,'Almas muertas','Catedra'),
(null,'El tambor de hojalata ','Aranzadi'),
(null,'Hambre ','CSIC'),
(null,'El viejo y el mar','CSIC'),
(null,'Ilíada ','CSIC'),
(null,'Odisea ','Pirámide'),
(null,'Casa de muñecas','Pirámide'),
(null,'Ulises ','Crítica'),
(null,'Relatos cortos ','Crítica'),
(null,'El proceso ','Trotta'),
(null,'El castillo ','Trotta'),
(null,'Shakuntala','Paidós'),
(null,'El sonido de la montaña ','Bosch'),
(null,'Zorba, el griego ','Marcial Pons'),
(null,'El cuaderno dorado ','Tecnos');
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
(null,'Angel De La Rosa','Calle Wallaby,42,Sydney','55-33-99-44-22'),
(null,'Jackson Carter Gutierritos','Soldedad 200,33,Ecatepec Edo de México','30-24-36-77-11'),
(null,'Luella Givens','Emerald Dale','6152800936'),
(null,'Carmelo Laliberte','Emerald Dale','7616327546'),
(null,'Vinay Ornelas','Hidden Limits','8248125630'),
(null,'Ultima Retzlaff','Hidden Limits','7473338289'),
(null,'Hedva Feltner','Crystal Arbor','7787684508'),
(null,' Aubin Guinn','Crystal Arbor','8670082428'),
(null,'Snehal Canales','Umber Corner','8724313010'),
(null,'Telo Bair','Umber Corner','7811966208'),
(null,'Melburn Juergens','Dewy Swale','7279377925'),
(null,' Haralda Sipes','Dewy Swale','8416462528'),
(null,'Chloris Roney','Red Route','8382708820'),
(null,'Jarka McCaskill','Red Route','8249161633'),
(null,'Ackerley Ives','Quiet Woods','7123425508'),
(null,'Erhard Sennett','Bright Trail','7823789481'),
(null,'Gustavo Guinn','Bright Trail','7755578661'),
(null,'Garwood Heinrich','Bright Trail','7873061274'),
(null,'Clifford Dodson','Sleepy Way','8819802859'),
(null,' Brody Veltri','Sleepy Way','6949729505'),
(null,'Nayoko Moralez','Sleepy Way','6708675028'),
(null,'Shaw Sandy',' Round Chase','7689133561'),
(null,'Javed Keyser',' Round Chase','8727887459'),
(null,'Boa Wick','Dusty View Boulevard','6747869977'),
(null,'Talbot Moir','Dusty View Boulevard','6648048645'),
(null,' Ajay McQuade','Velvet Via','8587179278'),
(null,'Mohan Fullmer','Velvet Via','7842848546'),
(null,'Nerhim Arendt',' Fallen Lake Mountain','6486414302'),
(null,'Delyth Eyler',' Fallen Lake Mountain','7995799970'),
(null,'Corina Tiemann',' Fallen Lake Mountain','8821564442'),
(null,'Arval Wightman',' Old Hill','8126678397'),
(null,' Ernest Gann',' Old Hill','8535850332'),
(null,'Iden Pine','Colonial Lagoon Quay','7611325203'),
(null,'Salihah Berryman','Colonial Lagoon Quay','8173287259'),
(null,'Galloway Arnette','Colonial Lagoon Quay','7531119062'),
(null,'Abhilasha Sosnowski',' Clear Nectar Passage','6569556524'),
(null,' Zeus Farrow',' Misty Branch Trace','8260687195'),
(null,'Kade Moralez','Bright Trail','6955347037'),
(null,'Mariana Gonzáles','Matamoros,32,Morelia Mich','2-45-27-08');
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
	SELECT a.idLibro,a.titulo,d.nombreAutor,a.editorialNom,b.idSucursal,c.nombreSucursal,b.numeroCopias
	FROM libro a
	INNER JOIN copiasLibro b ON a.idLibro = b.idLibro
	INNER JOIN sucursalBiblioteca c ON b.idSucursal = c.idSucursal
    INNER JOIN autoresLibro d ON d.idLibro = a.idLibro;

CREATE OR REPLACE VIEW librosEnPrestamoVista AS
	SELECT a.numTarjeta,e.nombre,a.idLibro,b.titulo,c.nombreAutor,a.idSucursal,d.nombreSucursal
	FROM prestamo a
	INNER JOIN libro b ON a.idLibro = b.idLibro
	INNER JOIN autoresLibro c ON a.idLibro = c.idLibro
	INNER JOIN sucursalBiblioteca d ON a.idSucursal = d.idSucursal
	INNER JOIN lector e ON a.numTarjeta = e.numTarjeta
	INNER JOIN autoresLibro f ON a.idLibro = f.idLibro;
/*Trigger*/
/*Procedures*/
DELIMITER //
CREATE PROCEDURE nuevoPrestamo(IN libro INT,IN autor VARCHAR(60),IN sucursal INT,IN numLector INT,OUT estatusProc VARCHAR(70))
BEGIN
	DECLARE librosDisponibles,librosEnPrestamo INT;
    
    DECLARE exit handler for sqlexception
	  BEGIN
		GET DIAGNOSTICS CONDITION 1
        estatusProc = MESSAGE_TEXT;
        SELECT estatusProc;
	  ROLLBACK;
	END;

	DECLARE exit handler for sqlwarning
	 BEGIN
		GET DIAGNOSTICS CONDITION 1
        estatusProc = MESSAGE_TEXT;
        SELECT estatusProc;
	 ROLLBACK;
	END;
    START TRANSACTION;
		/*Obtenemos el número de libros disponibles*/
		SELECT numeroCopias INTO librosDisponibles 
		FROM librosDisponiblesVista
		WHERE idLibro=libro and idSucursal=sucursal and nombreAutor=autor;
        SELECT librosDisponibles;
        /*Obtenemos el número de copias que tiene del libro*/
        SELECT COUNT(b.idLibro) into librosEnPrestamo
		FROM lector a
		LEFT JOIN librosEnPrestamoVista b ON a.numTarjeta = b.numTarjeta
        WHERE a.numTarjeta = numLector
		GROUP BY a.numTarjeta;
		/*Verificamos la disponibilidad*/
		IF librosDisponibles>0 AND librosEnPrestamo<4 THEN 
			INSERT INTO `DBLibreria`.`prestamo` (`idLibro`,`idSucursal`,`numTarjeta`,`fechaSalida`,`fechaDevolucion`)
			VALUES(libro,sucursal,numLector,curdate(),adddate(curdate(),INTERVAL 21 DAY));
            SET estatusProc='Se ingreso correctamente el prestamo';
		ELSEIF librosDisponibles=0 THEN
            SET estatusProc='No hay copias suficientes para realizar el prestamo';
		ELSEIF librosEnPrestamo >=4 THEN
			SET estatusProc='No puedes hacer mas prestamos';
		END IF;
    COMMIT;
    #SELECT librosDisponibles;
END //
DELIMITER ;
#Triggers
DELIMITER $$
CREATE TRIGGER actualizaDisp 
	AFTER INSERT ON prestamo FOR EACH ROW
BEGIN
	UPDATE copiasLibro set numeroCopias=numeroCopias-1 WHERE idLibro=NEW.idLibro AND idSucursal=NEW.idSucursal; 
END$$
DELIMITER ;
/**/
DELIMITER $$
CREATE TRIGGER devolucion
	AFTER DELETE ON prestamo FOR EACH ROW
BEGIN
	UPDATE copiasLibro set numeroCopias=numeroCopias+1 WHERE idLibro=OLD.idLibro AND idSucursal=OLD.idSucursal; 
END$$
DELIMITER ;