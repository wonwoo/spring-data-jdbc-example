DROP TABLE IF EXISTS `persons`;

create table persons (
     id       BIGINT NOT NULL auto_increment,
     name     VARCHAR(255),
     desc     CLOB,
     time     DATETIME,
     PRIMARY KEY (id)
);

DROP TABLE IF EXISTS `foo`;

create table foo (
     id       BIGINT NOT NULL auto_increment,
     name     VARCHAR(255),
     PRIMARY KEY (id)
);