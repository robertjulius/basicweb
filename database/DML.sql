
-- MS_MODULE --
DELETE FROM ms_module WHERE id = '011user_maintenace';
DELETE FROM ms_module WHERE id = '012usergroup_maintenace';
DELETE FROM ms_module WHERE id = '010maintenance';
DELETE FROM ms_module WHERE id = '021module_maintenance';
DELETE FROM ms_module WHERE id = '020developer';
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, first_entry, description, name, parent) VALUES ('010maintenance', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Parent for all maintenances utility', 'Maintenance', NULL);
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, first_entry, description, name, parent) VALUES ('011user_maintenace', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Menu for user maintenance', 'User', '010maintenance');
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, first_entry, description, name, parent) VALUES ('012usergroup_maintenace', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Menu for user group maintenance', 'User Group', '010maintenance');
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, first_entry, description, name, parent) VALUES ('013reset_user_session', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '/modules/resetusersession/initial.action', 'Menu to reset user session', 'Reset User Session', '010maintenance');
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, first_entry, description, name, parent) VALUES ('020developer', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, NULL, 'Parent for all developer utility', 'Developer', NULL);
INSERT INTO ms_module (id, create_by, create_date, update_by, update_date, first_entry, description, name, parent) VALUES ('021module_maintenance', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '/modules/module/initial.action', 'Menu for module maintenance', 'Module', '020developer');

-- MS_USERGROUP
DELETE FROM ms_user_group;
INSERT INTO ms_user_group (id, create_by, create_date, update_by, update_date, description, name) VALUES ('developer', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, 'This group just for developer only', 'Developer');

-- MS_USER
DELETE FROM ms_user;
INSERT INTO ms_user (id, create_by, create_date, update_by, update_date, name, password, user_id, user_group_id) VALUES ('qpalzmwoskxn', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, 'Robert Julius', '1234', '1234', 'developer');
INSERT INTO ms_user (id, create_by, create_date, update_by, update_date, name, password, user_id, user_group_id) VALUES ('qpalzm', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, 'Robert 2', '123', '123', 'developer');

-- MS_PRIVILEGE
DELETE FROM ms_privilege;
INSERT INTO ms_privilege (user_group_id, module_id) VALUES ('developer', '011user_maintenace');
INSERT INTO ms_privilege (user_group_id, module_id) VALUES ('developer', '021module_maintenance');
INSERT INTO ms_privilege (user_group_id, module_id) VALUES ('developer', '013reset_user_session');

-- MS_ACCESS_PATH
DELETE FROM ms_access_path;
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/module/initial.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '021module_maintenance');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/module/prepareNew.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '021module_maintenance');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/module/search.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '021module_maintenance');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/module/prepareDetail.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '021module_maintenance');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/module/prepareEdit.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '021module_maintenance');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/module/confirmEdit.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '021module_maintenance');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/resetusersession/initial.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '013reset_user_session');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/resetusersession/prepareDetail.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '013reset_user_session');
INSERT INTO ms_access_path (url, create_by, create_date, update_by, update_date, module_id) VALUES ('/modules/resetusersession/executeReset.action', 'SYSTEM', CURRENT_TIMESTAMP, 'SYSTEM', CURRENT_TIMESTAMP, '013reset_user_session');
