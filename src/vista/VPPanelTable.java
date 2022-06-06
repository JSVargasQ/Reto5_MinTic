/**
 ----- Autores ------
 * Andres David Gonzalez Murcia
 * Juan Sebastian Vargas Quintero
 * Erika Nathalia Gama
 Ciclo 2 - Grupo 6
 */
package vista;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VPPanelTable extends JPanel {

	// ============================================
	// Attributes
	// ============================================

	private String[] columns = { "Referencia", "Nombre", "Categoria", "Valor compra", "Valor venta", "Cantidad" };

	private DefaultTableModel defaultTableModel;
	private JTable table;

	// ============================================
	// Constructor
	// ============================================

	public VPPanelTable() {
		this.setVisible(true);
		this.setLayout(new GridLayout(1, 1));
		this._inicializarComponentes();
	}

	// ============================================
	// Public methods
	// ============================================
	
	public void cargarDatos(ArrayList<String[]> data) {
		String[][] auxData = new String[data.size()][6];
		
		for ( int i = 0; i < data.size(); i++ ) {
			auxData[i][0] = data.get(i)[0];
			auxData[i][1] = data.get(i)[1];
			auxData[i][2] = data.get(i)[2];
			auxData[i][3] = data.get(i)[3];
			auxData[i][4] = data.get(i)[4];
			auxData[i][5] = data.get(i)[5];
		}
		
		this.defaultTableModel = new DefaultTableModel(auxData, this.columns);
		this.table.setModel(this.defaultTableModel);
	}

	// ============================================
	// Private methods
	// ============================================

	private void _inicializarComponentes() {
		// Init JTable with empty information
		this.defaultTableModel = new DefaultTableModel(null, this.columns);
		this.table = new JTable(defaultTableModel);

		// Create & add scroll pane
		JScrollPane scrollPane = new JScrollPane(table);
		this.add(scrollPane);
	}

	// ============================================
	// Getters & Setters
	// ============================================

}
