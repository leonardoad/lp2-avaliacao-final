package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import swing.action.JAboutMenuAction;
import swing.action.JProdutosMenuAction;
import swing.action.JSairMenuAction;

public class Carrinho {
	public static final String PRINCIPAL = "PRINCIPAL";

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Banco Pindorama - Caixa Eletrônico");
		frame.setBounds(0, 0, 300, 600);
		CardLayout cards = new CardLayout();
		//http://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
		JPanel principal = new JPanel(cards);

//		JPanel consultarExtrato = new JConsultarExtratoPanel(principal, cards);
		JPanel depositar = new JProdutosPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel("Carrinho de compras.");
		vazio.add(label);
		
		principal.add(vazio, PRINCIPAL);
		principal.add(depositar, JProdutosMenuAction.DEPOSITAR1); 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("icon.jpg").getImage());
		
		frame.getContentPane().add(principal);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu terminal = new JMenu("Terminal");
		menubar.add(terminal);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);
		
		Action exitAction = new JSairMenuAction();
		file.add(exitAction);
		
		 
		Action depositarAction = new JProdutosMenuAction(principal,cards);
		terminal.add(depositarAction);		
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);

		frame.setJMenuBar(menubar);
		
		frame.setMinimumSize(new Dimension(400,200));

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
