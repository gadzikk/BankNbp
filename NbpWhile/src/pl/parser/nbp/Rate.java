package pl.parser.nbp;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rate {
	private LocalDate effectiveDate;
	private BigDecimal bid;
	private BigDecimal ask;
	
	public Rate(){}
	
	public Rate(LocalDate effectiveDate , BigDecimal bid , BigDecimal ask){
		this.effectiveDate = effectiveDate;
		this.bid = bid;
		this.ask = ask;
	}

	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public BigDecimal getBid() {
		return bid;
	}

	public void setBid(BigDecimal bid) {
		this.bid = bid;
	}

	public BigDecimal getAsk() {
		return ask;
	}

	public void setAsk(BigDecimal ask) {
		this.ask = ask;
	}
	
	

}
