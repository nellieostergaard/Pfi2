import java.util.Calendar;

public class ClockThread implements Runnable{
	
	private boolean running = true;
	
	private ClockInterface clockInterface;
	
	private Calendar c;
	
	
	public ClockThread  (ClockInterface ci){
		this.clockInterface = ci;
	}
	
		public void run(){
			
			while (running) {
				try {
					c = Calendar.getInstance();
					clockInterface.update(c.get(Calendar.HOUR_OF_DAY),
							c.get(Calendar.MINUTE), c.get(Calendar.SECOND));
					Thread.sleep(900);
				
				}catch (Exception e){
					e.printStackTrace();
				}
				
				
			
				}
	}
	}
	
	

