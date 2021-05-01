DROP TABLE IF EXISTS vote CASCADE;
DROP TABLE IF EXISTS menu CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS user_roles CASCADE;
DROP TABLE IF EXISTS roles CASCADE;
DROP TABLE IF EXISTS dish CASCADE;
DROP TABLE IF EXISTS restaurant CASCADE;
DROP SEQUENCE IF EXISTS global_seq CASCADE;

CREATE SEQUENCE GLOBAL_SEQ AS INTEGER START WITH 100000;

CREATE TABLE users
(
    id         INTEGER  PRIMARY KEY DEFAULT nextval('global_seq'),
    username       VARCHAR(255)          NOT NULL,

    email      VARCHAR(255)          NOT NULL,
    password   VARCHAR(255)          NOT NULL,
    first_name  VARCHAR(255)         NOT NULL,
    last_name   VARCHAR(255)         NOT NULL,
    created     TIMESTAMP            NOT NULL,
    updated     TIMESTAMP            NOT NULL,
    status      VARCHAR(255)          NOT NULL

);
CREATE UNIQUE INDEX users_unique_email_idx ON USERS (email);

CREATE TABLE roles
(
    id           INTEGER           NOT NULL,
    name         VARCHAR           NOT NULL,
    created     TIMESTAMP            NOT NULL,
    updated     TIMESTAMP            NOT NULL,
    status      VARCHAR(255)          NOT NULL

);
CREATE UNIQUE INDEX roles_unique_idx ON ROLES (id);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role_id INTEGER NOT NULL,
    CONSTRAINT fk_user_roles_users UNIQUE (user_id),
    CONSTRAINT fk_user_roles_roles UNIQUE (role_id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE



);
CREATE TABLE restaurant
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(255) NOT NULL,
    created     TIMESTAMP            NOT NULL,
    updated     TIMESTAMP            NOT NULL,
    status      VARCHAR(255)          NOT NULL
);

CREATE TABLE menu
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    restaurant_id INTEGER NOT NULL,
    created       DATE    NOT NULL,
    updated     TIMESTAMP            NOT NULL,
    status      VARCHAR(255)          NOT NULL,
    CONSTRAINT restaurant_date_idx UNIQUE (restaurant_id, created),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE

);

CREATE TABLE dish
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    menu_id INTEGER NOT NULL,
    created       DATE    NOT NULL,
    updated     TIMESTAMP            NOT NULL,
    status      VARCHAR(255)          NOT NULL,
    CONSTRAINT dish_idx UNIQUE (menu_id, name),
    FOREIGN KEY (menu_id) REFERENCES menu (id) ON DELETE CASCADE
);



CREATE TABLE vote
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    dcreated    TIMESTAMP DEFAULT now() ,
    created     TIMESTAMP         ,
    updated     TIMESTAMP           ,
    status      VARCHAR(255)          ,
    rate      DOUBLE PRECISION ,
    user_id  INTEGER ,
    restaurant_id INTEGER ,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (restaurant_id) REFERENCES restaurant (id) ON DELETE CASCADE
);