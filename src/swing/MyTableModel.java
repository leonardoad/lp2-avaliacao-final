package swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import produtos.Carrinho;
import produtos.CarrinhoDAO;

public final class MyTableModel extends AbstractTableModel {

	// /**
	// * Creates new form Resultados
	// */
	// public Resultados(ResultSet resultSet) throws SQLException {
	// initComponents();
	// ResultSetMetaData metaDados = resultSet.getMetaData();
	// Object[][] dados;
	// Object[] nomeColunas;
	// int numeroColunas = metaDados.getColumnCount();
	// int numeroLinhas = 0;
	// do {
	// numeroLinhas++;
	// } while (resultSet.next());
	// resultSet.first();
	// nomeColunas = new String[numeroColunas];
	// for (int i = 1; i <= numeroColunas; i++) {
	// nomeColunas[i-1]=metaDados.getColumnName(i);
	// }
	// resultSet.beforeFirst();
	// dados = new Object[numeroLinhas][numeroColunas];
	// for (int row = 0; row < numeroLinhas; row++) {
	// resultSet.next();
	// for (int col = 0; col < numeroColunas; col++) {
	// dados[row][col] = resultSet.getObject(col+1);
	// }
	// }
	// resultSet.first();
	// /*do {
	// int row = 0;
	// for (int col = 1; col <= numeroColunas; col++) {
	// dados[col-1][row] = resultSet.getObject(col);
	// }
	// row++;
	// } while (resultSet.next());*/
	// jTable1.setModel(new DefaultTableModel(dados, nomeColunas));
	// setVisible(true);
	// }
	int id;

	public MyTableModel(int id) {
		this.id = id;
		atualizar();

	}

	public void atualizar() {
		CarrinhoDAO carDAO = new CarrinhoDAO();
		carrinho = carDAO.selectCarrinho(id);
		fireTableDataChanged();
	}

	private String[] columnNames = { "descricao", "preco" };

	private List<Carrinho> carrinho;

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return carrinho.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {

		System.out.println(row);
		Carrinho c = carrinho.get(row);
		switch (col) {
		case 0:
			return c.getDescricao();
		case 1:
			return c.getPreco();
		default:
			return null;
		}
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

}
