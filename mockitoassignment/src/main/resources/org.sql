CREATE TABLE ORGANIZATION (
  orgId INT  PRIMARY KEY,
  orgName varchar(20)
);

Insert into ORGANIZATION (orgId, orgName) values(1, 'Org1');
Insert into ORGANIZATION (orgId, orgName) values(2, 'Org2');
Insert into ORGANIZATION (orgId, orgName) values(3, 'Org3');
Insert into ORGANIZATION (orgId, orgName) values(4, 'Org4');
Insert into ORGANIZATION (orgId, orgName) values(5, 'Org5');
Insert into ORGANIZATION (orgId, orgName) values(6, 'Org6');


CREATE TABLE CLIENT (
  clientId INT  PRIMARY KEY,
  clientName varchar(20),
  orgId INT
);
ALTER TABLE PUBLIC.CLIENT ADD FOREIGN KEY ( orgId ) REFERENCES PUBLIC.ORGANIZATION( orgId ) ON DELETE CASCADE ;

Insert into CLIENT (clientId, clientName,  orgId) values(1, 'Client1',1);
Insert into CLIENT (clientId, clientName,  orgId) values(2, 'Client2',1);
Insert into CLIENT (clientId, clientName,  orgId) values(3, 'Client3',2);
Insert into CLIENT (clientId, clientName,  orgId) values(4, 'Client4',3);
Insert into CLIENT (clientId, clientName,  orgId) values(5, 'Client5',2);
Insert into CLIENT (clientId, clientName,  orgId) values(6, 'Client6',3);
Insert into CLIENT (clientId, clientName,  orgId) values(7, 'Client7',2);


CREATE TABLE FARM (
  farmId INT  PRIMARY KEY,
  farmName varchar(20),
  clientId INT
);

ALTER TABLE PUBLIC.FARM ADD FOREIGN KEY (clientId) REFERENCES PUBLIC.CLIENT( clientId ) ON DELETE CASCADE ;

Insert into FARM (farmId, farmName,  clientId) values(1, 'Farm1',1);
Insert into FARM (farmId, farmName,  clientId) values(2, 'Farm2',1);
Insert into FARM (farmId, farmName,  clientId) values(3, 'Farm3',2);
Insert into FARM (farmId, farmName,  clientId) values(4, 'Farm3',2);
Insert into FARM (farmId, farmName,  clientId) values(5, 'Farm3',3);
Insert into FARM (farmId, farmName,  clientId) values(6, 'Farm3',3);
Insert into FARM (farmId, farmName,  clientId) values(7, 'Farm3',5);
Insert into FARM (farmId, farmName,  clientId) values(8, 'Farm3',5);


CREATE TABLE FIELD (
  fieldId INT  PRIMARY KEY,
  fieldName varchar(20),
  farmId INT
);

ALTER TABLE PUBLIC.FIELD ADD FOREIGN KEY (farmId) REFERENCES PUBLIC.FARM(farmId) ON DELETE CASCADE ;

Insert into FIELD (fieldId, fieldName,  farmId) values(1, 'Field1',1);
Insert into FIELD (fieldId, fieldName,  farmId) values(2, 'Field2',1);
Insert into FIELD (fieldId, fieldName,  farmId) values(3, 'Field3',2);
Insert into FIELD (fieldId, fieldName,  farmId) values(4, 'Field4',2);
Insert into FIELD (fieldId, fieldName,  farmId) values(5, 'Field5',3);
Insert into FIELD (fieldId, fieldName,  farmId) values(6, 'Field6',3);
Insert into FIELD (fieldId, fieldName,  farmId) values(7, 'Field7',5);
Insert into FIELD (fieldId, fieldName,  farmId) values(8, 'Field8',5);