package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import modelo.BaseDatos;
import view.Inicio;
import view.VentanaPrincipal;

public class Controlador implements ActionListener {

    private VentanaPrincipal vista;
    private Inicio inicio;
    private BaseDatos bd;

    public Controlador() {
        vista = new VentanaPrincipal();
        inicio = new Inicio();
        bd = new BaseDatos();
        asignarOyentes();
    }

    public void asignarOyentes() {
        vista.getPanel().getBotonIngresar().addActionListener(this);
        vista.getPanel().getBotonVerListado().addActionListener(this);
        vista.getPanel().getBotonBuscarId().addActionListener(this);
        inicio.getPinicio().getB_ingresar().addActionListener(this);
        inicio.getPinicio().getB_cancelar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        bd = new BaseDatos();
        if (e.getActionCommand().equals("INGRESAR")) {
            try {
                String Nombre = vista.getPanel().getCampoNombre().getText();
                int id = Integer.parseInt(vista.getPanel().getCampoDocumento().getText());
                bd.EstableciendoConexion();
                String respuesta = bd.InsertarRegistro(id, Nombre);
                vista.mostrarInformacion(respuesta);
            } catch (Exception ex) {
                System.out.println("Problema al insertar la información.");
            }
            bd.closeConnection();
        } else if (e.getActionCommand().equals("VER")) {
            ResultSet rs = null;
            String resultados = "";

            bd.EstableciendoConexion();
            rs = bd.Vertodos();
            try {
                while (rs.next()) {
                    resultados += rs.getString(1) + " -  " + rs.getString(2) + "\n";
                }
                vista.mostrarInformacion(resultados);
            } catch (Exception ex) {
                System.out.println("Problema al imprimir la información.");
            }
            bd.closeConnection();
        } else if (e.getActionCommand().equals("ID")) {
            ResultSet rs = null;
            String string = "";

            bd.EstableciendoConexion();
            int id = Integer.parseInt(vista.capturarInformacion("Ingrese ID a buscar:"));
            rs = bd.consultarID(id);

            try {
                while (rs.next()) {
                    string += rs.getString(2) + "\n";
                }
                vista.mostrarInformacion(string);
            } catch (Exception ex) {
                System.out.println("Problema al imprimir la información.");
            }
            bd.closeConnection();
        } else if (e.getActionCommand().equals("cancelar")) {
            vista.mostrarInformacion("Hasta luego");
            System.exit(0);
        } else if (e.getActionCommand().equals("login")) {
            String us = inicio.getPinicio().getUsuario().getText();
            String co = inicio.getPinicio().getContraseña().getText();
            if (us.equals("admin") && co.equals("12345")) {
                vista.mostrarInformacion("Ingresando a la aplicación");
                inicio.setVisible(false);
                vista.setVisible(true);
            } else {
                inicio.getPinicio().getUsuario().setText("");
                inicio.getPinicio().getContraseña().setText("");
                vista.mostrarInformacion("Usuario y/o Contraseña errados. Ingrese nuevamente la información");
            }
        }
    }
}
