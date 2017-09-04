CREATE TABLE "post" (
  id BIGINT PRIMARY KEY NOT NULL,
  title TEXT NOT NULL,
  author TEXT NOT NULL,
  date TEXT NOT NULL,
  content TEXT NOT NULL
);

CREATE SEQUENCE post_sequence START WITH 1 INCREMENT BY 1;

INSERT INTO "post" (id, title, author, date, content)
VALUES (1, 'title', 'author', 'date', 'content');
