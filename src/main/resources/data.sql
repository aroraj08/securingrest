
/*INSERT INTO AUTH_USER (ID, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED, PASSWORD, USERNAME)
VALUES (1, TRUE, TRUE, TRUE, TRUE, 'admin', 'admin');*/

INSERT INTO ROLES(ID, ROLE_TYPE ) VALUES(1, 'Admin');
INSERT INTO ROLES(ID, ROLE_TYPE ) VALUES(2, 'User');


INSERT INTO RESOURCE (ID,RESOURCE  ) VALUES(1, 'Admin_Read');
INSERT INTO RESOURCE (ID, RESOURCE ) VALUES(2, 'Admin_Write');
INSERT INTO RESOURCE (ID,RESOURCE  ) VALUES(3, 'Admin_Delete');
INSERT INTO RESOURCE (ID, RESOURCE ) VALUES(4, 'User_Read');
INSERT INTO RESOURCE (ID, RESOURCE ) VALUES(5, 'User_Write');

INSERT INTO ROLE_RESOURCE (ROLE_ID ,RESOURCE_ID ) VALUES(1, 1);
INSERT INTO ROLE_RESOURCE (ROLE_ID ,RESOURCE_ID ) VALUES(1, 2);
INSERT INTO ROLE_RESOURCE (ROLE_ID ,RESOURCE_ID ) VALUES(1, 3);
INSERT INTO ROLE_RESOURCE (ROLE_ID ,RESOURCE_ID ) VALUES(2, 4);
INSERT INTO ROLE_RESOURCE (ROLE_ID ,RESOURCE_ID ) VALUES(2, 5);