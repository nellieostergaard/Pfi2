
public class Snake extends Animal {
	private boolean poisonus;
	
	public Snake(String latinName, boolean poisonus){
		super(latinName);
		this.poisonus = poisonus;
	}
	
	public boolean isPoisonus(){
		
		return poisonus;
	}

	@Override
	public String getInfo() {
			String poison = "is poisonus" ;
			String noPoison = "is not poisonus";
			
			String info = "The Snake named " + this.getFriendlyName() + this.getLatinName()+ ", ";
			if (isPoisonus() == true){
				return info + poison;
				
			}else{
				
			return info + noPoison;
			}
		
	}

	
	

}
