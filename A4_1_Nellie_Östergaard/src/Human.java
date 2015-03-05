
public class Human {
	

	private Dog dog;	
    private String name;
    private String errorText;

//kontrollerar så att namnet på människan är längre är tre eller mer bokstäver
    
public Human (String name){
    	if ( name.length()> 3){
    		this.name = name;
    	} else{
    		this.errorText=" Namnet måste ha minst 3 bokstäver ";
    	}
	
}
// Metoder som hämtar namn, felmeddelande, hund, information
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
	return getName() + " äger en hund som heter " + dog.getName() ;

}
}
