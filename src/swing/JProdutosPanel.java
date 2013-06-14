package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel; 

//import swing.action.JDepositarPanelAction;
//import swing.action.JDepositarPanelCloseAction;
final class MyTableModel extends AbstractTableModel {
	
	/*
	
	/**
     * Creates new form Resultados
     */
    public Resultados(ResultSet resultSet) throws SQLException {
        initComponents();
        ResultSetMetaData metaDados = resultSet.getMetaData();
        Object[][] dados;
        Object[] nomeColunas;
        int numeroColunas = metaDados.getColumnCount();
        int numeroLinhas = 0;
        do {
            numeroLinhas++;
        } while (resultSet.next());
        resultSet.first();
        nomeColunas = new String[numeroColunas];
        for (int i = 1; i <= numeroColunas; i++) {
            nomeColunas[i-1]=metaDados.getColumnName(i);
        }
        resultSet.beforeFirst();
        dados = new Object[numeroLinhas][numeroColunas];
        for (int row = 0; row < numeroLinhas; row++) {
            resultSet.next();
            for (int col = 0; col < numeroColunas; col++) {
                dados[row][col] = resultSet.getObject(col+1);
            }
        }
        resultSet.first();
        /*do {
            int row = 0;
            for (int col = 1; col <= numeroColunas; col++) {
                dados[col-1][row] = resultSet.getObject(col);
            }
            row++;
        } while (resultSet.next());*/
        jTable1.setModel(new DefaultTableModel(dados, nomeColunas));
        setVisible(true);
    }
	
	*/
	
    private String[] columnNames =  {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
    private Object[][] data = {
		    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }
 
    
}
@SuppressWarnings("serial")
public class JProdutosPanel extends JPanel {

	JTextField valor;
	public JProdutosPanel(JPanel principal, CardLayout cards) {
		 
		
		JTable table = new JTable(new MyTableModel());
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		add(scrollPane);
//		Setting and Changing Column Widths
//		TableColumn column = null;
//		for (int i = 0; i < 5; i++) {
//		    column = table.getColumnModel().getColumn(i);
//		    if (i == 2) {
//		        column.setPreferredWidth(100); //third column is bigger
//		    } else {
//		        column.setPreferredWidth(50);
//		    }
//		}
		
		
		add(new JLabel("Valor R$"));
		valor = new JTextField(8);
		add(valor);
//		add(new JButton(new JDepositarPanelAction(principal, cards, valor)));
//		add(new JButton(new JDepositarPanelCloseAction(principal, cards)));
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		System.out.printf("JDepositarPanel::setVisible %b\n", aFlag);
		valor.setText("");
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
