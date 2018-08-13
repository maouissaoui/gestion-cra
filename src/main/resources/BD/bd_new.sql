 CREATE TABLE `gestioncra`.`contract` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `contract_id` BIGINT(20) NULL,
  `tjm` BIGINT(20) NULL,
  `start_date` date NULL,
  `end_Date` date NULL,
  `paiement_period` BIGINT(20) NULL,
  `comment` VARCHAR(45) NULL,
  `active` boolean NULL,
  `company_cra_id` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  FOREIGN KEY (`company_cra_id`) REFERENCES cra(`id`) ON DELETE CASCADE);
  
CREATE TABLE `gestioncra`.`company` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `company_id` VARCHAR(20) NULL ,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `email_bill` VARCHAR(45) NULL,
  `email_contrat` VARCHAR(45) NULL,
 `company_contrat_id` BIGINT(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  FOREIGN KEY (`company_contrat_id`) REFERENCES contract(`id`) ON DELETE CASCADE);
  
  CREATE TABLE `gestioncra`.`cra` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `year` BIGINT(20) NULL,
  `month` BIGINT(20) NULL,
  `days` BIGINT(20) NULL,
  `status` varchar(45) NULL,
  `cra_bill_id` BIGINT(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
 FOREIGN KEY (`cra_bill_id`) REFERENCES bill(`id`) ON DELETE CASCADE);

CREATE TABLE `gestioncra`.`bill` (
  `id` BIGINT(20) NOT NULL auto_increment,
  `tva` BIGINT(20) NULL,
  `paid` boolean NULL,
  `global_amount` BIGINT(20) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);