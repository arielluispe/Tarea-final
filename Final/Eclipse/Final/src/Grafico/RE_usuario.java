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
import javax.swing.JPasswordField;

public class RE_usuario extends JFrame {

	private JPanel passw;
	private JTextField txtusuario;
	private JTextField txtnombre;
	private JTextField txtapellido;
	private JTextField txttelefono;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	
	//Conexion
	
	
		Connection conexion =null;
		PreparedStatement preparedStatement=null;
		ResultSet resulSet=null;
		private JTextField pass;
		
		
		
		private void LimpiarCuadrosDeTexto() {
			
			txtusuario.setText(null);
			txtnombre.setText(null);
			txtapellido.setText(null);
			txttelefono.setText(null);
			txtemail.setText(null);
			pass.setText(null);
			
		}
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RE_usuario frame = new RE_usuario();
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
	public RE_usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 476);
		passw = new JPanel();
		passw.setBackground(new Color(128, 128, 128));
		passw.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(passw);
		passw.setLayout(null);
		
		JLabel lblRegistroUsuario = new JLabel("Registro Usuario");
		lblRegistroUsuario.setForeground(Color.CYAN);
		lblRegistroUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblRegistroUsuario.setBounds(38, 11, 462, 65);
		passw.add(lblRegistroUsuario);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblUsuario.setBackground(new Color(245, 255, 250));
		lblUsuario.setBounds(10, 99, 102, 14);
		passw.add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNombre.setBackground(new Color(245, 255, 250));
		lblNombre.setBounds(10, 141, 102, 14);
		passw.add(lblNombre);
		
		JLabel lblAmellido = new JLabel("Apellido");
		lblAmellido.setForeground(Color.WHITE);
		lblAmellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblAmellido.setBackground(new Color(245, 255, 250));
		lblAmellido.setBounds(10, 183, 102, 14);
		passw.add(lblAmellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblTelefono.setBackground(new Color(245, 255, 250));
		lblTelefono.setBounds(10, 226, 102, 14);
		passw.add(lblTelefono);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblEmail.setBackground(new Color(245, 255, 250));
		lblEmail.setBounds(10, 278, 102, 14);
		passw.add(lblEmail);
		
		txtusuario = new JTextField();
		txtusuario.setColumns(10);
		txtusuario.setBounds(142, 87, 266, 34);
		passw.add(txtusuario);
		
		txtnombre = new JTextField();
		txtnombre.setColumns(10);
		txtnombre.setBounds(142, 132, 266, 34);
		passw.add(txtnombre);
		
		txtapellido = new JTextField();
		txtapellido.setColumns(10);
		txtapellido.setBounds(142, 182, 266, 34);
		passw.add(txtapellido);
		
		txttelefono = new JTextField();
		txttelefono.setColumns(10);
		txttelefono.setBounds(142, 227, 266, 34);
		passw.add(txttelefono);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(142, 277, 266, 34);
		passw.add(txtemail);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				conexion = Conexion.conectar ();
				try {
					preparedStatement = conexion.prepareStatement("Insert into usuarios (UserName, Nombre, Apellido, Telefono, Email, Password) values (?,?,?,?,?,?)");
					
					preparedStatement.setString(1,txtusuario.getText());
					preparedStatement.setString(2,txtnombre.getText());
					preparedStatement.setString(3,txtapellido.getText());
					preparedStatement.setString(4,txttelefono.getText());
					preparedStatement.setString(5,txtemail.getText());
					preparedStatement.setString(6,pass.getText());
					
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
		btnRegistrar.setBounds(190, 365, 161, 61);
		passw.add(btnRegistrar);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblContrasea.setBackground(new Color(245, 255, 250));
		lblContrasea.setBounds(10, 330, 102, 14);
		passw.add(lblContrasea);
		
		
		
		pass = new JTextField();
		pass.setColumns(10);
		pass.setBounds(142, 329, 266, 34);
		passw.add(pass);
	}

}
