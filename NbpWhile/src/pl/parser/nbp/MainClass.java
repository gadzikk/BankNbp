package pl.parser.nbp;


import java.math.BigDecimal;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	private boolean stop;
	private Validation validate;
	private AddressWriter aWrite;
	private XmlHelper xmlhelp;
	private Calculations calulate;

	public MainClass(){
		validate = new Validation();
		aWrite = new AddressWriter();
		xmlhelp = new XmlHelper();
		calulate = new Calculations();
	}
	
	public static void main(String [] args){

		MainClass obj = new MainClass();
		Scanner inps = new Scanner(System.in);
		while(!obj.getStop()){

		System.out.println("Information: Insert currency please");
		String currency = inps.nextLine().toLowerCase();

		System.out.println("Information: Insert start date please");
		String dateStart = inps.nextLine();
		System.out.println("Information: Insert end date please");
		String dateEnd = inps.nextLine();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
		LocalDate firstDate = null;
		try{
			firstDate = LocalDate.parse(dateStart, formatter);
		}catch(DateTimeException e){System.out.println("Information: Format of start date insterted incorrect.");}
		LocalDate secondDate = null;
		try{
			secondDate = LocalDate.parse(dateEnd, formatter);
		}catch(DateTimeException e){System.out.println("Information: Format of end date insterted incorrect.");}

		boolean validCurrency = obj.validate.currencyValid(currency);
		boolean validDates = obj.validate.datesValid(firstDate, secondDate);

		if(validCurrency && validDates){
			obj.aWrite.currencyWriter(currency);
			obj.aWrite.dateWriter(firstDate, secondDate);
			String addressURL = obj.aWrite.getAddress();
			List<Rate> listOfRatesObject = obj.xmlhelp.parseit(addressURL);
			BigDecimal bidAverage = obj.calulate.calculateAverageOfBid(listOfRatesObject);
			BigDecimal askStandardDeviation = obj.calulate.calculateStandardDeviationOfAsk(listOfRatesObject);
			System.out.println(bidAverage);
			System.out.println(askStandardDeviation);
			obj.setStop();
		}
		else{System.out.println("Information: You inserted incorrect currency or/and dates.");}
		obj.aWrite.setDefaultAddress();
		}
	}
	public void setStop(){
		this.stop=true;
	}
	public boolean getStop(){
		return this.stop;
	}


}