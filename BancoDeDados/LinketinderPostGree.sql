/*CREATE TABLE candidatos (
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	data_de_nascimento DATE NOT NULL,
	email VARCHAR(50) NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	descricao VARCHAR(200) NOT NULL,
	senha VARCHAR(15) NOT NULL,
	competencias VARCHAR(50) NOT NULL
);
CREATE TABLE empresas(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	cnpj VARCHAR(14) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	cep VARCHAR(8) NOT NULL,
	senha VARCHAR(15) NOT NULL,
	competencias VARCHAR(50) NOT NULL
);

CREATE TABLE competencias_empresas(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50),
	id_empresas INT REFERENCES empresas(id)
);
CREATE TABLE competencias_candidatos(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50),
	id_candidatos INT REFERENCES candidatos(id)

);

CREATE TABLE vagas(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(50) NOT NULL,
	estado VARCHAR(2) NOT NULL,
	cidade VARCHAR(50) NOT NULL,
	id_empresas INT REFERENCES empresas(id)  NOT NULL 

); */

INSERT INTO candidatos VALUES (1,'Lucas', 'Paradizo', '01-12-1998','lucasparadizzo@gmail.com', '16777031725', 'Brasil','29160778','Alooou','123','Angular, Python');
INSERT INTO empresas VALUES (2,'Acelera2,', 'Acelera2@gmail.com','12345678912345', 'Brasil','29160779','123456','Angular, Python, Viver');
/* O que eu pensei em fazer aqui é adicionar uma coluna serial ( Coluna1, Coluna2) no próprio código, assim, cada input de adição de tarefas gera também uma nova coluna*/ 
SELECT * FROM empresas;


INSERT INTO vagas VALUES (1,'Dev Front end', 'Desenvolvedor front end', 'ES', 'Vitoria', '1');
INSERT INTO vagas VALUES (2, 'Dev Back End','Desenvolvedor Backend', 'ES','Serra','1');
INSERT INTO vagas VALUES ('3','Dev Back End','Desenvolvedor Backend', 'ES','Serra','2');

SELECT * FROM vagas;



