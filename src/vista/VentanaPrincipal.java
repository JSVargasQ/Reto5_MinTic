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
		setTitle("Primer Programa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.blue);
        getContentPane().setLayout(null);

	}
	
	// ============================================
	// Public methods
	// ============================================
	
        public void mostrarInformacion(String mensaje) {
            JOptionPane.showMessageDialog(null, mensaje);
        }

	// ============================================
	// Private methods
	// ============================================
	
}
