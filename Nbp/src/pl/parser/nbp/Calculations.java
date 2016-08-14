package pl.parser.nbp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Calculations {
	
	public BigDecimal calculateAverageOfBid(List<Rate> listOfRates){
		BigDecimal averageOfBid= new BigDecimal("0");
		BigDecimal divisor =  new BigDecimal(listOfRates.size());
		for(Rate valueOfBid : listOfRates){
			averageOfBid = averageOfBid.add(valueOfBid.getBid());
		}
		averageOfBid = averageOfBid.divide(divisor, 4, RoundingMode.HALF_UP);
		return averageOfBid;
	}
	public BigDecimal calculateStandardDeviationOfAsk(List<Rate> listOfRates){
		BigDecimal averageOfAsk= new BigDecimal("0");
		BigDecimal divisor =  new BigDecimal(listOfRates.size());
		for(Rate valueOfAsk : listOfRates){
			averageOfAsk = averageOfAsk.add(valueOfAsk.getAsk()); //<< getAsk() [another value] is a Reason for repeat avg count
		}
		averageOfAsk = averageOfAsk.divide(divisor, 10, RoundingMode.HALF_UP);
		BigDecimal sumStandartDeviation = new BigDecimal("0");
        for(int i = 0 ; i<divisor.intValue() ; i++){
        	sumStandartDeviation = sumStandartDeviation.add((listOfRates.get(i).getAsk().subtract(averageOfAsk)).pow(2));
        }
        sumStandartDeviation = sumStandartDeviation.divide(divisor, 10, RoundingMode.HALF_UP);
        sumStandartDeviation = BigDecimal.valueOf(Math.sqrt(sumStandartDeviation.doubleValue()))
        		.setScale(4, RoundingMode.HALF_UP);
        return sumStandartDeviation;
		
	}

}
