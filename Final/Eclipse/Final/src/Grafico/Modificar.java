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

public class Modificar extends JFrame {

	private JPanel contentPane;
	private JTextField mid;

	/**
	 * Launch the application.
	 */
	
	Connection conexion =null;
	PreparedStatement preparedStatement=null;
	ResultSet resulSet=null;
	
	
	
	private void LimpiarCuadrosDeTexto() {
		
		cnombre.setText(null);
		capellido.setText(null);
		ctelefono.setText(null);
		cemail.setText(null);
		cusuario.setText(null);
		cpass.setText(null);
		
	}
	
	private JTextField cnombre;
	private JTextField capellido;
	private JTextField ctelefono;
	private JTextField cemail;
	private JTextField cusuario;
	private JTextField cpass;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar frame = new Modificar();
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
	public Modificar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPodificar = new JLabel("Podificar ");
		lblPodificar.setForeground(Color.CYAN);
		lblPodificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblPodificar.setBounds(135, 11, 356, 65);
		contentPane.add(lblPodificar);
		
		JLabel lblColocarId = new JLabel("Colocar id");
		lblColocarId.setForeground(Color.WHITE);
		lblColocarId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblColocarId.setBackground(new Color(245, 255, 250));
		lblColocarId.setBounds(10, 86, 102, 33);
		contentPane.add(lblColocarId);
		
		mid = new JTextField();
		mid.setColumns(10);
		mid.setBounds(176, 87, 266, 34);
		contentPane.add(mid);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion = Conexion.conectar ();
				try {
					preparedStatement = conexion.prepareStatement("UPDATE Usuarios SET Nombre = ?, Apellido = ?, Telefono = ?, Email = ?, UserName = ?, Password = ?  Where idusuarios= ?");
					
					preparedStatement.setString(1,cnombre.getText());
					preparedStatement.setString(2,capellido.getText());
					preparedStatement.setString(3,ctelefono.getText());
					preparedStatement.setString(4,cemail.getText());
					preparedStatement.setString(5,cusuario.getText());
					preparedStatement.setString(6,cpass.getText());
					
								
					preparedStatement.setString(7,mid.getText());
					
					int resultado = preparedStatement.executeUpdate();
					if (resultado > 0) {
						JOptionPane.showInternalMessageDialog(null,"Registro Actualizado correctamente");
						LimpiarCuadrosDeTexto();
						
						conexion.close();
					}else {
						JOptionPane.showInternalMessageDialog(null,"El registro no se actualizo");
					}
					
					
				} catch (Exception e1) {
					
					JOptionPane.showInternalMessageDialog(null,"Ocurrio un error en la base de datos");
				}
				
				
				
			}
		});
		btnModificar.setForeground(Color.BLUE);
		btnModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnModificar.setBackground(new Color(138, 43, 226));
		btnModificar.setBounds(226, 509, 161, 46);
		contentPane.add(btnModificar);
		
		JLabel lblColocarNombre = new JLabel("Modificar nombre");
		lblColocarNombre.setForeground(Color.WHITE);
		lblColocarNombre.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblColocarNombre.setBackground(new Color(245, 255, 250));
		lblColocarNombre.setBounds(10, 172, 148, 33);
		contentPane.add(lblColocarNombre);
		
		cnombre = new JTextField();
		cnombre.setColumns(10);
		cnombre.setBounds(176, 173, 266, 34);
		contentPane.add(cnombre);
		
		JLabel lblElementosAModificar = new JLabel("Elementos a modificar");
		lblElementosAModificar.setForeground(Color.CYAN);
		lblElementosAModificar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		lblElementosAModificar.setBounds(121, 111, 356, 65);
		contentPane.add(lblElementosAModificar);
		
		JLabel lblModificarApellido = new JLabel("Modificar Apellido");
		lblModificarApellido.setForeground(Color.WHITE);
		lblModificarApellido.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblModificarApellido.setBackground(new Color(245, 255, 250));
		lblModificarApellido.setBounds(10, 227, 148, 33);
		contentPane.add(lblModificarApellido);
		
		capellido = new JTextField();
		capellido.setColumns(10);
		capellido.setBounds(176, 226, 266, 34);
		contentPane.add(capellido);
		
		JLabel lblModificarTelefono = new JLabel("Modificar Telefono");
		lblModificarTelefono.setForeground(Color.WHITE);
		lblModificarTelefono.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblModificarTelefono.setBackground(new Color(245, 255, 250));
		lblModificarTelefono.setBounds(10, 282, 161, 33);
		contentPane.add(lblModificarTelefono);
		
		ctelefono = new JTextField();
		ctelefono.setColumns(10);
		ctelefono.setBounds(176, 290, 266, 34);
		contentPane.add(ctelefono);
		
		JLabel lblModificarEmail = new JLabel("Modificar Email");
		lblModificarEmail.setForeground(Color.WHITE);
		lblModificarEmail.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblModificarEmail.setBackground(new Color(245, 255, 250));
		lblModificarEmail.setBounds(10, 346, 161, 33);
		contentPane.add(lblModificarEmail);
		
		cemail = new JTextField();
		cemail.setColumns(10);
		cemail.setBounds(176, 354, 266, 34);
		contentPane.add(cemail);
		
		JLabel lblModificarUsuario = new JLabel("Modificar Usuario");
		lblModificarUsuario.setForeground(Color.WHITE);
		lblModificarUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblModificarUsuario.setBackground(new Color(245, 255, 250));
		lblModificarUsuario.setBounds(10, 419, 148, 33);
		contentPane.add(lblModificarUsuario);
		
		cusuario = new JTextField();
		cusuario.setColumns(10);
		cusuario.setBounds(176, 419, 266, 34);
		contentPane.add(cusuario);
		
		JLabel lblModificarContrasea = new JLabel("Modificar passw");
		lblModificarContrasea.setForeground(Color.WHITE);
		lblModificarContrasea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblModificarContrasea.setBackground(new Color(245, 255, 250));
		lblModificarContrasea.setBounds(10, 471, 148, 33);
		contentPane.add(lblModificarContrasea);
		
		cpass = new JTextField();
		cpass.setColumns(10);
		cpass.setBounds(176, 464, 266, 34);
		contentPane.add(cpass);
	}

}
