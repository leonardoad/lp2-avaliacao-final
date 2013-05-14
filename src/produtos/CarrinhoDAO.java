package produtos;

import java.util.ArrayList;

public class CarrinhoDAO {

	private static String PRODUTOS = "select * from produto where descricao ilike '%?%' or titulo ilike '%?%';";
	private static String CARRINHO =
		"SELECT "+
 " produto.id_produto, "+
 " produto.titulo, "+
 " produto.descricao, "+
 " produto.preco, "+
 " produtocarrinho.qtd AS qtd_no_carrinho, "+
 " produtocarrinho.id_produtocarrinho, "+
 " produto.qtd AS qtd_produtos, "+
 " carrinho.id_carrinho, "+
 " carrinho.datacadastro AS datacadastrocarrinho "+
" FROM "+
 " public.carrinho, "+
 " public.produto, "+
 " public.produtocarrinho "+
" WHERE "+
"  carrinho.id_carrinho = produtocarrinho.id_carrinho AND "+
"  produto.id_produto = produtocarrinho.id_produto  " +
"  carrinho.id_carrinho = ? ";


	private static String CRIA_CARRINHO = "INSERT INTO carrinho(datacadastro) VALUES (  ?);";
	private static String ADD_ITEM_CARRINHO = "INSERT INTO produtocarrinho(id_carrinho, id_produto, qtd)VALUES ( ?, ?, ?);";


	public ArrayList<Produto> getProdutos(String consulta) {

		//consultar do banco os produtos



		return null;

	}

}
