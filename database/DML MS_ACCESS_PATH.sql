-- MODULE MAINTENANCE
DELETE FROM ms_access_path WHERE module_id = '021module_maintenance';
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/initial.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/main.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/search.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/searchResult.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/prepareDetail.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/detail.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/prepareUpdate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/formUpdate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/validateUpdate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/confirmUpdate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/executeUpdate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/summaryUpdate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/prepareCreate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/formCreate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/validateCreate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/confirmCreate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/executeCreate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/summaryCreate.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/executeDelete.action', '021module_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/module/summaryDelete.action', '021module_maintenance');

-- USER GROUP MAINTENANCE
DELETE FROM ms_access_path WHERE module_id = '012usergroup_maintenance';
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/initial.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/main.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/search.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/searchResult.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/prepareDetail.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/detail.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/prepareUpdate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/formUpdate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/validateUpdate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/confirmUpdate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/executeUpdate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/summaryUpdate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/prepareCreate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/formCreate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/validateCreate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/confirmCreate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/executeCreate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/summaryCreate.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/executeDelete.action', '012usergroup_maintenance');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/usergroupmaintenance/summaryDelete.action', '012usergroup_maintenance');

INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/resetusersession/initial.action', '013reset_user_session');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/resetusersession/prepareDetail.action', '013reset_user_session');
INSERT INTO ms_access_path (url, module_id) VALUES ('/modules/resetusersession/executeReset.action', '013reset_user_session');
