/**
 ----- Autores ------
 * Andres David Gonzalez Murcia
 * Juan Sebastian Vargas Quintero
 * Erika Nathalia Gama
 Ciclo 2 - Grupo 6
 */
package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class Inicio extends JFrame {

	// ============================================
	// Attributes
	// ============================================

	public final static int WIDTH = 500;
	public final static int HEIGHT = 600;
	
	private InicioPanelImagen inicioPanelImagen;
	private InicioPanelInicio inicioPanelInicio;
	private InicioPanelAcciones inicioPapenAcciones;
	private JLayeredPane layeredPane;

	// ============================================
	// Constructor
	// ============================================

	public Inicio() {
		this.setTitle("Ingreso");
		this.setPreferredSize(new Dimension(500, 600));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout());

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - WIDTH / 2, dim.height / 2 - HEIGHT / 2);

		this.pack();
		this.setVisible(true);
		this.setResizable(false);

		this._inicializarComponentes();
	}

	// ============================================
	// Public methods
	// ============================================

	// ============================================
	// Private methods
	// ============================================

	private void _inicializarComponentes() {

		this.layeredPane = new JLayeredPane();
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);
		this.layeredPane.setBounds(0, 0, WIDTH, HEIGHT);

		// Add panel for image
		this.inicioPanelImagen = new InicioPanelImagen();
		this.inicioPanelImagen.setBounds(0, 0, WIDTH, HEIGHT);
		this.inicioPanelImagen.setOpaque(true);

		// Add principal panel for label and inputs
		this.inicioPanelInicio = new InicioPanelInicio();
		this.inicioPanelInicio.setBounds(100, 200, 300, 125);
		this.inicioPanelInicio.setOpaque(true);
		
		// Add actions of panels
		this.inicioPapenAcciones = new InicioPanelAcciones();
		this.inicioPapenAcciones.setBounds(100, 340, 300, 50);

		// Sort components
		this.layeredPane.add(inicioPanelImagen, new Integer(0), 0);
		this.layeredPane.add(inicioPanelInicio, new Integer(1), 0);
		this.layeredPane.add(inicioPapenAcciones, new Integer(2), 0);
	}

	// ============================================
	// Getters & Setters
	// ============================================

	public InicioPanelImagen getPimagen() {
		return inicioPanelImagen;
	}


	public InicioPanelInicio getPanelInicio() {
		return inicioPanelInicio;
	}
	
	public InicioPanelAcciones getInicioPapelAcciones() {
		return inicioPapenAcciones;
	}



}
