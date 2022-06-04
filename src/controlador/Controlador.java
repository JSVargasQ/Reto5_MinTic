package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import modelo.BaseDatos;
import vista.Inicio;
import vista.InicioPanelAcciones;
import vista.VentanaPrincipal;

public class Controlador implements ActionListener {

	// ============================================
	// Attributes
	// ============================================

	private VentanaPrincipal vista;
	private Inicio inicio;
	private BaseDatos bd;

	// ============================================
	// Constructor
	// ============================================

	public Controlador() {
		vista = new VentanaPrincipal();
		inicio = new Inicio();
		bd = new BaseDatos();
		pruebaConexion();
                
		this._asignarOyentes();
	}

	// ============================================
	// Public methods
	// ============================================

	public void pruebaConexion() {
		bd.EstableciendoConexion();
		System.out.println(bd.getDato(1, "nombre"));
		System.out.println(bd.getDato(1, "valor_compra"));
		System.out.println(bd.getDato(1, "valor_venta"));
		System.out.println(bd.getDato(1, "cantidad"));
		System.out.println(bd.getDato(1, "categoria"));
                bd.setDatoV2(1, "valor_venta", 5);
		System.out.println(bd.getDato(1, "nombre"));
		System.out.println(bd.getDato(1, "valor_venta"));
                bd.borrarRegistro(3);
		bd.closeConnection();
	}

	// ============================================
	// Private methods
	// ============================================

	private void _asignarOyentes() {
		this.inicio.getInicioPapelAcciones().getBtnIngresar().addActionListener(this);
	}

	// ============================================
	// Action Listener
	// ============================================

	@Override
	public void actionPerformed(ActionEvent e) {
		// bd = new BaseDatos();
		String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);

		// Login - Inicio
		if (actionCommand.equals(InicioPanelAcciones.BTN_LOGIN_INICIO)) {
			// Get username & password
			String username = this.inicio.getPanelInicio().getTxtUsuario().getText();
			String password = this.inicio.getPanelInicio().getPassContrasena().getText();

			System.out.println("aaa");
			System.out.println(username + " - " + password);

			// this.inicio.setVisible(false);
			// this.vista.setVisible(true);
		}
	}
}
