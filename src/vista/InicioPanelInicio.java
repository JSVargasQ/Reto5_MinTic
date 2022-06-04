package vista;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class InicioPanelInicio extends JPanel {

	// ============================================
	// Attributes
	// ============================================

	private JLabel lbUsuario;
	private JLabel lbContrasena;
	private JLabel lbImagen;

	private JTextField txtUsuario;
	private JPasswordField passContrasena;

	// ============================================
	// Constructor
	// ============================================

	public InicioPanelInicio() {
		this.setLayout(new GridLayout(3, 2, 5, 5));
		this._inicializarComponentes();
	}

	// ============================================
	// Public methods
	// ============================================

	// ============================================
	// Private methods
	// ============================================

	private void _inicializarComponentes() {

		lbUsuario = new JLabel("Usuario: ");
		add(lbUsuario);

		txtUsuario = new JTextField();
		add(txtUsuario);

		lbContrasena = new JLabel("Contraseña: ");
		add(lbContrasena);

		passContrasena = new JPasswordField();
		add(passContrasena);

	}

	// ============================================
	// Getters & Setters
	// ============================================

	public JLabel getLbUsuario() {
		return lbUsuario;
	}

	public void setLbUsuario(JLabel lbUsuario) {
		this.lbUsuario = lbUsuario;
	}

	public JLabel getLbContrasena() {
		return lbContrasena;
	}

	public void setLbContrasena(JLabel lbContrasena) {
		this.lbContrasena = lbContrasena;
	}

	public JLabel getLbImagen() {
		return lbImagen;
	}

	public void setLbImagen(JLabel lbImagen) {
		this.lbImagen = lbImagen;
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public void setTxtUsuario(JTextField txtUsuario) {
		this.txtUsuario = txtUsuario;
	}

	public JPasswordField getPassContrasena() {
		return passContrasena;
	}

	public void setPassContrasena(JPasswordField passContrasena) {
		this.passContrasena = passContrasena;
	}

}
