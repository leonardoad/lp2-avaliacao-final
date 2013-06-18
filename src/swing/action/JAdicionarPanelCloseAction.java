package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.Carrinho;

@SuppressWarnings("serial")
public class JAdicionarPanelCloseAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JAdicionarPanelCloseAction(JPanel principal, CardLayout cards) {
		super("Fechar");
		this.principal = principal;
		this.cards = cards;
	}

 
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			cards.show(principal, Carrinho.PRINCIPAL);
		}

	}
}
