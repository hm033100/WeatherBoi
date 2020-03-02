package business;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import data.IndividualDataService;
import model.DTO;
import model.IndividualData;

@RequestScoped
@Path("/rest")
public class WeatherRestService {
	@Inject
	IndividualDataService service;
	
	//REST service for reading a JSON file and writing it's contents to the database
	@POST
	@Path("/postweather")
	@Consumes(MediaType.APPLICATION_JSON)
	public DTO<IndividualData> dataFromJson(IndividualData data) {
		try {
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

}
