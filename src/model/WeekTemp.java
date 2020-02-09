package model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class WeekTemp {
	private String dayOne;
	private String dayTwo;
	private String dayThree;
	private String dayFour;
	private String dayFive;
	private String daySix;
	private String daySeven;
	private float tempOne;
	private float tempTwo;
	private float tempThree;
	private float tempFour;
	private float tempFive;
	private float tempSix;
	private float tempSeven;
	
	public WeekTemp() {
		this.dayOne = "99/99/9999";
		this.dayTwo = "99/99/9999";
		this.dayThree = "99/99/9999";
		this.dayFour = "99/99/9999";
		this.dayFive = "99/99/9999";
		this.daySix = "99/99/9999";
		this.daySeven = "99/99/9999";
		this.tempOne = 99.f;
		this.tempTwo = 99.f;
		this.tempThree = 99.f;
		this.tempFour = 99.f;
		this.tempFive = 99.f;
		this.tempSix = 99.f;
		this.tempSeven = 99.f;
		
	}

	public String getDayOne() {
		return dayOne;
	}

	public void setDayOne(String dayOne) {
		this.dayOne = dayOne;
	}

	public String getDayTwo() {
		return dayTwo;
	}

	public void setDayTwo(String dayTwo) {
		this.dayTwo = dayTwo;
	}

	public String getDayThree() {
		return dayThree;
	}

	public void setDayThree(String dayThree) {
		this.dayThree = dayThree;
	}

	public String getDayFour() {
		return dayFour;
	}

	public void setDayFour(String dayFour) {
		this.dayFour = dayFour;
	}

	public String getDayFive() {
		return dayFive;
	}

	public void setDayFive(String dayFive) {
		this.dayFive = dayFive;
	}

	public String getDaySix() {
		return daySix;
	}

	public void setDaySix(String daySix) {
		this.daySix = daySix;
	}

	public String getDaySeven() {
		return daySeven;
	}

	public void setDaySeven(String daySeven) {
		this.daySeven = daySeven;
	}

	public float getTempOne() {
		return tempOne;
	}

	public void setTempOne(float tempOne) {
		this.tempOne = tempOne;
	}

	public float getTempTwo() {
		return tempTwo;
	}

	public void setTempTwo(float tempTwo) {
		this.tempTwo = tempTwo;
	}

	public float getTempThree() {
		return tempThree;
	}

	public void setTempThree(float tempThree) {
		this.tempThree = tempThree;
	}

	public float getTempFour() {
		return tempFour;
	}

	public void setTempFour(float tempFour) {
		this.tempFour = tempFour;
	}

	public float getTempFive() {
		return tempFive;
	}

	public void setTempFive(float tempFive) {
		this.tempFive = tempFive;
	}

	public float getTempSix() {
		return tempSix;
	}

	public void setTempSix(float tempSix) {
		this.tempSix = tempSix;
	}

	public float getTempSeven() {
		return tempSeven;
	}

	public void setTempSeven(float tempSeven) {
		this.tempSeven = tempSeven;
	}
	
	
}
