
public class Dog extends Mammal{
	
	private boolean stupid;
	
	
	public Dog (String latinName, int gestationTime,boolean stupid){
		super(latinName, gestationTime);
		this.stupid = stupid;
	}
		
		public Dog ( String friendlyName, String latinName, int gestationTime, boolean stupid){
		super(latinName, gestationTime);
		this.stupid = stupid;
		super.setFriendlyName(friendlyName);
	}
	
	public boolean isStupid(){
		return stupid;
	}


	@Override
	public String getInfo() {
		String stupid = "is stupid" ;
		String notStupid = "is not stupid";
		
		String info = "The Dog named "  + this.getFriendlyName() + ", " + this.getLatinName()  + ", has the gestation time  "+ this.getGestationTime() +" days " + "and " ;
		if (isStupid() == true){
			return info + stupid;
			
		}else{
			
			return info + notStupid;		
		
		}
	}
	}
	

