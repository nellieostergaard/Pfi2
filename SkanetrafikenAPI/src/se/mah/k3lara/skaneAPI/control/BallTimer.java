package se.mah.k3lara.skaneAPI.control;

import java.util.TimerTask;

import se.mah.k3lara.skaneAPI.view.BallPanel;

/**This thread updates the ball position*/
public class BallTimer extends TimerTask {	
	BallPanel testBallPanel;
	
	/**Constructor that keeps track of the JPanel it is connected to so it can call the repaint method for that panel*/
    public BallTimer(BallPanel testGUIBall) {
		this.testBallPanel = testGUIBall; 
	}
    
	@Override
	public void run() {
			testBallPanel.repaint();;
	}
}
