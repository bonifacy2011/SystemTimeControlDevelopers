DROP DATABASE IF EXISTS timeManager;
CREATE DATABASE IF NOT EXISTS timeManager CHARACTER SET utf8 COLLATE utf8_general_ci;
USE timeManager;


 CREATE TABLE responsible
  (
     id          integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
     name        VARCHAR(30) NOT NULL,
     surname     VARCHAR(30) NOT NULL
     
     
  );
  
 CREATE TABLE recordingElapsedTime
  (
     id                   integer NOT NULL PRIMARY KEY AUTO_INCREMENT, 
     dateOfEntry          TIMESTAMP DEFAULT NOW(),
     numberOfHours        DOUBLE NOT NULL,
     responsible_id       integer  NOT NULL,
    FOREIGN KEY (responsible_id) REFERENCES responsible(id)
  );
  
  CREATE TABLE task
  (
     id                              integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
     name                             VARCHAR(30) NOT NULL,
    responsible_id                  integer NOT NULL, 
    FOREIGN KEY (responsible_id) REFERENCES responsible(id)
  ); 
  
  CREATE TABLE task_to_recordingElapsedTime (
   id                      integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
   task_id                 integer NOT NULL,
   recordingElapsedTime_id integer NOT NULL,
   FOREIGN KEY (task_id) REFERENCES task (id) ON DELETE CASCADE ON UPDATE CASCADE,
   FOREIGN KEY (recordingElapsedTime_id) REFERENCES recordingElapsedTime (id) ON DELETE CASCADE ON UPDATE CASCADE
 );
 
 CREATE TABLE project
  (
     id       integer NOT NULL PRIMARY KEY AUTO_INCREMENT,
     name     VARCHAR(30) NOT NULL,
     responsible_id       integer NOT NULL,
     task_id       integer NOT NULL,
      FOREIGN KEY (task_id) REFERENCES task(id),
     FOREIGN KEY (responsible_id) REFERENCES responsible(id)
  ); 
  
 


  SELECT * from timeManager.recordingElapsedTime;
  
 DELETE  FROM timeManager.responsible; 
 
 
 USE timeManager;
 SELECT  r.id, r. dateOfEntry, r.numberOfHours, r1. name, r1.surname  FROM recordingElapsedTime r INNER JOIN responsible r1 on r.responsible_id = r1.id;
 