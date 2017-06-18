CREATE TABLE post (
  id SERIAL,
  title TEXT NOT NULL,
  author TEXT NOT NULL,
  date TEXT NOT NULL,
  content TEXT NOT NULL,
  CONSTRAINT pk_posst_id PRIMARY KEY (id)
);
