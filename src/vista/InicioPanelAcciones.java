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
	
	private JButton btnIngresar;

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

}
