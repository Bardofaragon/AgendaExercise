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
CREATE TABLE Hours(
  hours_id SMALLINT NOT NULL AUTO_INCREMENT,
  interview_start TIME NOT NULL,
  interview_end TIME NOT NULL,
  PRIMARY KEY (hours_id)
);
CREATE TABLE InterviewerHours(
 interviewer_id INT NOT NULL,
 hours_id SMALLINT NOT NULL,
 PRIMARY KEY(interviewer_id, hours_id),
 FOREIGN KEY(interviewer_id) REFERENCES
 Interviewer(interviewer_id),
 FOREIGN KEY (hours_id) REFERENCES
 Hours(hours_id)
);
CREATE TABLE Appointment(
  place_id INT NOT NULL,
  hours_id SMALLINT NOT NULL,
  daydesc DATE NOT NULL,
  interviewer_id INT NOT NULL,
  interviewed_id INT NOT NULL,
  PRIMARY KEY (place_id,hours_id,daydesc),
  FOREIGN KEY(place_id) REFERENCES
  Place(place_id),
  FOREIGN KEY(hours_id) REFERENCES
  Hours(hours_id),
  FOREIGN KEY(interviewer_id) REFERENCES
  Interviewer(interviewer_id),
  FOREIGN KEY(interviewed_id) REFERENCES
  Interviewed(interviewed_id)
);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Place(location) VALUES (null);
INSERT INTO Hours(interview_start, interview_end) VALUES ("9:00","9:20");
INSERT INTO Hours(interview_start, interview_end) VALUES ("9:20","9:40");
INSERT INTO Hours(interview_start, interview_end) VALUES ("9:40","10:00");
INSERT INTO Hours(interview_start, interview_end) VALUES ("10:20","10:40");
INSERT INTO Interviewer(interviewer_name) VALUES ("Juan");
INSERT INTO Interviewer(interviewer_name) VALUES ("Rosa Ximena");
INSERT INTO Interviewer(interviewer_name) VALUES ("Sandra");
INSERT INTO InterviewerHours VALUES (1,1);
INSERT INTO InterviewerHours VALUES (1,2);
INSERT INTO InterviewerHours VALUES (1,3);
INSERT INTO InterviewerHours VALUES (2,1);
INSERT INTO InterviewerHours VALUES (2,3);
INSERT INTO InterviewerHours VALUES (2,4);
INSERT INTO InterviewerHours VALUES (3,1);
INSERT INTO Interviewed(interviewed_name) VALUES ("Jesus");
INSERT INTO Interviewed(interviewed_name) VALUES ("Joan");
INSERT INTO Interviewed(interviewed_name) VALUES ("John");
INSERT INTO Interviewed(interviewed_name) VALUES ("Houdini");
INSERT INTO Interviewed(interviewed_name) VALUES ("John Jr.");
INSERT INTO Interviewed(interviewed_name) VALUES ("Yoko Ono");
INSERT INTO Interviewed(interviewed_name) VALUES ("Jaime");
INSERT INTO Interviewed(interviewed_name) VALUES ("Jorge");
INSERT INTO Interviewed(interviewed_name) VALUES ("Gerbacio");
INSERT INTO Interviewed(interviewed_name) VALUES ("Genaro");
INSERT INTO Interviewed(interviewed_name) VALUES ("Guadalupe");
INSERT INTO Interviewed(interviewed_name) VALUES ("Bryan");