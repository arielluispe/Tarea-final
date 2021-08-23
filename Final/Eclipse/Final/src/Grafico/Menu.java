package Grafico;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setForeground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Usuarios");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuarios t=new Usuarios();
				t.setVisible(true);
			
			}
		});
		btnNewButton.setBackground(new Color(138, 43, 226));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnNewButton.setBounds(10, 21, 163, 78);
		contentPane.add(btnNewButton);
		
		JButton btnN = new JButton("Productos");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Productos a=new Productos();
				a.setVisible(true);
			}
		});
		btnN.setBackground(new Color(138, 43, 226));
		btnN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		btnN.setBounds(10, 141, 163, 78);
		contentPane.add(btnN);
		
		JLabel lblNewLabel = new JLabel("Bienvenido!!");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(243, 91, 353, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Cerrar seccion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnNewButton_2.setBackground(new Color(128, 128, 128));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(550, 11, 106, 23);
		contentPane.add(btnNewButton_2);
	}

}
