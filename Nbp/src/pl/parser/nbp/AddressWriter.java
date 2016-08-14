package pl.parser.nbp;

import java.time.LocalDate;

public class AddressWriter {
	private StringBuilder address;
	
	public AddressWriter(){
		this.address = new StringBuilder("http://api.nbp.pl/api/exchangerates/rates/c/");
	}
	
	public void currencyWriter(String choice){
			this.address.append(choice + "/");
	}
	
	public void dateWriter(LocalDate firstDate , LocalDate secondDate){
			if(secondDate.isAfter(firstDate)){
				this.address.append(firstDate + "/" + secondDate + "/" + "?format=xml");
			}
			else if(secondDate.isEqual(firstDate)){
				this.address.append(firstDate + "/" + "?format=xml");
			}
	}
	
	public String getAddress(){
		return this.address.toString();
	}
	
	public void setDefaultAddress(){
		this.address.setLength(0);
		this.address.append("http://api.nbp.pl/api/exchangerates/rates/c/");
	}


}
