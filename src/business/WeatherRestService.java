package business;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import data.IndividualDataService;
import data.UserDataAccess;
import model.DTO;
import model.IndividualData;
import model.User;

@RequestScoped
@Path("/rest")
public class WeatherRestService {
	@Inject
	IndividualDataService service;
	
	@Inject
	UserDataAccess uda;
	
	//REST service for reading a JSON file and writing it's contents to the database
	@POST
	@Path("/postweather")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DTO<IndividualData> dataFromJson(IndividualData data) {
		try {
			System.out.println("Temp: " + data.getTemp());
			System.out.println("Press: " + data.getPress());
			System.out.println("Humid: " + data.getHumid());
			service.CreateT(data);
			return new DTO<IndividualData>(
					200,
					"Data added to data base",
					new ArrayList<IndividualData>());
		}catch(Exception e) {
			e.printStackTrace();
			return new DTO<IndividualData>(
					500, 
					"There was a problem when adding this to the database", 
					new ArrayList<IndividualData>());
		}
	}
	
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public DTO<User> test(){
		return new DTO<User>(
				200,
				"Test success",
				new ArrayList<User>());
	}

}
