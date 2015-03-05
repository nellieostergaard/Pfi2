package se.mah.k3lara.skaneAPI.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;



import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;

import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JScrollPane;

@SuppressWarnings("Serial")
public class GUI extends JFrame {

	private JPanel contentPane;
	JTextField textField;
	JTextField textField_1;
	JTextField textField_2;
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	
	
	GUI g = this;
	private Parser p = new Parser();
	
	Thread t1 = new JourneysThread (p, this);
	Thread t2 = new StationsThread(p, this);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 33, 414, 217);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(56, 10, 172, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Sök Resa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Thread t1 = new JourneysThread(p, g);
				t1.start();
				
				}
			
		});
		btnNewButton.setBounds(93, 57, 99, 21);
		panel.add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(247, 71, 157, 146);
		panel.add(scrollPane_1);
		
		scrollPane_1.setViewportView(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(56, 32, 172, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblFrn = new JLabel("Från");
		lblFrn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFrn.setBounds(0, 11, 46, 14);
		panel.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till");
		lblTill.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTill.setBounds(0, 33, 46, 14);
		panel.add(lblTill);
		
		JButton btnSk = new JButton("Sök Station");
		btnSk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Thread t2 = new StationsThread(p, g);
				t2.start();
				}
				
			
		});
		btnSk.setBounds(282, 39, 99, 21);
		panel.add(btnSk);
		
		textField_2 = new JTextField();
		textField_2.setBounds(261, 10, 132, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 218, 97);
		panel.add(scrollPane);
		
		scrollPane.setViewportView(textArea_1);
		
		JLabel lblSknetrafiken = new JLabel("                    Skånetrafiken");
		lblSknetrafiken.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSknetrafiken.setBounds(31, 9, 324, 27);
		contentPane.add(lblSknetrafiken);
	}
}
