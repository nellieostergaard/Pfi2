import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Toolkit;


public class DigitalClockGUI extends JFrame {

	private ClockLogic clockLogic = new ClockLogic(this);
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	 public JTextField textField_2;
	 public JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Nellie\\Desktop\\colorful-clock-clipart-orologio_clock_alarm_icon_coloring_book_colouring-1969px.png"));
		setTitle("Fancy Alarm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(20, 168, 46, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblHours.setBounds(20, 143, 46, 14);
		contentPane.add(lblHours);
		
		textField_1 = new JTextField();
		textField_1.setBounds(20, 219, 53, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setFont(new Font("Trajan Pro", Font.PLAIN, 11));
		lblMinutes.setBounds(20, 199, 53, 14);
		contentPane.add(lblMinutes);
		
		JButton btnNewButton = new JButton("Set Alarm");
		btnNewButton.setBackground(new Color(255, 255, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clockLogic.setAlarm(Integer.parseInt(textField.getText()) , Integer.parseInt(textField_1.getText()));
				 
			}
		});
		btnNewButton.setFont(new Font("Trajan Pro", Font.PLAIN, 8));
		btnNewButton.setBounds(316, 155, 97, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear Alarm");
		btnNewButton_1.setBackground(new Color(255, 255, 204));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clockLogic.clearAlarm();
				textField.setText(" ");
				textField_1.setText(" ");
			}
		});
		btnNewButton_1.setFont(new Font("Trajan Pro", Font.PLAIN, 8));
		btnNewButton_1.setBounds(316, 187, 97, 21);
		contentPane.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 255, 204));
		textField_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBounds(295, 75, 129, 48);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Trajan Pro", Font.BOLD, 11));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBounds(316, 50, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Trajan Pro", Font.BOLD, 25));
		lblTime.setBounds(32, 50, 77, 40);
		contentPane.add(lblTime);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Nellie\\Desktop\\vintage-old-retro-clock-roman-numbers-200X200.jpg"));
		lblNewLabel.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel);
	}
	
	public void setTimeOnLabel (String time){
		textField_2.setText(time);
	}
}
