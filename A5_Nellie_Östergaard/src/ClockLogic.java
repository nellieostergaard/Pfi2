import java.awt.Color;
import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ClockLogic implements ClockInterface{
	
	private DigitalClockGUI clockGUI;
	private String time= "";
	private String alarmTime = "";
	private int alarmHour;
	private int alarmMinute;
	private int hours;
	private int minutes;
	
	public ClockLogic (DigitalClockGUI clockIn){
		this.clockGUI = clockIn;
		Thread t = new Thread(new ClockThread(this));
		t.start();
		 
		
	}
	
	public void setAlarm (int hours, int minutes){
		this.alarmMinute = minutes;
		this.alarmHour = hours;
	}

	public void clearAlarm(){		
		this.alarmHour = 1000;
		this.alarmMinute = 1000;
	
		
	}

	@Override
	public void update(int hours, int minutes, int seconds) {
		// TODO Auto-generated method stub
		
		System.out.println("updating");
		
		//clockGUI.textField_2.setText(hours+":" + minutes+":"+ seconds);
		
		if(alarmHour == hours && alarmMinute == minutes){
			
			System.out.println("ALARM");
			
			clockGUI.textField_3.setText("Wake Up!");
		}
		clockGUI.setTimeOnLabel(addzero(hours) + ":" + (addzero(minutes) + ":" + (addzero(seconds))));
		
	}

	private String addzero(int i){
		String s = String.valueOf(i);
		if (s.length() == 1){
			s = "0" + s;
		}
	return s;
}
	
	
	public void getClockGUI(DigitalClockGUI clockGUI){
		this.clockGUI = clockGUI;
	}
	
	public void setClockGUI ( DigitalClockGUI clockGUI){
		this.clockGUI = clockGUI;
		
	}
}
