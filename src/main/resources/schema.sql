DROP TABLE IF EXISTS "post" CASCADE;

DROP SEQUENCE IF EXISTS hibernate_sequence CASCADE;

CREATE TABLE IF NOT EXISTS "post" (
  id BIGINT PRIMARY KEY NOT NULL,
  title TEXT NOT NULL,
  author TEXT NOT NULL,
  date TEXT NOT NULL,
  content TEXT NOT NULL
);

-- CREATE TABLE IF NOT EXISTS "JWT_USER" (
--   id SERIAL NOT NULL PRIMARY KEY,
--   username VARCHAR(64) NOT NULL,
--   password VARCHAR(64) NOT NULL,
--   first_name VARCHAR(64) NOT NULL,
--   last_name VARCHAR(64) NOT NULL,
--   email VARCHAR(64) NOT NULL,
--   enabled BOOLEAN NOT NULL,
--   last_password_reset_date TIMESTAMP NOT NULL
-- );
--
-- CREATE TYPE "AUTHORITY_NAME" AS ENUM ('ROLE_USER', 'ROLE_ADMIN');
--
-- CREATE TABLE IF NOT EXISTS "AUTHORITY" (
--   id SERIAL NOT NULL PRIMARY KEY,
--   name "AUTHORITY_NAME" NOT NULL
-- );
--
-- CREATE TABLE IF NOT EXISTS "USER_AUTHORITY" (
--   id SERIAL NOT NULL PRIMARY KEY,
--   jwt_user_id INT NOT NULL REFERENCES "JWT_USER" (id) ON UPDATE CASCADE ON DELETE CASCADE,
--   authority_id INT NOT NULL REFERENCES "AUTHORITY" (id) ON UPDATE CASCADE ON DELETE CASCADE,
--   CONSTRAINT uk_user_authority_id UNIQUE (jwt_user_id, authority_id)
-- );
