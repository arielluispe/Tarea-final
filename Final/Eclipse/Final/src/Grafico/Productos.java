package Grafico;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Productos extends JFrame {

	private JPanel contentPane;
	private JTable tablef;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
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
	Connection conexion =null;
	PreparedStatement preparedStatement=null;
	ResultSet resulSet=null;
	public Productos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistrados = new JLabel("Productos Registrados");
		lblRegistrados.setForeground(Color.CYAN);
		lblRegistrados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblRegistrados.setBounds(132, 11, 524, 65);
		contentPane.add(lblRegistrados);
		
		tablef = new JTable();
		tablef.setBounds(60, 102, 636, 172);
		contentPane.add(tablef);
		
		
		
			
		
				
		String []titulo = {"idProductos","NombreProducto","MarcaProducto","CategoriaProducto","PrecioProducto","StockProducto" };
		String[] registro =new String[6];
		
		DefaultTableModel modelo =new DefaultTableModel(null, titulo);
		String SQL ="select * from productos";
		
		try {
			Statement st= conexion.createStatement();
			resulSet = st.executeQuery(SQL);
			
			while (resulSet.next()) {
				registro[0]=resulSet.getString("idProducto");
				registro[1]=resulSet.getString("Nombreproducto");
				registro[2]=resulSet.getString("MarcaProducto");
				registro[3]=resulSet.getString("CategoriaProducto");
				registro[4]=resulSet.getString("PrecioProducto");
				registro[5]=resulSet.getString("StockProducto");
				
				modelo.addRow(registro);
				
				
			}
			tablef.setModel(modelo);
			
			
			
			
			
			
		} catch (Exception e) {
			JOptionPane.showInternalMessageDialog(null,"error al mostrar datos");
		}
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				R_productos r=new R_productos();
				r.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setBounds(40, 294, 115, 46);
		contentPane.add(btnNewButton);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu w = new Menu();
				w.setVisible(true);
			}
		});
		btnVolver.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		btnVolver.setBounds(602, 294, 115, 46);
		contentPane.add(btnVolver);
	}
}
