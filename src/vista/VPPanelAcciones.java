/**
 ----- Autores ------
 * Andres David Gonzalez Murcia
 * Juan Sebastian Vargas Quintero
 * Erika Nathalia Gama
 Ciclo 2 - Grupo 6
 */
package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VPPanelAcciones extends JPanel {

	// ============================================
	// Attributes
	// ============================================

	public static final String BTN_AGREGAR = "BTN_ADD";
	public static final String BTN_ACTUALIZAR = "BTN_UPDATE";
	public static final String BTN_ELIMINAR = "BTN_DELETE";

	private JButton btnAgregar;
	private JButton btnActualizar;
	private JButton btnEliminar;

	// ============================================
	// Constructor
	// ============================================

	public VPPanelAcciones() {
		this.setLayout(null);
		this._inicializarComponentes();
		this._agregarComponentes();
		
		//setBackground(Color.yellow);
	}

	// ============================================
	// Public methods
	// ============================================

	// ============================================
	// Private methods
	// ============================================

	private void _agregarComponentes() {
		this.btnAgregar.setBounds(0, 50, 150, 50);
		this.add(this.btnAgregar);

		this.btnActualizar.setBounds(180, 50, 150, 50);
		this.add(this.btnActualizar);

		this.btnEliminar.setBounds(360, 50, 150, 50);
		this.add(this.btnEliminar);
	}

	private void _inicializarComponentes() {
		this.btnAgregar = new JButton("Agregar");
		this.btnAgregar.setActionCommand(BTN_AGREGAR);
		
		this.btnActualizar = new JButton("Actualizar");
		this.btnActualizar.setActionCommand(BTN_ACTUALIZAR);
		
		this.btnEliminar = new JButton("Eliminar");
		this.btnEliminar.setActionCommand(BTN_ELIMINAR);
	}

	// ============================================
	// Getters & Setters
	// ============================================

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JButton getBtnActualizar() {
		return btnActualizar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	

}
