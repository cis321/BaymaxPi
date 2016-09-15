package co.uniandes.serverBaymaxPi.api.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.uniandes.serverBaymaxPi.domain.business.MedicalDataBusiness;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.BusinessException;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.ExceptionCodes;
import co.uniandes.serverBaymaxPi.infrasctructure.exceptions.IException;
import fj.data.Either;

@Path("/content-web")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MedicalDataResource {

    private final MedicalDataBusiness contentBusiness;
    private final static Logger LOGGER = LoggerFactory.getLogger(MedicalDataResource.class);

    public MedicalDataResource(MedicalDataBusiness contentBusiness) {
        this.contentBusiness = contentBusiness;
    }

    @POST
    @Path("/tmpfile")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createTemporalFile(@QueryParam("fileName") String fileName) {

        Response response;
        fileName = fileName.toLowerCase();
        try {

            Either<IException, String> either = contentBusiness.ok();

            if (either.isRight()) {

                response = Response.status(Response.Status.CREATED).entity(either.right().value()).build();

            } else {

                IException exception = either.left().value();
                response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception).build();

            }

        } catch (IllegalArgumentException e) {

            LOGGER.error("ContentResource :: createTemporalFile", e);
            BusinessException businessException = new BusinessException(
                    ExceptionCodes.DM_CREATE_TEMPORAL_INVALID_FILE_TYPE_EXCEPTION, null);
            response = Response.status(ExceptionCodes.getStatusCode(businessException)).entity(businessException)
                    .build();

        }

        return response;

    }
}