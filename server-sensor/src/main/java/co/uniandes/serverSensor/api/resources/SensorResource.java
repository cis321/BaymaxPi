package co.uniandes.serverSensor.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.uniandes.serverSensor.domain.business.SensorBusiness;
import co.uniandes.serverSensor.infrasctructure.exceptions.IException;
import fj.data.Either;

@Path("/sensor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SensorResource {

    private final SensorBusiness sensorBusiness;

    public SensorResource(SensorBusiness sensorBusiness) {
        this.sensorBusiness = sensorBusiness;
    }

    @GET
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPresionData(){
        
        Response response;

        Either<IException, String> either = sensorBusiness.getPresionData();

        if (either.isRight()) {

            response = Response.status(Response.Status.CREATED).entity(either.right().value()).build();

        } else {

            IException exception = either.left().value();
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();

        }

        return response;        
    }
}
