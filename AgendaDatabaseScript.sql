DROP DATABASE IF EXISTS AgendaExercise;
CREATE DATABASE AgendaExercise;
USE AgendaExercise;
CREATE TABLE Place(
  place_id INT NOT NULL AUTO_INCREMENT,
  location VARCHAR(25),
  PRIMARY KEY (place_id)
);
CREATE TABLE Interviewer(
  interviewer_id INT NOT NULL AUTO_INCREMENT,
  interviewer_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (interviewer_id)
);
CREATE TABLE Interviewed(
  interviewed_id INT NOT NULL AUTO_INCREMENT,
  interviewed_name VARCHAR(50) NOT NULL,
  PRIMARY KEY (interviewed_id)
);
CREATE TABLE Agenda(
  agenda_id INT NOT NULL AUTO_INCREMENT,
  agenda_name VARCHAR(50),
  PRIMARY KEY (agenda_id)
);
CREATE TABLE Hours(
  hours_id SMALLINT NOT NULL AUTO_INCREMENT,
  interview_start TIME NOT NULL,
  interview_end TIME NOT NULL,
  PRIMARY KEY (hours_id)
);
CREATE TABLE Appointment(
  place_id INT NOT NULL,
  hours_id SMALLINT NOT NULL,
  agenda_id INT NOT NULL,
  interviewer_id INT NOT NULL,
  interviewed_id INT NOT NULL,
  PRIMARY KEY (place_id,hours_id,agenda_id),
  FOREIGN KEY(place_id) REFERENCES
  Place(place_id),
  FOREIGN KEY(hours_id) REFERENCES
  Hours(hours_id),
  FOREIGN KEY(agenda_id) REFERENCES
  Agenda(agenda_id),
  FOREIGN KEY(interviewer_id) REFERENCES
  Interviewer(interviewer_id),
  FOREIGN KEY(interviewed_id) REFERENCES
  Interviewed(interviewed_id)
);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Agenda(agenda_name) VALUES (null);
INSERT INTO Agenda(agenda_name) VALUES (null);
INSERT INTO Agenda(agenda_name) VALUES (null);
INSERT INTO Agenda(agenda_name) VALUES (null);
INSERT INTO Agenda(agenda_name) VALUES (null);
INSERT INTO Hours(interview_start, interview_end) VALUES ("7:00","8:00");
INSERT INTO Hours(interview_start, interview_end) VALUES ("8:00","9:00");
INSERT INTO Hours(interview_start, interview_end) VALUES ("9:00","10:00");
INSERT INTO Hours(interview_start, interview_end) VALUES ("11:00","12:00");
INSERT INTO Interviewer(interviewer_name) VALUES ("Juan");
INSERT INTO Interviewer(interviewer_name) VALUES ("Rosa Ximena");
INSERT INTO Interviewer(interviewer_name) VALUES ("Roger Scherbatzky");
INSERT INTO Interviewer(interviewer_name) VALUES ("Santi");
INSERT INTO Interviewer(interviewer_name) VALUES ("Sandra");
INSERT INTO Interviewed(interviewed_name) VALUES ("Jesus");
INSERT INTO Interviewed(interviewed_name) VALUES ("Joan");
INSERT INTO Interviewed(interviewed_name) VALUES ("John");
INSERT INTO Interviewed(interviewed_name) VALUES ("Houdini");
INSERT INTO Interviewed(interviewed_name) VALUES ("John Jr.");
INSERT INTO Interviewed(interviewed_name) VALUES ("Yoko Ono");
INSERT INTO Appointment VALUES (1,1,1,1,1);
INSERT INTO Appointment VALUES (2,1,1,2,2);
INSERT INTO Appointment VALUES (3,1,1,3,3);
INSERT INTO Appointment VALUES (4,1,1,4,4);
INSERT INTO Appointment VALUES (1,2,1,1,4);
INSERT INTO Appointment VALUES (2,2,1,2,3);
INSERT INTO Appointment VALUES (3,2,1,3,2);
INSERT INTO Appointment VALUES (4,2,1,4,1);
INSERT INTO Appointment VALUES (1,1,2,1,1);
INSERT INTO Appointment VALUES (2,1,2,2,2);
INSERT INTO Appointment VALUES (3,1,2,3,3);
INSERT INTO Appointment VALUES (4,1,2,4,4);
INSERT INTO Appointment VALUES (1,2,2,1,4);
INSERT INTO Appointment VALUES (2,2,2,2,3);
INSERT INTO Appointment VALUES (3,2,2,3,2);
INSERT INTO Appointment VALUES (4,2,2,4,1);


