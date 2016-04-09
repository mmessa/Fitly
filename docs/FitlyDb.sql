SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema FitlyDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `FitlyDB` ;
CREATE SCHEMA IF NOT EXISTS `FitlyDB` DEFAULT CHARACTER SET utf8 ;
USE `FitlyDB` ;

-- -----------------------------------------------------
-- Table `FitlyDB`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`users` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`users` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(60) NOT NULL,
  `email` VARCHAR(45) NULL,
  `password` VARCHAR(80) NOT NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  `authority` VARCHAR(30) NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `userId_UNIQUE` (`userId` ASC),
  UNIQUE INDEX `email_UNIQUE` (`username` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`profile` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`profile` (
  `userId` INT NOT NULL,
  `firstName` VARCHAR(45) NULL DEFAULT NULL COMMENT '	',
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `image` BLOB NULL DEFAULT NULL,
  `heightFeet` INT(11) NULL DEFAULT NULL,
  `heightInches` INT(11) NULL DEFAULT NULL,
  `DOB` DATE NULL DEFAULT NULL,
  `gender` CHAR(1) NULL DEFAULT NULL,
  `city` VARCHAR(45) NULL DEFAULT NULL,
  `state` CHAR(2) NULL DEFAULT NULL,
  `zipCode` CHAR(5) NULL DEFAULT NULL,
  `gym` VARCHAR(45) NULL DEFAULT NULL,
  `level` INT(11) NULL DEFAULT NULL,
  `experiencePoints` INT(11) NULL DEFAULT NULL,
  `coins` INT(11) NULL DEFAULT NULL,
  `createTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `UserID_UNIQUE` (`userId` ASC),
  CONSTRAINT `UserID.Profile.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`users` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`bodyfat`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`bodyfat` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`bodyfat` (
  `bodyFatId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `createDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `bodyFatPercentage` DOUBLE NULL,
  PRIMARY KEY (`bodyFatId`),
  CONSTRAINT `UserID.BodyFat.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`challenge`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`challenge` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`challenge` (
  `challengeId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `level` INT NULL DEFAULT NULL,
  `pictureUrl` VARCHAR(256) NULL DEFAULT NULL,
  `description` VARCHAR(200) NULL DEFAULT NULL,
  `coinsGiven` INT NULL DEFAULT NULL,
  `experienceGiven` INT(11) NULL DEFAULT NULL,
  `type` CHAR(1) NULL DEFAULT NULL,
  PRIMARY KEY (`challengeId`),
  UNIQUE INDEX `challengeId_UNIQUE` (`challengeId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`goal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`goal` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`goal` (
  `goalId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` CHAR(1) NULL,
  `value` DOUBLE NULL DEFAULT NULL,
  `complete` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`goalId`),
  CONSTRAINT `UserID.Goal.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`updates`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`updates` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`updates` (
  `updateId` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `notes` VARCHAR(80) NULL,
  `createDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`updateId`),
  UNIQUE INDEX `UpdateID_UNIQUE` (`updateId` ASC),
  INDEX `UserID.Update.fk_idx` (`userId` ASC),
  CONSTRAINT `UserID.Update.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`image`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`image` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`image` (
  `imageId` INT NOT NULL AUTO_INCREMENT,
  `updateId` INT(11) NOT NULL,
  `userId` INT(11) NOT NULL,
  `picture` BLOB NULL DEFAULT NULL,
  `createDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`imageId`),
  CONSTRAINT `updateId.image.fk`
    FOREIGN KEY (`updateId`)
    REFERENCES `FitlyDB`.`updates` (`updateId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`item` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`item` (
  `itemId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  `imageUrl` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`itemId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`performance`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`performance` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`performance` (
  `performanceId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `challengeId` INT(11) NOT NULL,
  `startedDateTime` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `completedDateTime` DATETIME NULL DEFAULT NULL,
  `complete` TINYINT(1) NULL DEFAULT NULL,
  INDEX `challengeId.Performance.fk_idx` (`challengeId` ASC),
  PRIMARY KEY (`performanceId`),
  CONSTRAINT `userId.Performance.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `challengeId.Performance.fk`
    FOREIGN KEY (`challengeId`)
    REFERENCES `FitlyDB`.`challenge` (`challengeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`purchases` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`purchases` (
  `purchaseId` INT(11) NOT NULL AUTO_INCREMENT,
  `userId` INT(11) NOT NULL,
  `itemId` INT(11) NOT NULL,
  `quantity` INT(11) NULL,
  `purchaseDate` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`purchaseId`),
  INDEX `UserID_idx` (`userId` ASC),
  CONSTRAINT `UserID.Purchases.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`supplement`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`supplement` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`supplement` (
  `supplementId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`supplementId`),
  CONSTRAINT `UserID.Suplement.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `FitlyDB`.`weight`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `FitlyDB`.`weight` ;

CREATE TABLE IF NOT EXISTS `FitlyDB`.`weight` (
  `weightId` INT NOT NULL AUTO_INCREMENT,
  `userId` INT NOT NULL,
  `updateId` INT NULL,
  `createDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `weight` DOUBLE NOT NULL,
  PRIMARY KEY (`weightId`),
  INDEX `UserID.Weight.fk_idx` (`userId` ASC),
  CONSTRAINT `UserID.Weight.fk`
    FOREIGN KEY (`userId`)
    REFERENCES `FitlyDB`.`profile` (`userId`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
