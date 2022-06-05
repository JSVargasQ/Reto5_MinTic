package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends JFrame {

	// ============================================
	// Attributes
	// ============================================

	public final static String TITLE = "Reto 5 - MinTic";

	public final static int WIDTH = 1200;
	public final static int HEIGHT = 700;

	private VPPanelInputs panelInputs;
	private VPPanelTable panelTable;
	private VPPanelAcciones panelAcciones;

	private JLayeredPane layeredPane;

	// ============================================
	// Constructor
	// ============================================

	public VentanaPrincipal() {
		this._inicializarVentanaPrincipal();
		this._inicializarComponentes();
	}

	// ============================================
	// Public methods
	// ============================================

	public String obtenerDato(String mensage) {
		return JOptionPane.showInputDialog(null, mensage);
	}
	
	public void mostrarError(String message) {
		JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public void mostrarInformacion(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	// ============================================
	// Private methods
	// ============================================

	private void _inicializarComponentes() {
		this.layeredPane = new JLayeredPane();
		this.getContentPane().add(layeredPane, BorderLayout.CENTER);
		this.layeredPane.setBounds(0, 0, WIDTH, HEIGHT);

		getContentPane().setLayout(null);

		this.panelInputs = new VPPanelInputs();
		this.panelInputs.setBounds(20, 20, 550-(20*2), HEIGHT-(20*12));

		this.panelTable = new VPPanelTable();
		this.panelTable.setBounds(550, 0, WIDTH-550, HEIGHT);
		
		this.panelAcciones = new VPPanelAcciones();
		this.panelAcciones.setBounds(20, 20+HEIGHT-(20*12), 550-(20*2), 150);
		
		this.layeredPane.add(panelInputs, new Integer(0), 0);
		this.layeredPane.add(panelTable, new Integer(1), 0);
		this.layeredPane.add(panelAcciones, new Integer(2), 0);

	}

	private void _inicializarVentanaPrincipal() {
		setTitle(TITLE);
		setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(false);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width / 2 - WIDTH / 2, dim.height / 2 - HEIGHT / 2);

		//getContentPane().setBackground(Color.blue);
	}
	
	// ============================================
	// Getters
	// ============================================


	public VPPanelInputs getPanelInputs() {
		return panelInputs;
	}

	public VPPanelTable getPanelTable() {
		return panelTable;
	}

	public VPPanelAcciones getPanelAcciones() {
		return panelAcciones;
	}
	
	
	
	
}
