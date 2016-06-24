SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `minska` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `minska` ;

-- -----------------------------------------------------
-- Table `minska`.`Estado`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Estado` ;

CREATE TABLE IF NOT EXISTS `minska`.`Estado` (
  `sigla` CHAR(2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`sigla`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Cidade`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Cidade` ;

CREATE TABLE IF NOT EXISTS `minska`.`Cidade` (
  `idCidade` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `Estado_sigla` CHAR(2) NOT NULL,
  PRIMARY KEY (`idCidade`),
  INDEX `fk_Cidade_Estado1_idx` (`Estado_sigla` ASC),
  CONSTRAINT `fk_Cidade_Estado1`
    FOREIGN KEY (`Estado_sigla`)
    REFERENCES `minska`.`Estado` (`sigla`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Pessoa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Pessoa` ;

CREATE TABLE IF NOT EXISTS `minska`.`Pessoa` (
  `idPessoa` INT NOT NULL AUTO_INCREMENT,
  `idCidade` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `logradouro` VARCHAR(45) NULL,
  `numero` INT NULL,
  `bairro` VARCHAR(45) NULL,
  `cep` CHAR(8) NULL,
  `complemento` VARCHAR(45) NULL,
  `dataCadastro` DATETIME NOT NULL,
  PRIMARY KEY (`idPessoa`),
  INDEX `fk_Pessoa_Cidade1_idx` (`idCidade` ASC),
  CONSTRAINT `fk_Pessoa_Cidade1`
    FOREIGN KEY (`idCidade`)
    REFERENCES `minska`.`Cidade` (`idCidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`PessoaFisica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`PessoaFisica` ;

CREATE TABLE IF NOT EXISTS `minska`.`PessoaFisica` (
  `idPessoa` INT NOT NULL,
  `dataNascimento` DATE NOT NULL,
  `cpf` CHAR(14) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_Terceiro_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `minska`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Telefone`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Telefone` ;

CREATE TABLE IF NOT EXISTS `minska`.`Telefone` (
  `ddi` CHAR(3) NOT NULL DEFAULT '+55',
  `ddd` CHAR(2) NOT NULL,
  `numero` VARCHAR(9) NOT NULL,
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`ddi`, `ddd`, `numero`),
  INDEX `fk_Telefone_Pessoa1_idx` (`idPessoa` ASC),
  CONSTRAINT `fk_Telefone_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `minska`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Vendedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Vendedor` ;

CREATE TABLE IF NOT EXISTS `minska`.`Vendedor` (
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_Vendedor_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `minska`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Cliente` ;

CREATE TABLE IF NOT EXISTS `minska`.`Cliente` (
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_Cliente_Pessoa1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `minska`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Pedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Pedido` ;

CREATE TABLE IF NOT EXISTS `minska`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `idVendedor` INT NOT NULL,
  `idCliente` INT NOT NULL,
  `dataPedido` DATETIME NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_Pedido_Vendedor1_idx` (`idVendedor` ASC),
  INDEX `fk_Pedido_Cliente1_idx` (`idCliente` ASC),
  CONSTRAINT `fk_Pedido_Vendedor1`
    FOREIGN KEY (`idVendedor`)
    REFERENCES `minska`.`Vendedor` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `minska`.`Cliente` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`Fornecedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`Fornecedor` ;

CREATE TABLE IF NOT EXISTS `minska`.`Fornecedor` (
  `idPessoa` INT NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_Fornecedor_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `minska`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`ModeloPlaca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`ModeloPlaca` ;

CREATE TABLE IF NOT EXISTS `minska`.`ModeloPlaca` (
  `idModeloPlaca` INT NOT NULL AUTO_INCREMENT,
  `valor` DECIMAL(4,2) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `descricao` TEXT NOT NULL,
  `qtdCampos` INT NOT NULL,
  `peso` DECIMAL(4,3) NOT NULL,
  PRIMARY KEY (`idModeloPlaca`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`DetalhePedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`DetalhePedido` ;

CREATE TABLE IF NOT EXISTS `minska`.`DetalhePedido` (
  `idDetalhePedido` INT NOT NULL AUTO_INCREMENT,
  `idPedido` INT NOT NULL,
  `idModeloPlaca` INT NOT NULL,
  `texto` TEXT NOT NULL,
  INDEX `fk_DetalhePedido_Pedido1_idx` (`idPedido` ASC),
  PRIMARY KEY (`idDetalhePedido`),
  INDEX `fk_DetalhePedido_ModeloPlaca1_idx` (`idModeloPlaca` ASC),
  CONSTRAINT `fk_DetalhePedido_Pedido1`
    FOREIGN KEY (`idPedido`)
    REFERENCES `minska`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DetalhePedido_ModeloPlaca1`
    FOREIGN KEY (`idModeloPlaca`)
    REFERENCES `minska`.`ModeloPlaca` (`idModeloPlaca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`FretePedido`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`FretePedido` ;

CREATE TABLE IF NOT EXISTS `minska`.`FretePedido` (
  `idPedido` INT NOT NULL,
  `valor` DECIMAL(4,2) NOT NULL,
  `CEP` CHAR(8) NOT NULL,
  `numero` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `fk_FretePedido_Pedido1_idx` (`idPedido` ASC),
  CONSTRAINT `fk_FretePedido_Pedido1`
    FOREIGN KEY (`idPedido`)
    REFERENCES `minska`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `minska`.`PessoaJuridica`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `minska`.`PessoaJuridica` ;

CREATE TABLE IF NOT EXISTS `minska`.`PessoaJuridica` (
  `idPessoa` INT NOT NULL,
  `cnpj` CHAR(14) NOT NULL,
  `razaoSocial` VARCHAR(45) NOT NULL,
  `inscricaoEstadual` CHAR(9) NOT NULL,
  PRIMARY KEY (`idPessoa`),
  CONSTRAINT `fk_PessoaJuridica_1`
    FOREIGN KEY (`idPessoa`)
    REFERENCES `minska`.`Pessoa` (`idPessoa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `minska`.`Estado`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`Estado` (`sigla`, `nome`) VALUES ('SP', 'São Paulo');

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`Cidade`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`Cidade` (`idCidade`, `nome`, `Estado_sigla`) VALUES (1, 'Caraguatatuba', 'SP');

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`Pessoa`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`Pessoa` (`idPessoa`, `idCidade`, `nome`, `email`, `logradouro`, `numero`, `bairro`, `cep`, `complemento`, `dataCadastro`) VALUES (NULL, 1, 'Daniele Santos', 'daniele@gmail.com', NULL, NULL, NULL, NULL, NULL, '2016-06-26');
INSERT INTO `minska`.`Pessoa` (`idPessoa`, `idCidade`, `nome`, `email`, `logradouro`, `numero`, `bairro`, `cep`, `complemento`, `dataCadastro`) VALUES (NULL, 1, 'Hugo Cuba', 'hscuba@gmail.com', NULL, NULL, NULL, NULL, NULL, '2016-06-26');

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`PessoaFisica`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`PessoaFisica` (`idPessoa`, `dataNascimento`, `cpf`) VALUES (2, '1988-03-31', '36924418864');
INSERT INTO `minska`.`PessoaFisica` (`idPessoa`, `dataNascimento`, `cpf`) VALUES (1, '1990-02-01', '29864512896');

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`Telefone`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`Telefone` (`ddd`, `numero`, `idPessoa`) VALUES ('12', '981636528', 2);
INSERT INTO `minska`.`Telefone` (`ddd`, `numero`, `idPessoa`) VALUES ('12', '988765489', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`Vendedor`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`Vendedor` (`idPessoa`) VALUES (1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`Cliente`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`Cliente` (`idPessoa`) VALUES (2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `minska`.`ModeloPlaca`
-- -----------------------------------------------------
START TRANSACTION;
USE `minska`;
INSERT INTO `minska`.`ModeloPlaca` (`idModeloPlaca`, `valor`, `nome`, `descricao`, `qtdCampos`, `peso`) VALUES (NULL, 10, 'Ossinho', 'Placa com formato de ossinho', 3, 0.100);
INSERT INTO `minska`.`ModeloPlaca` (`idModeloPlaca`, `valor`, `nome`, `descricao`, `qtdCampos`, `peso`) VALUES (NULL, 15, 'Coração', 'Placa com formato de coração', 2, 0.200);

COMMIT;


