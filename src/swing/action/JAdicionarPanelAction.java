package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import produtos.CarrinhoDAO;
import swing.JProdutosPanel;
import swing.MyTableModel;

@SuppressWarnings("serial")
public class JAdicionarPanelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;
	private MyTableModel model;

	private JTextField codigo;
	private JTextField valor;

	public JAdicionarPanelAction(JPanel principal, CardLayout cards,
			JTextField codigo,MyTableModel model,JTextField valor) {
		super("Adicionar");
		this.principal = principal;
		this.cards = cards;
		this.codigo = codigo;
		this.model = model;
		this.valor = valor;
	}

	// @Override
	public void actionPerformed(ActionEvent e) {
		CarrinhoDAO carDAO = new CarrinhoDAO();
		carDAO.addProdutoCarrinho(18, Integer.parseInt(codigo.getText()), 1);

		model.atualizar();
		
		
		
		valor.setText(carDAO.getTotalCarrinho(18).toString());
		// FIXME atualizar a lista

	}
}
