-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema compliancecompany
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema compliancecompany
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `compliancecompany` ;
USE `compliancecompany` ;

-- -----------------------------------------------------
-- Table `compliancecompany`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compliancecompany`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `avaiable` VARCHAR(1) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compliancecompany`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compliancecompany`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compliancecompany`.`product_category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compliancecompany`.`product_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product_id` INT NOT NULL,
  `category_id` INT NOT NULL,
  INDEX `fk_table1_product_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_table1_category1_idx` (`category_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_table1_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `compliancecompany`.`product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `compliancecompany`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
