--
-- PostgreSQL database dump
--

-- Dumped from database version 9.2.2
-- Dumped by pg_dump version 9.2.2
-- Started on 2013-05-28 10:41:34

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1950 (class 1262 OID 41276)
-- Name: produtos_lp2_leo; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE produtos_lp2_leo WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';


ALTER DATABASE produtos_lp2_leo OWNER TO postgres;

\connect produtos_lp2_leo

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 174 (class 3079 OID 11727)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1953 (class 0 OID 0)
-- Dependencies: 174
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 41290)
-- Name: carrinho; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE carrinho (
    id_carrinho integer NOT NULL,
    datacadastro timestamp without time zone
);


ALTER TABLE public.carrinho OWNER TO postgres;

--
-- TOC entry 170 (class 1259 OID 41288)
-- Name: carrinho_id_carrinho_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE carrinho_id_carrinho_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.carrinho_id_carrinho_seq OWNER TO postgres;

--
-- TOC entry 1954 (class 0 OID 0)
-- Dependencies: 170
-- Name: carrinho_id_carrinho_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE carrinho_id_carrinho_seq OWNED BY carrinho.id_carrinho;


--
-- TOC entry 169 (class 1259 OID 41279)
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE produto (
    id_produto integer NOT NULL,
    titulo character varying(200),
    descricao text,
    preco numeric(15,2),
    datacadastro timestamp without time zone,
    qtd smallint
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- TOC entry 168 (class 1259 OID 41277)
-- Name: produto_id_produto_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produto_id_produto_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produto_id_produto_seq OWNER TO postgres;

--
-- TOC entry 1955 (class 0 OID 0)
-- Dependencies: 168
-- Name: produto_id_produto_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produto_id_produto_seq OWNED BY produto.id_produto;


--
-- TOC entry 173 (class 1259 OID 41298)
-- Name: produtocarrinho; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE produtocarrinho (
    id_produtocarrinho integer NOT NULL,
    id_carrinho integer,
    id_produto integer,
    qtd smallint
);


ALTER TABLE public.produtocarrinho OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 41296)
-- Name: produtocarrinho_id_produtocarrinho_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE produtocarrinho_id_produtocarrinho_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.produtocarrinho_id_produtocarrinho_seq OWNER TO postgres;

--
-- TOC entry 1956 (class 0 OID 0)
-- Dependencies: 172
-- Name: produtocarrinho_id_produtocarrinho_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE produtocarrinho_id_produtocarrinho_seq OWNED BY produtocarrinho.id_produtocarrinho;


--
-- TOC entry 1930 (class 2604 OID 41293)
-- Name: id_carrinho; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY carrinho ALTER COLUMN id_carrinho SET DEFAULT nextval('carrinho_id_carrinho_seq'::regclass);


--
-- TOC entry 1929 (class 2604 OID 41282)
-- Name: id_produto; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produto ALTER COLUMN id_produto SET DEFAULT nextval('produto_id_produto_seq'::regclass);


--
-- TOC entry 1931 (class 2604 OID 41301)
-- Name: id_produtocarrinho; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produtocarrinho ALTER COLUMN id_produtocarrinho SET DEFAULT nextval('produtocarrinho_id_produtocarrinho_seq'::regclass);


--
-- TOC entry 1943 (class 0 OID 41290)
-- Dependencies: 171
-- Data for Name: carrinho; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY carrinho (id_carrinho, datacadastro) FROM stdin;
1	2013-05-28 00:00:00
\.


--
-- TOC entry 1957 (class 0 OID 0)
-- Dependencies: 170
-- Name: carrinho_id_carrinho_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('carrinho_id_carrinho_seq', 1, true);


--
-- TOC entry 1941 (class 0 OID 41279)
-- Dependencies: 169
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY produto (id_produto, titulo, descricao, preco, datacadastro, qtd) FROM stdin;
1	Armário Plus	4 portas, 2m de altura	4000.00	2013-05-14 15:15:15	\N
2	Computador Intel Core 2 Duo	Inclui Monitor, Kit multimidia	1099.99	2013-05-14 15:19:15	\N
3	100 Canetas brancas	10 canetas brancas com cores variadas	29.90	2013-05-17 10:25:56	\N
\.


--
-- TOC entry 1958 (class 0 OID 0)
-- Dependencies: 168
-- Name: produto_id_produto_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produto_id_produto_seq', 3, true);


--
-- TOC entry 1945 (class 0 OID 41298)
-- Dependencies: 173
-- Data for Name: produtocarrinho; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY produtocarrinho (id_produtocarrinho, id_carrinho, id_produto, qtd) FROM stdin;
4	1	1	5
\.


--
-- TOC entry 1959 (class 0 OID 0)
-- Dependencies: 172
-- Name: produtocarrinho_id_produtocarrinho_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('produtocarrinho_id_produtocarrinho_seq', 4, true);


--
-- TOC entry 1935 (class 2606 OID 41295)
-- Name: carrinho_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY carrinho
    ADD CONSTRAINT carrinho_pkey PRIMARY KEY (id_carrinho);


--
-- TOC entry 1933 (class 2606 OID 41287)
-- Name: produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id_produto);


--
-- TOC entry 1937 (class 2606 OID 41303)
-- Name: produtocarrinho_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY produtocarrinho
    ADD CONSTRAINT produtocarrinho_pkey PRIMARY KEY (id_produtocarrinho);


--
-- TOC entry 1938 (class 2606 OID 41314)
-- Name: produtocarrinho_id_carrinho_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produtocarrinho
    ADD CONSTRAINT produtocarrinho_id_carrinho_fkey FOREIGN KEY (id_carrinho) REFERENCES carrinho(id_carrinho);


--
-- TOC entry 1939 (class 2606 OID 41319)
-- Name: produtocarrinho_id_produto_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY produtocarrinho
    ADD CONSTRAINT produtocarrinho_id_produto_fkey FOREIGN KEY (id_produto) REFERENCES produto(id_produto);


--
-- TOC entry 1952 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-05-28 10:41:34

--
-- PostgreSQL database dump complete
--

