INSERT INTO SYS_JOB (ID, NAME, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (1, '中公网', 0, '0/', null, 100, true);
INSERT INTO SYS_JOB (ID, NAME, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (2, '公司副总', 1, '0/1/', null, 100, true);
INSERT INTO SYS_JOB (ID, NAME, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (3, '技术总监', 2, '0/1/2/', null, 100, true);
INSERT INTO SYS_JOB (ID, NAME, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (4, '技术经理', 3, '0/1/2/3/', null, 100, true);
INSERT INTO SYS_JOB (ID, NAME, PARENT_ID, PARENT_IDS, ICON, WEIGHT, IS_SHOW) VALUES (5, '普通员工', 4, '0/1/2/3/4/', null, 100, true);
INSERT INTO SYS_USER (ID, USERNAME, EMAIL, PHONE_NUMBER, PASSWORD, SALT, CREATE_DATE, STATUS, DELETED, IS_ADMIN) VALUES (1, 'David Kong', 'kong.dw@hotmail.com', '13693601808', '123456', '111111', '2015-11-16 16:06:17.320000000', 'normal', FALSE , true);
