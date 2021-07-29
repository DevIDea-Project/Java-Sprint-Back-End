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
INSERT INTO TB_GROUPS (name, nameTeacher, course_id) VALUES ('Curso01', 'Bruno Vinicius', 1);
INSERT INTO TB_GROUPS (name, nameTeacher, course_id) VALUES ('Curso02', 'Vito Gabriel', 2);
INSERT INTO TB_GROUPS (name, nameTeacher, course_id) VALUES ('Curso03', 'Maria Clarissa', 3);
INSERT INTO TB_GROUPS (name, nameTeacher, course_id) VALUES ('Curso04', 'Junior Ramos', 4);