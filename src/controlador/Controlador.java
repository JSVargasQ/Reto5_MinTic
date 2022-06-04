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
		//pruebaConexion();
                
		this._asignarOyentes();
	}

	// ============================================
	// Public methods
	// ============================================

	public void pruebaConexion() {
		bd.EstableciendoConexion();

		System.out.println(bd.getDato(1004, "nombre"));
                System.out.println(bd.getDato(1004, "categoria"));
		System.out.println(bd.getDato(1004, "valorCompra"));
		System.out.println(bd.getDato(1004, "valorVenta"));
		System.out.println(bd.getDato(1004, "cantidadProducto"));
                //bd.setDatoV2(1001, "valorVenta", "5");
		//System.out.println(bd.getDato(1001, "nombre"));
		//System.out.println(bd.getDato(1001, "valorVenta"));
                bd.borrarRegistro(1006);
                bd.InsertarRegistro(1006, "Metro", "Herramientas", 20000, 23000, 2);
                System.out.println(bd.getDato(1004, "nombre"));
                System.out.println(bd.getDato(1004, "nombre"));
        	/*System.out.println(bd.getDato(1001, "nombre"));
                System.out.println(bd.getDato(1001, "categoria"));
		System.out.println(bd.getDato(1001, "valorCompra"));
		System.out.println(bd.getDato(1001, "valorVenta"));
		System.out.println(bd.getDato(1001, "cantidadProducto"));
		
                bd.setDatoV2(1001, "valorVenta", 5);
		System.out.println(bd.getDato(1001, "nombre"));
		System.out.println(bd.getDato(1001, "valorVenta"));
                bd.borrarRegistro(1002);*/
                String registro = bd.InsertarRegistro(1008, "cemento blanco x bulto ", "Contrucción", 2320, 2600, 13);
                System.out.println(bd.getDato(1007, "nombre"));
                System.out.println(bd.getDato(1007, "cantidadProducto"));
              

		bd.closeConnection();
                
	}

	// ============================================
	// Private methods
	// ============================================

	private void _asignarOyentes() {
		this.inicio.getInicioPapelAcciones().getBtnIngresar().addActionListener(this);
                this.inicio.getInicioPapelAcciones().getBtnVerListado().addActionListener(this);
	}

	// ============================================
	// Action Listener
	// ============================================

	@Override
	public void actionPerformed(ActionEvent e) {
		bd = new BaseDatos();
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
		//Botón nuevo registro
                } else if (actionCommand.equals(InicioPanelAcciones.Nuevo_Registro_BD)){
                    try{
                        /* //toma todos los datos de entrada
                        int id = Integer.parseInt(vista.getPanel().getCampoDocumento().getText());
                        String Nombre = vista.getPanel().getCampoNombre().getText();
                        String categoria = 
                        int valorCompra =
                        int valorVenta =
                        int cantidadProducto =
                        */
                        bd.EstableciendoConexion();
                        //String respuesta = bd.InsertarRegistro(id, nombre, categoría, valorCompra, valorVenta, cantidadProducto);
                    }catch (Exception ex) {
                        System.out.println("Problema al insertar la información.");
                    }
                    bd.closeConnection();
                //Botón para ver BD
                }else if (actionCommand.equals(InicioPanelAcciones.Ver_BD)){
                    ResultSet rs = null;
                    String resultados = "";
                    bd.EstableciendoConexion();
                    rs = bd.Vertodos();
                    try {
                        while (rs.next()) {
                        resultados += rs.getString(1) + " -  " + rs.getString(2) + " -  " + rs.getString(3) + " -  " + rs.getString(4) + " -  " + rs.getString(6) + " -  " + rs.getString(6) + "\n";
                        }
                        vista.mostrarInformacion(resultados);
                    } catch (Exception ex) {
                        System.out.println("Problema al imprimir la información.");
                    }
                    bd.closeConnection();
                }
               
	}
}
