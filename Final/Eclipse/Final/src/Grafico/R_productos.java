package Grafico;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class R_productos extends JFrame {

	private JPanel contentPane;
	private JTextField nproducto;
	private JTextField mproducto;
	private JTextField cproducto;
	private JTextField pproducto;
	private JTextField caproducto;

	/**
	 * Launch the application.
	 */
	
	//Conexion
	
	
			Connection conexion =null;
			PreparedStatement preparedStatement=null;
			ResultSet resulSet=null;
			
	
	
	private void LimpiarCuadrosDeTexto() {
		
		nproducto.setText(null);
		mproducto.setText(null);
		cproducto.setText(null);
		pproducto.setText(null);
		caproducto.setText(null);
	
		
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					R_productos frame = new R_productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public R_productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 461);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroProductos = new JLabel("Registro Productos");
		lblRegistroProductos.setForeground(Color.CYAN);
		lblRegistroProductos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblRegistroProductos.setBounds(10, 11, 462, 65);
		contentPane.add(lblRegistroProductos);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBackground(new Color(245, 255, 250));
		lblNombre.setBounds(20, 87, 102, 14);
		contentPane.add(lblNombre);
		
		nproducto = new JTextField();
		nproducto.setColumns(10);
		nproducto.setBounds(158, 88, 266, 34);
		contentPane.add(nproducto);
		
		mproducto = new JTextField();
		mproducto.setColumns(10);
		mproducto.setBounds(158, 144, 266, 34);
		contentPane.add(mproducto);
		
		cproducto = new JTextField();
		cproducto.setColumns(10);
		cproducto.setBounds(158, 203, 266, 34);
		contentPane.add(cproducto);
		
		pproducto = new JTextField();
		pproducto.setColumns(10);
		pproducto.setBounds(158, 259, 266, 34);
		contentPane.add(pproducto);
		
		caproducto = new JTextField();
		caproducto.setColumns(10);
		caproducto.setBounds(158, 307, 266, 34);
		contentPane.add(caproducto);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setForeground(Color.WHITE);
		lblMarca.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblMarca.setBackground(new Color(245, 255, 250));
		lblMarca.setBounds(20, 143, 102, 14);
		contentPane.add(lblMarca);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCategoria.setBackground(new Color(245, 255, 250));
		lblCategoria.setBounds(20, 197, 102, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblPrecio.setBackground(new Color(245, 255, 250));
		lblPrecio.setBounds(20, 256, 102, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblCantidad.setBackground(new Color(245, 255, 250));
		lblCantidad.setBounds(20, 304, 102, 14);
		contentPane.add(lblCantidad);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				conexion = Conexion.conectar ();
				try {
					preparedStatement = conexion.prepareStatement("Insert into productos (NombreProducto, MarcaProducto,CategoriaProducto,PrecioProducto, StockProducto) values (?,?,?,?,?)");
					
					preparedStatement.setString(1,nproducto.getText());
					preparedStatement.setString(2,mproducto.getText());
					preparedStatement.setString(3,cproducto.getText());
					preparedStatement.setString(4,pproducto.getText());
					preparedStatement.setString(5,caproducto.getText());
					
					
					int resultado = preparedStatement.executeUpdate();
					if (resultado >0) {
						JOptionPane.showInternalMessageDialog(null,"Registro agregado correctamente");
						LimpiarCuadrosDeTexto();
						conexion.close();
					}else {
						JOptionPane.showInternalMessageDialog(null,"El registro fallo");
					}
					
					
				} catch (Exception e1) {
					
					JOptionPane.showInternalMessageDialog(null,"Ocurrio un error en la base de datos");
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnRegistrar.setForeground(Color.BLUE);
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnRegistrar.setBackground(new Color(138, 43, 226));
		btnRegistrar.setBounds(210, 350, 161, 61);
		contentPane.add(btnRegistrar);
	}

}
