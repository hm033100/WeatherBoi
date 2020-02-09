package business;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import model.WeekTemp;

@Stateless
@Local(WeatherBusinessService.class)
@LocalBean
public class WeatherBusinessService implements WeatherBusinessInterface {

	public WeekTemp CreateWeek()
	{
		WeekTemp week = new WeekTemp();
		week.setDayOne("2/9/2020");
		week.setDayTwo("2/10/2020");
		week.setDayThree("2/11/2020");
		week.setDayFour("2/12/2020");
		week.setDayFive("2/13/2020");
		week.setDaySix("2/14/2020");
		week.setDaySeven("2/15/2020");
		week.setTempOne(72);
		week.setTempTwo(70);
		week.setTempThree(63);
		week.setTempFour(59);
		week.setTempFive(63);
		week.setTempSix(65);
		week.setTempSeven(75);
		
		return week;
	}
}
