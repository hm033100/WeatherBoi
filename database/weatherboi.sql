
DROP SCHEMA IF EXISTS `weatherboi`;
CREATE SCHEMA IF NOT EXISTS `weatherboi` DEFAULT CHARACTER SET latin1 ;
USE `weatherboi` ;

-- -----------------------------------------------------
-- Table `weatherboi`.`data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `weatherboi`.`data` (
  `DATA_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `DATE` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `TEMP` FLOAT NOT NULL,
  `PRESS` FLOAT NOT NULL,
  `HUMID` FLOAT NOT NULL,
  PRIMARY KEY (`DATA_ID`));


-- -----------------------------------------------------
-- Table `weatherboi`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `weatherboi`.`user` (
  `USER_ID` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(45) NULL DEFAULT NULL,
  `USER_NAME` VARCHAR(20) NOT NULL,
  `PASSWORD` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`USER_ID`));
