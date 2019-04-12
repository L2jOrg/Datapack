DROP TABLE IF EXISTS `character_contacts`;
CREATE TABLE IF NOT EXISTS `character_contacts` (
  charId INT UNSIGNED NOT NULL DEFAULT 0,
  contactId INT UNSIGNED NOT NULL DEFAULT 0,

  PRIMARY KEY (`charId`,`contactId`),
  FOREIGN KEY FK_CONTANCTS_CHARACTER (`charId`) REFERENCES characters (`charId`) ON DELETE CASCADE,
  FOREIGN KEY FK_CONTANCTS_CONTACT (`charId`) REFERENCES characters (`charId`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;