-- MODULE --
DELETE FROM ms_module WHERE id = '011user_maintenace';
DELETE FROM ms_module WHERE id = '012usergroup_maintenace';
DELETE FROM ms_module WHERE id = '010maintenance';
DELETE FROM ms_module WHERE id = '021module';
DELETE FROM ms_module WHERE id = '020developer';
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, action, description, name, parent) VALUES ('010maintenance', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Parent for all maintenances utility', 'Maintenance', NULL);
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, action, description, name, parent) VALUES ('011user_maintenace', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Menu for user maintenance', 'User', '010maintenance');
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, action, description, name, parent) VALUES ('012usergroup_maintenace', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Menu for user group maintenance', 'User Group', '010maintenance');
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, action, description, name, parent) VALUES ('020developer', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Parent for all developer utility', 'Developer', NULL);
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, action, description, name, parent) VALUES ('021module', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Menu for module maintenance', 'Module', '020developer');

-- USERGROUP
INSERT INTO ms_user_group (id, create_by, create_date, update_by, update_date, description, name) VALUES ('developer', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, 'This group just for developer only', 'Developer');


