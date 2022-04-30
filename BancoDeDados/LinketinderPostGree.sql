/*INSERT INTO competencias(id, nome) VALUES (1, 'Angular')
INSERT INTO competencias(id, nome) VALUES (2, 'Java');
INSERT INTO competencias(id, nome) VALUES (3, 'Groovy');
INSERT INTO competencias(id, nome) VALUES (4, 'Python');
INSERT INTO competencias(id, nome) VALUES (5, 'Typescript'); */

SELECT * FROM candidatos;

/* CREATE TABLE candidatos_has_competencias (
	candidatos_id INT NOT NULL,
	competencias_id INT NOT NULL,
	CONSTRAINT PK_candidatos_has_competencias PRIMARY KEY(candidatos_id, competencias_id),
	CONSTRAINT FK_candidatos_has_competencias2 FOREIGN KEY(candidatos_id) REFERENCES candidatos(id),
	CONSTRAINT FK_candidatos_has_competencias3 FOREIGN KEY(competencias_id) REFERENCES competencias(id)
);*/


 /*CREATE TABLE vagas_has_competencias (
	vagas_id INT NOT NULL,
	competencias_id INT NOT NULL,
	CONSTRAINT PK_vagas_has_competencias PRIMARY KEY(vagas_id, competencias_id),
	CONSTRAINT FK_vagas_has_competencias2 FOREIGN KEY(vagas_id) REFERENCES vagas(id),
	CONSTRAINT FK_vagas_has_competencias3 FOREIGN KEY(vagas_id) REFERENCES competencias(id)
); */

SELECT * FROM vagas_has_competencias;

