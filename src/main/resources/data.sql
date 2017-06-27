INSERT INTO jwt_user (id, username, password, first_name, last_name, email)
VALUES (1, 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', 'admin', 'admin', 'admin@admin.com');

INSERT INTO jwt_user (id, username, password, first_name, last_name, email)
VALUES (2, 'user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'user', 'user', 'enabled@user.com');

INSERT INTO "authority" (ID, NAME) VALUES (1, 'ROLE_USER');
INSERT INTO "authority" (ID, NAME) VALUES (2, 'ROLE_ADMIN');

INSERT INTO "user_authority" (jwt_user_id, authority_id) VALUES (1, 1);
INSERT INTO "user_authority" (jwt_user_id, authority_id) VALUES (1, 2);
INSERT INTO "user_authority" (jwt_user_id, authority_id) VALUES (2, 1);
