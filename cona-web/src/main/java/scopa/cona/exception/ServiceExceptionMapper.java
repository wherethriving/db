package scopa.cona.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by panda on 5/20/16.
 */
@Provider
public class ServiceExceptionMapper implements ExceptionMapper<ServiceException>{

    @Override
    public Response toResponse(ServiceException exception)
    {
        return Response.status(Status.BAD_REQUEST)
                .entity(new ErrorMessage(exception.getMessage())
                ).build();
    }
}
