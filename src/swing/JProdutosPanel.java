package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import produtos.CarrinhoDAO;
import swing.action.JAdicionarPanelAction;
import swing.action.JAdicionarPanelCloseAction;

//import swing.action.JDepositarPanelAction;
//import swing.action.JDepositarPanelCloseAction;


@SuppressWarnings("serial")
public class JProdutosPanel extends JPanel {

	JTextField codigo;
	JTextField valor;

	public JProdutosPanel(JPanel principal, CardLayout cards) {

		MyTableModel model = new MyTableModel(18);
		JTable table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(scrollPane);

		add(new JLabel("Codigo"));
		codigo = new JTextField(8);
		add(codigo);
		
		add(new JLabel("Valor Total"));
		valor = new JTextField(8);
		add(valor);

		CarrinhoDAO carDAO = new CarrinhoDAO();
		valor.setText(carDAO.getTotalCarrinho(18).toString());
		
		 add(new JButton(new JAdicionarPanelAction(principal, cards, codigo,model,valor)));
		 add(new JButton(new JAdicionarPanelCloseAction(principal, cards)));
	}

	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JDepositarPanel::setVisible %b\n", aFlag);
		codigo.setText("");
	}

	public JProdutosPanel() {
		this(null, null);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Banco Pindorama - Teste do Painel Depositar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JProdutosPanel();
		frame.getContentPane().add(painel);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
