package co.uniandes.serverBaymaxPi.api.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bson.Document;

import co.uniandes.serverBaymaxPi.domain.business.AuthorizationBusiness;
import co.uniandes.serverBaymaxPi.infrasctructure.DTOs.UserDTO;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.ExceptionCodes;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import fj.data.Either;

@Path("/authorization")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorizationResource {

    private final AuthorizationBusiness authorizationBusiness;
    
    private final ExceptionCodes exceptionCodes;

    public AuthorizationResource(AuthorizationBusiness authorizationBusiness) {
        
        this.exceptionCodes = new ExceptionCodes();
        this.authorizationBusiness = authorizationBusiness;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {

        Either<IException, Boolean> either = authorizationBusiness.createUser(userDTO);

        if (either.isRight()) {

            return Response.status(Response.Status.CREATED).entity(either.right().value()).build();

        } else {

            IException exception = either.left().value();
            int statusCode = exceptionCodes.getStatusCode(exception);
            return Response.status(statusCode).entity(exception).build();
        }
    }
    
    @POST
    @Path("/updateUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(UserDTO userDTO) {

        Either<IException, Boolean> either = authorizationBusiness.updateUser(userDTO);

        if (either.isRight()) {

            return Response.status(Response.Status.CREATED).entity(either.right().value()).build();

        } else {

            IException exception = either.left().value();
            int statusCode = exceptionCodes.getStatusCode(exception);
            return Response.status(statusCode).entity(exception).build();
        }
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(@QueryParam("username") String username, @QueryParam("contrasena") String contrasena) {

        Either<IException, Document> either = authorizationBusiness.login(username, contrasena);

        if (either.isRight()) {

            return Response.status(Response.Status.OK).entity(either.right().value()).build();

        } else {

            IException exception = either.left().value();
            int statusCode = exceptionCodes.getStatusCode(exception);
            return Response.status(statusCode).entity(exception).build();
        }
    }
    
    @GET
    @Path("/disabledMedics")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDisabledMedics() {

        Either<IException, List<Document>> either = authorizationBusiness.getAllDisabledMedics();

        if (either.isRight()) {

            return Response.status(Response.Status.OK).entity(either.right().value()).build();

        } else {

            IException exception = either.left().value();
            int statusCode = exceptionCodes.getStatusCode(exception);
            return Response.status(statusCode).entity(exception).build();
        }
    }
}
