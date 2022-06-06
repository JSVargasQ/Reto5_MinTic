/**
 ----- Autores ------
 * Andres David Gonzalez Murcia
 * Juan Sebastian Vargas Quintero
 * Erika Nathalia Gama
 Ciclo 2 - Grupo 6
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.BaseDatos;
import vista.Inicio;
import vista.InicioPanelAcciones;
import vista.VPPanelAcciones;
import vista.VPPanelInputs;
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
		this._asignarOyentes();
		this.refrescarTabla();
	}

	// ============================================
	// Public methods
	// ============================================

	public void pruebaConexion() {
		bd.EstableciendoConexion();

		// this.vista.getPanelTable().cargarDatos();

		System.out.println(bd.getDato(1004, "nombre"));
		System.out.println(bd.getDato(1004, "categoria"));
		System.out.println(bd.getDato(1004, "valorCompra"));
		System.out.println(bd.getDato(1004, "valorVenta"));
		System.out.println(bd.getDato(1004, "cantidadProducto"));
		// bd.setDatoV2(1001, "valorVenta", "5");
		// System.out.println(bd.getDato(1001, "nombre"));
		// System.out.println(bd.getDato(1001, "valorVenta"));
		bd.borrarRegistro(1006);
		bd.insertarRegistro(1006, "Metro", "Herramientas", 20000, 23000, 2);
		System.out.println(bd.getDato(1004, "nombre"));
		System.out.println(bd.getDato(1004, "nombre"));
		/*
		 * System.out.println(bd.getDato(1001, "nombre"));
		 * System.out.println(bd.getDato(1001, "categoria"));
		 * System.out.println(bd.getDato(1001, "valorCompra"));
		 * System.out.println(bd.getDato(1001, "valorVenta"));
		 * System.out.println(bd.getDato(1001, "cantidadProducto"));
		 * 
		 * bd.setDatoV2(1001, "valorVenta", 5); System.out.println(bd.getDato(1001,
		 * "nombre")); System.out.println(bd.getDato(1001, "valorVenta"));
		 * bd.borrarRegistro(1002);
		 */
		Boolean registro = bd.insertarRegistro(1008, "cemento blanco x bulto ", "Contrucción", 2320, 2600, 13);
		System.out.println(bd.getDato(1007, "nombre"));
		System.out.println(bd.getDato(1007, "cantidadProducto"));

		bd.closeConnection();

	}

	public void refrescarTabla() {
		try {
			ResultSet rs = null;
			ArrayList<String[]> resultados = new ArrayList<>();
			bd.EstableciendoConexion();
			rs = bd.Vertodos();
			while (rs.next()) {
				String[] fila = new String[6];
				fila[0] = rs.getString(1);
				fila[1] = rs.getString(2);
				fila[2] = rs.getString(3);
				fila[3] = rs.getString(4);
				fila[4] = rs.getString(5);
				fila[5] = rs.getString(6);

				resultados.add(fila);
			}
			vista.getPanelTable().cargarDatos(resultados);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// ============================================
	// Private methods
	// ============================================

	private void _asignarOyentes() {
		this.inicio.getInicioPapelAcciones().getBtnIngresar().addActionListener(this);
		this.inicio.getInicioPapelAcciones().getBtnVerListado().addActionListener(this);

		this.vista.getPanelInputs().getBtnBuscar().addActionListener(this);

		this.vista.getPanelAcciones().getBtnAgregar().addActionListener(this);
		this.vista.getPanelAcciones().getBtnActualizar().addActionListener(this);
		this.vista.getPanelAcciones().getBtnEliminar().addActionListener(this);
	}

	// ============================================
	// Action Listener
	// ============================================

	@Override
	public void actionPerformed(ActionEvent e) {
		bd = new BaseDatos();
		bd.EstableciendoConexion();

		String actionCommand = e.getActionCommand();
		System.out.println(actionCommand);

		// Login - Inicio
		if (actionCommand.equals(InicioPanelAcciones.BTN_LOGIN_INICIO)) {
			// Get username & password
			String username = this.inicio.getPanelInicio().getTxtUsuario().getText();
			String password = this.inicio.getPanelInicio().getPassContrasena().getText();

			// Validate user and password
			if (username.equals("admin") && password.equals("12345")) {
				this.inicio.setVisible(false);
				this.vista.setVisible(true);
				this.refrescarTabla();
			} else {
				// Show error message
				this.vista.mostrarError("Usuario y/o contrase�a incorrecta");
			}
			// Agregar nuevo registro
		} else if (actionCommand.equals(VPPanelAcciones.BTN_AGREGAR)) {
			Object[] datos = this.vista.getPanelInputs().obtenerDatos();

			Boolean response = bd.insertarRegistro((Integer) datos[0], (String) datos[1], (String) datos[2],
					(Integer) datos[3], (Integer) datos[4], (Integer) datos[5]);
			if (response) {
				this.vista.mostrarInformacion("Agregado exitosamente");
				this.refrescarTabla();
				this.vista.getPanelInputs().limpiarCampos();
			} else {
				this.vista.mostrarError("Ha ocurrido un error");
			}
			// Actualizar elemento
		} else if (actionCommand.equals(VPPanelAcciones.BTN_ACTUALIZAR)) {
			Object[] datos = this.vista.getPanelInputs().obtenerDatos();

			boolean respuesta = this.bd.actualizarDato(datos);
			
			if (respuesta) {
				this.vista.mostrarInformacion("Actualizado exitosamente");
				this.refrescarTabla();
				this.vista.getPanelInputs().limpiarCampos();
			} else {
				this.vista.mostrarError("Ha ocurrido un error");
			}
			// Eliminar elemento
		} else if (actionCommand.equals(VPPanelAcciones.BTN_ELIMINAR)) {
			String referencia = this.vista.obtenerDato("Ingrese la referencia del elemento a eliminar");

			boolean respuesta = this.bd.borrarRegistro(Integer.parseInt(referencia));

			if (respuesta) {
				this.vista.mostrarInformacion("Se ha eliminado exitosamente");
				this.refrescarTabla();
			} else {
				this.vista.mostrarError("Ha ocurrido un error");
			}
		} else if (actionCommand.equals(VPPanelInputs.BTN_BUSCAR)) {
			try {
				int idReferencia = (Integer) this.vista.getPanelInputs().getTxtReferencia().getValue();
				ResultSet response = this.bd.consultarID(idReferencia);
				response.next();

				Object[] elemento = new Object[6];
				elemento[0] = response.getInt(1);
				elemento[1] = response.getString(2);
				elemento[2] = response.getString(3);
				elemento[3] = response.getInt(4);
				elemento[4] = response.getInt(5);
				elemento[5] = response.getInt(6);

				this.vista.getPanelInputs().cargarElemento(elemento);

			} catch (SQLException exception) {
				exception.printStackTrace();
				this.vista.mostrarError("Ha ocurrido un error al consultar la referencia, verifique que exista.");
			} catch (Exception exception) {
				exception.printStackTrace();
				this.vista.mostrarError("Ha ocurrido un error. " + exception.getMessage());
			}

		}

		bd.closeConnection();
	}
}
