select * from produto where descricao ilike '%comp%' or titulo ilike '%comp%';

INSERT INTO produto(  titulo, descricao, preco, datacadastro)
    VALUES ( '100 Canetas brancas','10 canetas brancas com cores variadas', 29.90, '2013-05-17 10:25:56');