package vista;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InicioPanelImagen extends JPanel {

	// ============================================
	// Attributes
	// ============================================

	ImageIcon im;

	// ============================================
	// Constructor
	// ============================================

	public InicioPanelImagen() {

	}

	// ============================================
	// Public methods
	// ============================================

	public void paint(Graphics g) {
		Dimension tam = getSize();
		this.im = new ImageIcon(getClass().getResource("/img/inicio/FondoInicio_v1.png"));
		g.drawImage(im.getImage(), 0, 0, tam.width-16, tam.height-40, null);
		this.setOpaque(false);
		super.paint(g);
	}

	// ============================================
	// Private methods
	// ============================================

}
