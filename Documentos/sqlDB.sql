
-- DROP DATABASE produtos_lp2_leo;

CREATE DATABASE produtos_lp2_leo
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Portuguese_Brazil.1252'
       LC_CTYPE = 'Portuguese_Brazil.1252'
       CONNECTION LIMIT = -1;

-- Table: carrinho

-- DROP TABLE carrinho;

CREATE TABLE carrinho
(
  id_carrinho serial NOT NULL,
  datacadastro timestamp without time zone,
  CONSTRAINT carrinho_pkey PRIMARY KEY (id_carrinho)
)
 
-- Table: produto

-- DROP TABLE produto;

CREATE TABLE produto
(
  id_produto serial NOT NULL,
  titulo character varying(200),
  descricao text,
  preco numeric(15,2),
  datacadastro timestamp without time zone,
  CONSTRAINT produto_pkey PRIMARY KEY (id_produto)
)
 
  -- Table: produtocarrinho

-- DROP TABLE produtocarrinho;

CREATE TABLE produtocarrinho
(
  id_produtocarrinho serial NOT NULL,
  id_carrinho integer,
  id_produto integer,
  CONSTRAINT produtocarrinho_pkey PRIMARY KEY (id_produtocarrinho),
  CONSTRAINT produtocarrinho_id_carrinho_fkey FOREIGN KEY (id_carrinho)
      REFERENCES carrinho (id_carrinho) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT produtocarrinho_id_produto_fkey FOREIGN KEY (id_produto)
      REFERENCES produto (id_produto) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
 
