CREATE TABLE IF NOT EXISTS `character_recipebook` (
	`char_id` INT NOT NULL DEFAULT '0',
	`id` SMALLINT UNSIGNED NOT NULL DEFAULT '0',
	PRIMARY KEY  (`id`,`char_id`)
);