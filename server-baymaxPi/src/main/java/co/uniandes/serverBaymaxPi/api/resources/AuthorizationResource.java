package co.uniandes.serverBaymaxPi.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import co.uniandes.serverBaymaxPi.domain.business.AuthorizationBusiness;
import co.uniandes.serverBaymaxPi.infrasctructure.DTOs.UserDTO;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import fj.data.Either;

@Path("/authorization")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthorizationResource {

    private final AuthorizationBusiness authorizationBusiness;

    public AuthorizationResource(AuthorizationBusiness authorizationBusiness) {
        this.authorizationBusiness = authorizationBusiness;
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(UserDTO userDTO) {

        Either<IException, String> either = authorizationBusiness.createUser(userDTO);

        if (either.isRight()) {

            return Response.status(Response.Status.CREATED).entity(either.right().value()).build();

        } else {

            IException exception = either.left().value();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();
        }
    }
}
