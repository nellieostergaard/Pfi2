
public class Human {
	

	private Dog dog;	
    private String name;
    private String errorText;

//kontrollerar s� att namnet p� m�nniskan �r l�ngre �r tre eller mer bokst�ver
    
public Human (String name){
    	if ( name.length()> 3){
    		this.name = name;
    	} else{
    		this.errorText=" Namnet m�ste ha minst 3 bokst�ver ";
    	}
	
}
// Metoder som h�mtar namn, felmeddelande, hund, information
public String getName(){
	
	return this.name;
}

public String getError(){
	return this.errorText;
}

public Dog buyDog (Dog dog){
	return this.dog = dog;
	
	
}


public String getInfo(){
	return getName() + " �ger en hund som heter " + dog.getName() ;

}
}
