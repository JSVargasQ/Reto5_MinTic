/**
 ----- Autores ------
 * Andres David Gonzalez Murcia
 * Juan Sebastian Vargas Quintero
 * Erika Nathalia Gama
 Ciclo 2 - Grupo 6
 */
package vista;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InicioPanelAcciones extends JPanel {

	// ============================================
	// Attributes
	// ============================================

	public static final String BTN_LOGIN_INICIO = "BTN_LOGIN_INICIO";
	public static final String Ver_BD = "Ver_BD";
	public static final String Nuevo_Registro_BD = "Nuevo_Registro_BD";

	private JButton btnIngresar;
	private JButton btnNuevoRegistro;
	private JButton btnVerListado;

	// ============================================
	// Constructor
	// ============================================

	public InicioPanelAcciones() {
		try {
			this.setLayout(new GridLayout(1, 1));
			this._inicializarComponentes();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ============================================
	// Public methods
	// ============================================

	// ============================================
	// Private methods
	// ============================================

	private void _inicializarComponentes() throws IOException {

		this.btnIngresar = new JButton("Ingresar");

		Image img = ImageIO.read(getClass().getResource("/img/inicio/btnIngresar.png"));
		this.btnIngresar.setIcon(new ImageIcon(img));

		this.btnIngresar.setActionCommand(BTN_LOGIN_INICIO);
		this.add(btnIngresar);

		// Botón nuevo registro
		this.btnNuevoRegistro = new JButton("Ingresar Nuevo Registro");
		this.btnNuevoRegistro.setActionCommand(Nuevo_Registro_BD);
		//this.add(btnNuevoRegistro);

		// Botón para ver toda la BD
		this.btnVerListado = new JButton("Ver Listado");
		this.btnVerListado.setActionCommand(Ver_BD);
		//this.add(btnVerListado);

	}

	// ============================================
	// Getters & Setters
	// ============================================

	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	// Botón nuevo registro
	public JButton getBtnNuevoRegistro() {
		return btnNuevoRegistro;
	}

	// Botón para ver toda la BD
	public JButton getBtnVerListado() {
		return btnVerListado;
	}
}
