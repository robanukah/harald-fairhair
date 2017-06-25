CREATE TABLE IF NOT EXISTS "post" (
  id SERIAL NOT NULL PRIMARY KEY,
  title TEXT NOT NULL,
  author TEXT NOT NULL,
  date TEXT NOT NULL,
  content TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS "user" (
  id SERIAL NOT NULL PRIMARY KEY,
  username VARCHAR(64) NOT NULL,
  password VARCHAR(64) NOT NULL,
  first_name VARCHAR(64) NOT NULL,
  last_name VARCHAR(64) NOT NULL,
  email VARCHAR(64) NOT NULL
);

CREATE TYPE "authority_name" AS ENUM ('ROLE_USER', 'ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS "authority" (
  id SERIAL NOT NULL PRIMARY KEY,
  name authority_name NOT NULL
);

CREATE TABLE IF NOT EXISTS "user_authority" (
  id SERIAL NOT NULL PRIMARY KEY,
  user_id INT NOT NULL REFERENCES "user" (id) ON UPDATE CASCADE ON DELETE CASCADE,
  authority_id INT NOT NULL REFERENCES authority (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT uk_user_authority_id UNIQUE (user_id, authority_id)
);

INSERT INTO "user" (id, username, password, first_name, last_name, email)
VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com');

INSERT INTO "user" (id, username, password, first_name, last_name, email)
VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com');

INSERT INTO "authority" (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO "authority" (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO "user_authority" (user_id, authority_id) VALUES (1, 1);
INSERT INTO "user_authority" (user_id, authority_id) VALUES (1, 2);
INSERT INTO "user_authority" (user_id, authority_id) VALUES (2, 1);
