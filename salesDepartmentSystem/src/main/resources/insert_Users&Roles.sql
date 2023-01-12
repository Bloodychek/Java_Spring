INSERT INTO users(password, username) VALUES ('qwe123', 'Roma'), ('qwe123', 'Evgeniy'), ('qwe123', 'Denis');
INSERT INTO roles(name) VALUES ('Director'), ('Main Accounting'), ('Accounting');
INSERT INTO users_roles(user_id, role_id) VALUES (1, 1), (2, 2), (3, 3);