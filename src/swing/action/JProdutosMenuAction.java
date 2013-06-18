package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JProdutosMenuAction  extends AbstractAction {
	public static final String DEPOSITAR1 = "DEPOSITAR1";

	private JPanel principal;
	private CardLayout cards;
	
	public JProdutosMenuAction(JPanel principal, CardLayout cards) {
		super("Produtos");
		this.principal = principal;
		this.cards = cards;
	}
	 
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, DEPOSITAR1);
	}
}