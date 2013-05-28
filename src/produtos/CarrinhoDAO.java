package produtos;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CarrinhoDAO {

	private static final String selectProdutos = "select * from produto where descricao ilike '%?%' or titulo ilike '%?%';";
	private static final String selectCarrinho =
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
"  produto.id_produto = produtocarrinho.id_produto and  " +
"  carrinho.id_carrinho = ? ";


	private static final String criaCarrinho = "INSERT INTO carrinho(datacadastro) VALUES (  ?);";
	private static final String insertProdutoCarrinho = "INSERT INTO produtocarrinho(id_carrinho, id_produto, qtd)VALUES ( ?, ?, ?);";

	/**
	 * Retorna um objeto com a lista de Produtos do carrinho com o <code>id</code> 
	 * e com a senha <code>senha</code>.
	 *
	 * @param id_carrinho
	 *            o id do carrinho, não pode ser null.
	 *
	 * @return null caso o id do carrinho não exista, caso contrário, retorna
	 *         um objeto Carrinho com a lista de itens do carrinho
	 *
	 */
	public List<Carrinho> selectCarrinho(Integer id_carrinho) {
		if (id_carrinho == null) {
			throw new IllegalArgumentException(
					"O cod do Carrinho não pode ser null.");
		}

		Carrinho c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		List<Carrinho> carrinho = new ArrayList<Carrinho>();
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/produtos_lp2_leo", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectCarrinho);
			stmt.setInt(1, id_carrinho);
			rs = stmt.executeQuery();
			if (rs.next()) {
				c = new Carrinho();
				c.setIdProduto(rs.getInt("id_produto"));
				c.setQtdNoCarrinho(rs.getInt("qtd_no_carrinho"));
				c.setIdProdutoCarrinho(rs.getInt("id_produtocarrinho"));
				c.setQtdProdutos(rs.getInt("qtd_produtos"));
				c.setIdCarrinho(rs.getInt("id_carrinho"));
				c.setTitulo(rs.getString("titulo"));
				c.setDescricao(rs.getString("descricao"));
				c.setPreco(rs.getDouble("preco"));
				c.setDataCadastroCarrinho(rs.getString("datacadastrocarrinho"));

				carrinho.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return carrinho;
	}
	
	/**
	 * Retorna um objeto com a lista de Produtos do carrinho com o <code>id</code> 
	 * e com a senha <code>senha</code>.
	 *
	 * @param id_carrinho
	 *            o id do carrinho, não pode ser null.
	 *
	 * @return null caso o id do carrinho não exista, caso contrário, retorna
	 *         um objeto Carrinho com a lista de itens do carrinho
	 *
	 */
	public List<Carrinho> selectCarrinho(Integer id_carrinho) {
		if (id_carrinho == null) {
			throw new IllegalArgumentException(
					"O cod do Carrinho não pode ser null.");
		}

		Carrinho c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		List<Carrinho> carrinho = new ArrayList<Carrinho>();
		try {
			con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/produtos_lp2_leo", "postgres",
					"senacrs");

			stmt = con.prepareStatement(selectCarrinho);
			stmt.setInt(1, id_carrinho);
			rs = stmt.executeQuery();
			if (rs.next()) {
				c = new Carrinho();
				c.setIdProduto(rs.getInt("id_produto"));
				c.setQtdNoCarrinho(rs.getInt("qtd_no_carrinho"));
				c.setIdProdutoCarrinho(rs.getInt("id_produtocarrinho"));
				c.setQtdProdutos(rs.getInt("qtd_produtos"));
				c.setIdCarrinho(rs.getInt("id_carrinho"));
				c.setTitulo(rs.getString("titulo"));
				c.setDescricao(rs.getString("descricao"));
				c.setPreco(rs.getDouble("preco"));
				c.setDataCadastroCarrinho(rs.getString("datacadastrocarrinho"));

				carrinho.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa cliente
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					stmt.close();
				}
				if (con != null) {
					stmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				// FIXME: comunicar erro ao programa cliente
			}
		}
		return carrinho;
	}


	public static void main(String[] args) {
		CarrinhoDAO car = new CarrinhoDAO();
	System.out.println(car.selectCarrinho(1));
//		List<Carrinho> c = car.selectCarrinho("1");
//		if (c == null) {
//			System.out.println("Conta não encontrada!");
//		} else {
//			System.out.println(c);
//			car.depositar(c, 112.45);
//			System.out.println(car.consultarExtrato(c));
//		}
	}

}
