INSERT INTO users  (id, username, email, password, first_name, last_name, created, updated, status)
VALUES (100004,'RETA', 'RET12@gmail.com','$2y$12$ZTvhsePOBoMTS5M6oLX6W.Pwq/CBqBu1BjcUiSJLSxyZoXL/HgGxS', 'User_First', 'User_Last', '2012-07-24', '2012-07-24','ACTIVE');
INSERT INTO users (id, username, email, password, first_name, last_name, created, updated, status)
VALUES (100009,'ADMIN', 'ADMIN12@gmail.com','$2y$12$fDZwDspTfTmLwLfixRNtyO7XjX/342CovJgNB6fS1Epcf1OjoR1Gy', 'Admin_First', 'Admin_Last', '2014-07-24', '2014-07-24','ACTIVE');
INSERT INTO roles (id, name, created, updated, status) VALUES (1, 'ROLE_USER','2012-07-24', '2012-07-24', 'ACTIVE');
INSERT INTO roles (id, name, created, updated, status) VALUES (2, 'ROLE_ADMIN','2012-07-24', '2012-07-24', 'ACTIVE');
INSERT INTO user_roles (user_id, role_id)
VALUES (100004, 1);
INSERT INTO user_roles (user_id, role_id)
VALUES (100009, 2);
INSERT INTO restaurant (id, name, created, updated,status) VALUES (100006, 'DAF','2012-07-24', '2012-07-24', 'ACTIVE');
INSERT INTO menu(id, restaurant_id, created,updated,status) VALUES (100007,100006,'2012-07-24', '2012-07-24', 'ACTIVE');
INSERT INTO dish(id, name, price, menu_id,created,updated,status) VALUES (100008,'dish',123,100007, '2012-07-24', '2012-07-24', 'ACTIVE');