


public abstract class Animal {
	
	private String latinName;
	private String friendlyName;

	
	
	public Animal (String latinName){
		this.setLatinName(latinName);
		

	}

	public abstract String getInfo();
	
	public void setFriendlyName(String name) {
		this.friendlyName = name;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	
	
	public String getLatinName(){
		return latinName;
	}


	public void setLatinName(String latinName){
		this.latinName = latinName;
	}
}

	
			
