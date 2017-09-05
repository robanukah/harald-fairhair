CREATE TABLE "post" (
  id BIGINT PRIMARY KEY NOT NULL,
  title VARCHAR(128) NOT NULL,
  author VARCHAR(32),
  date VARCHAR(32),
  content TEXT
);

CREATE SEQUENCE post_sequence START WITH 3 INCREMENT BY 1;

INSERT INTO "post" (id, title, author, date, content)
VALUES
  (1, 'title', 'solairerove', 'date', 'content'),
  (2, 'title', 'solairerove', 'date', 'content');
