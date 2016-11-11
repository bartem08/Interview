DROP FUNCTION IF EXISTS interview.initialize;
CREATE DEFINER=`root`@`localhost` FUNCTION `initialize`() RETURNS INT
BEGIN
  DECLARE userID VARCHAR(100);
  DECLARE authorityID VARCHAR(100);
  DECLARE directionID VARCHAR(100);
  DECLARE candidateID VARCHAR(100);
  DECLARE questionTagID1 VARCHAR(100);
  DECLARE questionTagID2 VARCHAR(100);

  INSERT INTO interview.online_user (id, email, password, phone, first_name, last_name, enabled)
  VALUES (uuid(), 'artem2549@gmail.com', '$2a$06$RCJZozzg0xftVneDlnqZSO.mlNUsasAEGbAG9Xlj8jrwGVgtMtoTi',
          '0971234654', 'Artem', 'Baranovskiy', '1');

  INSERT INTO interview.user_authority (id, authority)
  VALUES (uuid(), 'ROLE_HR');

  INSERT INTO interview.candidate (id, email, phone, first_name, last_name, date_of_birth)
  VALUES (uuid(), 'whoiam2549@gmail.com', '0960209511', 'Peter', 'Krasnov', '1995-01-01');

  INSERT INTO interview.direction (id, name)
  VALUES (uuid(), 'Java');

  INSERT INTO interview.question_tag (id, name)
  VALUES (uuid(), 'OOP');

  INSERT INTO interview.question_tag (id, name)
  VALUES (uuid(), 'GoF');

  SET userID = (SELECT ou.id FROM online_user ou WHERE ou.phone = '0971234654');
  SET authorityID = (SELECT ua.id FROM user_authority ua WHERE ua.authority = 'ROLE_HR');
  SET directionID = (SELECT d.id FROM direction d WHERE d.name = 'Java');
  SET candidateID = (SELECT c.id FROM candidate c WHERE c.phone = '0960209511');
  SET questionTagID1 = (SELECT qt.id FROM question_tag qt WHERE qt.name = 'OOP');
  SET questionTagID2 = (SELECT qt.id FROM question_tag qt WHERE qt.name = 'GoF');

  INSERT INTO interview.online_user_authority (user_id, authority_id)
  VALUES (userID, authorityID);

  INSERT INTO interview.candidate_direction (candidate_id, direction_id)
  VALUES (candidateID, directionID);

  INSERT INTO interview.online_user_direction (online_user_id, direction_id)
  VALUES (userID, directionID);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Encapsulation', questionTagID1);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Abstraction', questionTagID1);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Polymorphism', questionTagID1);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Inheritance', questionTagID1);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Decorator', questionTagID2);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Abstract Factory', questionTagID2);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Observer', questionTagID2);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Strategy', questionTagID2);

  INSERT INTO interview.question (id, content, tag_id)
  VALUES (uuid(), 'Builder', questionTagID2);

  INSERT INTO interview.template (id, name, favourite, online_user_id, direction_id)
  VALUES (uuid(), 'My java template', true, userID, directionID);

  RETURN 1;
END;