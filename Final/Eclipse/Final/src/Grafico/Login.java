package Grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.HierarchyBoundsAdapter;
import java.awt.event.HierarchyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JLayeredPane contentPane;
	private JTextField uusuario;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	Connection conexion =null;
	PreparedStatement preparedStatement=null;
	ResultSet resulSet = null;
	private JTextField ppass;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(new Color(128, 128, 128));
		addHierarchyBoundsListener(new HierarchyBoundsAdapter() {
			@Override
			public void ancestorMoved(HierarchyEvent e) {
			}
		});
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent e) {
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 172);
		contentPane = new JLayeredPane();
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBackground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(29, 42, 102, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setForeground(new Color(0, 0, 255));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblContrasea.setBounds(29, 77, 102, 14);
		contentPane.add(lblContrasea);
		
		uusuario = new JTextField();
		uusuario.setBounds(130, 41, 216, 20);
		contentPane.add(uusuario);
		uusuario.setColumns(10);
		
		btnNewButton = new JButton("acces");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion = Conexion.conectar ();
				try {
					preparedStatement = conexion.prepareStatement("Select Nombre from usuarios Where UserName = ? and Password = ? ");
					
					preparedStatement.setString(1,uusuario.getText());
					preparedStatement.setString(2,ppass.getText());
					
					resulSet = preparedStatement.executeQuery();
					
					
					
								
					
					
					
					if (resulSet.next() ) {
						JOptionPane.showInternalMessageDialog(null,"contraseña correcta");
						//LimpiarCuadrosDeTexto();
						Menu m= new Menu();
						m.setVisible(true);
						conexion.close();
					}else {
						JOptionPane.showInternalMessageDialog(null," contraseña fallida");
					}
					
					
				} catch (Exception e1) {
					
					JOptionPane.showInternalMessageDialog(null,"Ocurrio un error en la base de datos");
				}
				
				
				
			}
				
			
		});
		btnNewButton.setForeground(new Color(0, 0, 255));
		btnNewButton.setBackground(new Color(138, 43, 226));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(389, 42, 161, 61);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrarte!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RE_usuario q= new RE_usuario();
				q.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_1.setBounds(418, 110, 107, 23);
		contentPane.add(btnNewButton_1);
		
		ppass = new JTextField();
		ppass.setColumns(10);
		ppass.setBounds(130, 76, 216, 20);
		contentPane.add(ppass);
	}
}
