--Inserts for courses
INSERT INTO TB_COURSE (name) VALUES ('TDD');
INSERT INTO TB_COURSE (name) VALUES ('JavaScript');
INSERT INTO TB_COURSE (name) VALUES ('Java');
INSERT INTO TB_COURSE (name) VALUES ('Banco De Dados');
INSERT INTO TB_COURSE (name) VALUES ('HTML');
INSERT INTO TB_COURSE (name) VALUES ('CSS');
INSERT INTO TB_COURSE (name) VALUES ('Clean Code');
INSERT INTO TB_COURSE (name) VALUES ('SOLID');


--Insert for user
INSERT INTO TB_USUARIO (email, name, senha) VALUES ('brunoviniciustica@gmail.com', 'Bruno Vinicius Felix Da Silva', '$2a$10$za0OmFoDGW6A.YZM8zP4JOjypne6wQMR/7xgWEBMkyKwoLLyPQRvm');
INSERT INTO TB_USUARIO (email, nome, senha) VALUES ('almeidalima.igor@gmail.com', 'Igor de Almeida Lima', '$2a$10$Gn03nA57itFW1RqrQCOZPON5b2L296pX0HBcVwpuHiyyD7qBpph/C');
INSERT INTO TB_USUARIO (email, nome, senha) VALUES ('sofia@gmail.com', 'Sofia Lima', '$2a$10$Gn03nA57itFW1RqrQCOZPON5b2L296pX0HBcVwpuHiyyD7qBpph/C');
INSERT INTO TB_USUARIO (email, nome, senha) VALUES ('furustreca@gmail.com', 'Furustreca Lima', '$2a$10$Gn03nA57itFW1RqrQCOZPON5b2L296pX0HBcVwpuHiyyD7qBpph/C');


-- Insert for Groups
INSERT INTO TB_GROUPS (course_id, name, nameTeacher) VALUES (1, 'TDD', 'Bruno Vinicius');
INSERT INTO TB_GROUPS (course_id, name, nameTeacher) VALUES (2, 'JavaScript', 'Vito Gabriel');
INSERT INTO TB_GROUPS (course_id, name, nameTeacher) VALUES (3, 'Java', 'Maria Clarissa');
INSERT INTO TB_GROUPS (course_id, name, nameTeacher) VALUES (4, 'Banco De Dados', 'Junior Ramos');

-- Insert for Student
INSERT INTO TB_GROUPS (course_id, name, address, phoneNumber) VALUES (1, 'Bruno', 'Rua Poloni', '56789098765');
INSERT INTO TB_GROUPS (course_id, name, address, phoneNumber) VALUES (2, 'Clarissa', 'Rua 2', '8798797099');
INSERT INTO TB_GROUPS (course_id, name, address, phoneNumber) VALUES (3, 'Vitor', 'Rua 3', '65576253986391');
INSERT INTO TB_GROUPS (course_id, name, address, phoneNumber) VALUES (4, 'Margarida', 'Rua 4', '765633689319333');
