--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3 (Debian 11.3-1.pgdg90+1)
-- Dumped by pg_dump version 11.3 (Debian 11.3-1.pgdg90+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: public; Type: SCHEMA; Schema: -; Owner: docker
--

-- CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO docker;

--
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: docker
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: docker
--

CREATE SEQUENCE public.hibernate_sequence
    START WITH 16
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO docker;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: jobs; Type: TABLE; Schema: public; Owner: docker
--

CREATE TABLE public.jobs (
    id bigint NOT NULL,
    date timestamp without time zone,
    title character varying(255),
    user_id bigint
);


ALTER TABLE public.jobs OWNER TO docker;

--
-- Name: role; Type: TABLE; Schema: public; Owner: docker
--

CREATE TABLE public.role (
    id bigint NOT NULL,
    code character varying(255),
    name character varying(255)
);


ALTER TABLE public.role OWNER TO docker;

--
-- Name: user_roles; Type: TABLE; Schema: public; Owner: docker
--

CREATE TABLE public.user_roles (
    users_id bigint NOT NULL,
    roles_id bigint NOT NULL
);


ALTER TABLE public.user_roles OWNER TO docker;

--
-- Name: users; Type: TABLE; Schema: public; Owner: docker
--

CREATE TABLE public.users (
    id bigint NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE public.users OWNER TO docker;

--
-- Data for Name: jobs; Type: TABLE DATA; Schema: public; Owner: docker
--

-- COPY public.jobs (id, date, title, user_id) FROM stdin;
-- 1	2019-05-27 15:59:12.603911	story3.docx	1
-- 2	2019-05-27 15:59:12.603911	new-sotry.docx	2
-- 3	2019-05-28 15:59:12.603911	story.docx	3
-- 4	2019-05-28 15:59:12.603911	story2.docx	4
-- 5	2019-05-28 15:59:12.603911	story3.docx	5
-- 6	2019-05-29 15:59:12.603911	story3.docx	6
-- 7	2019-05-29 15:59:12.603911	story3.docx	6
-- 8	2019-05-29 15:59:12.603911	story3.docx	7
-- \.
INSERT INTO public.jobs (id, date, title, user_id) values (1, (NOW() - INTERVAL '1 DAYS'), 'work1.docx', 1);
INSERT INTO public.jobs (id, date, title, user_id) values (2, (NOW() - INTERVAL '1 DAYS'), 'work2.docx', 2);
INSERT INTO public.jobs (id, date, title, user_id) values (3, (NOW() - INTERVAL '1 DAYS'), 'work3.docx', 3);
INSERT INTO public.jobs (id, date, title, user_id) values (4, (NOW() - INTERVAL '1 DAYS'), 'work4.docx', 4);
INSERT INTO public.jobs (id, date, title, user_id) values (5, (NOW() - INTERVAL '1 DAYS'), 'work5.docx', 5);


INSERT INTO public.jobs (id, date, title, user_id) values (6, (NOW() - INTERVAL '2 DAYS'), 'work6.docx', 6);
INSERT INTO public.jobs (id, date, title, user_id) values (7, (NOW() - INTERVAL '2 DAYS'), 'work7.docx', 7);
INSERT INTO public.jobs (id, date, title, user_id) values (8, (NOW() - INTERVAL '2 DAYS'), 'work8.docx', 1);
INSERT INTO public.jobs (id, date, title, user_id) values (9, (NOW() - INTERVAL '2 DAYS'), 'work9.docx', 2);

INSERT INTO public.jobs (id, date, title, user_id) values (10, (NOW() - INTERVAL '3 DAYS'), 'work10.docx', 3);
INSERT INTO public.jobs (id, date, title, user_id) values (11, (NOW() - INTERVAL '3 DAYS'), 'work11.docx', 4);
INSERT INTO public.jobs (id, date, title, user_id) values (12, (NOW() - INTERVAL '3 DAYS'), 'work12.docx', 5);

INSERT INTO public.jobs (id, date, title, user_id) values (13, (NOW() - INTERVAL '4 DAYS'), 'work13.docx', 6);
INSERT INTO public.jobs (id, date, title, user_id) values (14, (NOW() - INTERVAL '4 DAYS'), 'work14.docx', 7);

INSERT INTO public.jobs (id, date, title, user_id) values (15, (NOW() - INTERVAL '5 DAYS'), 'work15.docx', 1);



--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: docker
--

COPY public.role (id, code, name) FROM stdin;
2	admin	admin
3	user	user
\.


--
-- Data for Name: user_roles; Type: TABLE DATA; Schema: public; Owner: docker
--

COPY public.user_roles (users_id, roles_id) FROM stdin;
1	2
1	3
2	3
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: docker
--

COPY public.users (id, login, password) FROM stdin;
1	tomek	$2a$10$wb2bCJss3flkLUCpq6D5GemoANM9jwaIrt7mNTAjo5UFt2P77ruwK
2	tomek2	$2a$10$wb2bCJss3flkLUCpq6D5GemoANM9jwaIrt7mNTAjo5UFt2P77ruwK
3	tomek3	\N
4	tomek4	\N
5	tomek5	\N
6	tomek6	\N
7	tomek7	\N
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: docker
--

SELECT pg_catalog.setval('public.hibernate_sequence', 3, true);


--
-- Name: jobs jobs_pkey; Type: CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT jobs_pkey PRIMARY KEY (id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id);


--
-- Name: users uk_ow0gan20590jrb00upg3va2fn; Type: CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT uk_ow0gan20590jrb00upg3va2fn UNIQUE (login);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_roles fkj9553ass9uctjrmh0gkqsmv0d; Type: FK CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkj9553ass9uctjrmh0gkqsmv0d FOREIGN KEY (roles_id) REFERENCES public.role(id);


--
-- Name: user_roles fkoovdgg7vvr1hb8vw6ivcrv3tb; Type: FK CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.user_roles
    ADD CONSTRAINT fkoovdgg7vvr1hb8vw6ivcrv3tb FOREIGN KEY (users_id) REFERENCES public.users(id);


--
-- Name: jobs fkra3g6pshf0p0hv5aisuh3weg8; Type: FK CONSTRAINT; Schema: public; Owner: docker
--

ALTER TABLE ONLY public.jobs
    ADD CONSTRAINT fkra3g6pshf0p0hv5aisuh3weg8 FOREIGN KEY (user_id) REFERENCES public.users(id);


--
-- PostgreSQL database dump complete
--

DROP SEQUENCE IF EXISTS public.hibernate_sequence;
CREATE SEQUENCE public.hibernate_sequence START 16;
