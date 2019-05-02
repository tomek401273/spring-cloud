-- DROP TABLE IF EXISTS roles;
-- DROP TABLE IF EXISTS users;
-- DROP TABLE IF EXISTS user_roles;

--  CREATE TABLE users
--  (
--    id bigint NOT NULL,
--    login character varying(255),
--    password character varying(255),
--    CONSTRAINT users_pkey PRIMARY KEY (id),
--    CONSTRAINT uk_ow0gan20590jrb00upg3va2fn UNIQUE (login)
--  );
--
--  CREATE TABLE roles
--  (
--    id bigint NOT NULL,
--    code character varying(255),
--    name character varying(255),
--    CONSTRAINT roles_pkey PRIMARY KEY (id)
--  )
--
--  CREATE TABLE user_roles
--  (
--    users_id bigint NOT NULL,
--    roles_id bigint NOT NULL,
--    CONSTRAINT fkdbv8tdyltxa1qjmfnj9oboxse FOREIGN KEY (roles_id)
--        REFERENCES roles (id) MATCH SIMPLE
--        ON UPDATE NO ACTION ON DELETE NO ACTION,
--    CONSTRAINT fkoovdgg7vvr1hb8vw6ivcrv3tb FOREIGN KEY (users_id)
--        REFERENCES users (id) MATCH SIMPLE
--        ON UPDATE NO ACTION ON DELETE NO ACTION
--  )

 INSERT INTO users(
             id, login, password)
     VALUES (1, 'tomek', '$2a$10$wb2bCJss3flkLUCpq6D5GemoANM9jwaIrt7mNTAjo5UFt2P77ruwK');

 INSERT INTO roles(
             id, code, name)
     VALUES (1, 'admin', 'admin');

 INSERT INTO roles(
             id, code, name)
     VALUES (2, 'user', 'user');

INSERT INTO user_roles(
            users_id, roles_id)
    VALUES (1, 1);

INSERT INTO user_roles(
            users_id, roles_id)
    VALUES (2, 2);

