
public class Cat extends Mammal{
	
	private int numberOfLifes;
	
	
	public Cat (String latinName, int numberOfLifes, int gestationTime){
		super(latinName, gestationTime);
		this.numberOfLifes = numberOfLifes;
	}
	
	public int getNumberOfLifes(){
		return numberOfLifes;
		
	}

	public int setNumberOfLifes(int i){
		return i;
		
	}

	@Override
	public String getInfo() {
		
		
		String info = "The Cat named " + getFriendlyName() +  this.getLatinName() + " has the gestationtime " + this.getGestationTime() +" days and has " + numberOfLifes+ " lifes ";
		return info;
		}
		
		
	}

