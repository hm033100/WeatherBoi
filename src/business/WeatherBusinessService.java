package business;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import data.IndividualDataService;
import exception.RecordNotFoundException;
import model.IndividualData;
import model.WeekTemp;

@Stateless
@Local(WeatherBusinessService.class)
@LocalBean
public class WeatherBusinessService implements WeatherBusinessInterface {

	@Inject
	IndividualDataService ids;
	
	public WeekTemp CreateWeek() throws RecordNotFoundException
	{
		Date today = new Date();
		ArrayList<IndividualData> data = new ArrayList<IndividualData>();
		for(int i = 6; i >+ 0 ; i--) {
			Date tempDate = new Date(today.getTime() - (i * 24 * 60 * 60 * 1000));
			IndividualData temp = new IndividualData();
			temp.setDate(tempDate);
			data.add(ids.ReadTByField(temp));
		}
		WeekTemp week = new WeekTemp();
		week.setDayOne(data.get(0).getDate().toString());
		week.setDayTwo(data.get(1).getDate().toString());
		week.setDayThree(data.get(2).getDate().toString());
		week.setDayFour(data.get(3).getDate().toString());
		week.setDayFive(data.get(4).getDate().toString());
		week.setDaySix(data.get(5).getDate().toString());
		week.setDaySeven(data.get(6).getDate().toString());
		week.setTempOne(data.get(0).getTemp());
		week.setTempTwo(data.get(1).getTemp());
		week.setTempThree(data.get(2).getTemp());
		week.setTempFour(data.get(3).getTemp());
		week.setTempFive(data.get(4).getTemp());
		week.setTempSix(data.get(5).getTemp());
		week.setTempSeven(data.get(6).getTemp());
		
		return week;
	}
}
