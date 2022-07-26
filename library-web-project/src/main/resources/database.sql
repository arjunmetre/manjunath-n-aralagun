create table tb_admin(aid varchar(50),
Aname varchar(50),
Asex varchar(50),
Aage varchar(50),
AidCard varchar(50),
Atel varchar(50),
Alevel varchar(50),
Apsw varchar(50));



CREATE TABLE tb_user (
	`id` INT NOT NULL,
	
uname varchar(50),
uage varchar(50),
uidCard varchar(50),
effectivedate varchar(50),
utel varchar(50),
balance varchar(50),
userId varchar(50),
startTime varchar(50),
upsw varchar(50),
	PRIMARY KEY (`id`)
)
COLLATE='utf8mb4_general_ci'
;

ALTER TABLE `tb_user`
	CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT FIRST;