-- id, pw, ssn, name, regdate;

	CREATE SEQUENCE article_seq
	START WITH		1000
	INCREMENT BY	1
	NOCACHE
	NOCYCLE;

CREATE TABLE Member(
	id VARCHAR2(10),
	pw VARCHAR2(10),
	ssn VARCHAR2(15),
	name VARCHAR2(10),
	regdate DATE,
	PRIMARY KEY(id)
);

DROP SEQUENCE article_seq;
DROP TABLE Member;
DROP TABLE Board;

SELECT * FROM Member;


-- id, title, content;
-- article_seq, hitcount;
-- regdate;

CREATE TABLE Board(
	article_seq NUMBER,
	id VARCHAR2(10),
	title VARCHAR2(20),
	content VARCHAR2(100),
	hitcount NUMBER,
	regdate DATE,
	PRIMARY KEY(article_seq),
	FOREIGN KEY(id) REFERENCES Member(id)
		ON DELETE CASCADE
);