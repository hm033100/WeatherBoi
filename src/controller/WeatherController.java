package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import business.WeatherBusinessService;
import model.WeekTemp;

@ManagedBean(name="weather")
@ViewScoped
public class WeatherController {

	@Inject
	WeatherBusinessService weatherService;
	
	public String ColumnChart()
	{
		return "ColumnChart.xhtml";
	}
	
	
	public WeekTemp getWeek()
	{
		try {
			return weatherService.CreateWeek();
		}catch(Exception e) {
			e.printStackTrace();
			return new WeekTemp();
		}
		
	}
	
	
}
