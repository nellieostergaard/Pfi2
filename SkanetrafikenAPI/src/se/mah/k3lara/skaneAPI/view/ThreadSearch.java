package se.mah.k3lara.skaneAPI.view;

public class ThreadSearch extends Thread{
	
private GUI gui;
	
	private boolean running = true;
	
	public ThreadSearch(GUI g){
		this.gui = g;
	}
	
	public void run() {
		while (running == true){
			
			
			try{
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("Loading...");
			gui.UpdateLabels();
		}		
	}

}


