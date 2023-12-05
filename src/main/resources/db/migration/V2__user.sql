INSERT INTO "user"(id, email, password, username, is_credentials_non_expired, is_enabled, is_non_expired, is_non_locked)
VALUES
(1, 'email@test.com', 'password', 'testuser', true, true, true, true);

INSERT INTO role(id, name)
VALUES
(1, 'ADMIN'),
(2, 'ADVANCED'),
(3, 'BASE');