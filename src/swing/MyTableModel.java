package swing;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import produtos.Carrinho;
import produtos.CarrinhoDAO;

public final class MyTableModel extends AbstractTableModel {

	 
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

	private String[] columnNames = {"Titulo", "Descricao", "Preco" ,"Quantidade"};

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
			return c.getTitulo();
		case 1:
			return c.getDescricao();
		case 2:
			return c.getPreco();
		case 3:
			return c.getQtdNoCarrinho(); 
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
