package business;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import model.IndividualData;
import model.WeekTemp;

@RequestScoped
@Path("/rest")
public class WeatherRestService {
	@Inject
	WeatherBusinessService service;
	
	//REST service for reading a JSON file and writing it's contents to the database
	@POST
	@Path("/postweather")
	@Consumes(MediaType.APPLICATION_JSON)
	public void dataFromJson(IndividualData data) {
	}

}
