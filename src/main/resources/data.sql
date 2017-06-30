INSERT INTO "JWT_USER" (id, username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES
  (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com', 1,
   PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));

INSERT INTO "JWT_USER" (id, username, password, first_name, last_name, email, enabled, last_password_reset_date)
VALUES
  (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com', 1,
   PARSEDATETIME('01-01-2016', 'dd-MM-yyyy'));

INSERT INTO "AUTHORITY" (id, name) VALUES (1, 'ROLE_USER');
INSERT INTO "AUTHORITY" (id, name) VALUES (2, 'ROLE_ADMIN');

INSERT INTO "USER_AUTHORITY" (jwt_user_id, authority_id) VALUES (1, 1);
INSERT INTO "USER_AUTHORITY" (jwt_user_id, authority_id) VALUES (1, 2);
INSERT INTO "USER_AUTHORITY" (jwt_user_id, authority_id) VALUES (2, 1);

INSERT INTO "POST" (id, title, author, date, content)
VALUES (1, 'title', 'author', 'date', 'content');
