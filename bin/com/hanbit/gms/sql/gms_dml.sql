-- id, pw, ssn, name, regdate;
INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('hon', '1', '800101-123456', '홍길똥', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('bomb', '1', '170514-123456', '이밤이', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('black', '1', '160314-123456', '깜댕이', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('lee','1','850518-123456','이주연',SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('lee2','1', '560519-123456', '이주연', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('lee3','1', '930518-223456', '이주연', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('kwon', '1', '930304-223456', '권예지', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('gugu', '1', '161014-223456', '구구구', SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('cuza','1','930705-223456','구수완',SYSDATE);

INSERT INTO Member(id, pw, ssn, name, regdate)
VALUES('cream','1','170513-223456','구크림',SYSDATE);

SELECT * FROM Member;
SELECT * FROM Member WHERE name = '';
SELECT COUNT(*) AS count FROM Member;
SELECT * FROM Member WHERE id = '';
UPDATE Member SET password='' WHERE id='';
DELETE FROM Member WHERE id='';


-- id, title, content;
-- article_seq, hitcount;
-- regdate;
INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'hon','안녕 난 홍길동','난 역적일까 아닐까',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'hon','안녕홍길도옹','탐정이죠',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'hon','안녕 닌겐','네이놈 무슨 짓을 하는게냐',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'bomb','집사여 안녕','츄르를 이제 나에게 다오.',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'black','쿠자여 안녕','왜 날 고자로 만들었느냐',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'lee','얘들아 안녕','난 남자 이주연이야.',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'kwon','왕현아 안녕','난 독일에 가고싶어.',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'gugu','고먐미들아','난 고양이들의 요정~! 구구입니다.',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'cuza','안녕 바보들','고양이들밖에 모르는 바보들아.',0,SYSDATE);

INSERT INTO Board(article_seq,id,title,content,hitcount,regdate)
VALUES(article_seq.nextval,'cream','냐옹','난 아이스크림따위는 먹지않아.',0,SYSDATE);


INSERT INTO Board(article_seq,id,title,content,hitcount,regdate) VALUES(article_seq.nextval,'cream','sisi','sisisi',0,SYSDATE);
SELECT * FROM Board;
SELECT * FROM Board WHERE id='hon';
SELECT * FROM Board WHERE article_seq=1020;
SELECT COUNT(*) AS count FROM Board;
UPDATE Board SET title='수정업뎃',content='업뎃내용' WHERE article_seq='1020';
DELETE FROM Board WHERE article_seq='1020';