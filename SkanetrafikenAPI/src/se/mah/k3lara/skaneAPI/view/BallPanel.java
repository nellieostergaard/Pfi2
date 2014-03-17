package se.mah.k3lara.skaneAPI.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;

import javax.swing.JPanel;

import se.mah.k3lara.skaneAPI.control.BallTimer;
import se.mah.k3lara.skaneAPI.model.Ball;

public class BallPanel extends JPanel {

	private Ball myBall;
	
	public BallPanel(int width, int height) {
		setBackground(Color.BLACK);
		myBall = new Ball(width/2,height/2, width, height);
		System.out.println("Width"+this.getWidth());
		//Start the balltimer
		Timer ballTimer = new Timer("BallTimer");
		BallTimer b = new BallTimer(this);
		//Here the update intervall is set wait 1sec before start and then run every 0,01 seconds.
		ballTimer.schedule(b,1000,10);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //Draw background in parent class
		myBall.move();
		myBall.draw(g);
	}
	
	@Override
	public void repaint() {
		//Could you call paintComponent asap please
		super.repaint();
	}
}
