package vista;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	// ============================================
	// Attributes
	// ============================================

	// ============================================
	// Constructor
	// ============================================

	public VentanaPrincipal() {
		setTitle("Reto 5");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.blue);
		getContentPane().setLayout(null);

	}

	// ============================================
	// Public methods
	// ============================================
	
	public void showError(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	// ============================================
	// Private methods
	// ============================================

}
