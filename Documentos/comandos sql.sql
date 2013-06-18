-- busca dos produtos
select * from produto where descricao ilike '%comp%' or titulo ilike '%comp%';


-- insersao do produto.

INSERT INTO produto(  titulo, descricao, preco, datacadastro)
    VALUES ( '100 Canetas brancas','10 canetas brancas com cores variadas', 29.90, '2013-05-17 10:25:56');


-- inserindo um novo carrinho
INSERT INTO carrinho(  datacadastro)
    VALUES (  ?);

-- inserindo um novo item no carrinho
INSERT INTO produtocarrinho(
             id_carrinho, id_produto, qtd)
    VALUES ( ?, ?, ?);


-- consulta para carrinho de compras.

CREATE OR REPLACE VIEW carrinhoview AS 
 SELECT produto.id_produto, produto.titulo, produto.descricao, produto.preco, 
    produtocarrinho.qtd AS qtd_no_carrinho, produtocarrinho.id_produtocarrinho, 
    produto.qtd AS qtd_produtos, carrinho.id_carrinho, 
    carrinho.datacadastro AS datacadastrocarrinho
   FROM carrinho, produto, produtocarrinho
  WHERE carrinho.id_carrinho = produtocarrinho.id_carrinho AND produto.id_produto = produtocarrinho.id_produto;
