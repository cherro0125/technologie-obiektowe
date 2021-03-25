CREATE DATABASE mmo;

USE mmo;

CREATE TABLE countries
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    code VARCHAR(3) NOT NULL,
    name VARCHAR(100) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL
);

CREATE TABLE servers
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    slots INT NOT NULL DEFAULT 1,
    port INT NOT NULL DEFAULT 2000,
    country_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,
    CONSTRAINT country_id_server_fk FOREIGN KEY(country_id) REFERENCES countries(id)
);

CREATE TABLE accounts
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(100) NOT NULL,
    nickname VARCHAR(100) NOT NULL,
    login VARCHAR(100) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,
    ban_expired_at DATETIME NULL
);

CREATE TABLE base_statistics
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    intelligent_value INT NOT NULL DEFAULT 0,
    strength_value INT NOT NULL DEFAULT 0,
    vitality_value INT NOT NULL DEFAULT 0,
    luck_value INT NOT NULL DEFAULT 0,
    armor INT NOT NULL DEFAULT 0,
    magic_armor INT NOT NULL DEFAULT 0,
    attack INT NOT NULL DEFAULT 0,
    magic_attack INT NOT NULL DEFAULT 0,
    max_hp INT NOT NULL DEFAULT 100 COMMENT 'Health points',
    max_mp INT NOT NULL DEFAULT 200 COMMENT 'Mana points',
    max_sp INT NOT NULL DEFAULT 500 COMMENT 'Stamina points',
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL
);


CREATE TABLE character_looks
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    hair_type SMALLINT NOT NULL DEFAULT 0,
    hair_color SMALLINT NOT NULL DEFAULT 0,
    body_type SMALLINT NOT NULL DEFAULT 0,
    skin_color SMALLINT NOT NULL DEFAULT 0,
    head_type SMALLINT NOT NULL DEFAULT 0,
    sex SMALLINT NOT NULL DEFAULT 0 CHECK ( sex = 1 OR sex = 0 ) ,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL
);

CREATE TABLE character_races
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    base_stat_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,
    CONSTRAINT base_stat_char_r_fk FOREIGN KEY(base_stat_id) REFERENCES base_statistics(id)
);

CREATE TABLE character_classes
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    base_stat_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,
    CONSTRAINT base_stat_char_c_fk FOREIGN KEY(base_stat_id) REFERENCES base_statistics(id)
);

CREATE TABLE map
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL
);

CREATE TABLE map_position
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    pos_x FLOAT NOT NULL DEFAULT 0.0,
    pos_y FLOAT NOT NULL DEFAULT 0.0,
    pos_z FLOAT NOT NULL DEFAULT 0.0,
    is_spawn_position BOOLEAN NOT NULL DEFAULT 0,
    map_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,

    CONSTRAINT map_id_map_fk FOREIGN KEY(map_id) REFERENCES map(id)
);

CREATE TABLE characters
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    account_id BIGINT NOT NULL,
    server_id BIGINT NOT NULL,
    char_look_id BIGINT NOT NULL,
    char_class_id BIGINT NOT NULL,
    char_race_id BIGINT NOT NULL,
    position_id BIGINT NOT NULL,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,

    CONSTRAINT account_id_char_fk FOREIGN KEY(account_id) REFERENCES accounts(id),
    CONSTRAINT server_id_char_fk FOREIGN KEY(server_id) REFERENCES servers(id),
    CONSTRAINT char_look_id_fk FOREIGN KEY(char_look_id) REFERENCES character_looks(id),
    CONSTRAINT char_class_id_fk FOREIGN KEY(char_class_id) REFERENCES character_classes(id),
    CONSTRAINT char_race_id_fk FOREIGN KEY(char_race_id) REFERENCES character_races(id),
    CONSTRAINT position_id_pos_fk FOREIGN KEY(position_id) REFERENCES map_position(id)
);

CREATE TABLE skills
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL ,
    stat_id BIGINT NOT NULL,
    is_passive BOOLEAN NOT NULL DEFAULT 0,
    is_buff BOOLEAN NOT NULL DEFAULT 0,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,
    CONSTRAINT stat_id_skill_fk FOREIGN KEY(stat_id) REFERENCES base_statistics(id)
);

CREATE TABLE character_class_skills
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    skill_id BIGINT NOT NULL,
    char_class_id BIGINT NOT NULL ,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,

    CONSTRAINT skill_id_chr_skill_fk FOREIGN KEY(skill_id) REFERENCES skills(id),
    CONSTRAINT char_class_id_chr_skill_fk FOREIGN KEY(char_class_id) REFERENCES character_classes(id)
);



CREATE TABLE items
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    stat_id BIGINT NOT NULL,
    item_type VARCHAR(100) NOT NULL COMMENT 'ENUM FOR ITEM TYPE',
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,

    CONSTRAINT stat_id_item_fk FOREIGN KEY(stat_id) REFERENCES base_statistics(id)
);

CREATE TABLE character_items
(
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    item_id BIGINT NOT NULL,
    char_id BIGINT NOT NULL ,
    created_at DATETIME NOT NULL DEFAULT NOW(),
    modified_at DATETIME NULL,
    deleted_at DATETIME NULL,

    CONSTRAINT item_id_char_fk FOREIGN KEY(item_id) REFERENCES items(id),
    CONSTRAINT char_id_char_item_fk FOREIGN KEY(char_id) REFERENCES characters(id)
);
