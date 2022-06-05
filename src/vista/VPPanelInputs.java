package vista;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class VPPanelInputs extends JPanel {

	// ============================================
	// Attributes
	// ============================================

	public static final String BTN_BUSCAR = "BTN_SEARCH";

	
	private JButton btnBuscar;
	
	private JLabel lbReferencia;
	private JLabel lbNombre;
	private JLabel lbCategoria;
	private JLabel lbValorCompra;
	private JLabel lbValorVenta;
	private JLabel lbCantidad;

	private JSpinner txtReferencia;
	private JTextField txtNombre;
	private JTextField txtCategoria;
	private JSpinner txtValorCompra;
	private JSpinner txtValorVenta;
	private JSpinner txtCantidad;

	// ============================================
	// Constructor
	// ============================================

	public VPPanelInputs() {
		this.setLayout(new GridLayout(12, 3));
		this._inicializarComponentes();
		this._agregarComponentes();
	}

	// ============================================
	// Public methods
	// ============================================

	public Object[] obtenerDatos() {
		Object[] response = new Object[6];

		response[0] = (Integer) this.txtReferencia.getValue();
		response[1] = this.txtNombre.getText();
		response[2] = this.txtCategoria.getText();
		response[3] = (Integer) this.txtValorCompra.getValue();
		response[4] = (Integer) this.txtValorVenta.getValue();
		response[5] = (Integer) this.txtCantidad.getValue();

		return response;
	}

	public void limpiarCampos() {
		this.txtReferencia.setValue(0);
		this.txtNombre.setText("");
		this.txtCategoria.setText("");
		this.txtValorCompra.setValue(0);
		this.txtValorVenta.setValue(0);
		this.txtCantidad.setValue(0);
	}
	
	public void cargarElemento(Object[] datos) {
		this.txtReferencia.setValue(datos[0]);
		this.txtNombre.setText((String)datos[1]);
		this.txtCategoria.setText((String)datos[2]);
		this.txtValorCompra.setValue(datos[3]);
		this.txtValorVenta.setValue(datos[4]);
		this.txtCantidad.setValue(datos[5]);
	}

	// ============================================
	// Private methods
	// ============================================

	private void _agregarComponentes() {
		this.add(this.lbReferencia);
		this.add(this.txtReferencia);
		this.add(this.btnBuscar);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		this.add(this.lbNombre);
		this.add(this.txtNombre);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		this.add(this.lbCategoria);
		this.add(this.txtCategoria);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());


		this.add(this.lbValorCompra);
		this.add(this.txtValorCompra);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		this.add(this.lbValorVenta);
		this.add(this.txtValorVenta);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

		this.add(this.lbCantidad);
		this.add(this.txtCantidad);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(new JLabel());

	}

	private void _inicializarComponentes() {
		this.btnBuscar = new JButton("Buscar");
		this.btnBuscar.setActionCommand(BTN_BUSCAR);
		
		this.lbReferencia = new JLabel("Referencia");
		this.lbNombre = new JLabel("Nombre");
		this.lbCategoria = new JLabel("Categoria");
		this.lbValorCompra = new JLabel("Valor de compra");
		this.lbValorVenta = new JLabel("Valor de venta");
		this.lbCantidad = new JLabel("Cantidad");

		this.txtReferencia = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
		this.txtNombre = new JTextField();
		this.txtCategoria = new JTextField();

		this.txtValorCompra = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 100));
		this.txtValorVenta = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 100));
		this.txtCantidad = new JSpinner(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
	}

	// ============================================
	// Getters & Setters
	// ============================================


	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public JSpinner getTxtReferencia() {
		return txtReferencia;
	}
	
	
}
