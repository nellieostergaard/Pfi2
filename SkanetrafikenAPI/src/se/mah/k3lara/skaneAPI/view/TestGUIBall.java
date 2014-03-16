package se.mah.k3lara.skaneAPI.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Timer;
import javax.swing.SwingConstants;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.control.ThreadWithTimer;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmalparser.Parser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class TestGUIBall extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel minutesLabel;
	private JLabel minutesLabel2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUIBall frame = new TestGUIBall();
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
	public TestGUIBall() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
		minutesLabel = new JLabel("10");
		minutesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minutesLabel.setFont(new Font("Tahoma", Font.PLAIN, 49));
		minutesLabel.setBounds(10, 0, 71, 54);
		contentPane.add(minutesLabel);
		
		JButton btnNewButton = new JButton("Same thread");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 runOnThisThread();
			}
		});
		btnNewButton.setBounds(138, 11, 105, 23);
		contentPane.add(btnNewButton);
		
		//Create the ballPanel
		BallPanel panel = new BallPanel(322,175);
		panel.setBounds(0, 60, 322, 175);
		contentPane.add(panel);
		
		minutesLabel2 = new JLabel("10");
		minutesLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		minutesLabel2.setFont(new Font("Vivaldi", Font.PLAIN, 49));
		minutesLabel2.setBounds(241, 0, 71, 54);
		contentPane.add(minutesLabel2);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(101, 0, 0, 54);
		contentPane.add(verticalStrut);
		
		///Start the Timer for Skånetrafiken calls
		 Timer timer = new Timer("TestTimer");
		 ThreadWithTimer t = new ThreadWithTimer(this);
		 timer.schedule(t, 1000, 20000);
		 //OK
	}

	//This method is called from the ThreadWith timer when a new update is collected from Skånetrafiken but on another thread so no lagg here  
	public void updateGUI(String timeToDeparture) {
		minutesLabel.setText(timeToDeparture);
		
	}

	//This makes a call from the UI thread to show that the ball "laggar" during the call. That doesn't happen for the timer class ThreadWithTimer*/
	private void runOnThisThread(){					 
   	 //Minutes to next train Malmö - Lund
   		String searchURL = Constants.getURL("80000","81216",1); //Malmö C = 80000,  Malmö Gatorg 80100, Häsleholm C 93070 Kolla skånetrafiken för fler koder
   		Journeys journeys = Parser.getJourneys(searchURL);
   		if (journeys.getJourneys().get(0) != null ){
   			minutesLabel2.setText(journeys.getJourneys().get(0).getTimeToDeparture());
   		}
	}
}
