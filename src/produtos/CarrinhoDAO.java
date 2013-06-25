package produtos;

import java.util.ArrayList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.util.Properties;


public class CarrinhoDAO {

	private static final String selectProdutos = "select * from produto where descricao ilike '%?%' or titulo ilike '%?%';";
	private static final String selectCarrinho ="SELECT * from  CarrinhoView   WHERE   id_carrinho = ? ";
	private static final String selectTotalCarrinho ="SELECT sum(preco*qtd_no_carrinho) from  CarrinhoView   WHERE   id_carrinho = ? ";


	private static final String criaCarrinho = "INSERT INTO carrinho(datacadastro) VALUES (  ?);";
	private static final String insertProdutoCarrinho = "INSERT INTO produtocarrinho(id_carrinho, id_produto, qtd)VALUES ( ?, ?, ?);";

	/**
	 * Retorna um objeto com a lista de Produtos do carrinho com o <code>id</code> 
	 * e com a senha <code>senha</code>.
	 *
	 * @param id_carrinho
	 *            o id do carrinho, n�o pode ser null.
	 *
	 * @return null caso o id do carrinho n�o exista, caso contr�rio, retorna
	 *         um objeto Carrinho com a lista de itens do carrinho
	 *
	 */
	public List<Carrinho> selectCarrinho(Integer id_carrinho) {
		if (id_carrinho == null) {
			throw new IllegalArgumentException(
					"O cod do Carrinho n�o pode ser null.");
		}

		Carrinho c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		List<Carrinho> carrinho = new ArrayList<Carrinho>();
		try {
			con = connect();

			stmt = con.prepareStatement(selectCarrinho);
			stmt.setInt(1, id_carrinho);
			rs = stmt.executeQuery();
			while (rs.next()) {
				c = new Carrinho();
				c.setIdProduto(rs.getInt("id_produto"));
				c.setQtdNoCarrinho(rs.getInt("qtd_no_carrinho"));
				c.setIdProdutoCarrinho(rs.getInt("id_produtocarrinho"));
				c.setQtdProdutos(rs.getInt("qtd_produtos"));
				c.setIdCarrinho(rs.getInt("id_carrinho"));
				c.setTitulo(rs.getString("titulo"));
				c.setDescricao(rs.getString("descricao"));
				c.setPreco(rs.getDouble("preco"));
				c.setDataCadastroCarrinho(rs.getDate("datacadastrocarrinho"));

				carrinho.add(c);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar Carrinho1"); 
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
				throw new RuntimeException("Erro ao fechar Conex�o.");
			}
		}
		return carrinho;
	}

	public Double getTotalCarrinho(Integer id_carrinho) {
		if (id_carrinho == null) {
			throw new IllegalArgumentException(
					"O cod do Carrinho n�o pode ser null.");
		}
 
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null; 
		try {
			con = connect();

			stmt = con.prepareStatement(selectTotalCarrinho);
			stmt.setInt(1, id_carrinho);
			rs = stmt.executeQuery();
			if (rs.next()) {
				 return rs.getDouble(1);
			}
		} catch (Exception e) {
			throw new RuntimeException("Erro ao buscar Carrinho2"); 
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
				throw new RuntimeException("Erro ao fechar Conex�o.");
			}
		}
		return 0.00;
	}

	private Connection connect() throws IOException, FileNotFoundException,SQLException {
		Connection con;
		Properties p = new Properties();
		p.load(new FileInputStream("src/conf/CarrinhoDAO.properties"));
		String url = p.getProperty("url");
 
		con = DriverManager.getConnection(url,p);
		return con;
	}
	
	 
	public Carrinho criaCarrinho() {
		 
//		Carrinho c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
//		List<Carrinho> carrinho = new ArrayList<Carrinho>();
		Carrinho car = new Carrinho();
		try {

			con = connect();

			stmt = con.prepareStatement(criaCarrinho, Statement.RETURN_GENERATED_KEYS);
			java.sql.Timestamp data = new java.sql.Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(1, data);
			int affectedRows = stmt.executeUpdate();
			 
	        if (affectedRows == 0) {
	            throw new SQLException("Erro ao criar o Carrinho, sem linhas afetadas.");
	        }

	        rs = stmt.getGeneratedKeys();
	        if (rs.next()) { 
	            car.setIdCarrinho(rs.getInt(1));
	        } else {
	            throw new SQLException("Erro ao criar o Carrinho, sem linhas afetadas.");
	        }
			 
		} catch (Exception e) {
			throw new RuntimeException("Erro ao criar Carrinho");
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
				throw new RuntimeException("Erro ao fechar Carrinho1");
			}
		}
		
		return car;
		 
	}


	public void addProdutoCarrinho(int idCarrinho, int idProduto, int quantidade) {
		 
//		Carrinho c = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;
		try {

			con = connect();

			stmt = con.prepareStatement(insertProdutoCarrinho );
//			java.sql.Timestamp data = new java.sql.Timestamp(System.currentTimeMillis());
			stmt.setInt(1, idCarrinho);
			stmt.setInt(2, idProduto);
			stmt.setInt(3, quantidade);
			int affectedRows = stmt.executeUpdate();
			 
	        if (affectedRows == 0) {
	            throw new SQLException("Erro ao adicionar carrinho, sem linhas afetadas.");
	        }

	         
			 
		} catch (Exception e) {
			throw new RuntimeException("Erro ao inserir produto no Carrinho");
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
				throw new RuntimeException("Erro ao fechar Carrinho2");
			}
		}
		
		 
	}

	public static void main(String[] args) {
		CarrinhoDAO carDAO = new CarrinhoDAO();
		Carrinho carro = carDAO.criaCarrinho();
		

		carDAO.addProdutoCarrinho(carro.getIdCarrinho(), 2, 60);
		carDAO.addProdutoCarrinho(carro.getIdCarrinho(), 3, 55);

		System.out.println(carDAO.selectCarrinho(carro.getIdCarrinho()).toString());
		
		
//		List<Carrinho> c = car.selectCarrinho("1");
//		if (c == null) {
//			System.out.println("Conta n�o encontrada!");
//		} else {
//			System.out.println(c);
//			car.depositar(c, 112.45);
//			System.out.println(car.consultarExtrato(c));
//		}
	}

}
