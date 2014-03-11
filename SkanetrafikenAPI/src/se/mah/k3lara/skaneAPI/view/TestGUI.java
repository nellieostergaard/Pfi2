package se.mah.k3lara.skaneAPI.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Timer;

import javax.swing.SwingConstants;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.control.ThreadWithTimer;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmalparser.Parser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestGUI extends JFrame implements MouseMotionListener{

	private JPanel contentPane;
	private JLabel minutesLabel;
	private JLabel xLabel;
	private JLabel yLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI frame = new TestGUI();
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
	public TestGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addMouseMotionListener(this);
		JLabel lblNextTrainFrom = new JLabel("Next train from Malm\u00F6 to Lund in");
		lblNextTrainFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNextTrainFrom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNextTrainFrom.setBounds(0, 0, 321, 38);
		contentPane.add(lblNextTrainFrom);
		
		minutesLabel = new JLabel("10");
		minutesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		minutesLabel.setFont(new Font("Tahoma", Font.PLAIN, 49));
		minutesLabel.setBounds(10, 41, 302, 85);
		contentPane.add(minutesLabel);
		
		JLabel lblMinutes = new JLabel("minutes");
		lblMinutes.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinutes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMinutes.setBounds(0, 116, 321, 38);
		contentPane.add(lblMinutes);
		
		xLabel = new JLabel("X =");
		xLabel.setBounds(10, 165, 46, 14);
		contentPane.add(xLabel);
		
		yLabel = new JLabel("Y =  ");
		yLabel.setBounds(10, 190, 46, 14);
		contentPane.add(yLabel);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				runOnThisThread();
			}
		});
		btnNewButton.setBounds(184, 186, 89, 23);
		contentPane.add(btnNewButton);
		
		///Start the Timer
		 Timer timer = new Timer("TestTimer");
		 ThreadWithTimer t = new ThreadWithTimer(this);
		 timer.schedule(t, 1000, 20000);
		 //OK
	}

	public void updateGUI(String timeToDeparture) {
		minutesLabel.setText(timeToDeparture);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		xLabel.setText("X = "+ String.valueOf(x));
		yLabel.setText("Y = "+ String.valueOf(y));
	}
	
	private void runOnThisThread(){					 
	 System.out.println("// Results when searching for Sölvesborg resecentrum - Malmö Gustav Adolfs torg");
		String searchURL = Constants.getURL("10001","80100",20); //Malmö C = 80000,  Malmö GAtorg 80100, Häsleholm C 93070 Kolla skånetrafiken för fler koder
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			System.out.print(journey.getStartStation()+" - ");
			System.out.print(journey.getEndStation());
			System.out.println(" Departs in "+journey.getTimeToDeparture()+ " minutes");
		} 
		
	   System.out.println("// Stations when searching for stations containing \"Malm\"");
		ArrayList<Station> searchStations = new ArrayList<Station>(); 
		searchStations.addAll(Parser.getStationsFromURL("Malm"));
		for (Station s: searchStations){
			System.out.println(s.getStationName());
		}
	}
}
