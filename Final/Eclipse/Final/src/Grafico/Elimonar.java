package Grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Elimonar extends JFrame {

	private JPanel contentPane;
	private JTextField eid;

	/**
	 * Launch the application.
	 */
	
	Connection conexion =null;
	PreparedStatement preparedStatement=null;
	ResultSet resulSet=null;
	
private void LimpiarCuadrosDeTexto() {
		
		eid.setText(null);
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Elimonar frame = new Elimonar();
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
	public Elimonar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEliminar = new JLabel("Eliminar");
		lblEliminar.setForeground(Color.CYAN);
		lblEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblEliminar.setBounds(85, 11, 319, 65);
		contentPane.add(lblEliminar);
		
		JLabel lblIdQueDesea = new JLabel("id que desea eliminar");
		lblIdQueDesea.setForeground(Color.WHITE);
		lblIdQueDesea.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIdQueDesea.setBackground(new Color(245, 255, 250));
		lblIdQueDesea.setBounds(110, 87, 236, 33);
		contentPane.add(lblIdQueDesea);
		
		eid = new JTextField();
		eid.setColumns(10);
		eid.setBounds(65, 131, 266, 34);
		contentPane.add(eid);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion = Conexion.conectar ();
				try {
					preparedStatement = conexion.prepareStatement("DELETE FROM Usuarios  Where idusuarios= ?");
					
					preparedStatement.setString(1,eid.getText());
					
					
								
					
					
					int resultado = preparedStatement.executeUpdate();
					if (resultado > 0) {
						JOptionPane.showInternalMessageDialog(null,"Registro fue eliminado correctamente");
						LimpiarCuadrosDeTexto();
						conexion.close();
					}else {
						JOptionPane.showInternalMessageDialog(null,"El registro no se elimino");
					}
					
					
				} catch (Exception e1) {
					
					JOptionPane.showInternalMessageDialog(null,"Ocurrio un error en la base de datos");
				}
				
				
				
			}
				
				
			
		});
		btnEliminar.setForeground(Color.BLUE);
		btnEliminar.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEliminar.setBackground(new Color(138, 43, 226));
		btnEliminar.setBounds(121, 191, 161, 46);
		contentPane.add(btnEliminar);
	}

}
