-- -----------------------------------------------------
-- Schema gs_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gs_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `gs_db` ;

-- -----------------------------------------------------
-- Table `gs_db`.`gs_repository`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gs_db`.`gs_repository` (
  `id` VARCHAR(36) NOT NULL,
  `directory` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


-- -----------------------------------------------------
-- Table `gs_db`.`gs_commit`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gs_db`.`gs_commit` (
  `id` VARCHAR(40) NOT NULL,
  `repository_id` VARCHAR(36) NOT NULL,
  `short_message` VARCHAR(255) NULL,
  `author_name` VARCHAR(100) NULL,
  `author_email` VARCHAR(100) NULL,
  `author_when` DATETIME NULL,
  `insertion` INT NULL,
  `deletion` INT NULL,
  `ignored` BIT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


