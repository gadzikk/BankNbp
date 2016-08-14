package pl.parser.nbp;

import java.time.LocalDate;

public class Validation {
	
	public boolean currencyValid(String validateIt){

		if(validateIt.equalsIgnoreCase("usd")||validateIt.equalsIgnoreCase("eur")
				||validateIt.equalsIgnoreCase("gbp")||validateIt.equalsIgnoreCase("chf")){
			return true;
		}
		else return false;
	}
	public boolean datesValid(LocalDate firstDate , LocalDate secondDate){
		if(firstDate==null||secondDate==null){
			return false;
		}
		else if(secondDate.isBefore(firstDate)){
			return false;
		}
		else return true;
	}




}
