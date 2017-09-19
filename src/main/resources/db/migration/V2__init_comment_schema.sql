CREATE TABLE "comment" (
  id BIGINT PRIMARY KEY NOT NULL,
  author VARCHAR(32),
  date VARCHAR(32),
  content TEXT,
  post_id BIGINT NOT NULL
);

CREATE SEQUENCE comment_sequence START WITH 4 INCREMENT BY 1;

INSERT INTO "comment" (id, author, date, content, post_id)
VALUES
  (1, 'solairerove', 'date', 'content', 1),
  (2, 'solairerove', 'date', 'content', 1),
  (3, 'solairerove', 'date', 'content', 2);
