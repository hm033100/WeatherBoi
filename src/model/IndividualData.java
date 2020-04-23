package model;

import java.util.Date;

public class IndividualData {

	private int id;
	private Date date;
	private float temp;
	private float press;
	private float humid;
	
	public IndividualData() {
		super();
		this.id = 0;
		this.date = new Date();
		this.temp = 0.0f;
		this.press = 0.0f;
		this.humid = 0.0f;
	}
	
	public IndividualData(float temp, float press, float humid) {
		this.temp = temp;
		this.press = press;
		this.humid = humid;
	}

	public IndividualData(int id, Date date, float temp, float press, float humid) {
		super();
		this.id = id;
		this.date = date;
		this.temp = temp;
		this.press = press;
		this.humid = humid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getTemp() {
		return temp;
	}

	public void setTemp(float temp) {
		this.temp = temp;
	}

	public float getPress() {
		return press;
	}

	public void setPress(float press) {
		this.press = press;
	}

	public float getHumid() {
		return humid;
	}

	public void setHumid(float humid) {
		this.humid = humid;
	}
	
	
	
	

}
